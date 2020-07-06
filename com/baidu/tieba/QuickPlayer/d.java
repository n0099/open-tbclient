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
    private static d eUv;
    private Set<b> eUA;
    private Set<b> eUB;
    private boolean eUC;
    private a eUD;
    private IQuickMediaPlayerService eUx;
    private Set<b> eUz;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean eUw = false;
    private boolean eUy = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.eUw = true;
            com.baidu.adp.lib.f.e.lt().removeCallbacks(d.this.eUE);
            d.this.eUx = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.eUy) {
                d.this.eUy = false;
                d.this.bny();
            }
            if (d.this.eUD != null) {
                d.this.eUD.a(d.this.eUx);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.eUw = false;
            d.this.eUy = true;
            com.baidu.adp.lib.f.e.lt().postDelayed(d.this.eUE, 1000L);
        }
    };
    private Runnable eUE = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.eUw) {
                d.this.bnx();
                com.baidu.adp.lib.f.e.lt().postDelayed(d.this.eUE, 1000L);
            }
        }
    };

    /* loaded from: classes13.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void bnz();
    }

    private d() {
        bnx();
        com.baidu.adp.lib.f.e.lt().postDelayed(this.eUE, 1000L);
        this.eUz = new HashSet();
        this.eUA = new HashSet();
        this.eUB = new HashSet();
    }

    public static d bnw() {
        if (eUv == null) {
            synchronized (d.class) {
                if (eUv == null) {
                    eUv = new d();
                }
            }
        }
        return eUv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnx() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bny() {
        this.eUC = true;
        for (b bVar : this.eUz) {
            if (bVar != null) {
                bVar.bnz();
            }
        }
        this.eUC = false;
        this.eUz.addAll(this.eUB);
        this.eUB.clear();
        this.eUz.removeAll(this.eUA);
        this.eUA.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.eUw && this.eUx != null) {
            try {
                return this.eUx.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.f.e.lt().postDelayed(this.eUE, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.eUD = aVar;
    }

    public void a(b bVar) {
        if (this.eUC) {
            this.eUB.add(bVar);
        } else {
            this.eUz.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.eUC) {
            this.eUB.remove(bVar);
        } else {
            this.eUz.remove(bVar);
        }
    }
}
