package com.baidu.tieba.homepage.fragment.controller;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.homepage.fragment.data.UserModuleData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a bye;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.bye = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.homepage.fragment.data.b bVar;
        com.baidu.tieba.homepage.fragment.data.b bVar2;
        com.baidu.tieba.homepage.fragment.a.a aVar;
        com.baidu.tieba.homepage.fragment.data.b bVar3;
        com.baidu.tieba.homepage.fragment.a.a aVar2;
        com.baidu.tieba.homepage.fragment.data.b bVar4;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof UserModuleData)) {
            bVar = this.bye.bxX;
            if (bVar != null) {
                bVar2 = this.bye.bxX;
                bVar2.a((UserModuleData) customResponsedMessage.getData());
                aVar = this.bye.bxV;
                bVar3 = this.bye.bxX;
                aVar.aM(bVar3.TP());
                aVar2 = this.bye.bxV;
                bVar4 = this.bye.bxX;
                aVar2.b(bVar4);
            }
        }
    }
}
