package com.baidu.tbadk.coreExtra.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeMessage;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends CustomMessageListener {
    final /* synthetic */ LivePlayingStatusMgr OJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(LivePlayingStatusMgr livePlayingStatusMgr, int i) {
        super(i);
        this.OJ = livePlayingStatusMgr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LiveStatusChangeMessage.LiveStatusData data;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus2;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus3;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus4;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus5;
        if (customResponsedMessage.getCmd() == 2001161 && (customResponsedMessage instanceof LiveStatusChangeMessage) && (data = ((LiveStatusChangeMessage) customResponsedMessage).getData()) != null) {
            if (LiveStatusChangeMessage.isPlayingLive(data) || LiveStatusChangeMessage.isPublishing(data)) {
                livePlayingStatus = this.OJ.OG;
                if (livePlayingStatus != LivePlayingStatusMgr.LivePlayingStatus.IDEL) {
                    livePlayingStatus2 = this.OJ.OG;
                    if (livePlayingStatus2 != LivePlayingStatusMgr.LivePlayingStatus.JOINED) {
                        livePlayingStatus3 = this.OJ.OG;
                        if (livePlayingStatus3 != LivePlayingStatusMgr.LivePlayingStatus.NO_PUBLISHER) {
                            return;
                        }
                    }
                }
                this.OJ.a(com.baidu.adp.lib.g.c.f(data.groupId, 0), LivePlayingStatusMgr.LivePlayingStatus.PLAYING);
            } else if (data.status == 0) {
                livePlayingStatus4 = this.OJ.OG;
                if (livePlayingStatus4 != LivePlayingStatusMgr.LivePlayingStatus.PAUSE) {
                    livePlayingStatus5 = this.OJ.OG;
                    if (livePlayingStatus5 != LivePlayingStatusMgr.LivePlayingStatus.PLAYING) {
                        return;
                    }
                }
                this.OJ.a(0, LivePlayingStatusMgr.LivePlayingStatus.IDEL);
            }
        }
    }
}
