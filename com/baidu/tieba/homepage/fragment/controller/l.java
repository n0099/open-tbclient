package com.baidu.tieba.homepage.fragment.controller;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends CustomMessageListener {
    final /* synthetic */ a bye;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(a aVar, int i) {
        super(i);
        this.bye = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.homepage.fragment.data.b bVar;
        com.baidu.tieba.homepage.fragment.data.b bVar2;
        com.baidu.tieba.homepage.fragment.a.a aVar;
        if (customResponsedMessage != null) {
            bVar = this.bye.bxX;
            if (bVar != null) {
                bVar2 = this.bye.bxX;
                bVar2.TO();
                aVar = this.bye.bxV;
                aVar.TV();
            }
        }
    }
}
