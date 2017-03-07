package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends CustomMessageListener {
    final /* synthetic */ bk btN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(bk bkVar, int i) {
        super(i);
        this.btN = bkVar;
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
            oVar = this.btN.btJ;
            if (oVar != null) {
                oVar2 = this.btN.btJ;
                if (oVar2.bbv != null) {
                    oVar3 = this.btN.btJ;
                    if (oVar3.bbv.getTid() != null && this.btN.btK != null && this.btN.btK.aRE != null && this.btN.btK.btQ != null) {
                        oVar4 = this.btN.btJ;
                        if (((String) customResponsedMessage.getData()).equals(oVar4.bbv.getTid())) {
                            TextView textView = this.btN.btK.aRE;
                            oVar5 = this.btN.btJ;
                            at.a(textView, oVar5.bbv.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                            TextView textView2 = this.btN.btK.btQ;
                            oVar6 = this.btN.btJ;
                            at.a(textView2, oVar6.bbv.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
