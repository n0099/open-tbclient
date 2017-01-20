package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends CustomMessageListener {
    final /* synthetic */ au bmH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw(au auVar, int i) {
        super(i);
        this.bmH = auVar;
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
            nVar = this.bmH.bmC;
            if (nVar != null) {
                nVar2 = this.bmH.bmC;
                if (nVar2.threadData != null) {
                    nVar3 = this.bmH.bmC;
                    if (nVar3.threadData.getTid() != null) {
                        textView = this.bmH.aNb;
                        if (textView != null) {
                            textView2 = this.bmH.bkS;
                            if (textView2 != null) {
                                nVar4 = this.bmH.bmC;
                                if (((String) customResponsedMessage.getData()).equals(nVar4.threadData.getTid())) {
                                    Rp = this.bmH.Rp();
                                    if (!Rp) {
                                        textView3 = this.bmH.aNb;
                                        nVar5 = this.bmH.bmC;
                                        at.a(textView3, nVar5.Ji().getId(), r.e.cp_cont_b, r.e.cp_cont_d);
                                        textView4 = this.bmH.bkS;
                                        nVar6 = this.bmH.bmC;
                                        at.a(textView4, nVar6.threadData.getId(), r.e.cp_cont_c, r.e.cp_cont_d);
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
