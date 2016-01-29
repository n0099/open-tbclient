package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends CustomMessageListener {
    final /* synthetic */ an aQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(an anVar, int i) {
        super(i);
        this.aQz = anVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.a.r rVar;
        com.baidu.tieba.card.a.r rVar2;
        com.baidu.tieba.card.a.r rVar3;
        com.baidu.tieba.card.a.r rVar4;
        com.baidu.tieba.card.a.r rVar5;
        com.baidu.tieba.card.a.r rVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            rVar = this.aQz.aQv;
            if (rVar != null) {
                rVar2 = this.aQz.aQv;
                if (rVar2.aSu != null) {
                    rVar3 = this.aQz.aQv;
                    if (rVar3.aSu.getTid() != null && this.aQz.aQw != null && this.aQz.aQw.aQC != null && this.aQz.aQw.aQD != null) {
                        rVar4 = this.aQz.aQv;
                        if (((String) customResponsedMessage.getData()).equals(rVar4.aSu.getTid())) {
                            TextView textView = this.aQz.aQw.aQC;
                            rVar5 = this.aQz.aQv;
                            ae.a(textView, rVar5.aSu.getId(), t.d.cp_cont_b, t.d.cp_cont_d);
                            TextView textView2 = this.aQz.aQw.aQD;
                            rVar6 = this.aQz.aQv;
                            ae.a(textView2, rVar6.aSu.getId(), t.d.cp_cont_j, t.d.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
