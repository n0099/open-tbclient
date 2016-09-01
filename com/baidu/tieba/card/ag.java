package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends CustomMessageListener {
    final /* synthetic */ t aZF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(t tVar, int i) {
        super(i);
        this.aZF = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.data.o oVar;
        com.baidu.tieba.card.data.o oVar2;
        com.baidu.tieba.card.data.o oVar3;
        TextView textView;
        com.baidu.tieba.card.data.o oVar4;
        TextView textView2;
        com.baidu.tieba.card.data.o oVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            oVar = this.aZF.aZr;
            if (oVar != null) {
                oVar2 = this.aZF.aZr;
                if (oVar2.bbC != null) {
                    oVar3 = this.aZF.aZr;
                    if (oVar3.bbC.getTid() != null) {
                        textView = this.aZF.mTextTitle;
                        if (textView != null) {
                            oVar4 = this.aZF.aZr;
                            if (((String) customResponsedMessage.getData()).equals(oVar4.bbC.getTid())) {
                                textView2 = this.aZF.mTextTitle;
                                oVar5 = this.aZF.aZr;
                                ap.a(textView2, oVar5.bbC.getId(), t.d.cp_cont_c, t.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
