package com.baidu.tieba.QuickPlayer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.tieba.QuickPlayer.IQuickMediaPlayerService;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.IMediaPlayer;
/* loaded from: classes.dex */
public class QuickMediaPlayerService extends Service implements a {
    public static final String KEY_RELEASE_ALL_PLAYERS = "KEY_RELEASE_ALL_PLAYERS";
    private List<IMediaPlayer> mPlayerList = new ArrayList();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new QuickMediaPlayerServiceBinder();
    }

    /* loaded from: classes.dex */
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
                for (IMediaPlayer iMediaPlayer : this.mPlayerList) {
                    if (iMediaPlayer != null) {
                        iMediaPlayer.reset();
                        iMediaPlayer.release();
                    }
                }
                this.mPlayerList.clear();
            }
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public void addPlayer(IMediaPlayer iMediaPlayer) {
        synchronized (QuickMediaPlayerService.class) {
            this.mPlayerList.add(iMediaPlayer);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public void removePlayer(IMediaPlayer iMediaPlayer) {
        synchronized (QuickMediaPlayerService.class) {
            this.mPlayerList.remove(iMediaPlayer);
        }
    }

    @Override // com.baidu.tieba.QuickPlayer.a
    public boolean isExistInRemote(IMediaPlayer iMediaPlayer) {
        synchronized (QuickMediaPlayerService.class) {
            if (iMediaPlayer != null) {
                if (this.mPlayerList != null && !this.mPlayerList.isEmpty()) {
                    for (IMediaPlayer iMediaPlayer2 : this.mPlayerList) {
                        if (iMediaPlayer2 != null && iMediaPlayer2 == iMediaPlayer) {
                            return true;
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
