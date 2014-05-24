package com.baidu.tieba.im.live;

import android.os.Handler;
import com.baidu.tieba.im.live.service.IRemoteCallback;
import com.baidu.tieba.im.live.service.LiveStatusParcelable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends IRemoteCallback.Stub {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.tieba.im.live.service.IRemoteCallback
    public void onLiveStatusChangeEvent(LiveStatusParcelable liveStatusParcelable) {
        Handler handler;
        Handler handler2;
        handler = this.a.q;
        handler2 = this.a.q;
        handler.sendMessage(handler2.obtainMessage(1, liveStatusParcelable));
    }

    @Override // com.baidu.tieba.im.live.service.IRemoteCallback
    public void onLiveErrorEvent(String str) {
        Handler handler;
        Handler handler2;
        handler = this.a.q;
        handler2 = this.a.q;
        handler.sendMessage(handler2.obtainMessage(2, str));
    }

    @Override // com.baidu.tieba.im.live.service.IRemoteCallback
    public void onLivePlayProgressUpdate(String str, int i, int i2) {
        Handler handler;
        Handler handler2;
        handler = this.a.q;
        handler2 = this.a.q;
        handler.sendMessage(handler2.obtainMessage(3, i, i2, str));
    }

    @Override // com.baidu.tieba.im.live.service.IRemoteCallback
    public void onLiveRecordTimeUpdate(int i) {
        Handler handler;
        Handler handler2;
        handler = this.a.q;
        handler2 = this.a.q;
        handler.sendMessage(handler2.obtainMessage(4, i, i));
    }

    @Override // com.baidu.tieba.im.live.service.IRemoteCallback
    public void onLivePlayWarning(int i) {
        Handler handler;
        Handler handler2;
        handler = this.a.q;
        handler2 = this.a.q;
        handler.sendMessage(handler2.obtainMessage(5, i, i));
    }
}
