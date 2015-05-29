package com.baidu.tbadk.coreExtra.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class aa extends CustomMessageListener {
    final /* synthetic */ LiveBroadcastCard agj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(LiveBroadcastCard liveBroadcastCard, int i) {
        super(i);
        this.agj = liveBroadcastCard;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        long j;
        if (customResponsedMessage != null) {
            j = this.agj.mStartTime;
            if (j <= 0) {
                return;
            }
            this.agj.dealStatusWillStart();
        }
    }
}
