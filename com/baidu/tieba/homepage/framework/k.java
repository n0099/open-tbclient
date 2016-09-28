package com.baidu.tieba.homepage.framework;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.homepage.framework.RecommendFrsControlFragment;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CustomMessageListener {
    final /* synthetic */ RecommendFrsControlFragment cCw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(RecommendFrsControlFragment recommendFrsControlFragment, int i) {
        super(i);
        this.cCw = recommendFrsControlFragment;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        q qVar;
        q qVar2;
        q qVar3;
        if (customResponsedMessage != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Boolean) && ((Boolean) data).booleanValue()) {
                qVar = this.cCw.cCj;
                if (qVar != null) {
                    qVar2 = this.cCw.cCj;
                    if (qVar2.alQ() == null) {
                        MessageManager messageManager = MessageManager.getInstance();
                        qVar3 = this.cCw.cCj;
                        messageManager.sendMessage(new RecommendFrsControlFragment.ControlModelMessage(qVar3));
                    }
                }
            }
        }
    }
}
