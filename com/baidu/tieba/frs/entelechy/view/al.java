package com.baidu.tieba.frs.entelechy.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.card.at;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends CustomMessageListener {
    final /* synthetic */ ak bKJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(ak akVar, int i) {
        super(i);
        this.bKJ = akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && this.bKJ.aas != null && this.bKJ.aas.getTid() != null && this.bKJ.So != null && ((String) customResponsedMessage.getData()).equals(this.bKJ.aas.getTid())) {
            at.a(this.bKJ.So, this.bKJ.aas.getId(), u.d.cp_cont_b, u.d.cp_cont_d);
        }
    }
}
