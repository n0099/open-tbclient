package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends CustomMessageListener {
    final /* synthetic */ w caE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(w wVar, int i) {
        super(i);
        this.caE = wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        TextView textView;
        bk bkVar4;
        TextView textView2;
        bk bkVar5;
        bk bkVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            bkVar = this.caE.aeu;
            if (bkVar != null) {
                bkVar2 = this.caE.aeu;
                if (bkVar2 != null) {
                    bkVar3 = this.caE.aeu;
                    if (bkVar3.getTid() != null) {
                        textView = this.caE.aOH;
                        if (textView != null && this.caE.bbY != null) {
                            bkVar4 = this.caE.aeu;
                            if (((String) customResponsedMessage.getData()).equals(bkVar4.getTid())) {
                                textView2 = this.caE.aOH;
                                bkVar5 = this.caE.aeu;
                                com.baidu.tieba.card.an.a(textView2, bkVar5.getId(), r.d.cp_cont_b, r.d.cp_cont_d);
                                TextView textView3 = this.caE.bbY;
                                bkVar6 = this.caE.aeu;
                                com.baidu.tieba.card.an.a(textView3, bkVar6.getId(), r.d.cp_cont_c, r.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
