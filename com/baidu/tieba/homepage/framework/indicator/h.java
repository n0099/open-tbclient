package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class h extends CustomMessageListener {
    final /* synthetic */ ScrollFragmentTabHost cwt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
        super(i);
        this.cwt = scrollFragmentTabHost;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        o oVar;
        o oVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016326 && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            oVar = this.cwt.cwg;
            if (oVar != null) {
                oVar2 = this.cwt.cwg;
                oVar2.as(com.baidu.tieba.homepage.framework.a.a.aja().cxl, intValue);
            }
        }
    }
}
