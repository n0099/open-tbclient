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
    private static d eKj;
    private IQuickMediaPlayerService eKl;
    private Set<b> eKn;
    private Set<b> eKo;
    private Set<b> eKp;
    private boolean eKq;
    private a eKr;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean eKk = false;
    private boolean eKm = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.eKk = true;
            com.baidu.adp.lib.f.e.ld().removeCallbacks(d.this.eKs);
            d.this.eKl = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.eKm) {
                d.this.eKm = false;
                d.this.bkY();
            }
            if (d.this.eKr != null) {
                d.this.eKr.a(d.this.eKl);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.eKk = false;
            d.this.eKm = true;
            com.baidu.adp.lib.f.e.ld().postDelayed(d.this.eKs, 1000L);
        }
    };
    private Runnable eKs = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.eKk) {
                d.this.bkX();
                com.baidu.adp.lib.f.e.ld().postDelayed(d.this.eKs, 1000L);
            }
        }
    };

    /* loaded from: classes13.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void bkZ();
    }

    private d() {
        bkX();
        com.baidu.adp.lib.f.e.ld().postDelayed(this.eKs, 1000L);
        this.eKn = new HashSet();
        this.eKo = new HashSet();
        this.eKp = new HashSet();
    }

    public static d bkW() {
        if (eKj == null) {
            synchronized (d.class) {
                if (eKj == null) {
                    eKj = new d();
                }
            }
        }
        return eKj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkX() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkY() {
        this.eKq = true;
        for (b bVar : this.eKn) {
            if (bVar != null) {
                bVar.bkZ();
            }
        }
        this.eKq = false;
        this.eKn.addAll(this.eKp);
        this.eKp.clear();
        this.eKn.removeAll(this.eKo);
        this.eKo.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.eKk && this.eKl != null) {
            try {
                return this.eKl.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.f.e.ld().postDelayed(this.eKs, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.eKr = aVar;
    }

    public void a(b bVar) {
        if (this.eKq) {
            this.eKp.add(bVar);
        } else {
            this.eKn.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.eKq) {
            this.eKp.remove(bVar);
        } else {
            this.eKn.remove(bVar);
        }
    }
}
