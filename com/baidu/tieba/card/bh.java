package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh extends CustomMessageListener {
    final /* synthetic */ be baC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh(be beVar, int i) {
        super(i);
        this.baC = beVar;
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
            nVar = this.baC.bay;
            if (nVar != null) {
                nVar2 = this.baC.bay;
                if (nVar2.bbU != null) {
                    nVar3 = this.baC.bay;
                    if (nVar3.bbU.getTid() != null && this.baC.baz != null && this.baC.baz.baF != null && this.baC.baz.baG != null) {
                        nVar4 = this.baC.bay;
                        if (((String) customResponsedMessage.getData()).equals(nVar4.bbU.getTid())) {
                            TextView textView = this.baC.baz.baF;
                            nVar5 = this.baC.bay;
                            an.a(textView, nVar5.bbU.getId(), r.d.cp_cont_b, r.d.cp_cont_d);
                            TextView textView2 = this.baC.baz.baG;
                            nVar6 = this.baC.bay;
                            an.a(textView2, nVar6.bbU.getId(), r.d.cp_cont_j, r.d.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
