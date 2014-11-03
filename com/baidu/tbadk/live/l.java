package com.baidu.tbadk.live;

import android.os.Handler;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ LiveGroupManager Vy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LiveGroupManager liveGroupManager) {
        this.Vy = liveGroupManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Handler handler;
        int i2;
        int i3;
        i = this.Vy.mAccTimesWhenNoStreamWarning;
        if (i > 0) {
            this.Vy.mAccTimesWhenNoStreamWarning = 0;
            handler = this.Vy.mHandler;
            handler.postDelayed(this, 20000L);
            i2 = this.Vy.mRetryTimesWhenNoStream;
            if (i2 < 2) {
                UtilHelper.showToast(TbadkApplication.m251getInst().getApp(), y.live_error_play_no_stream_retry);
                LiveGroupManager liveGroupManager = this.Vy;
                i3 = liveGroupManager.mRetryTimesWhenNoStream;
                liveGroupManager.mRetryTimesWhenNoStream = i3 + 1;
                this.Vy.retryPlay();
                return;
            }
            UtilHelper.showToast(TbadkApplication.m251getInst().getApp(), y.live_error_play_no_stream);
            this.Vy.mRetryTimesWhenNoStream = 0;
            this.Vy.stopAnyRunning();
            return;
        }
        this.Vy.mHasBookedWarningTask = false;
        this.Vy.mAccTimesWhenNoStreamWarning = 0;
        this.Vy.mRetryTimesWhenNoStream = 0;
    }
}
