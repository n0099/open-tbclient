package com.baidu.tieba.frs.entelechy.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends CustomMessageListener {
    final /* synthetic */ ap bXM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(ap apVar, int i) {
        super(i);
        this.bXM = apVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && this.bXM.adL != null && this.bXM.adL.getTid() != null && this.bXM.VM != null && ((String) customResponsedMessage.getData()).equals(this.bXM.adL.getTid())) {
            com.baidu.tieba.card.ap.a(this.bXM.VM, this.bXM.adL.getId(), t.d.cp_cont_b, t.d.cp_cont_d);
        }
    }
}
