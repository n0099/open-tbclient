package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends CustomMessageListener {
    final /* synthetic */ ai bTO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(ai aiVar, int i) {
        super(i);
        this.bTO = aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.aw awVar;
        com.baidu.tbadk.core.data.aw awVar2;
        com.baidu.tbadk.core.data.aw awVar3;
        com.baidu.tbadk.core.data.aw awVar4;
        com.baidu.tbadk.core.data.aw awVar5;
        com.baidu.tbadk.core.data.aw awVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            awVar = this.bTO.bTM;
            if (awVar != null) {
                awVar2 = this.bTO.bTM;
                if (awVar2 != null) {
                    awVar3 = this.bTO.bTM;
                    if (awVar3.getTid() != null && this.bTO.bTN != null && this.bTO.bTN.aSr != null && this.bTO.bTN.bTU != null) {
                        awVar4 = this.bTO.bTM;
                        if (((String) customResponsedMessage.getData()).equals(awVar4.getTid())) {
                            TextView textView = this.bTO.bTN.aSr;
                            awVar5 = this.bTO.bTM;
                            com.baidu.tieba.card.ap.a(textView, awVar5.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                            TextView textView2 = this.bTO.bTN.bTU;
                            awVar6 = this.bTO.bTM;
                            com.baidu.tieba.card.ap.a(textView2, awVar6.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
