package com.baidu.tieba.frs.entelechy.c;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends CustomMessageListener {
    final /* synthetic */ af bpP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(af afVar, int i) {
        super(i);
        this.bpP = afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.ag agVar;
        com.baidu.tbadk.core.data.ag agVar2;
        com.baidu.tbadk.core.data.ag agVar3;
        com.baidu.tbadk.core.data.ag agVar4;
        com.baidu.tbadk.core.data.ag agVar5;
        com.baidu.tbadk.core.data.ag agVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            agVar = this.bpP.bpN;
            if (agVar != null) {
                agVar2 = this.bpP.bpN;
                if (agVar2 != null) {
                    agVar3 = this.bpP.bpN;
                    if (agVar3.getTid() != null && this.bpP.bpO != null && this.bpP.bpO.aQJ != null && this.bpP.bpO.aQK != null) {
                        agVar4 = this.bpP.bpN;
                        if (((String) customResponsedMessage.getData()).equals(agVar4.getTid())) {
                            TextView textView = this.bpP.bpO.aQJ;
                            agVar5 = this.bpP.bpN;
                            com.baidu.tieba.card.au.a(textView, agVar5.getId(), t.d.cp_cont_b, t.d.cp_cont_d);
                            TextView textView2 = this.bpP.bpO.aQK;
                            agVar6 = this.bpP.bpN;
                            com.baidu.tieba.card.au.a(textView2, agVar6.getId(), t.d.cp_cont_j, t.d.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
