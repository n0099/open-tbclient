package com.baidu.tbadk.live;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.ExitAppMessage;
/* loaded from: classes.dex */
class i extends CustomMessageListener {
    final /* synthetic */ LiveGroupManager Vy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(LiveGroupManager liveGroupManager, int i) {
        super(i);
        this.Vy = liveGroupManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage.getCmd() == 2001171 && (customResponsedMessage instanceof ExitAppMessage) && !((ExitAppMessage) customResponsedMessage).hasError()) {
            this.Vy.stopAnyRunning();
        }
    }
}
