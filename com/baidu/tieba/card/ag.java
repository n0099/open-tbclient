package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends CustomMessageListener {
    final /* synthetic */ t bcw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(t tVar, int i) {
        super(i);
        this.bcw = tVar;
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
            oVar = this.bcw.bco;
            if (oVar != null) {
                oVar2 = this.bcw.bco;
                if (oVar2.beB != null) {
                    oVar3 = this.bcw.bco;
                    if (oVar3.beB.getTid() != null) {
                        textView = this.bcw.mTextTitle;
                        if (textView != null) {
                            oVar4 = this.bcw.bco;
                            if (((String) customResponsedMessage.getData()).equals(oVar4.beB.getTid())) {
                                textView2 = this.bcw.mTextTitle;
                                oVar5 = this.bcw.bco;
                                ap.a(textView2, oVar5.beB.getId(), r.d.cp_cont_c, r.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
