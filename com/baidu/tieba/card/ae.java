package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends CustomMessageListener {
    final /* synthetic */ r bde;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(r rVar, int i) {
        super(i);
        this.bde = rVar;
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
            oVar = this.bde.bcW;
            if (oVar != null) {
                oVar2 = this.bde.bcW;
                if (oVar2.beS != null) {
                    oVar3 = this.bde.bcW;
                    if (oVar3.beS.getTid() != null) {
                        textView = this.bde.mTextTitle;
                        if (textView != null) {
                            oVar4 = this.bde.bcW;
                            if (((String) customResponsedMessage.getData()).equals(oVar4.beS.getTid())) {
                                textView2 = this.bde.mTextTitle;
                                oVar5 = this.bde.bcW;
                                an.a(textView2, oVar5.beS.getId(), r.d.cp_cont_c, r.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
