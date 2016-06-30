package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends CustomMessageListener {
    final /* synthetic */ bk aUd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(bk bkVar, int i) {
        super(i);
        this.aUd = bkVar;
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
            nVar = this.aUd.aTZ;
            if (nVar != null) {
                nVar2 = this.aUd.aTZ;
                if (nVar2.aVc != null) {
                    nVar3 = this.aUd.aTZ;
                    if (nVar3.aVc.getTid() != null && this.aUd.aUa != null && this.aUd.aUa.aUf != null && this.aUd.aUa.aUg != null) {
                        nVar4 = this.aUd.aTZ;
                        if (((String) customResponsedMessage.getData()).equals(nVar4.aVc.getTid())) {
                            TextView textView = this.aUd.aUa.aUf;
                            nVar5 = this.aUd.aTZ;
                            at.a(textView, nVar5.aVc.getId(), u.d.cp_cont_b, u.d.cp_cont_d);
                            TextView textView2 = this.aUd.aUa.aUg;
                            nVar6 = this.aUd.aTZ;
                            at.a(textView2, nVar6.aVc.getId(), u.d.cp_cont_j, u.d.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
