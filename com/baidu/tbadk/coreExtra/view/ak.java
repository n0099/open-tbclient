package com.baidu.tbadk.coreExtra.view;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends Handler {
    final /* synthetic */ LivePlayingStatusMgr OJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(LivePlayingStatusMgr livePlayingStatusMgr) {
        this.OJ = livePlayingStatusMgr;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus;
        if (message != null) {
            LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus2 = (LivePlayingStatusMgr.LivePlayingStatus) message.obj;
            try {
                this.OJ.OG = (LivePlayingStatusMgr.LivePlayingStatus) message.obj;
                this.OJ.gid = message.arg1;
                LivePlayingStatusMgr livePlayingStatusMgr = this.OJ;
                livePlayingStatus = this.OJ.OG;
                livePlayingStatusMgr.b(livePlayingStatus);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
