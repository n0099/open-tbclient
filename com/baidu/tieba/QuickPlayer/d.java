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
    private static d aVV;
    private IQuickMediaPlayerService aVX;
    private Set<a> aVZ;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean aVW = false;
    private boolean aVY = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.aVW = true;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(d.this.aWa);
            d.this.aVX = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.aVY) {
                d.this.aVY = false;
                for (a aVar : d.this.aVZ) {
                    if (aVar != null) {
                        aVar.KA();
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.aVW = false;
            d.this.aVY = true;
            com.baidu.adp.lib.g.e.fP().postDelayed(d.this.aWa, 1000L);
        }
    };
    private Runnable aWa = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.aVW) {
                d.this.Kz();
                com.baidu.adp.lib.g.e.fP().postDelayed(d.this.aWa, 1000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void KA();
    }

    private d() {
        Kz();
        this.aVZ = new HashSet();
    }

    public static d Ky() {
        if (aVV == null) {
            synchronized (d.class) {
                if (aVV == null) {
                    aVV = new d();
                }
            }
        }
        return aVV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kz() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.aVW && this.aVX != null) {
            try {
                return this.aVX.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean a(a aVar) {
        return this.aVZ.add(aVar);
    }

    public void b(a aVar) {
        this.aVZ.remove(aVar);
    }
}
