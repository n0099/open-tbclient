package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends CustomMessageListener {
    final /* synthetic */ ah bXw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(ah ahVar, int i) {
        super(i);
        this.bXw = ahVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.aq aqVar;
        com.baidu.tbadk.core.data.aq aqVar2;
        com.baidu.tbadk.core.data.aq aqVar3;
        com.baidu.tbadk.core.data.aq aqVar4;
        com.baidu.tbadk.core.data.aq aqVar5;
        com.baidu.tbadk.core.data.aq aqVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            aqVar = this.bXw.bXu;
            if (aqVar != null) {
                aqVar2 = this.bXw.bXu;
                if (aqVar2 != null) {
                    aqVar3 = this.bXw.bXu;
                    if (aqVar3.getTid() != null && this.bXw.bXv != null && this.bXw.bXv.ban != null && this.bXw.bXv.bao != null) {
                        aqVar4 = this.bXw.bXu;
                        if (((String) customResponsedMessage.getData()).equals(aqVar4.getTid())) {
                            TextView textView = this.bXw.bXv.ban;
                            aqVar5 = this.bXw.bXu;
                            com.baidu.tieba.card.ap.a(textView, aqVar5.getId(), t.d.cp_cont_b, t.d.cp_cont_d);
                            TextView textView2 = this.bXw.bXv.bao;
                            aqVar6 = this.bXw.bXu;
                            com.baidu.tieba.card.ap.a(textView2, aqVar6.getId(), t.d.cp_cont_j, t.d.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
