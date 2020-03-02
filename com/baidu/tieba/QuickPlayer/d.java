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
    private static d dUP;
    private IQuickMediaPlayerService dUR;
    private Set<b> dUT;
    private Set<b> dUU;
    private Set<b> dUV;
    private boolean dUW;
    private a dUX;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean dUQ = false;
    private boolean dUS = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.dUQ = true;
            com.baidu.adp.lib.f.e.gx().removeCallbacks(d.this.dUY);
            d.this.dUR = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.dUS) {
                d.this.dUS = false;
                d.this.aWA();
            }
            if (d.this.dUX != null) {
                d.this.dUX.a(d.this.dUR);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.dUQ = false;
            d.this.dUS = true;
            com.baidu.adp.lib.f.e.gx().postDelayed(d.this.dUY, 1000L);
        }
    };
    private Runnable dUY = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.dUQ) {
                d.this.aWz();
                com.baidu.adp.lib.f.e.gx().postDelayed(d.this.dUY, 1000L);
            }
        }
    };

    /* loaded from: classes13.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes13.dex */
    public interface b {
        void aWB();
    }

    private d() {
        aWz();
        com.baidu.adp.lib.f.e.gx().postDelayed(this.dUY, 1000L);
        this.dUT = new HashSet();
        this.dUU = new HashSet();
        this.dUV = new HashSet();
    }

    public static d aWy() {
        if (dUP == null) {
            synchronized (d.class) {
                if (dUP == null) {
                    dUP = new d();
                }
            }
        }
        return dUP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWz() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWA() {
        this.dUW = true;
        for (b bVar : this.dUT) {
            if (bVar != null) {
                bVar.aWB();
            }
        }
        this.dUW = false;
        this.dUT.addAll(this.dUV);
        this.dUV.clear();
        this.dUT.removeAll(this.dUU);
        this.dUU.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.dUQ && this.dUR != null) {
            try {
                return this.dUR.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.dUY, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.dUX = aVar;
    }

    public void a(b bVar) {
        if (this.dUW) {
            this.dUV.add(bVar);
        } else {
            this.dUT.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.dUW) {
            this.dUV.remove(bVar);
        } else {
            this.dUT.remove(bVar);
        }
    }
}
