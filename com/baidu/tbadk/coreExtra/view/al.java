package com.baidu.tbadk.coreExtra.view;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends Handler {
    final /* synthetic */ LivePlayingStatusMgr Vf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(LivePlayingStatusMgr livePlayingStatusMgr) {
        this.Vf = livePlayingStatusMgr;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus;
        if (message != null) {
            LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus2 = (LivePlayingStatusMgr.LivePlayingStatus) message.obj;
            try {
                this.Vf.Vc = (LivePlayingStatusMgr.LivePlayingStatus) message.obj;
                this.Vf.gid = message.arg1;
                LivePlayingStatusMgr livePlayingStatusMgr = this.Vf;
                livePlayingStatus = this.Vf.Vc;
                livePlayingStatusMgr.b(livePlayingStatus);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
