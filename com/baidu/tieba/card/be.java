package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class be extends CustomMessageListener {
    final /* synthetic */ bc btA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(bc bcVar, int i) {
        super(i);
        this.btA = bcVar;
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
        boolean SL;
        TextView textView3;
        com.baidu.tieba.card.data.n nVar5;
        TextView textView4;
        com.baidu.tieba.card.data.n nVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            nVar = this.btA.btp;
            if (nVar != null) {
                nVar2 = this.btA.btp;
                if (nVar2.threadData != null) {
                    nVar3 = this.btA.btp;
                    if (nVar3.threadData.getTid() != null) {
                        textView = this.btA.mTitle;
                        if (textView != null) {
                            textView2 = this.btA.brC;
                            if (textView2 != null) {
                                nVar4 = this.btA.btp;
                                if (((String) customResponsedMessage.getData()).equals(nVar4.threadData.getTid())) {
                                    SL = this.btA.SL();
                                    if (!SL) {
                                        textView3 = this.btA.mTitle;
                                        nVar5 = this.btA.btp;
                                        at.a(textView3, nVar5.Kn().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                                        textView4 = this.btA.brC;
                                        nVar6 = this.btA.btp;
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
