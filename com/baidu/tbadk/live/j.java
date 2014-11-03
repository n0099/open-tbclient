package com.baidu.tbadk.live;

import android.os.Handler;
import com.baidu.tbadk.live.service.LiveStatusParcelable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.tbadk.live.service.e {
    final /* synthetic */ LiveGroupManager Vy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LiveGroupManager liveGroupManager) {
        this.Vy = liveGroupManager;
    }

    @Override // com.baidu.tbadk.live.service.d
    public void a(LiveStatusParcelable liveStatusParcelable) {
        Handler handler;
        Handler handler2;
        handler = this.Vy.mHandler;
        handler2 = this.Vy.mHandler;
        handler.sendMessage(handler2.obtainMessage(1, liveStatusParcelable));
    }

    @Override // com.baidu.tbadk.live.service.d
    public void dB(String str) {
        Handler handler;
        Handler handler2;
        handler = this.Vy.mHandler;
        handler2 = this.Vy.mHandler;
        handler.sendMessage(handler2.obtainMessage(2, str));
    }

    @Override // com.baidu.tbadk.live.service.d
    public void e(String str, int i, int i2) {
        Handler handler;
        Handler handler2;
        handler = this.Vy.mHandler;
        handler2 = this.Vy.mHandler;
        handler.sendMessage(handler2.obtainMessage(3, i, i2, str));
    }

    @Override // com.baidu.tbadk.live.service.d
    public void cU(int i) {
        Handler handler;
        Handler handler2;
        handler = this.Vy.mHandler;
        handler2 = this.Vy.mHandler;
        handler.sendMessage(handler2.obtainMessage(4, i, i));
    }

    @Override // com.baidu.tbadk.live.service.d
    public void cV(int i) {
        Handler handler;
        Handler handler2;
        handler = this.Vy.mHandler;
        handler2 = this.Vy.mHandler;
        handler.sendMessage(handler2.obtainMessage(5, i, i));
    }
}
