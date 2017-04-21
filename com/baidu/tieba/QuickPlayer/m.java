package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m {
    private static m aQC;
    private d aQE;
    private Context mContext = TbadkCoreApplication.m9getInst();
    private boolean aQD = false;
    private ServiceConnection mServiceConnection = new n(this);
    private Runnable aQF = new o(this);

    private m() {
        Ke();
    }

    public static m Kd() {
        if (aQC == null) {
            synchronized (m.class) {
                if (aQC == null) {
                    aQC = new m();
                }
            }
        }
        return aQC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ke() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public b JZ() {
        if (this.aQD && this.aQE != null) {
            try {
                return this.aQE.JZ();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
