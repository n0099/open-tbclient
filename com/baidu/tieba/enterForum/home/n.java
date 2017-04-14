package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends CustomMessageListener {
    final /* synthetic */ l bEU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(l lVar, int i) {
        super(i);
        this.bEU = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean VT;
        boolean z;
        VT = this.bEU.VT();
        if (!VT) {
            this.bEU.VU();
        } else {
            this.bEU.VW();
        }
        z = this.bEU.bEH;
        if (z) {
            this.bEU.bEB.startPullRefresh();
        }
    }
}
