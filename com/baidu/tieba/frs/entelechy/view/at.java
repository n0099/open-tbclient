package com.baidu.tieba.frs.entelechy.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends CustomMessageListener {
    final /* synthetic */ as bWf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at(as asVar, int i) {
        super(i);
        this.bWf = asVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && this.bWf.aiC != null && this.bWf.aiC.getTid() != null && this.bWf.aaG != null && ((String) customResponsedMessage.getData()).equals(this.bWf.aiC.getTid())) {
            com.baidu.tieba.card.at.a(this.bWf.aaG, this.bWf.aiC.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        }
    }
}
