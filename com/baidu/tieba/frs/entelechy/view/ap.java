package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends CustomMessageListener {
    final /* synthetic */ am bGv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(am amVar, int i) {
        super(i);
        this.bGv = amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.at atVar;
        com.baidu.tbadk.core.data.at atVar2;
        com.baidu.tbadk.core.data.at atVar3;
        com.baidu.tbadk.core.data.at atVar4;
        com.baidu.tbadk.core.data.at atVar5;
        com.baidu.tbadk.core.data.at atVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            atVar = this.bGv.bGt;
            if (atVar != null) {
                atVar2 = this.bGv.bGt;
                if (atVar2 != null) {
                    atVar3 = this.bGv.bGt;
                    if (atVar3.getTid() != null && this.bGv.bGu != null && this.bGv.bGu.aMQ != null && this.bGv.bGu.bdg != null) {
                        atVar4 = this.bGv.bGt;
                        if (((String) customResponsedMessage.getData()).equals(atVar4.getTid())) {
                            TextView textView = this.bGv.bGu.aMQ;
                            atVar5 = this.bGv.bGt;
                            com.baidu.tieba.card.ap.a(textView, atVar5.getId(), r.d.cp_cont_b, r.d.cp_cont_d);
                            TextView textView2 = this.bGv.bGu.bdg;
                            atVar6 = this.bGv.bGt;
                            com.baidu.tieba.card.ap.a(textView2, atVar6.getId(), r.d.cp_cont_j, r.d.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
