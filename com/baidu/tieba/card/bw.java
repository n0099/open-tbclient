package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw extends CustomMessageListener {
    final /* synthetic */ bt aUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw(bt btVar, int i) {
        super(i);
        this.aUm = btVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.a.u uVar;
        com.baidu.tieba.card.a.u uVar2;
        com.baidu.tieba.card.a.u uVar3;
        com.baidu.tieba.card.a.u uVar4;
        com.baidu.tieba.card.a.u uVar5;
        com.baidu.tieba.card.a.u uVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            uVar = this.aUm.aUi;
            if (uVar != null) {
                uVar2 = this.aUm.aUi;
                if (uVar2.aWf != null) {
                    uVar3 = this.aUm.aUi;
                    if (uVar3.aWf.getTid() != null && this.aUm.aUj != null && this.aUm.aUj.aUp != null && this.aUm.aUj.aUq != null) {
                        uVar4 = this.aUm.aUi;
                        if (((String) customResponsedMessage.getData()).equals(uVar4.aWf.getTid())) {
                            TextView textView = this.aUm.aUj.aUp;
                            uVar5 = this.aUm.aUi;
                            bc.a(textView, uVar5.aWf.getId(), t.d.cp_cont_b, t.d.cp_cont_d);
                            TextView textView2 = this.aUm.aUj.aUq;
                            uVar6 = this.aUm.aUi;
                            bc.a(textView2, uVar6.aWf.getId(), t.d.cp_cont_j, t.d.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
