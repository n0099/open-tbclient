package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj extends CustomMessageListener {
    final /* synthetic */ bg bdd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bj(bg bgVar, int i) {
        super(i);
        this.bdd = bgVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.data.n nVar;
        com.baidu.tieba.card.data.n nVar2;
        com.baidu.tieba.card.data.n nVar3;
        com.baidu.tieba.card.data.n nVar4;
        com.baidu.tieba.card.data.n nVar5;
        com.baidu.tieba.card.data.n nVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            nVar = this.bdd.bcZ;
            if (nVar != null) {
                nVar2 = this.bdd.bcZ;
                if (nVar2.beB != null) {
                    nVar3 = this.bdd.bcZ;
                    if (nVar3.beB.getTid() != null && this.bdd.bda != null && this.bdd.bda.aMQ != null && this.bdd.bda.bdg != null) {
                        nVar4 = this.bdd.bcZ;
                        if (((String) customResponsedMessage.getData()).equals(nVar4.beB.getTid())) {
                            TextView textView = this.bdd.bda.aMQ;
                            nVar5 = this.bdd.bcZ;
                            ap.a(textView, nVar5.beB.getId(), r.d.cp_cont_b, r.d.cp_cont_d);
                            TextView textView2 = this.bdd.bda.bdg;
                            nVar6 = this.bdd.bcZ;
                            ap.a(textView2, nVar6.beB.getId(), r.d.cp_cont_j, r.d.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
