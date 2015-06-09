package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ a aFe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(a aVar, int i) {
        super(i);
        this.aFe = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.enterForum.d.e eVar;
        boolean HN;
        boolean z;
        com.baidu.tieba.enterForum.d.e eVar2;
        com.baidu.tieba.enterForum.d.e eVar3;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.d.e eVar4;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.d.e eVar5;
        eVar = this.aFe.aEM;
        eVar.Ix();
        HN = this.aFe.HN();
        if (HN) {
            eVar3 = this.aFe.aEM;
            eVar3.Iw();
            cVar = this.aFe.aEN;
            eVar4 = this.aFe.aEM;
            cVar.K(eVar4.Iz());
            cVar2 = this.aFe.aEN;
            eVar5 = this.aFe.aEM;
            cVar2.eG(eVar5.Im());
        }
        z = this.aFe.aES;
        if (z) {
            eVar2 = this.aFe.aEM;
            eVar2.no();
        }
    }
}
