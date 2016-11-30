package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.baidu.tieba.QuickPlayer.c;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class g extends c.a {
    private WeakReference<Handler> aMa;

    public g(Handler handler) {
        this.aMa = new WeakReference<>(handler);
    }

    @Override // com.baidu.tieba.QuickPlayer.c
    public void Jk() throws RemoteException {
        sendMessage(6);
    }

    @Override // com.baidu.tieba.QuickPlayer.c
    public void Jl() throws RemoteException {
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
        if (this.aMa != null && this.aMa.get() != null) {
            Handler handler = this.aMa.get();
            Message obtainMessage = handler.obtainMessage(i);
            obtainMessage.arg1 = i2;
            obtainMessage.arg2 = i3;
            handler.sendMessage(obtainMessage);
        }
    }
}
