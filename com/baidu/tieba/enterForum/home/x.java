package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends CustomMessageListener {
    final /* synthetic */ i bTq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(i iVar, int i) {
        super(i);
        this.bTq = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean aaL;
        boolean z;
        aaL = this.bTq.aaL();
        if (!aaL) {
            this.bTq.aaM();
        } else {
            this.bTq.aaO();
        }
        z = this.bTq.bTi;
        if (z) {
            this.bTq.bTc.startPullRefresh();
        }
    }
}
