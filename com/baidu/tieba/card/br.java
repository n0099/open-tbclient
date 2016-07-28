package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br extends CustomMessageListener {
    final /* synthetic */ bp aVh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(bp bpVar, int i) {
        super(i);
        this.aVh = bpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.a.o oVar;
        com.baidu.tieba.card.a.o oVar2;
        com.baidu.tieba.card.a.o oVar3;
        com.baidu.tieba.card.a.o oVar4;
        boolean KT;
        com.baidu.tieba.card.a.o oVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            oVar = this.aVh.aUj;
            if (oVar != null) {
                oVar2 = this.aVh.aUj;
                if (oVar2.aWa != null) {
                    oVar3 = this.aVh.aUj;
                    if (oVar3.aWa.getTid() != null && this.aVh.aVg != null && this.aVh.aVg.mTextTitle != null) {
                        oVar4 = this.aVh.aUj;
                        if (((String) customResponsedMessage.getData()).equals(oVar4.aWa.getTid())) {
                            KT = this.aVh.KT();
                            if (!KT) {
                                TextView textView = this.aVh.aVg.mTextTitle;
                                oVar5 = this.aVh.aUj;
                                at.a(textView, oVar5.aWa.getId(), u.d.cp_cont_b, u.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
