package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends CustomMessageListener {
    final /* synthetic */ d aMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(d dVar, int i) {
        super(i);
        this.aMQ = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Io;
        boolean z;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        this.aMQ.aMz.IY();
        Io = this.aMQ.Io();
        if (Io) {
            this.aMQ.aMz.IX();
            cVar = this.aMQ.aMA;
            cVar.K(this.aMQ.aMz.Ja());
            cVar2 = this.aMQ.aMA;
            cVar2.eT(this.aMQ.aMz.IN());
        }
        z = this.aMQ.aME;
        if (z) {
            this.aMQ.aMz.nv();
        }
    }
}
