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
    private static d aUp;
    private IQuickMediaPlayerService aUr;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean aUq = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.aUq = true;
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(d.this.aUs);
            d.this.aUr = IQuickMediaPlayerService.Stub.asInterface(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.aUq = false;
            com.baidu.adp.lib.g.e.fQ().postDelayed(d.this.aUs, 1000L);
        }
    };
    private Runnable aUs = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.aUq) {
                d.this.Ki();
                com.baidu.adp.lib.g.e.fQ().postDelayed(d.this.aUs, 1000L);
            }
        }
    };

    private d() {
        Ki();
    }

    public static d Kh() {
        if (aUp == null) {
            synchronized (d.class) {
                if (aUp == null) {
                    aUp = new d();
                }
            }
        }
        return aUp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ki() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public IQuickMediaPlayer createPlayer() {
        if (this.aUq && this.aUr != null) {
            try {
                return this.aUr.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
