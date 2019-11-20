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
    private static d dcF;
    private IQuickMediaPlayerService dcH;
    private Set<b> dcJ;
    private Set<b> dcK;
    private Set<b> dcL;
    private boolean dcM;
    private a dcN;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean dcG = false;
    private boolean dcI = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.dcG = true;
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(d.this.dcO);
            d.this.dcH = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.dcI) {
                d.this.dcI = false;
                d.this.aBW();
            }
            if (d.this.dcN != null) {
                d.this.dcN.a(d.this.dcH);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.dcG = false;
            d.this.dcI = true;
            com.baidu.adp.lib.g.e.fZ().postDelayed(d.this.dcO, 1000L);
        }
    };
    private Runnable dcO = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.dcG) {
                d.this.aBV();
                com.baidu.adp.lib.g.e.fZ().postDelayed(d.this.dcO, 1000L);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(IQuickMediaPlayerService iQuickMediaPlayerService);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void aBX();
    }

    private d() {
        aBV();
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.dcO, 1000L);
        this.dcJ = new HashSet();
        this.dcK = new HashSet();
        this.dcL = new HashSet();
    }

    public static d aBU() {
        if (dcF == null) {
            synchronized (d.class) {
                if (dcF == null) {
                    dcF = new d();
                }
            }
        }
        return dcF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBV() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBW() {
        this.dcM = true;
        for (b bVar : this.dcJ) {
            if (bVar != null) {
                bVar.aBX();
            }
        }
        this.dcM = false;
        this.dcJ.addAll(this.dcL);
        this.dcL.clear();
        this.dcJ.removeAll(this.dcK);
        this.dcK.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.dcG && this.dcH != null) {
            try {
                return this.dcH.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.dcO, 1000L);
        }
        return null;
    }

    public void a(a aVar) {
        this.dcN = aVar;
    }

    public void a(b bVar) {
        if (this.dcM) {
            this.dcL.add(bVar);
        } else {
            this.dcJ.add(bVar);
        }
    }

    public void b(b bVar) {
        if (this.dcM) {
            this.dcL.remove(bVar);
        } else {
            this.dcJ.remove(bVar);
        }
    }
}
