package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class h extends CustomMessageListener {
    final /* synthetic */ ScrollFragmentTabHost cCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
        super(i);
        this.cCF = scrollFragmentTabHost;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        o oVar;
        o oVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016326 && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            oVar = this.cCF.cCs;
            if (oVar != null) {
                oVar2 = this.cCF.cCs;
                oVar2.as(com.baidu.tieba.homepage.framework.a.a.alX().cDx, intValue);
            }
        }
    }
}
