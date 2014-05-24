package com.baidu.tbadk.coreExtra.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeMessage;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends CustomMessageListener {
    final /* synthetic */ LivePlayingStatusMgr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(LivePlayingStatusMgr livePlayingStatusMgr, int i) {
        super(i);
        this.a = livePlayingStatusMgr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LiveStatusChangeMessage.LiveStatusData data;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus;
        int i;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus2;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus3;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus4;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus5;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus6;
        if (customResponsedMessage.getCmd() == 2003161 && (customResponsedMessage instanceof LiveStatusChangeMessage) && (data = ((LiveStatusChangeMessage) customResponsedMessage).getData()) != null) {
            StringBuilder append = new StringBuilder("crs: LIVE_STATUS: ").append(data.status).append("; currState: ");
            livePlayingStatus = this.a.c;
            StringBuilder append2 = append.append(livePlayingStatus).append("; gid: ");
            i = this.a.b;
            BdLog.d(append2.append(i).toString());
            if (LiveStatusChangeMessage.isPlayingLive(data) || LiveStatusChangeMessage.isPublishing(data)) {
                livePlayingStatus2 = this.a.c;
                if (livePlayingStatus2 != LivePlayingStatusMgr.LivePlayingStatus.IDEL) {
                    livePlayingStatus3 = this.a.c;
                    if (livePlayingStatus3 != LivePlayingStatusMgr.LivePlayingStatus.JOINED) {
                        livePlayingStatus4 = this.a.c;
                        if (livePlayingStatus4 != LivePlayingStatusMgr.LivePlayingStatus.NO_PUBLISHER) {
                            return;
                        }
                    }
                }
                this.a.a(com.baidu.adp.lib.f.b.a(data.groupId, 0), LivePlayingStatusMgr.LivePlayingStatus.PLAYING);
            } else if (data.status == 0) {
                livePlayingStatus5 = this.a.c;
                if (livePlayingStatus5 != LivePlayingStatusMgr.LivePlayingStatus.PAUSE) {
                    livePlayingStatus6 = this.a.c;
                    if (livePlayingStatus6 != LivePlayingStatusMgr.LivePlayingStatus.PLAYING) {
                        return;
                    }
                }
                this.a.a(0, LivePlayingStatusMgr.LivePlayingStatus.IDEL);
            }
        }
    }
}
