package com.baidu.tbadk.coreExtra.view;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends Handler {
    final /* synthetic */ LivePlayingStatusMgr OO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(LivePlayingStatusMgr livePlayingStatusMgr) {
        this.OO = livePlayingStatusMgr;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus;
        if (message != null) {
            LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus2 = (LivePlayingStatusMgr.LivePlayingStatus) message.obj;
            try {
                this.OO.OK = (LivePlayingStatusMgr.LivePlayingStatus) message.obj;
                this.OO.gid = message.arg1;
                LivePlayingStatusMgr livePlayingStatusMgr = this.OO;
                livePlayingStatus = this.OO.OK;
                livePlayingStatusMgr.b(livePlayingStatus);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
