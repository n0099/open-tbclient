package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.card.at;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends CustomMessageListener {
    final /* synthetic */ ad bKw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(ad adVar, int i) {
        super(i);
        this.bKw = adVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.aj ajVar;
        com.baidu.tbadk.core.data.aj ajVar2;
        com.baidu.tbadk.core.data.aj ajVar3;
        com.baidu.tbadk.core.data.aj ajVar4;
        com.baidu.tbadk.core.data.aj ajVar5;
        com.baidu.tbadk.core.data.aj ajVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            ajVar = this.bKw.bKu;
            if (ajVar != null) {
                ajVar2 = this.bKw.bKu;
                if (ajVar2 != null) {
                    ajVar3 = this.bKw.bKu;
                    if (ajVar3.getTid() != null && this.bKw.bKv != null && this.bKw.bKv.aUf != null && this.bKw.bKv.aUg != null) {
                        ajVar4 = this.bKw.bKu;
                        if (((String) customResponsedMessage.getData()).equals(ajVar4.getTid())) {
                            TextView textView = this.bKw.bKv.aUf;
                            ajVar5 = this.bKw.bKu;
                            at.a(textView, ajVar5.getId(), u.d.cp_cont_b, u.d.cp_cont_d);
                            TextView textView2 = this.bKw.bKv.aUg;
                            ajVar6 = this.bKw.bKu;
                            at.a(textView2, ajVar6.getId(), u.d.cp_cont_j, u.d.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
