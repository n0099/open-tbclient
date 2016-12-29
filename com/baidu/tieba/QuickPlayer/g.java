package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.baidu.tieba.QuickPlayer.c;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class g extends c.a {
    private WeakReference<Handler> aLr;

    public g(Handler handler) {
        this.aLr = new WeakReference<>(handler);
    }

    @Override // com.baidu.tieba.QuickPlayer.c
    public void IF() throws RemoteException {
        sendMessage(6);
    }

    @Override // com.baidu.tieba.QuickPlayer.c
    public void IG() throws RemoteException {
        sendMessage(7);
    }

    @Override // com.baidu.tieba.QuickPlayer.c
    public void N(int i, int i2) throws RemoteException {
        q(8, i, i2);
    }

    @Override // com.baidu.tieba.QuickPlayer.c
    public void O(int i, int i2) throws RemoteException {
        q(9, i, i2);
    }

    private void sendMessage(int i) {
        q(i, 0, 0);
    }

    private void q(int i, int i2, int i3) {
        if (this.aLr != null && this.aLr.get() != null) {
            Handler handler = this.aLr.get();
            Message obtainMessage = handler.obtainMessage(i);
            obtainMessage.arg1 = i2;
            obtainMessage.arg2 = i3;
            handler.sendMessage(obtainMessage);
        }
    }
}
