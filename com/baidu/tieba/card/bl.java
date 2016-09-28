package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class bl extends CustomMessageListener {
    final /* synthetic */ bj baL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl(bj bjVar, int i) {
        super(i);
        this.baL = bjVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.data.o oVar;
        com.baidu.tieba.card.data.o oVar2;
        com.baidu.tieba.card.data.o oVar3;
        com.baidu.tieba.card.data.o oVar4;
        boolean NW;
        com.baidu.tieba.card.data.o oVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            oVar = this.baL.aZM;
            if (oVar != null) {
                oVar2 = this.baL.aZM;
                if (oVar2.bbU != null) {
                    oVar3 = this.baL.aZM;
                    if (oVar3.bbU.getTid() != null && this.baL.baK != null && this.baL.baK.mTextTitle != null) {
                        oVar4 = this.baL.aZM;
                        if (((String) customResponsedMessage.getData()).equals(oVar4.bbU.getTid())) {
                            NW = this.baL.NW();
                            if (!NW) {
                                TextView textView = this.baL.baK.mTextTitle;
                                oVar5 = this.baL.aZM;
                                an.a(textView, oVar5.bbU.getId(), r.d.cp_cont_b, r.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
