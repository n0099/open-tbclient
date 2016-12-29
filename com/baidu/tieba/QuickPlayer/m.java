package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m {
    private static m aLx;
    private d aLz;
    private Context mContext = TbadkCoreApplication.m9getInst();
    private boolean aLy = false;
    private ServiceConnection mServiceConnection = new n(this);
    private Runnable aLA = new o(this);

    private m() {
        IM();
    }

    public static m IL() {
        if (aLx == null) {
            synchronized (m.class) {
                if (aLx == null) {
                    aLx = new m();
                }
            }
        }
        return aLx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IM() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public b IH() {
        if (this.aLy && this.aLz != null) {
            try {
                return this.aLz.IH();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
