package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class be extends CustomMessageListener {
    final /* synthetic */ bc bvS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(bc bcVar, int i) {
        super(i);
        this.bvS = bcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.data.n nVar;
        com.baidu.tieba.card.data.n nVar2;
        com.baidu.tieba.card.data.n nVar3;
        TextView textView;
        TextView textView2;
        com.baidu.tieba.card.data.n nVar4;
        boolean TN;
        TextView textView3;
        com.baidu.tieba.card.data.n nVar5;
        TextView textView4;
        com.baidu.tieba.card.data.n nVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            nVar = this.bvS.bvH;
            if (nVar != null) {
                nVar2 = this.bvS.bvH;
                if (nVar2.threadData != null) {
                    nVar3 = this.bvS.bvH;
                    if (nVar3.threadData.getTid() != null) {
                        textView = this.bvS.mTitle;
                        if (textView != null) {
                            textView2 = this.bvS.btU;
                            if (textView2 != null) {
                                nVar4 = this.bvS.bvH;
                                if (((String) customResponsedMessage.getData()).equals(nVar4.threadData.getTid())) {
                                    TN = this.bvS.TN();
                                    if (!TN) {
                                        textView3 = this.bvS.mTitle;
                                        nVar5 = this.bvS.bvH;
                                        at.a(textView3, nVar5.Kn().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                                        textView4 = this.bvS.btU;
                                        nVar6 = this.bvS.bvH;
                                        at.a(textView4, nVar6.threadData.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
