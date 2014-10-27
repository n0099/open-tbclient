package com.baidu.tbadk.live;

import android.os.Handler;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ LiveGroupManager Vu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LiveGroupManager liveGroupManager) {
        this.Vu = liveGroupManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Handler handler;
        int i2;
        int i3;
        i = this.Vu.mAccTimesWhenNoStreamWarning;
        if (i > 0) {
            this.Vu.mAccTimesWhenNoStreamWarning = 0;
            handler = this.Vu.mHandler;
            handler.postDelayed(this, 20000L);
            i2 = this.Vu.mRetryTimesWhenNoStream;
            if (i2 < 2) {
                UtilHelper.showToast(TbadkApplication.m251getInst().getApp(), y.live_error_play_no_stream_retry);
                LiveGroupManager liveGroupManager = this.Vu;
                i3 = liveGroupManager.mRetryTimesWhenNoStream;
                liveGroupManager.mRetryTimesWhenNoStream = i3 + 1;
                this.Vu.retryPlay();
                return;
            }
            UtilHelper.showToast(TbadkApplication.m251getInst().getApp(), y.live_error_play_no_stream);
            this.Vu.mRetryTimesWhenNoStream = 0;
            this.Vu.stopAnyRunning();
            return;
        }
        this.Vu.mHasBookedWarningTask = false;
        this.Vu.mAccTimesWhenNoStreamWarning = 0;
        this.Vu.mRetryTimesWhenNoStream = 0;
    }
}
