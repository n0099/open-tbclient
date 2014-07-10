package com.baidu.tbadk.coreExtra.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeMessage;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends CustomMessageListener {
    final /* synthetic */ LivePlayingStatusMgr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(LivePlayingStatusMgr livePlayingStatusMgr, int i) {
        super(i);
        this.a = livePlayingStatusMgr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LiveStatusChangeMessage.LiveStatusData data;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus2;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus3;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus4;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus5;
        if (customResponsedMessage.getCmd() == 2001161 && (customResponsedMessage instanceof LiveStatusChangeMessage) && (data = ((LiveStatusChangeMessage) customResponsedMessage).getData()) != null) {
            if (LiveStatusChangeMessage.isPlayingLive(data) || LiveStatusChangeMessage.isPublishing(data)) {
                livePlayingStatus = this.a.c;
                if (livePlayingStatus != LivePlayingStatusMgr.LivePlayingStatus.IDEL) {
                    livePlayingStatus2 = this.a.c;
                    if (livePlayingStatus2 != LivePlayingStatusMgr.LivePlayingStatus.JOINED) {
                        livePlayingStatus3 = this.a.c;
                        if (livePlayingStatus3 != LivePlayingStatusMgr.LivePlayingStatus.NO_PUBLISHER) {
                            return;
                        }
                    }
                }
                this.a.a(com.baidu.adp.lib.f.b.a(data.groupId, 0), LivePlayingStatusMgr.LivePlayingStatus.PLAYING);
            } else if (data.status == 0) {
                livePlayingStatus4 = this.a.c;
                if (livePlayingStatus4 != LivePlayingStatusMgr.LivePlayingStatus.PAUSE) {
                    livePlayingStatus5 = this.a.c;
                    if (livePlayingStatus5 != LivePlayingStatusMgr.LivePlayingStatus.PLAYING) {
                        return;
                    }
                }
                this.a.a(0, LivePlayingStatusMgr.LivePlayingStatus.IDEL);
            }
        }
    }
}
