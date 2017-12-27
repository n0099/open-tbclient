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
    private static d bMT;
    private IQuickMediaPlayerService bMV;
    private Set<a> bMX;
    private Set<a> bMY;
    private Set<a> bMZ;
    private boolean bNa;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean bMU = false;
    private boolean bMW = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.bMU = true;
            com.baidu.adp.lib.g.e.nr().removeCallbacks(d.this.bNb);
            d.this.bMV = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.bMW) {
                d.this.bMW = false;
                d.this.SJ();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.bMU = false;
            d.this.bMW = true;
            com.baidu.adp.lib.g.e.nr().postDelayed(d.this.bNb, 1000L);
        }
    };
    private Runnable bNb = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.bMU) {
                d.this.SI();
                com.baidu.adp.lib.g.e.nr().postDelayed(d.this.bNb, 1000L);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void SK();
    }

    private d() {
        SI();
        this.bMX = new HashSet();
        this.bMY = new HashSet();
        this.bMZ = new HashSet();
    }

    public static d SH() {
        if (bMT == null) {
            synchronized (d.class) {
                if (bMT == null) {
                    bMT = new d();
                }
            }
        }
        return bMT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SI() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SJ() {
        this.bNa = true;
        for (a aVar : this.bMX) {
            if (aVar != null) {
                aVar.SK();
            }
        }
        this.bNa = false;
        this.bMX.addAll(this.bMZ);
        this.bMZ.clear();
        this.bMX.removeAll(this.bMY);
        this.bMY.clear();
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.bMU && this.bMV != null) {
            try {
                return this.bMV.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void a(a aVar) {
        if (this.bNa) {
            this.bMZ.add(aVar);
        } else {
            this.bMX.add(aVar);
        }
    }

    public void b(a aVar) {
        if (this.bNa) {
            this.bMZ.remove(aVar);
        } else {
            this.bMX.remove(aVar);
        }
    }
}
