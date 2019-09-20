package com.baidu.tieba.QuickPlayer;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
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
    public void onError(int i, int i2, int i3) throws RemoteException {
        sendMessage(8, new com.baidu.tieba.play.c.d(i, i2, i3));
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener
    public void onInfo(int i, int i2) throws RemoteException {
        sendMessage(9, i, i2);
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener
    public void onSeekComplete() throws RemoteException {
        sendMessage(12);
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener
    public void onSubError(int i, int i2, String str) throws RemoteException {
        sendMessage(13, i, i2, str);
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener
    public void onHandleOppoError(String str) throws RemoteException {
        sendMessage(14, str);
    }

    @Override // com.baidu.tieba.QuickPlayer.IQuickMediaPlayerListener
    public void onSpeedWhenError(long j) throws RemoteException {
        sendMessage(15, Long.valueOf(j));
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

    private void sendMessage(int i, Object obj) {
        if (this.mHandler != null && this.mHandler.get() != null) {
            Handler handler = this.mHandler.get();
            Message obtainMessage = handler.obtainMessage(i);
            obtainMessage.obj = obj;
            handler.sendMessage(obtainMessage);
        }
    }

    private void sendMessage(int i, int i2, int i3, Object obj) {
        if (this.mHandler != null && this.mHandler.get() != null) {
            Handler handler = this.mHandler.get();
            Message obtainMessage = handler.obtainMessage(i);
            obtainMessage.arg1 = i2;
            obtainMessage.arg2 = i3;
            obtainMessage.obj = obj;
            handler.sendMessage(obtainMessage);
        }
    }
}
