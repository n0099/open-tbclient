package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class h extends CustomMessageListener {
    final /* synthetic */ ScrollFragmentTabHost cuU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
        super(i);
        this.cuU = scrollFragmentTabHost;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        o oVar;
        o oVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016326 && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            oVar = this.cuU.cuH;
            if (oVar != null) {
                oVar2 = this.cuU.cuH;
                oVar2.ap(com.baidu.tieba.homepage.framework.a.a.ajO().cvM, intValue);
            }
        }
    }
}
