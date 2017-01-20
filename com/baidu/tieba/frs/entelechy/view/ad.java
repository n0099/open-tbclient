package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends CustomMessageListener {
    final /* synthetic */ aa bMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(aa aaVar, int i) {
        super(i);
        this.bMC = aaVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bh bhVar;
        bh bhVar2;
        bh bhVar3;
        TextView textView;
        bh bhVar4;
        TextView textView2;
        bh bhVar5;
        bh bhVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            bhVar = this.bMC.acX;
            if (bhVar != null) {
                bhVar2 = this.bMC.acX;
                if (bhVar2 != null) {
                    bhVar3 = this.bMC.acX;
                    if (bhVar3.getTid() != null) {
                        textView = this.bMC.aNb;
                        if (textView != null && this.bMC.bkS != null) {
                            bhVar4 = this.bMC.acX;
                            if (((String) customResponsedMessage.getData()).equals(bhVar4.getTid())) {
                                textView2 = this.bMC.aNb;
                                bhVar5 = this.bMC.acX;
                                com.baidu.tieba.card.at.a(textView2, bhVar5.getId(), r.e.cp_cont_b, r.e.cp_cont_d);
                                TextView textView3 = this.bMC.bkS;
                                bhVar6 = this.bMC.acX;
                                com.baidu.tieba.card.at.a(textView3, bhVar6.getId(), r.e.cp_cont_c, r.e.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
