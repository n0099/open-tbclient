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
/* loaded from: classes.dex */
public class d {
    private static d aWa;
    private IQuickMediaPlayerService aWc;
    private Set<a> aWe;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean aWb = false;
    private boolean aWd = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.aWb = true;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(d.this.aWf);
            d.this.aWc = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.aWd) {
                d.this.aWd = false;
                for (a aVar : d.this.aWe) {
                    if (aVar != null) {
                        aVar.KO();
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.aWb = false;
            d.this.aWd = true;
            com.baidu.adp.lib.g.e.fP().postDelayed(d.this.aWf, 1000L);
        }
    };
    private Runnable aWf = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.aWb) {
                d.this.KN();
                com.baidu.adp.lib.g.e.fP().postDelayed(d.this.aWf, 1000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void KO();
    }

    private d() {
        KN();
        this.aWe = new HashSet();
    }

    public static d KM() {
        if (aWa == null) {
            synchronized (d.class) {
                if (aWa == null) {
                    aWa = new d();
                }
            }
        }
        return aWa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KN() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.aWb && this.aWc != null) {
            try {
                return this.aWc.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean a(a aVar) {
        return this.aWe.add(aVar);
    }

    public void b(a aVar) {
        this.aWe.remove(aVar);
    }
}
