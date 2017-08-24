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
    private static d aUH;
    private IQuickMediaPlayerService aUJ;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean aUI = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.aUI = true;
            com.baidu.adp.lib.g.e.ga().removeCallbacks(d.this.aUK);
            d.this.aUJ = IQuickMediaPlayerService.Stub.asInterface(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.aUI = false;
            com.baidu.adp.lib.g.e.ga().postDelayed(d.this.aUK, 1000L);
        }
    };
    private Runnable aUK = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.aUI) {
                d.this.JZ();
                com.baidu.adp.lib.g.e.ga().postDelayed(d.this.aUK, 1000L);
            }
        }
    };

    private d() {
        JZ();
    }

    public static d JY() {
        if (aUH == null) {
            synchronized (d.class) {
                if (aUH == null) {
                    aUH = new d();
                }
            }
        }
        return aUH;
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
        if (this.aUI && this.aUJ != null) {
            try {
                return this.aUJ.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
