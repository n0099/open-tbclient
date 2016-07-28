package com.baidu.tieba.frs.entelechy.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.card.at;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends CustomMessageListener {
    final /* synthetic */ am bMt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(am amVar, int i) {
        super(i);
        this.bMt = amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && this.bMt.abb != null && this.bMt.abb.getTid() != null && this.bMt.SW != null && ((String) customResponsedMessage.getData()).equals(this.bMt.abb.getTid())) {
            at.a(this.bMt.SW, this.bMt.abb.getId(), u.d.cp_cont_b, u.d.cp_cont_d);
        }
    }
}
