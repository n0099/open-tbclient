package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends CustomMessageListener {
    final /* synthetic */ x btf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(x xVar, int i) {
        super(i);
        this.btf = xVar;
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
            pVar = this.btf.bsX;
            if (pVar != null) {
                pVar2 = this.btf.bsX;
                if (pVar2.bbv != null) {
                    pVar3 = this.btf.bsX;
                    if (pVar3.bbv.getTid() != null) {
                        textView = this.btf.mTextTitle;
                        if (textView != null) {
                            pVar4 = this.btf.bsX;
                            if (((String) customResponsedMessage.getData()).equals(pVar4.bbv.getTid())) {
                                textView2 = this.btf.mTextTitle;
                                pVar5 = this.btf.bsX;
                                at.a(textView2, pVar5.bbv.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
