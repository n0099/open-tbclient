package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends CustomMessageListener {
    final /* synthetic */ am bVX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(am amVar, int i) {
        super(i);
        this.bVX = amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.av avVar;
        com.baidu.tbadk.core.data.av avVar2;
        com.baidu.tbadk.core.data.av avVar3;
        com.baidu.tbadk.core.data.av avVar4;
        com.baidu.tbadk.core.data.av avVar5;
        com.baidu.tbadk.core.data.av avVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            avVar = this.bVX.bVV;
            if (avVar != null) {
                avVar2 = this.bVX.bVV;
                if (avVar2 != null) {
                    avVar3 = this.bVX.bVV;
                    if (avVar3.getTid() != null && this.bVX.bVW != null && this.bVX.bVW.aRW != null && this.bVX.bVW.bwa != null) {
                        avVar4 = this.bVX.bVV;
                        if (((String) customResponsedMessage.getData()).equals(avVar4.getTid())) {
                            TextView textView = this.bVX.bVW.aRW;
                            avVar5 = this.bVX.bVV;
                            com.baidu.tieba.card.at.a(textView, avVar5.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                            TextView textView2 = this.bVX.bVW.bwa;
                            avVar6 = this.bVX.bVV;
                            com.baidu.tieba.card.at.a(textView2, avVar6.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
