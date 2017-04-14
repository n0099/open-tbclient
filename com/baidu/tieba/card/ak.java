package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends CustomMessageListener {
    final /* synthetic */ x bsX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(x xVar, int i) {
        super(i);
        this.bsX = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.data.p pVar;
        com.baidu.tieba.card.data.p pVar2;
        com.baidu.tieba.card.data.p pVar3;
        TextView textView;
        com.baidu.tieba.card.data.p pVar4;
        TextView textView2;
        com.baidu.tieba.card.data.p pVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            pVar = this.bsX.bsP;
            if (pVar != null) {
                pVar2 = this.bsX.bsP;
                if (pVar2.bbo != null) {
                    pVar3 = this.bsX.bsP;
                    if (pVar3.bbo.getTid() != null) {
                        textView = this.bsX.mTextTitle;
                        if (textView != null) {
                            pVar4 = this.bsX.bsP;
                            if (((String) customResponsedMessage.getData()).equals(pVar4.bbo.getTid())) {
                                textView2 = this.bsX.mTextTitle;
                                pVar5 = this.bsX.bsP;
                                at.a(textView2, pVar5.bbo.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
