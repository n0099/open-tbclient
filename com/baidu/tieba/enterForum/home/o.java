package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ l bKe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(l lVar, int i) {
        super(i);
        this.bKe = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean YR;
        boolean z;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        this.bKe.bJM.ZA();
        YR = this.bKe.YR();
        if (YR) {
            this.bKe.bJM.Zz();
            cVar = this.bKe.bJN;
            cVar.ak(this.bKe.bJM.ZE());
            cVar2 = this.bKe.bJN;
            cVar2.hw(this.bKe.bJM.Zp());
        }
        z = this.bKe.bJS;
        if (z) {
            this.bKe.bJM.kv();
        }
    }
}
