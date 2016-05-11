package com.baidu.tieba.frs.entelechy.c;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends CustomMessageListener {
    final /* synthetic */ am bpY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(am amVar, int i) {
        super(i);
        this.bpY = amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && this.bpY.aab != null && this.bpY.aab.getTid() != null && this.bpY.RX != null && ((String) customResponsedMessage.getData()).equals(this.bpY.aab.getTid())) {
            com.baidu.tieba.card.au.a(this.bpY.RX, this.bpY.aab.getId(), t.d.cp_cont_b, t.d.cp_cont_d);
        }
    }
}
