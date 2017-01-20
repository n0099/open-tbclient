package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends CustomMessageListener {
    final /* synthetic */ bk bmS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(bk bkVar, int i) {
        super(i);
        this.bmS = bkVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.data.o oVar;
        com.baidu.tieba.card.data.o oVar2;
        com.baidu.tieba.card.data.o oVar3;
        com.baidu.tieba.card.data.o oVar4;
        com.baidu.tieba.card.data.o oVar5;
        com.baidu.tieba.card.data.o oVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            oVar = this.bmS.bmO;
            if (oVar != null) {
                oVar2 = this.bmS.bmO;
                if (oVar2.aVi != null) {
                    oVar3 = this.bmS.bmO;
                    if (oVar3.aVi.getTid() != null && this.bmS.bmP != null && this.bmS.bmP.aLR != null && this.bmS.bmP.bmV != null) {
                        oVar4 = this.bmS.bmO;
                        if (((String) customResponsedMessage.getData()).equals(oVar4.aVi.getTid())) {
                            TextView textView = this.bmS.bmP.aLR;
                            oVar5 = this.bmS.bmO;
                            at.a(textView, oVar5.aVi.getId(), r.e.cp_cont_b, r.e.cp_cont_d);
                            TextView textView2 = this.bmS.bmP.bmV;
                            oVar6 = this.bmS.bmO;
                            at.a(textView2, oVar6.aVi.getId(), r.e.cp_cont_j, r.e.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
