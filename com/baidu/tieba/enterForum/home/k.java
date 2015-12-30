package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CustomMessageListener {
    final /* synthetic */ i aUE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(i iVar, int i) {
        super(i);
        this.aUE = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean Kg;
        Kg = this.aUE.Kg();
        if (!Kg) {
            this.aUE.Kh();
        } else {
            this.aUE.Kj();
        }
    }
}
