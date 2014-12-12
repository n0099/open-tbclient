package com.baidu.tbadk.coreExtra.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.LivePlayingStatusMessage;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
/* loaded from: classes.dex */
class ax extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof LivePlayingStatusMessage) {
            LivePlayingStatusMgr.ty().a(0, LivePlayingStatusMgr.LivePlayingStatus.IDEL);
        }
    }
}
