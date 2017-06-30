package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends CustomMessageListener {
    final /* synthetic */ ai chP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(ai aiVar, int i) {
        super(i);
        this.chP = aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.ay ayVar;
        com.baidu.tbadk.core.data.ay ayVar2;
        com.baidu.tbadk.core.data.ay ayVar3;
        com.baidu.tbadk.core.data.ay ayVar4;
        com.baidu.tbadk.core.data.ay ayVar5;
        com.baidu.tbadk.core.data.ay ayVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            ayVar = this.chP.chN;
            if (ayVar != null) {
                ayVar2 = this.chP.chN;
                if (ayVar2 != null) {
                    ayVar3 = this.chP.chN;
                    if (ayVar3.getTid() != null && this.chP.chO != null && this.chP.chO.bAg != null && this.chP.chO.chV != null) {
                        ayVar4 = this.chP.chN;
                        if (((String) customResponsedMessage.getData()).equals(ayVar4.getTid())) {
                            TextView textView = this.chP.chO.bAg;
                            ayVar5 = this.chP.chN;
                            com.baidu.tieba.card.at.a(textView, ayVar5.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                            TextView textView2 = this.chP.chO.chV;
                            ayVar6 = this.chP.chN;
                            com.baidu.tieba.card.at.a(textView2, ayVar6.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
