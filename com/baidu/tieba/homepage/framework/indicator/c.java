package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ a cCq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.cCq = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int intValue;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016327 && (customResponsedMessage.getData() instanceof Integer) && com.baidu.tieba.homepage.framework.a.a.alX().cDz == (intValue = ((Integer) customResponsedMessage.getData()).intValue()) && intValue == com.baidu.tieba.homepage.framework.a.a.alX().cDx && com.baidu.tieba.homepage.framework.a.a.alX().cDy != 0) {
            this.cCq.eS(false);
        }
    }
}
