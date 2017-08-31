package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class PlayerListener extends IQuickMediaPlayerListener.Stub {
    private WeakReference<Handler> mHandler;

    public PlayerListener(Handler handler) {
        this.mHandler = new WeakReference<>(handler);
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener
    public void onPrepared() throws RemoteException {
        sendMessage(6);
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener
    public void onCompletion() throws RemoteException {
        sendMessage(7);
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener
    public void onError(int i, int i2) throws RemoteException {
        sendMessage(8, i, i2);
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener
    public void onInfo(int i, int i2) throws RemoteException {
        sendMessage(9, i, i2);
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener
    public void onReleaseFinished() throws RemoteException {
        sendMessage(11);
    }

    private void sendMessage(int i) {
        sendMessage(i, 0, 0);
    }

    private void sendMessage(int i, int i2, int i3) {
        if (this.mHandler != null && this.mHandler.get() != null) {
            Handler handler = this.mHandler.get();
            Message obtainMessage = handler.obtainMessage(i);
            obtainMessage.arg1 = i2;
            obtainMessage.arg2 = i3;
            handler.sendMessage(obtainMessage);
        }
    }
}
