package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends CustomMessageListener {
    final /* synthetic */ am bMK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(am amVar, int i) {
        super(i);
        this.bMK = amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.au auVar;
        com.baidu.tbadk.core.data.au auVar2;
        com.baidu.tbadk.core.data.au auVar3;
        com.baidu.tbadk.core.data.au auVar4;
        com.baidu.tbadk.core.data.au auVar5;
        com.baidu.tbadk.core.data.au auVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            auVar = this.bMK.bMI;
            if (auVar != null) {
                auVar2 = this.bMK.bMI;
                if (auVar2 != null) {
                    auVar3 = this.bMK.bMI;
                    if (auVar3.getTid() != null && this.bMK.bMJ != null && this.bMK.bMJ.aLR != null && this.bMK.bMJ.bmV != null) {
                        auVar4 = this.bMK.bMI;
                        if (((String) customResponsedMessage.getData()).equals(auVar4.getTid())) {
                            TextView textView = this.bMK.bMJ.aLR;
                            auVar5 = this.bMK.bMI;
                            com.baidu.tieba.card.at.a(textView, auVar5.getId(), r.e.cp_cont_b, r.e.cp_cont_d);
                            TextView textView2 = this.bMK.bMJ.bmV;
                            auVar6 = this.bMK.bMI;
                            com.baidu.tieba.card.at.a(textView2, auVar6.getId(), r.e.cp_cont_j, r.e.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
