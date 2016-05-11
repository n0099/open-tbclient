package com.baidu.tieba.frs.entelechy.c;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends CustomMessageListener {
    final /* synthetic */ w bpM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(w wVar, int i) {
        super(i);
        this.bpM = wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ax axVar;
        ax axVar2;
        ax axVar3;
        TextView textView;
        ax axVar4;
        TextView textView2;
        ax axVar5;
        ax axVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            axVar = this.bpM.aab;
            if (axVar != null) {
                axVar2 = this.bpM.aab;
                if (axVar2 != null) {
                    axVar3 = this.bpM.aab;
                    if (axVar3.getTid() != null) {
                        textView = this.bpM.aOG;
                        if (textView != null && this.bpM.aOM != null) {
                            axVar4 = this.bpM.aab;
                            if (((String) customResponsedMessage.getData()).equals(axVar4.getTid())) {
                                textView2 = this.bpM.aOG;
                                axVar5 = this.bpM.aab;
                                com.baidu.tieba.card.au.a(textView2, axVar5.getId(), t.d.cp_cont_b, t.d.cp_cont_c);
                                TextView textView3 = this.bpM.aOM;
                                axVar6 = this.bpM.aab;
                                com.baidu.tieba.card.au.a(textView3, axVar6.getId(), t.d.cp_cont_j, t.d.cp_cont_c);
                            }
                        }
                    }
                }
            }
        }
    }
}
