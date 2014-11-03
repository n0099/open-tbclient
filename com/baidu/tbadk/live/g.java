package com.baidu.tbadk.live;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.NetWorkChangeMessage;
/* loaded from: classes.dex */
class g extends CustomMessageListener {
    final /* synthetic */ LiveGroupManager Vy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(LiveGroupManager liveGroupManager, int i) {
        super(i);
        this.Vy = liveGroupManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof NetWorkChangeMessage) {
            NetWorkChangeMessage netWorkChangeMessage = (NetWorkChangeMessage) customResponsedMessage;
            if (!netWorkChangeMessage.hasError() && netWorkChangeMessage.mState == 0) {
                this.Vy.stopAnyRunning();
            }
        }
    }
}
