package com.baidu.tieba.QuickPlayer;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class m {
    private static m aKz;
    private d aKB;
    private Context mContext = TbadkCoreApplication.m9getInst();
    private boolean aKA = false;
    private ServiceConnection mServiceConnection = new n(this);
    private Runnable aKC = new o(this);

    private m() {
        IZ();
    }

    public static m IY() {
        if (aKz == null) {
            synchronized (m.class) {
                if (aKz == null) {
                    aKz = new m();
                }
            }
        }
        return aKz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IZ() {
        try {
            this.mContext.bindService(new Intent(this.mContext, QuickMediaPlayerService.class), this.mServiceConnection, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public b IU() {
        if (this.aKA && this.aKB != null) {
            try {
                return this.aKB.IU();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
