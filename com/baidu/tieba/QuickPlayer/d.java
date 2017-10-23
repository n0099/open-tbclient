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
    private static d aVI;
    private IQuickMediaPlayerService aVK;
    private Set<a> aVM;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean aVJ = false;
    private boolean aVL = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.aVJ = true;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(d.this.aVN);
            d.this.aVK = IQuickMediaPlayerService.Stub.asInterface(iBinder);
            if (d.this.aVL) {
                d.this.aVL = false;
                for (a aVar : d.this.aVM) {
                    if (aVar != null) {
                        aVar.Ku();
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.aVJ = false;
            d.this.aVL = true;
            com.baidu.adp.lib.g.e.fP().postDelayed(d.this.aVN, 1000L);
        }
    };
    private Runnable aVN = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.aVJ) {
                d.this.Kt();
                com.baidu.adp.lib.g.e.fP().postDelayed(d.this.aVN, 1000L);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void Ku();
    }

    private d() {
        Kt();
        this.aVM = new HashSet();
    }

    public static d Ks() {
        if (aVI == null) {
            synchronized (d.class) {
                if (aVI == null) {
                    aVI = new d();
                }
            }
        }
        return aVI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kt() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.aVJ && this.aVK != null) {
            try {
                return this.aVK.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean a(a aVar) {
        return this.aVM.add(aVar);
    }

    public void b(a aVar) {
        this.aVM.remove(aVar);
    }
}
