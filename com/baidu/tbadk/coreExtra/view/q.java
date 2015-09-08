package com.baidu.tbadk.coreExtra.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class q extends CustomMessageListener {
    final /* synthetic */ LiveBroadcastCard amf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(LiveBroadcastCard liveBroadcastCard, int i) {
        super(i);
        this.amf = liveBroadcastCard;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        long j;
        if (customResponsedMessage != null) {
            j = this.amf.mStartTime;
            if (j <= 0) {
                return;
            }
            this.amf.dealStatusWillStart();
        }
    }
}
