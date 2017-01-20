package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends CustomMessageListener {
    final /* synthetic */ l bxV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(l lVar, int i) {
        super(i);
        this.bxV = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Ux;
        boolean z;
        Ux = this.bxV.Ux();
        if (!Ux) {
            this.bxV.Uy();
        } else {
            this.bxV.UA();
        }
        z = this.bxV.bxI;
        if (z) {
            this.bxV.bxC.startPullRefresh();
        }
    }
}
