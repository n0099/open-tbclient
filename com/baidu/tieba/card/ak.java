package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends CustomMessageListener {
    final /* synthetic */ x bml;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(x xVar, int i) {
        super(i);
        this.bml = xVar;
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
            pVar = this.bml.bmd;
            if (pVar != null) {
                pVar2 = this.bml.bmd;
                if (pVar2.aVi != null) {
                    pVar3 = this.bml.bmd;
                    if (pVar3.aVi.getTid() != null) {
                        textView = this.bml.mTextTitle;
                        if (textView != null) {
                            pVar4 = this.bml.bmd;
                            if (((String) customResponsedMessage.getData()).equals(pVar4.aVi.getTid())) {
                                textView2 = this.bml.mTextTitle;
                                pVar5 = this.bml.bmd;
                                at.a(textView2, pVar5.aVi.getId(), r.e.cp_cont_c, r.e.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
