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
/* loaded from: classes13.dex */
public class d {
    private static d eJY;
    private IQuickMediaPlayerService eKa;
    private Set<b> eKc;
    private Set<b> eKd;
    private Set<b> eKe;
    private boolean eKf;
    private a eKg;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean eJZ = false;
    private boolean eKb = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.eJZ = true;
            com.baidu.adp.lib.f.e.ld().removeCallbacks(d.this.eKh);
            d.this.eKa = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.eKb) {
                d.this.eKb = false;
                d.this.bkW();
            }
            if (d.this.eKg != null) {
                d.this.eKg.a(d.this.eKa);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.eJZ = false;
            d.this.eKb = true;
            com.baidu.adp.lib.f.e.ld().postDelayed(d.this.eKh, 1000L);
        }
    };
    private Runnable eKh = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.eJZ) {
                d.this.bkV();
                com.baidu.adp.lib.f.e.ld().postDelayed(d.this.eKh, 1000L);
            }
        }
    };

    /* loaded from: classes13.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void bkX();
    }

    private d() {
        bkV();
        com.baidu.adp.lib.f.e.ld().postDelayed(this.eKh, 1000L);
        this.eKc = new HashSet();
        this.eKd = new HashSet();
        this.eKe = new HashSet();
    }

    public static d bkU() {
        if (eJY == null) {
            synchronized (d.class) {
                if (eJY == null) {
                    eJY = new d();
                }
            }
        }
        return eJY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkV() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkW() {
        this.eKf = true;
        for (b bVar : this.eKc) {
            if (bVar != null) {
                bVar.bkX();
            }
        }
        this.eKf = false;
        this.eKc.addAll(this.eKe);
        this.eKe.clear();
        this.eKc.removeAll(this.eKd);
        this.eKd.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.eJZ && this.eKa != null) {
            try {
                return this.eKa.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.f.e.ld().postDelayed(this.eKh, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.eKg = aVar;
    }

    public void a(b bVar) {
        if (this.eKf) {
            this.eKe.add(bVar);
        } else {
            this.eKc.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.eKf) {
            this.eKe.remove(bVar);
        } else {
            this.eKc.remove(bVar);
        }
    }
}
