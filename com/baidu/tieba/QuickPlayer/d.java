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
    private static d aUm;
    private IQuickMediaPlayerService aUo;
    private Context mContext = TbadkCoreApplication.getInst();
    private boolean aUn = false;
    private ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.baidu.tieba.QuickPlayer.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.aUn = true;
            com.baidu.adp.lib.g.e.fQ().removeCallbacks(d.this.aUp);
            d.this.aUo = IQuickMediaPlayerService.Stub.asInterface(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.aUn = false;
            com.baidu.adp.lib.g.e.fQ().postDelayed(d.this.aUp, 1000L);
        }
    };
    private Runnable aUp = new Runnable() { // from class: com.baidu.tieba.QuickPlayer.d.2
        @Override // java.lang.Runnable
        public void run() {
            if (!d.this.aUn) {
                d.this.Ki();
                com.baidu.adp.lib.g.e.fQ().postDelayed(d.this.aUp, 1000L);
            }
        }
    };

    private d() {
        Ki();
    }

    public static d Kh() {
        if (aUm == null) {
            synchronized (d.class) {
                if (aUm == null) {
                    aUm = new d();
                }
            }
        }
        return aUm;
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
        if (this.aUn && this.aUo != null) {
            try {
                return this.aUo.createPlayer();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
