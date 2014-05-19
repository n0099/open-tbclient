package com.baidu.tbadk.coreExtra.view;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends Handler {
    final /* synthetic */ LivePlayingStatusMgr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(LivePlayingStatusMgr livePlayingStatusMgr) {
        this.a = livePlayingStatusMgr;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus;
        if (message != null) {
            LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus2 = (LivePlayingStatusMgr.LivePlayingStatus) message.obj;
            if (livePlayingStatus2 == LivePlayingStatusMgr.LivePlayingStatus.IDEL) {
                BdLog.i("crs: IDEL");
            } else if (livePlayingStatus2 == LivePlayingStatusMgr.LivePlayingStatus.JOINED) {
                BdLog.i("crs: JOINED");
            } else if (livePlayingStatus2 == LivePlayingStatusMgr.LivePlayingStatus.NO_PUBLISHER) {
                BdLog.i("crs: NO_PUBLISHER");
            } else if (livePlayingStatus2 == LivePlayingStatusMgr.LivePlayingStatus.PAUSE) {
                BdLog.i("crs: PAUSE");
            } else if (livePlayingStatus2 == LivePlayingStatusMgr.LivePlayingStatus.PLAYING) {
                BdLog.i("crs: PLAYING");
            }
            try {
                this.a.c = (LivePlayingStatusMgr.LivePlayingStatus) message.obj;
                this.a.b = message.arg1;
                LivePlayingStatusMgr livePlayingStatusMgr = this.a;
                livePlayingStatus = this.a.c;
                livePlayingStatusMgr.a(livePlayingStatus);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
