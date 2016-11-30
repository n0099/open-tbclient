package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh extends CustomMessageListener {
    final /* synthetic */ be bdL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh(be beVar, int i) {
        super(i);
        this.bdL = beVar;
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
            nVar = this.bdL.bdH;
            if (nVar != null) {
                nVar2 = this.bdL.bdH;
                if (nVar2.beS != null) {
                    nVar3 = this.bdL.bdH;
                    if (nVar3.beS.getTid() != null && this.bdL.bdI != null && this.bdL.bdI.aNz != null && this.bdL.bdI.bdO != null) {
                        nVar4 = this.bdL.bdH;
                        if (((String) customResponsedMessage.getData()).equals(nVar4.beS.getTid())) {
                            TextView textView = this.bdL.bdI.aNz;
                            nVar5 = this.bdL.bdH;
                            an.a(textView, nVar5.beS.getId(), r.d.cp_cont_b, r.d.cp_cont_d);
                            TextView textView2 = this.bdL.bdI.bdO;
                            nVar6 = this.bdL.bdH;
                            an.a(textView2, nVar6.beS.getId(), r.d.cp_cont_j, r.d.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
