package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends CustomMessageListener {
    final /* synthetic */ bk aUZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(bk bkVar, int i) {
        super(i);
        this.aUZ = bkVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.a.n nVar;
        com.baidu.tieba.card.a.n nVar2;
        com.baidu.tieba.card.a.n nVar3;
        com.baidu.tieba.card.a.n nVar4;
        com.baidu.tieba.card.a.n nVar5;
        com.baidu.tieba.card.a.n nVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            nVar = this.aUZ.aUV;
            if (nVar != null) {
                nVar2 = this.aUZ.aUV;
                if (nVar2.aWa != null) {
                    nVar3 = this.aUZ.aUV;
                    if (nVar3.aWa.getTid() != null && this.aUZ.aUW != null && this.aUZ.aUW.aVb != null && this.aUZ.aUW.aVc != null) {
                        nVar4 = this.aUZ.aUV;
                        if (((String) customResponsedMessage.getData()).equals(nVar4.aWa.getTid())) {
                            TextView textView = this.aUZ.aUW.aVb;
                            nVar5 = this.aUZ.aUV;
                            at.a(textView, nVar5.aWa.getId(), u.d.cp_cont_b, u.d.cp_cont_d);
                            TextView textView2 = this.aUZ.aUW.aVc;
                            nVar6 = this.aUZ.aUV;
                            at.a(textView2, nVar6.aWa.getId(), u.d.cp_cont_j, u.d.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
