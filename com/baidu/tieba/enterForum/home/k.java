package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CustomMessageListener {
    final /* synthetic */ h aQN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(h hVar, int i) {
        super(i);
        this.aQN = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean JN;
        boolean z;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        this.aQN.aQu.KB();
        JN = this.aQN.JN();
        if (JN) {
            this.aQN.aQu.KA();
            cVar = this.aQN.aQv;
            cVar.N(this.aQN.aQu.KC());
            cVar2 = this.aQN.aQv;
            cVar2.fy(this.aQN.aQu.Kn());
        }
        z = this.aQN.aQz;
        if (z) {
            this.aQN.aQu.nD();
        }
    }
}
