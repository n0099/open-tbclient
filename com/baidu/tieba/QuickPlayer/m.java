package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m {
    private static m aQA;
    private d aQC;
    private Context mContext = TbadkCoreApplication.m9getInst();
    private boolean aQB = false;
    private ServiceConnection mServiceConnection = new n(this);
    private Runnable aQD = new o(this);

    private m() {
        Ke();
    }

    public static m Kd() {
        if (aQA == null) {
            synchronized (m.class) {
                if (aQA == null) {
                    aQA = new m();
                }
            }
        }
        return aQA;
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
        if (this.aQB && this.aQC != null) {
            try {
                return this.aQC.JZ();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
