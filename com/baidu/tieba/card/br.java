package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br extends CustomMessageListener {
    final /* synthetic */ bp aUl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(bp bpVar, int i) {
        super(i);
        this.aUl = bpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.a.o oVar;
        com.baidu.tieba.card.a.o oVar2;
        com.baidu.tieba.card.a.o oVar3;
        com.baidu.tieba.card.a.o oVar4;
        boolean KU;
        com.baidu.tieba.card.a.o oVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            oVar = this.aUl.aTn;
            if (oVar != null) {
                oVar2 = this.aUl.aTn;
                if (oVar2.aVc != null) {
                    oVar3 = this.aUl.aTn;
                    if (oVar3.aVc.getTid() != null && this.aUl.aUk != null && this.aUl.aUk.mTextTitle != null) {
                        oVar4 = this.aUl.aTn;
                        if (((String) customResponsedMessage.getData()).equals(oVar4.aVc.getTid())) {
                            KU = this.aUl.KU();
                            if (!KU) {
                                TextView textView = this.aUl.aUk.mTextTitle;
                                oVar5 = this.aUl.aTn;
                                at.a(textView, oVar5.aVc.getId(), u.d.cp_cont_b, u.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
