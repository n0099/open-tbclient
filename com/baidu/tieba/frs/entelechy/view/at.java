package com.baidu.tieba.frs.entelechy.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends CustomMessageListener {
    final /* synthetic */ as bMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at(as asVar, int i) {
        super(i);
        this.bMS = asVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && this.bMS.acX != null && this.bMS.acX.getTid() != null && this.bMS.Ve != null && ((String) customResponsedMessage.getData()).equals(this.bMS.acX.getTid())) {
            com.baidu.tieba.card.at.a(this.bMS.Ve, this.bMS.acX.getId(), r.e.cp_cont_b, r.e.cp_cont_d);
        }
    }
}
