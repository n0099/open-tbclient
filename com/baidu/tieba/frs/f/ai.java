package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends CustomMessageListener {
    final /* synthetic */ ah cdq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(ah ahVar, int i) {
        super(i);
        this.cdq = ahVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ax axVar;
        ax axVar2;
        if (customResponsedMessage != null) {
            axVar = this.cdq.bMN;
            if (axVar != null) {
                axVar2 = this.cdq.bMN;
                axVar2.startPullRefresh();
            }
        }
    }
}
