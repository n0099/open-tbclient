package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends CustomMessageListener {
    final /* synthetic */ ai bZG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(ai aiVar, int i) {
        super(i);
        this.bZG = aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.ax axVar;
        com.baidu.tbadk.core.data.ax axVar2;
        com.baidu.tbadk.core.data.ax axVar3;
        com.baidu.tbadk.core.data.ax axVar4;
        com.baidu.tbadk.core.data.ax axVar5;
        com.baidu.tbadk.core.data.ax axVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            axVar = this.bZG.bZE;
            if (axVar != null) {
                axVar2 = this.bZG.bZE;
                if (axVar2 != null) {
                    axVar3 = this.bZG.bZE;
                    if (axVar3.getTid() != null && this.bZG.bZF != null && this.bZG.bZF.bzn != null && this.bZG.bZF.bZM != null) {
                        axVar4 = this.bZG.bZE;
                        if (((String) customResponsedMessage.getData()).equals(axVar4.getTid())) {
                            TextView textView = this.bZG.bZF.bzn;
                            axVar5 = this.bZG.bZE;
                            com.baidu.tieba.card.at.a(textView, axVar5.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                            TextView textView2 = this.bZG.bZF.bZM;
                            axVar6 = this.bZG.bZE;
                            com.baidu.tieba.card.at.a(textView2, axVar6.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
