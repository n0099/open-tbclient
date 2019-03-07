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
    private static d cJv;
    private Set<b> cJA;
    private Set<b> cJB;
    private boolean cJC;
    private a cJD;
    private IQuickMediaPlayerService cJx;
    private Set<b> cJz;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean cJw = false;
    private boolean cJy = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.cJw = true;
            com.baidu.adp.lib.g.e.jH().removeCallbacks(d.this.cJE);
            d.this.cJx = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.cJy) {
                d.this.cJy = false;
                d.this.ave();
            }
            if (d.this.cJD != null) {
                d.this.cJD.a(d.this.cJx);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.cJw = false;
            d.this.cJy = true;
            com.baidu.adp.lib.g.e.jH().postDelayed(d.this.cJE, 1000L);
        }
    };
    private Runnable cJE = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.cJw) {
                d.this.avd();
                com.baidu.adp.lib.g.e.jH().postDelayed(d.this.cJE, 1000L);
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
        com.baidu.adp.lib.g.e.jH().postDelayed(this.cJE, 1000L);
        this.cJz = new HashSet();
        this.cJA = new HashSet();
        this.cJB = new HashSet();
    }

    public static d avc() {
        if (cJv == null) {
            synchronized (d.class) {
                if (cJv == null) {
                    cJv = new d();
                }
            }
        }
        return cJv;
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
        this.cJC = true;
        for (b bVar : this.cJz) {
            if (bVar != null) {
                bVar.avf();
            }
        }
        this.cJC = false;
        this.cJz.addAll(this.cJB);
        this.cJB.clear();
        this.cJz.removeAll(this.cJA);
        this.cJA.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.cJw && this.cJx != null) {
            try {
                return this.cJx.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.jH().postDelayed(this.cJE, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.cJD = aVar;
    }

    public void a(b bVar) {
        if (this.cJC) {
            this.cJB.add(bVar);
        } else {
            this.cJz.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.cJC) {
            this.cJB.remove(bVar);
        } else {
            this.cJz.remove(bVar);
        }
    }
}
