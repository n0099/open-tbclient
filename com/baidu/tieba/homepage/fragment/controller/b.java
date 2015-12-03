package com.baidu.tieba.homepage.fragment.controller;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ a bye;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.bye = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.homepage.fragment.data.b bVar;
        com.baidu.tieba.homepage.fragment.data.b bVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2009503) {
            bVar = this.bye.bxX;
            if (bVar != null) {
                bVar2 = this.bye.bxX;
                bVar2.TO();
            }
            this.bye.TM();
        }
    }
}
