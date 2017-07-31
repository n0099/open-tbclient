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
    private static d aUF;
    private IQuickMediaPlayerService aUH;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean aUG = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.aUG = true;
            com.baidu.adp.lib.g.e.ga().removeCallbacks(d.this.aUI);
            d.this.aUH = IQuickMediaPlayerService.Stub.asInterface(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.aUG = false;
            com.baidu.adp.lib.g.e.ga().postDelayed(d.this.aUI, 1000L);
        }
    };
    private Runnable aUI = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.aUG) {
                d.this.JZ();
                com.baidu.adp.lib.g.e.ga().postDelayed(d.this.aUI, 1000L);
            }
        }
    };

    private d() {
        JZ();
    }

    public static d JY() {
        if (aUF == null) {
            synchronized (d.class) {
                if (aUF == null) {
                    aUF = new d();
                }
            }
        }
        return aUF;
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
        if (this.aUG && this.aUH != null) {
            try {
                return this.aUH.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
