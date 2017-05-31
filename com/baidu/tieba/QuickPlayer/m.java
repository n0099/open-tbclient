package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m {
    private static m aQW;
    private d aQY;
    private Context mContext = TbadkCoreApplication.m9getInst();
    private boolean aQX = false;
    private ServiceConnection mServiceConnection = new n(this);
    private Runnable aQZ = new o(this);

    private m() {
        Jp();
    }

    public static m Jo() {
        if (aQW == null) {
            synchronized (m.class) {
                if (aQW == null) {
                    aQW = new m();
                }
            }
        }
        return aQW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jp() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public b Jk() {
        if (this.aQX && this.aQY != null) {
            try {
                return this.aQY.Jk();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
