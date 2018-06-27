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
/* loaded from: classes2.dex */
public class d {
    private static d biP;
    private IQuickMediaPlayerService biR;
    private Set<b> biT;
    private Set<b> biU;
    private Set<b> biV;
    private boolean biW;
    private a biX;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean biQ = false;
    private boolean biS = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.biQ = true;
            com.baidu.adp.lib.g.e.im().removeCallbacks(d.this.biY);
            d.this.biR = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.biS) {
                d.this.biS = false;
                d.this.Px();
            }
            if (d.this.biX != null) {
                d.this.biX.a(d.this.biR);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.biQ = false;
            d.this.biS = true;
            com.baidu.adp.lib.g.e.im().postDelayed(d.this.biY, 1000L);
        }
    };
    private Runnable biY = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.biQ) {
                d.this.Pw();
                com.baidu.adp.lib.g.e.im().postDelayed(d.this.biY, 1000L);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void Py();
    }

    private d() {
        Pw();
        com.baidu.adp.lib.g.e.im().postDelayed(this.biY, 1000L);
        this.biT = new HashSet();
        this.biU = new HashSet();
        this.biV = new HashSet();
    }

    public static d Pv() {
        if (biP == null) {
            synchronized (d.class) {
                if (biP == null) {
                    biP = new d();
                }
            }
        }
        return biP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pw() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Px() {
        this.biW = true;
        for (b bVar : this.biT) {
            if (bVar != null) {
                bVar.Py();
            }
        }
        this.biW = false;
        this.biT.addAll(this.biV);
        this.biV.clear();
        this.biT.removeAll(this.biU);
        this.biU.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.biQ && this.biR != null) {
            try {
                return this.biR.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.im().postDelayed(this.biY, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.biX = aVar;
    }

    public void a(b bVar) {
        if (this.biW) {
            this.biV.add(bVar);
        } else {
            this.biT.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.biW) {
            this.biV.remove(bVar);
        } else {
            this.biT.remove(bVar);
        }
    }
}
