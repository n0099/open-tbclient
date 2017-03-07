package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m {
    private static m aQk;
    private d aQm;
    private Context mContext = TbadkCoreApplication.m9getInst();
    private boolean aQl = false;
    private ServiceConnection mServiceConnection = new n(this);
    private Runnable aQn = new o(this);

    private m() {
        JE();
    }

    public static m JD() {
        if (aQk == null) {
            synchronized (m.class) {
                if (aQk == null) {
                    aQk = new m();
                }
            }
        }
        return aQk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JE() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public b Jz() {
        if (this.aQl && this.aQm != null) {
            try {
                return this.aQm.Jz();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
