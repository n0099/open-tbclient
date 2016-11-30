package com.baidu.tieba.frs.j;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends CustomMessageListener {
    final /* synthetic */ y ckm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(y yVar, int i) {
        super(i);
        this.ckm = yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        au auVar;
        au auVar2;
        if (customResponsedMessage != null) {
            auVar = this.ckm.bRW;
            if (auVar != null) {
                auVar2 = this.ckm.bRW;
                auVar2.kv();
            }
        }
    }
}
