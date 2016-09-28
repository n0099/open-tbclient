package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ l bHk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(l lVar, int i) {
        super(i);
        this.bHk = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean XP;
        boolean z;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        this.bHk.bGS.Yy();
        XP = this.bHk.XP();
        if (XP) {
            this.bHk.bGS.Yx();
            cVar = this.bHk.bGT;
            cVar.aj(this.bHk.bGS.YC());
            cVar2 = this.bHk.bGT;
            cVar2.hv(this.bHk.bGS.Yn());
        }
        z = this.bHk.bGY;
        if (z) {
            this.bHk.bGS.kv();
        }
    }
}
