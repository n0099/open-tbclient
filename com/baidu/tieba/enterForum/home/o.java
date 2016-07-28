package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CustomMessageListener {
    final /* synthetic */ k bvO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(k kVar, int i) {
        super(i);
        this.bvO = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean SJ;
        boolean z;
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        this.bvO.bvv.SP();
        SJ = this.bvO.SJ();
        if (SJ) {
            this.bvO.bvv.Tv();
            cVar = this.bvO.bvw;
            cVar.ah(this.bvO.bvv.TA());
            cVar2 = this.bvO.bvw;
            cVar2.gP(this.bvO.bvv.Tj());
        }
        z = this.bvO.bvB;
        if (z) {
            this.bvO.bvv.jA();
        }
    }
}
