package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends CustomMessageListener {
    final /* synthetic */ i aUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(i iVar, int i) {
        super(i);
        this.aUE = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Kg;
        boolean z;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        this.aUE.aUl.KU();
        Kg = this.aUE.Kg();
        if (Kg) {
            this.aUE.aUl.KT();
            cVar = this.aUE.aUm;
            cVar.O(this.aUE.aUl.KV());
            cVar2 = this.aUE.aUm;
            cVar2.ft(this.aUE.aUl.KG());
        }
        z = this.aUE.aUq;
        if (z) {
            this.aUE.aUl.nb();
        }
    }
}
