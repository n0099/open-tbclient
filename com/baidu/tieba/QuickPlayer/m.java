package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m {
    private static m aSp;
    private d aSr;
    private Context mContext = TbadkCoreApplication.m9getInst();
    private boolean aSq = false;
    private ServiceConnection mServiceConnection = new n(this);
    private Runnable aSs = new o(this);

    private m() {
        JN();
    }

    public static m JM() {
        if (aSp == null) {
            synchronized (m.class) {
                if (aSp == null) {
                    aSp = new m();
                }
            }
        }
        return aSp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JN() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public b JI() {
        if (this.aSq && this.aSr != null) {
            try {
                return this.aSr.JI();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
