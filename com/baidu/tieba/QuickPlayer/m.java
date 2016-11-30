package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m {
    private static m aMg;
    private d aMi;
    private Context mContext = TbadkCoreApplication.m9getInst();
    private boolean aMh = false;
    private ServiceConnection mServiceConnection = new n(this);
    private Runnable aMj = new o(this);

    private m() {
        Jr();
    }

    public static m Jq() {
        if (aMg == null) {
            synchronized (m.class) {
                if (aMg == null) {
                    aMg = new m();
                }
            }
        }
        return aMg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jr() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public b Jm() {
        if (this.aMh && this.aMi != null) {
            try {
                return this.aMi.Jm();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
