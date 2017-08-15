package com.baidu.tieba.QuickPlayer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.QuickPlayer.IQuickMediaPlayerService;
/* loaded from: classes.dex */
public class d {
    private static d aUG;
    private IQuickMediaPlayerService aUI;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean aUH = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.aUH = true;
            com.baidu.adp.lib.g.e.ga().removeCallbacks(d.this.aUJ);
            d.this.aUI = IQuickMediaPlayerService.Stub.asInterface(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.aUH = false;
            com.baidu.adp.lib.g.e.ga().postDelayed(d.this.aUJ, 1000L);
        }
    };
    private Runnable aUJ = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.aUH) {
                d.this.JZ();
                com.baidu.adp.lib.g.e.ga().postDelayed(d.this.aUJ, 1000L);
            }
        }
    };

    private d() {
        JZ();
    }

    public static d JY() {
        if (aUG == null) {
            synchronized (d.class) {
                if (aUG == null) {
                    aUG = new d();
                }
            }
        }
        return aUG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JZ() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.aUH && this.aUI != null) {
            try {
                return this.aUI.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
