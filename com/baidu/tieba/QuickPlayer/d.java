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
    private static d aVS;
    private IQuickMediaPlayerService aVU;
    private Set<a> aVW;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean aVT = false;
    private boolean aVV = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.aVT = true;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(d.this.aVX);
            d.this.aVU = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.aVV) {
                d.this.aVV = false;
                for (a aVar : d.this.aVW) {
                    if (aVar != null) {
                        aVar.KD();
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.aVT = false;
            d.this.aVV = true;
            com.baidu.adp.lib.g.e.fP().postDelayed(d.this.aVX, 1000L);
        }
    };
    private Runnable aVX = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.aVT) {
                d.this.KC();
                com.baidu.adp.lib.g.e.fP().postDelayed(d.this.aVX, 1000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void KD();
    }

    private d() {
        KC();
        this.aVW = new HashSet();
    }

    public static d KB() {
        if (aVS == null) {
            synchronized (d.class) {
                if (aVS == null) {
                    aVS = new d();
                }
            }
        }
        return aVS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KC() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.aVT && this.aVU != null) {
            try {
                return this.aVU.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean a(a aVar) {
        return this.aVW.add(aVar);
    }

    public void b(a aVar) {
        this.aVW.remove(aVar);
    }
}
