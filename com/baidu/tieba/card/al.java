package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends CustomMessageListener {
    final /* synthetic */ z aQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(z zVar, int i) {
        super(i);
        this.aQe = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.a.n nVar;
        com.baidu.tieba.card.a.n nVar2;
        com.baidu.tieba.card.a.n nVar3;
        TextView textView;
        com.baidu.tieba.card.a.n nVar4;
        TextView textView2;
        com.baidu.tieba.card.a.n nVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            nVar = this.aQe.aPR;
            if (nVar != null) {
                nVar2 = this.aQe.aPR;
                if (nVar2.aRZ != null) {
                    nVar3 = this.aQe.aPR;
                    if (nVar3.aRZ.getTid() != null) {
                        textView = this.aQe.mTextTitle;
                        if (textView != null) {
                            nVar4 = this.aQe.aPR;
                            if (((String) customResponsedMessage.getData()).equals(nVar4.aRZ.getTid())) {
                                textView2 = this.aQe.mTextTitle;
                                nVar5 = this.aQe.aPR;
                                au.a(textView2, nVar5.aRZ.getId(), t.d.cp_cont_c, t.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
