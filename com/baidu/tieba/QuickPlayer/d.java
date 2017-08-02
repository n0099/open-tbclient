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
    private static d aTt;
    private IQuickMediaPlayerService aTv;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean aTu = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.aTu = true;
            com.baidu.adp.lib.g.e.fP().removeCallbacks(d.this.aTw);
            d.this.aTv = IQuickMediaPlayerService.Stub.asInterface(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.aTu = false;
            com.baidu.adp.lib.g.e.fP().postDelayed(d.this.aTw, 1000L);
        }
    };
    private Runnable aTw = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.aTu) {
                d.this.JT();
                com.baidu.adp.lib.g.e.fP().postDelayed(d.this.aTw, 1000L);
            }
        }
    };

    private d() {
        JT();
    }

    public static d JS() {
        if (aTt == null) {
            synchronized (d.class) {
                if (aTt == null) {
                    aTt = new d();
                }
            }
        }
        return aTt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JT() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.aTu && this.aTv != null) {
            try {
                return this.aTv.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
