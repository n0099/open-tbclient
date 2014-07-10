package com.baidu.tieba.im.live.service;

import android.os.Handler;
import java.util.TimerTask;
/* loaded from: classes.dex */
class c extends TimerTask {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        LiveGroupManagerService liveGroupManagerService;
        int i;
        LiveGroupManagerService liveGroupManagerService2;
        Handler handler;
        LiveGroupManagerService liveGroupManagerService3;
        Handler handler2;
        LiveGroupManagerService liveGroupManagerService4;
        int i2;
        LiveGroupManagerService liveGroupManagerService5;
        int i3;
        liveGroupManagerService = this.a.a;
        i = liveGroupManagerService.mRecordTime;
        liveGroupManagerService.mRecordTime = i + 1;
        liveGroupManagerService2 = this.a.a;
        handler = liveGroupManagerService2.mHandler;
        liveGroupManagerService3 = this.a.a;
        handler2 = liveGroupManagerService3.mHandler;
        liveGroupManagerService4 = this.a.a;
        i2 = liveGroupManagerService4.mRecordTime;
        liveGroupManagerService5 = this.a.a;
        i3 = liveGroupManagerService5.mRecordTime;
        handler.sendMessage(handler2.obtainMessage(4, i2, i3));
    }
}
