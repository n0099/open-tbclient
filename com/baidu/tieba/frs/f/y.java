package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends CustomMessageListener {
    final /* synthetic */ x cqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(x xVar, int i) {
        super(i);
        this.cqf = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        av avVar;
        av avVar2;
        if (customResponsedMessage != null) {
            avVar = this.cqf.ccj;
            if (avVar != null) {
                avVar2 = this.cqf.ccj;
                avVar2.startPullRefresh();
            }
        }
    }
}
