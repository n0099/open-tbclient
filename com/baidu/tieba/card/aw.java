package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends CustomMessageListener {
    final /* synthetic */ au btC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw(au auVar, int i) {
        super(i);
        this.btC = auVar;
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
        boolean Sn;
        TextView textView3;
        com.baidu.tieba.card.data.n nVar5;
        TextView textView4;
        com.baidu.tieba.card.data.n nVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            nVar = this.btC.btx;
            if (nVar != null) {
                nVar2 = this.btC.btx;
                if (nVar2.threadData != null) {
                    nVar3 = this.btC.btx;
                    if (nVar3.threadData.getTid() != null) {
                        textView = this.btC.aSO;
                        if (textView != null) {
                            textView2 = this.btC.brK;
                            if (textView2 != null) {
                                nVar4 = this.btC.btx;
                                if (((String) customResponsedMessage.getData()).equals(nVar4.threadData.getTid())) {
                                    Sn = this.btC.Sn();
                                    if (!Sn) {
                                        textView3 = this.btC.aSO;
                                        nVar5 = this.btC.btx;
                                        at.a(textView3, nVar5.JN().getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                                        textView4 = this.btC.brK;
                                        nVar6 = this.btC.btx;
                                        at.a(textView4, nVar6.threadData.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
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
