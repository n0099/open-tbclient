package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends CustomMessageListener {
    final /* synthetic */ ag caH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ag agVar, int i) {
        super(i);
        this.caH = agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.au auVar;
        com.baidu.tbadk.core.data.au auVar2;
        com.baidu.tbadk.core.data.au auVar3;
        com.baidu.tbadk.core.data.au auVar4;
        com.baidu.tbadk.core.data.au auVar5;
        com.baidu.tbadk.core.data.au auVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            auVar = this.caH.caF;
            if (auVar != null) {
                auVar2 = this.caH.caF;
                if (auVar2 != null) {
                    auVar3 = this.caH.caF;
                    if (auVar3.getTid() != null && this.caH.caG != null && this.caH.caG.aNz != null && this.caH.caG.bdO != null) {
                        auVar4 = this.caH.caF;
                        if (((String) customResponsedMessage.getData()).equals(auVar4.getTid())) {
                            TextView textView = this.caH.caG.aNz;
                            auVar5 = this.caH.caF;
                            com.baidu.tieba.card.an.a(textView, auVar5.getId(), r.d.cp_cont_b, r.d.cp_cont_d);
                            TextView textView2 = this.caH.caG.bdO;
                            auVar6 = this.caH.caF;
                            com.baidu.tieba.card.an.a(textView2, auVar6.getId(), r.d.cp_cont_j, r.d.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
