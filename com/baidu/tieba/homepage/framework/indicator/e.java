package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    final /* synthetic */ ScrollFragmentTabHost cpc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ScrollFragmentTabHost scrollFragmentTabHost, int i) {
        super(i);
        this.cpc = scrollFragmentTabHost;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        j jVar;
        j jVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016326 && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            jVar = this.cpc.coS;
            if (jVar != null) {
                jVar2 = this.cpc.coS;
                jVar2.al(com.baidu.tieba.homepage.framework.a.a.agG().cpK, intValue);
            }
        }
    }
}
