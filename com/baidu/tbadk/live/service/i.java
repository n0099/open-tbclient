package com.baidu.tbadk.live.service;

import android.os.Handler;
import java.util.TimerTask;
/* loaded from: classes.dex */
class i extends TimerTask {
    final /* synthetic */ h abC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.abC = hVar;
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
        liveGroupManagerService = this.abC.abB;
        i = liveGroupManagerService.mRecordTime;
        liveGroupManagerService.mRecordTime = i + 1;
        liveGroupManagerService2 = this.abC.abB;
        handler = liveGroupManagerService2.mHandler;
        liveGroupManagerService3 = this.abC.abB;
        handler2 = liveGroupManagerService3.mHandler;
        liveGroupManagerService4 = this.abC.abB;
        i2 = liveGroupManagerService4.mRecordTime;
        liveGroupManagerService5 = this.abC.abB;
        i3 = liveGroupManagerService5.mRecordTime;
        handler.sendMessage(handler2.obtainMessage(4, i2, i3));
    }
}
