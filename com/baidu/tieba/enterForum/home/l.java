package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends CustomMessageListener {
    final /* synthetic */ i bbw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(i iVar, int i) {
        super(i);
        this.bbw = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean NM;
        boolean z;
        NM = this.bbw.NM();
        if (!NM) {
            this.bbw.NN();
        } else {
            this.bbw.NP();
        }
        z = this.bbw.bbh;
        if (z) {
            this.bbw.bbb.nk();
        }
    }
}
