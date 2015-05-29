package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ a aFd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(a aVar, int i) {
        super(i);
        this.aFd = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.enterForum.d.e eVar;
        boolean HM;
        boolean z;
        com.baidu.tieba.enterForum.d.e eVar2;
        com.baidu.tieba.enterForum.d.e eVar3;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.d.e eVar4;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.d.e eVar5;
        eVar = this.aFd.aEL;
        eVar.Iw();
        HM = this.aFd.HM();
        if (HM) {
            eVar3 = this.aFd.aEL;
            eVar3.Iv();
            cVar = this.aFd.aEM;
            eVar4 = this.aFd.aEL;
            cVar.K(eVar4.Iy());
            cVar2 = this.aFd.aEM;
            eVar5 = this.aFd.aEL;
            cVar2.eG(eVar5.Il());
        }
        z = this.aFd.aER;
        if (z) {
            eVar2 = this.aFd.aEL;
            eVar2.no();
        }
    }
}
