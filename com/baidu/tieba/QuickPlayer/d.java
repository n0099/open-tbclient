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
    private static d dVs;
    private a dVA;
    private IQuickMediaPlayerService dVu;
    private Set<b> dVw;
    private Set<b> dVx;
    private Set<b> dVy;
    private boolean dVz;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean dVt = false;
    private boolean dVv = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.dVt = true;
            com.baidu.adp.lib.f.e.gx().removeCallbacks(d.this.dVB);
            d.this.dVu = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.dVv) {
                d.this.dVv = false;
                d.this.aWF();
            }
            if (d.this.dVA != null) {
                d.this.dVA.a(d.this.dVu);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.dVt = false;
            d.this.dVv = true;
            com.baidu.adp.lib.f.e.gx().postDelayed(d.this.dVB, 1000L);
        }
    };
    private Runnable dVB = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.dVt) {
                d.this.aWE();
                com.baidu.adp.lib.f.e.gx().postDelayed(d.this.dVB, 1000L);
            }
        }
    };

    /* loaded from: classes13.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void aWG();
    }

    private d() {
        aWE();
        com.baidu.adp.lib.f.e.gx().postDelayed(this.dVB, 1000L);
        this.dVw = new HashSet();
        this.dVx = new HashSet();
        this.dVy = new HashSet();
    }

    public static d aWD() {
        if (dVs == null) {
            synchronized (d.class) {
                if (dVs == null) {
                    dVs = new d();
                }
            }
        }
        return dVs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWE() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWF() {
        this.dVz = true;
        for (b bVar : this.dVw) {
            if (bVar != null) {
                bVar.aWG();
            }
        }
        this.dVz = false;
        this.dVw.addAll(this.dVy);
        this.dVy.clear();
        this.dVw.removeAll(this.dVx);
        this.dVx.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.dVt && this.dVu != null) {
            try {
                return this.dVu.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.dVB, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.dVA = aVar;
    }

    public void a(b bVar) {
        if (this.dVz) {
            this.dVy.add(bVar);
        } else {
            this.dVw.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.dVz) {
            this.dVy.remove(bVar);
        } else {
            this.dVw.remove(bVar);
        }
    }
}
