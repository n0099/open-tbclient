package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class c extends CustomMessageListener {
    final /* synthetic */ a cwV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.cwV = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016327 && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            if (com.baidu.tieba.homepage.framework.a.a.ajV().cye == intValue && intValue == com.baidu.tieba.homepage.framework.a.a.ajV().cyc && com.baidu.tieba.homepage.framework.a.a.ajV().cyd != 0) {
                this.cwV.eY(false);
            }
            if (com.baidu.tieba.homepage.framework.a.a.ajV().cye == intValue && intValue == 0) {
                this.cwV.eY(false);
            }
        }
    }
}
