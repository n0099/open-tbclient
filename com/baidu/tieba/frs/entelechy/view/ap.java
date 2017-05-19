package com.baidu.tieba.frs.entelechy.view;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends CustomMessageListener {
    final /* synthetic */ ao bUc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(ao aoVar, int i) {
        super(i);
        this.bUc = aoVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && this.bUc.ahV != null && this.bUc.ahV.getTid() != null && this.bUc.aab != null && ((String) customResponsedMessage.getData()).equals(this.bUc.ahV.getTid())) {
            com.baidu.tieba.card.ap.a(this.bUc.aab, this.bUc.ahV.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
        }
    }
}
