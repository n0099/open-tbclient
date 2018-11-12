package com.baidu.tieba.QuickPlayer;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.tieba.QuickPlayer.IQuickMediaPlayerService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
/* loaded from: classes5.dex */
public class QuickMediaPlayerService extends Service implements com.baidu.tieba.QuickPlayer.a {
    public static final String KEY_RELEASE_ALL_PLAYERS = "KEY_RELEASE_ALL_PLAYERS";
    public static final String KEY_RELEASE_PLAYERS_IDS = "KEY_RELEASE_PLAYERS_IDS";
    public static final String KEY_RELEASE_SOME_PLAYERS = "KEY_RELEASE_SOME_PLAYERS";
    private LRULinkedHashMap<Uri, a> mPlayerList = new LRULinkedHashMap<>();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new QuickMediaPlayerServiceBinder();
    }

    /* loaded from: classes5.dex */
    public class QuickMediaPlayerServiceBinder extends IQuickMediaPlayerService.Stub {
        public QuickMediaPlayerServiceBinder() {
        }

        @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayerService
        public IQuickMediaPlayer createPlayer() throws RemoteException {
            return new QuickMediaPlayerBinder(QuickMediaPlayerService.this);
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        if (intent != null && intent.getBooleanExtra(KEY_RELEASE_ALL_PLAYERS, false)) {
            synchronized (QuickMediaPlayerService.class) {
                Iterator<Map.Entry<Uri, a>> it = this.mPlayerList.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Uri, a> next = it.next();
                    if (next != null && next.getValue() != null && it.hasNext()) {
                        next.getValue().TD();
                        it.remove();
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public void addPlayer(IMediaPlayer iMediaPlayer, Uri uri) {
        synchronized (QuickMediaPlayerService.class) {
            if (this.mPlayerList.containsKey(uri) && this.mPlayerList.get(uri) != null) {
                this.mPlayerList.get(uri).TD();
            }
            this.mPlayerList.put(uri, new a(iMediaPlayer));
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public void removePlayer(Uri uri) {
        synchronized (QuickMediaPlayerService.class) {
            a aVar = this.mPlayerList.get(uri);
            if (aVar != null) {
                aVar.count--;
                IMediaPlayer iMediaPlayer = aVar.buj;
                if (iMediaPlayer != null) {
                    if (iMediaPlayer.isPlaying()) {
                        iMediaPlayer.pause();
                    }
                    if (aVar.count <= 0) {
                        iMediaPlayer.resetListeners();
                        iMediaPlayer.setSurface(null);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public IMediaPlayer getPlayer(Uri uri) {
        synchronized (QuickMediaPlayerService.class) {
            if (this.mPlayerList.get(uri) != null && this.mPlayerList.get(uri).buj != null) {
                this.mPlayerList.get(uri).count++;
                return this.mPlayerList.get(uri).buj;
            }
            return null;
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public boolean isExistInRemote(IMediaPlayer iMediaPlayer) {
        boolean containsValue;
        synchronized (QuickMediaPlayerService.class) {
            if (iMediaPlayer != null) {
                if (this.mPlayerList != null && !this.mPlayerList.isEmpty()) {
                    containsValue = this.mPlayerList.containsValue(new a(iMediaPlayer));
                }
            }
            containsValue = false;
        }
        return containsValue;
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public List<String> getMediaIDs() {
        ArrayList arrayList = new ArrayList();
        synchronized (QuickMediaPlayerService.class) {
            for (Map.Entry<Uri, a> entry : this.mPlayerList.entrySet()) {
                if (entry != null && entry.getKey() != null && entry.getValue() != null && entry.getValue().buj != null) {
                    arrayList.add(entry.getValue().buj.generateMediaID());
                }
            }
        }
        return arrayList;
    }

    /* loaded from: classes5.dex */
    class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        public static final int MAX_PLAYERS = 3;
        private static final long serialVersionUID = 1;

        LRULinkedHashMap() {
            super(3, 0.75f, true);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, V> entry) {
            boolean z = size() > 3;
            V value = entry.getValue();
            if (z && (value instanceof a)) {
                ((a) value).TD();
            }
            return z;
        }
    }

    /* loaded from: classes5.dex */
    class a {
        public IMediaPlayer buj;
        public int count = 1;

        public a(IMediaPlayer iMediaPlayer) {
            this.buj = iMediaPlayer;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.buj == ((a) obj).buj;
        }

        public void TD() {
            if (this.buj != null) {
                try {
                    this.buj.reset();
                } catch (Throwable th) {
                }
                this.buj.release();
            }
        }
    }
}
