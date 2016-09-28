package com.baidu.tieba.frs.entelechy.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends CustomMessageListener {
    final /* synthetic */ ap bXH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(ap apVar, int i) {
        super(i);
        this.bXH = apVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && this.bXH.adW != null && this.bXH.adW.getTid() != null && this.bXH.VW != null && ((String) customResponsedMessage.getData()).equals(this.bXH.adW.getTid())) {
            com.baidu.tieba.card.an.a(this.bXH.VW, this.bXH.adW.getId(), r.d.cp_cont_b, r.d.cp_cont_d);
        }
    }
}
