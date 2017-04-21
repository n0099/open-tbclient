package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends CustomMessageListener {
    final /* synthetic */ bk bvX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(bk bkVar, int i) {
        super(i);
        this.bvX = bkVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.data.o oVar;
        com.baidu.tieba.card.data.o oVar2;
        com.baidu.tieba.card.data.o oVar3;
        com.baidu.tieba.card.data.o oVar4;
        com.baidu.tieba.card.data.o oVar5;
        com.baidu.tieba.card.data.o oVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            oVar = this.bvX.bvT;
            if (oVar != null) {
                oVar2 = this.bvX.bvT;
                if (oVar2.bck != null) {
                    oVar3 = this.bvX.bvT;
                    if (oVar3.bck.getTid() != null && this.bvX.bvU != null && this.bvX.bvU.aRW != null && this.bvX.bvU.bwa != null) {
                        oVar4 = this.bvX.bvT;
                        if (((String) customResponsedMessage.getData()).equals(oVar4.bck.getTid())) {
                            TextView textView = this.bvX.bvU.aRW;
                            oVar5 = this.bvX.bvT;
                            at.a(textView, oVar5.bck.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                            TextView textView2 = this.bvX.bvU.bwa;
                            oVar6 = this.bvX.bvT;
                            at.a(textView2, oVar6.bck.getId(), w.e.cp_cont_j, w.e.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
