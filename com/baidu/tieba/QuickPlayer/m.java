package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m {
    private static m aQV;
    private d aQX;
    private Context mContext = TbadkCoreApplication.m9getInst();
    private boolean aQW = false;
    private ServiceConnection mServiceConnection = new n(this);
    private Runnable aQY = new o(this);

    private m() {
        Js();
    }

    public static m Jr() {
        if (aQV == null) {
            synchronized (m.class) {
                if (aQV == null) {
                    aQV = new m();
                }
            }
        }
        return aQV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Js() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public b Jn() {
        if (this.aQW && this.aQX != null) {
            try {
                return this.aQX.Jn();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
