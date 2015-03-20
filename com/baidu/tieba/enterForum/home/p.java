package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends CustomMessageListener {
    final /* synthetic */ a aCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(a aVar, int i) {
        super(i);
        this.aCT = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.enterForum.d.e eVar;
        boolean GC;
        boolean z;
        com.baidu.tieba.enterForum.d.e eVar2;
        com.baidu.tieba.enterForum.d.e eVar3;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.d.e eVar4;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.d.e eVar5;
        eVar = this.aCT.aCB;
        eVar.bB(false);
        GC = this.aCT.GC();
        if (GC) {
            eVar3 = this.aCT.aCB;
            eVar3.Hp();
            cVar = this.aCT.aCC;
            eVar4 = this.aCT.aCB;
            cVar.H(eVar4.Hs());
            cVar2 = this.aCT.aCC;
            eVar5 = this.aCT.aCB;
            cVar2.eu(eVar5.Hf());
        }
        z = this.aCT.aCI;
        if (z) {
            eVar2 = this.aCT.aCB;
            eVar2.mX();
        }
    }
}
