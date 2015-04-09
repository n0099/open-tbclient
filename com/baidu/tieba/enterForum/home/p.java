package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends CustomMessageListener {
    final /* synthetic */ a aDb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(a aVar, int i) {
        super(i);
        this.aDb = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.enterForum.d.e eVar;
        boolean GI;
        boolean z;
        com.baidu.tieba.enterForum.d.e eVar2;
        com.baidu.tieba.enterForum.d.e eVar3;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.d.e eVar4;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.d.e eVar5;
        eVar = this.aDb.aCJ;
        eVar.bB(false);
        GI = this.aDb.GI();
        if (GI) {
            eVar3 = this.aDb.aCJ;
            eVar3.Hv();
            cVar = this.aDb.aCK;
            eVar4 = this.aDb.aCJ;
            cVar.H(eVar4.Hy());
            cVar2 = this.aDb.aCK;
            eVar5 = this.aDb.aCJ;
            cVar2.eu(eVar5.Hl());
        }
        z = this.aDb.aCQ;
        if (z) {
            eVar2 = this.aDb.aCJ;
            eVar2.mX();
        }
    }
}
