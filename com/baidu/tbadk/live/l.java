package com.baidu.tbadk.live;

import android.os.Handler;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ LiveGroupManager abA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(LiveGroupManager liveGroupManager) {
        this.abA = liveGroupManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        Handler handler;
        int i2;
        int i3;
        i = this.abA.mAccTimesWhenNoStreamWarning;
        if (i > 0) {
            this.abA.mAccTimesWhenNoStreamWarning = 0;
            handler = this.abA.mHandler;
            handler.postDelayed(this, 20000L);
            i2 = this.abA.mRetryTimesWhenNoStream;
            if (i2 < 2) {
                UtilHelper.showToast(TbadkApplication.getInst().getApp(), z.live_error_play_no_stream_retry);
                LiveGroupManager liveGroupManager = this.abA;
                i3 = liveGroupManager.mRetryTimesWhenNoStream;
                liveGroupManager.mRetryTimesWhenNoStream = i3 + 1;
                this.abA.retryPlay();
                return;
            }
            UtilHelper.showToast(TbadkApplication.getInst().getApp(), z.live_error_play_no_stream);
            this.abA.mRetryTimesWhenNoStream = 0;
            this.abA.stopAnyRunning();
            return;
        }
        this.abA.mHasBookedWarningTask = false;
        this.abA.mAccTimesWhenNoStreamWarning = 0;
        this.abA.mRetryTimesWhenNoStream = 0;
    }
}
