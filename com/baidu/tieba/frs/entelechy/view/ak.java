package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends CustomMessageListener {
    final /* synthetic */ ah bXr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(ah ahVar, int i) {
        super(i);
        this.bXr = ahVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.as asVar;
        com.baidu.tbadk.core.data.as asVar2;
        com.baidu.tbadk.core.data.as asVar3;
        com.baidu.tbadk.core.data.as asVar4;
        com.baidu.tbadk.core.data.as asVar5;
        com.baidu.tbadk.core.data.as asVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            asVar = this.bXr.bXp;
            if (asVar != null) {
                asVar2 = this.bXr.bXp;
                if (asVar2 != null) {
                    asVar3 = this.bXr.bXp;
                    if (asVar3.getTid() != null && this.bXr.bXq != null && this.bXr.bXq.baF != null && this.bXr.bXq.baG != null) {
                        asVar4 = this.bXr.bXp;
                        if (((String) customResponsedMessage.getData()).equals(asVar4.getTid())) {
                            TextView textView = this.bXr.bXq.baF;
                            asVar5 = this.bXr.bXp;
                            com.baidu.tieba.card.an.a(textView, asVar5.getId(), r.d.cp_cont_b, r.d.cp_cont_d);
                            TextView textView2 = this.bXr.bXq.baG;
                            asVar6 = this.bXr.bXp;
                            com.baidu.tieba.card.an.a(textView2, asVar6.getId(), r.d.cp_cont_j, r.d.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
