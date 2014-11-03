package com.baidu.tieba.faceshop;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class p extends CustomMessageListener {
    final /* synthetic */ EmotionManageActivity asQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(EmotionManageActivity emotionManageActivity, int i) {
        super(i);
        this.asQ = emotionManageActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        t tVar;
        if (customResponsedMessage.getCmd() == 2001120) {
            this.asQ.asF = new t(this.asQ, null);
            tVar = this.asQ.asF;
            tVar.execute(new String[0]);
        }
    }
}
