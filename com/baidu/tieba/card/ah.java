package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends CustomMessageListener {
    final /* synthetic */ af aQu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(af afVar, int i) {
        super(i);
        this.aQu = afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.a.q qVar;
        com.baidu.tieba.card.a.q qVar2;
        com.baidu.tieba.card.a.q qVar3;
        TextView textView;
        TextView textView2;
        com.baidu.tieba.card.a.q qVar4;
        boolean JY;
        TextView textView3;
        com.baidu.tieba.card.a.q qVar5;
        TextView textView4;
        com.baidu.tieba.card.a.q qVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            qVar = this.aQu.aQn;
            if (qVar != null) {
                qVar2 = this.aQu.aQn;
                if (qVar2.aSc != null) {
                    qVar3 = this.aQu.aQn;
                    if (qVar3.aSc.getTid() != null) {
                        textView = this.aQu.aPr;
                        if (textView != null) {
                            textView2 = this.aQu.aPx;
                            if (textView2 != null) {
                                qVar4 = this.aQu.aQn;
                                if (((String) customResponsedMessage.getData()).equals(qVar4.aSc.getTid())) {
                                    JY = this.aQu.JY();
                                    if (!JY) {
                                        textView3 = this.aQu.aPr;
                                        qVar5 = this.aQu.aQn;
                                        ae.a(textView3, qVar5.Ki().getId(), t.d.cp_cont_b, t.d.cp_cont_d);
                                        textView4 = this.aQu.aPx;
                                        qVar6 = this.aQu.aQn;
                                        ae.a(textView4, qVar6.aSc.getId(), t.d.cp_cont_j, t.d.cp_cont_d);
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
