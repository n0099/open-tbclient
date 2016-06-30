package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends CustomMessageListener {
    final /* synthetic */ z aTy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(z zVar, int i) {
        super(i);
        this.aTy = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.a.o oVar;
        com.baidu.tieba.card.a.o oVar2;
        com.baidu.tieba.card.a.o oVar3;
        TextView textView;
        com.baidu.tieba.card.a.o oVar4;
        TextView textView2;
        com.baidu.tieba.card.a.o oVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            oVar = this.aTy.aTn;
            if (oVar != null) {
                oVar2 = this.aTy.aTn;
                if (oVar2.aVc != null) {
                    oVar3 = this.aTy.aTn;
                    if (oVar3.aVc.getTid() != null) {
                        textView = this.aTy.mTextTitle;
                        if (textView != null) {
                            oVar4 = this.aTy.aTn;
                            if (((String) customResponsedMessage.getData()).equals(oVar4.aVc.getTid())) {
                                textView2 = this.aTy.mTextTitle;
                                oVar5 = this.aTy.aTn;
                                at.a(textView2, oVar5.aVc.getId(), u.d.cp_cont_c, u.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
