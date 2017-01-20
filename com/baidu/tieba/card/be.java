package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class be extends CustomMessageListener {
    final /* synthetic */ bc bmN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(bc bcVar, int i) {
        super(i);
        this.bmN = bcVar;
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
        boolean Rp;
        TextView textView3;
        com.baidu.tieba.card.data.n nVar5;
        TextView textView4;
        com.baidu.tieba.card.data.n nVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            nVar = this.bmN.bmC;
            if (nVar != null) {
                nVar2 = this.bmN.bmC;
                if (nVar2.threadData != null) {
                    nVar3 = this.bmN.bmC;
                    if (nVar3.threadData.getTid() != null) {
                        textView = this.bmN.aNb;
                        if (textView != null) {
                            textView2 = this.bmN.bkS;
                            if (textView2 != null) {
                                nVar4 = this.bmN.bmC;
                                if (((String) customResponsedMessage.getData()).equals(nVar4.threadData.getTid())) {
                                    Rp = this.bmN.Rp();
                                    if (!Rp) {
                                        textView3 = this.bmN.aNb;
                                        nVar5 = this.bmN.bmC;
                                        at.a(textView3, nVar5.Ji().getId(), r.e.cp_cont_b, r.e.cp_cont_d);
                                        textView4 = this.bmN.bkS;
                                        nVar6 = this.bmN.bmC;
                                        at.a(textView4, nVar6.threadData.getId(), r.e.cp_cont_j, r.e.cp_cont_d);
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
