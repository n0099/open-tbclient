package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends CustomMessageListener {
    final /* synthetic */ am bTS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(am amVar, int i) {
        super(i);
        this.bTS = amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        aw awVar;
        aw awVar2;
        aw awVar3;
        aw awVar4;
        aw awVar5;
        aw awVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            awVar = this.bTS.bTQ;
            if (awVar != null) {
                awVar2 = this.bTS.bTQ;
                if (awVar2 != null) {
                    awVar3 = this.bTS.bTQ;
                    if (awVar3.getTid() != null && this.bTS.bTR != null && this.bTS.bTR.aRE != null && this.bTS.bTR.btQ != null) {
                        awVar4 = this.bTS.bTQ;
                        if (((String) customResponsedMessage.getData()).equals(awVar4.getTid())) {
                            TextView textView = this.bTS.bTR.aRE;
                            awVar5 = this.bTS.bTQ;
                            com.baidu.tieba.card.at.a(textView, awVar5.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                            TextView textView2 = this.bTS.bTR.btQ;
                            awVar6 = this.bTS.bTQ;
                            com.baidu.tieba.card.at.a(textView2, awVar6.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
