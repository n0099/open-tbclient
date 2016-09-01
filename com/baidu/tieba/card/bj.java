package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj extends CustomMessageListener {
    final /* synthetic */ bg bak;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bj(bg bgVar, int i) {
        super(i);
        this.bak = bgVar;
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
            nVar = this.bak.bag;
            if (nVar != null) {
                nVar2 = this.bak.bag;
                if (nVar2.bbC != null) {
                    nVar3 = this.bak.bag;
                    if (nVar3.bbC.getTid() != null && this.bak.bah != null && this.bak.bah.ban != null && this.bak.bah.bao != null) {
                        nVar4 = this.bak.bag;
                        if (((String) customResponsedMessage.getData()).equals(nVar4.bbC.getTid())) {
                            TextView textView = this.bak.bah.ban;
                            nVar5 = this.bak.bag;
                            ap.a(textView, nVar5.bbC.getId(), t.d.cp_cont_b, t.d.cp_cont_d);
                            TextView textView2 = this.bak.bah.bao;
                            nVar6 = this.bak.bag;
                            ap.a(textView2, nVar6.bbC.getId(), t.d.cp_cont_j, t.d.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
