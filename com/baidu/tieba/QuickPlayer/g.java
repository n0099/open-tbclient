package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.baidu.tieba.QuickPlayer.c;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class g extends c.a {
    private WeakReference<Handler> aQe;

    public g(Handler handler) {
        this.aQe = new WeakReference<>(handler);
    }

    @Override // com.baidu.tieba.QuickPlayer.c
    public void Jx() throws RemoteException {
        sendMessage(6);
    }

    @Override // com.baidu.tieba.QuickPlayer.c
    public void Jy() throws RemoteException {
        sendMessage(7);
    }

    @Override // com.baidu.tieba.QuickPlayer.c
    public void T(int i, int i2) throws RemoteException {
        p(8, i, i2);
    }

    @Override // com.baidu.tieba.QuickPlayer.c
    public void U(int i, int i2) throws RemoteException {
        p(9, i, i2);
    }

    private void sendMessage(int i) {
        p(i, 0, 0);
    }

    private void p(int i, int i2, int i3) {
        if (this.aQe != null && this.aQe.get() != null) {
            Handler handler = this.aQe.get();
            Message obtainMessage = handler.obtainMessage(i);
            obtainMessage.arg1 = i2;
            obtainMessage.arg2 = i3;
            handler.sendMessage(obtainMessage);
        }
    }
}
