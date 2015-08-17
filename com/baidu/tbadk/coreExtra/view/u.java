package com.baidu.tbadk.coreExtra.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeMessage;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
/* loaded from: classes.dex */
class u extends CustomMessageListener {
    final /* synthetic */ LivePlayingStatusMgr alz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(LivePlayingStatusMgr livePlayingStatusMgr, int i) {
        super(i);
        this.alz = livePlayingStatusMgr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LiveStatusChangeMessage.LiveStatusData data;
        if (customResponsedMessage.getCmd() == 2001161 && (customResponsedMessage instanceof LiveStatusChangeMessage) && (data = ((LiveStatusChangeMessage) customResponsedMessage).getData()) != null) {
            if (LiveStatusChangeMessage.isPlayingLive(data) || LiveStatusChangeMessage.isPublishing(data)) {
                this.alz.a(com.baidu.adp.lib.g.b.g(data.groupId, 0), LivePlayingStatusMgr.LivePlayingStatus.PLAYING);
            } else if (20 != data.status && 4 != data.status) {
                this.alz.a(0, LivePlayingStatusMgr.LivePlayingStatus.IDEL);
            }
        }
    }
}
