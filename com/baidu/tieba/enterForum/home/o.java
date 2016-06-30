package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ k btA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(k kVar, int i) {
        super(i);
        this.btA = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Sb;
        boolean z;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        this.btA.btg.Sh();
        Sb = this.btA.Sb();
        if (Sb) {
            this.btA.btg.SN();
            cVar = this.btA.bth;
            cVar.ac(this.btA.btg.SS());
            cVar2 = this.btA.bth;
            cVar2.gP(this.btA.btg.SB());
        }
        z = this.btA.btm;
        if (z) {
            this.btA.btg.jB();
        }
    }
}
