package com.baidu.tieba.QuickPlayer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.QuickPlayer.IQuickMediaPlayerService;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class d {
    private static d cJs;
    private a cJA;
    private IQuickMediaPlayerService cJu;
    private Set<b> cJw;
    private Set<b> cJx;
    private Set<b> cJy;
    private boolean cJz;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean cJt = false;
    private boolean cJv = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.cJt = true;
            com.baidu.adp.lib.g.e.jH().removeCallbacks(d.this.cJB);
            d.this.cJu = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.cJv) {
                d.this.cJv = false;
                d.this.ave();
            }
            if (d.this.cJA != null) {
                d.this.cJA.a(d.this.cJu);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.cJt = false;
            d.this.cJv = true;
            com.baidu.adp.lib.g.e.jH().postDelayed(d.this.cJB, 1000L);
        }
    };
    private Runnable cJB = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.cJt) {
                d.this.avd();
                com.baidu.adp.lib.g.e.jH().postDelayed(d.this.cJB, 1000L);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void avf();
    }

    private d() {
        avd();
        com.baidu.adp.lib.g.e.jH().postDelayed(this.cJB, 1000L);
        this.cJw = new HashSet();
        this.cJx = new HashSet();
        this.cJy = new HashSet();
    }

    public static d avc() {
        if (cJs == null) {
            synchronized (d.class) {
                if (cJs == null) {
                    cJs = new d();
                }
            }
        }
        return cJs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avd() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ave() {
        this.cJz = true;
        for (b bVar : this.cJw) {
            if (bVar != null) {
                bVar.avf();
            }
        }
        this.cJz = false;
        this.cJw.addAll(this.cJy);
        this.cJy.clear();
        this.cJw.removeAll(this.cJx);
        this.cJx.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.cJt && this.cJu != null) {
            try {
                return this.cJu.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.cJB, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.cJA = aVar;
    }

    public void a(b bVar) {
        if (this.cJz) {
            this.cJy.add(bVar);
        } else {
            this.cJw.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.cJz) {
            this.cJy.remove(bVar);
        } else {
            this.cJw.remove(bVar);
        }
    }
}
