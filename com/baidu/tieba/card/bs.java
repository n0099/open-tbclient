package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends CustomMessageListener {
    final /* synthetic */ bq aQP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs(bq bqVar, int i) {
        super(i);
        this.aQP = bqVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.a.n nVar;
        com.baidu.tieba.card.a.n nVar2;
        com.baidu.tieba.card.a.n nVar3;
        com.baidu.tieba.card.a.n nVar4;
        boolean JV;
        com.baidu.tieba.card.a.n nVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            nVar = this.aQP.aPR;
            if (nVar != null) {
                nVar2 = this.aQP.aPR;
                if (nVar2.aRZ != null) {
                    nVar3 = this.aQP.aPR;
                    if (nVar3.aRZ.getTid() != null && this.aQP.aQO != null && this.aQP.aQO.mTextTitle != null) {
                        nVar4 = this.aQP.aPR;
                        if (((String) customResponsedMessage.getData()).equals(nVar4.aRZ.getTid())) {
                            JV = this.aQP.JV();
                            if (!JV) {
                                TextView textView = this.aQP.aQO.mTextTitle;
                                nVar5 = this.aQP.aPR;
                                au.a(textView, nVar5.aRZ.getId(), t.d.cp_cont_b, t.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
