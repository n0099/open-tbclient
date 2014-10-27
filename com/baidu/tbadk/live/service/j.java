package com.baidu.tbadk.live.service;

import android.os.Handler;
import java.util.TimerTask;
/* loaded from: classes.dex */
class j extends TimerTask {
    final /* synthetic */ h Vw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.Vw = hVar;
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
        liveGroupManagerService = this.Vw.Vv;
        i = liveGroupManagerService.mRecordTime;
        liveGroupManagerService.mRecordTime = i + 1;
        liveGroupManagerService2 = this.Vw.Vv;
        handler = liveGroupManagerService2.mHandler;
        liveGroupManagerService3 = this.Vw.Vv;
        handler2 = liveGroupManagerService3.mHandler;
        liveGroupManagerService4 = this.Vw.Vv;
        i2 = liveGroupManagerService4.mRecordTime;
        liveGroupManagerService5 = this.Vw.Vv;
        i3 = liveGroupManagerService5.mRecordTime;
        handler.sendMessage(handler2.obtainMessage(4, i2, i3));
    }
}
