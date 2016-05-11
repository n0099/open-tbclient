package com.baidu.tieba.frs.entelechy.c;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a bpG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.bpG = aVar;
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            axVar = this.bpG.aab;
            if (axVar != null) {
                axVar2 = this.bpG.aab;
                if (axVar2 != null) {
                    axVar3 = this.bpG.aab;
                    if (axVar3.getTid() != null) {
                        textView = this.bpG.mTextTitle;
                        if (textView != null) {
                            axVar4 = this.bpG.aab;
                            if (((String) customResponsedMessage.getData()).equals(axVar4.getTid())) {
                                textView2 = this.bpG.mTextTitle;
                                axVar5 = this.bpG.aab;
                                com.baidu.tieba.card.au.a(textView2, axVar5.getId(), t.d.cp_cont_c, t.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
