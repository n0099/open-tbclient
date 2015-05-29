package com.baidu.tbadk.coreExtra.view;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends Handler {
    final /* synthetic */ LivePlayingStatusMgr ags;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(LivePlayingStatusMgr livePlayingStatusMgr) {
        this.ags = livePlayingStatusMgr;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus;
        if (message != null) {
            LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus2 = (LivePlayingStatusMgr.LivePlayingStatus) message.obj;
            try {
                this.ags.agp = (LivePlayingStatusMgr.LivePlayingStatus) message.obj;
                this.ags.gid = message.arg1;
                LivePlayingStatusMgr livePlayingStatusMgr = this.ags;
                livePlayingStatus = this.ags.agp;
                livePlayingStatusMgr.b(livePlayingStatus);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
