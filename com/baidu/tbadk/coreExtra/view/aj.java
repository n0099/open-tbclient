package com.baidu.tbadk.coreExtra.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeMessage;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
/* loaded from: classes.dex */
class aj extends CustomMessageListener {
    final /* synthetic */ LivePlayingStatusMgr ags;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(LivePlayingStatusMgr livePlayingStatusMgr, int i) {
        super(i);
        this.ags = livePlayingStatusMgr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LiveStatusChangeMessage.LiveStatusData data;
        if (customResponsedMessage.getCmd() == 2001161 && (customResponsedMessage instanceof LiveStatusChangeMessage) && (data = ((LiveStatusChangeMessage) customResponsedMessage).getData()) != null) {
            if (LiveStatusChangeMessage.isPlayingLive(data) || LiveStatusChangeMessage.isPublishing(data)) {
                this.ags.a(com.baidu.adp.lib.g.c.toInt(data.groupId, 0), LivePlayingStatusMgr.LivePlayingStatus.PLAYING);
            } else {
                this.ags.a(0, LivePlayingStatusMgr.LivePlayingStatus.IDEL);
            }
        }
    }
}
