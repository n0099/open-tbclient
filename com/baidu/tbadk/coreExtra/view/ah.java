package com.baidu.tbadk.coreExtra.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
        int i;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus2;
        LivePlayingStatusMgr.LivePlayingStatus livePlayingStatus3;
        if (customResponsedMessage.getCmd() == 2003161 && (customResponsedMessage instanceof LiveStatusChangeMessage) && (data = ((LiveStatusChangeMessage) customResponsedMessage).getData()) != null) {
            i = this.a.b;
            if (i != 0) {
                if (LiveStatusChangeMessage.isPlayingLive(data) || LiveStatusChangeMessage.isPublishing(data)) {
                    livePlayingStatus = this.a.c;
                    if (livePlayingStatus == LivePlayingStatusMgr.LivePlayingStatus.IDEL) {
                        this.a.a(com.baidu.adp.lib.f.b.a(data.groupId, 0), LivePlayingStatusMgr.LivePlayingStatus.PLAYING);
                    }
                } else if (data.status == 0) {
                    livePlayingStatus2 = this.a.c;
                    if (livePlayingStatus2 != LivePlayingStatusMgr.LivePlayingStatus.PAUSE) {
                        livePlayingStatus3 = this.a.c;
                        if (livePlayingStatus3 != LivePlayingStatusMgr.LivePlayingStatus.PLAYING) {
                            return;
                        }
                    }
                    this.a.a(com.baidu.adp.lib.f.b.a(data.groupId, 0), LivePlayingStatusMgr.LivePlayingStatus.IDEL);
                }
            }
        }
    }
}
