package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends CustomMessageListener {
    final /* synthetic */ x bXo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(x xVar, int i) {
        super(i);
        this.bXo = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        TextView textView;
        bi biVar4;
        TextView textView2;
        bi biVar5;
        bi biVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            biVar = this.bXo.adW;
            if (biVar != null) {
                biVar2 = this.bXo.adW;
                if (biVar2 != null) {
                    biVar3 = this.bXo.adW;
                    if (biVar3.getTid() != null) {
                        textView = this.bXo.aMI;
                        if (textView != null && this.bXo.aYP != null) {
                            biVar4 = this.bXo.adW;
                            if (((String) customResponsedMessage.getData()).equals(biVar4.getTid())) {
                                textView2 = this.bXo.aMI;
                                biVar5 = this.bXo.adW;
                                com.baidu.tieba.card.an.a(textView2, biVar5.getId(), r.d.cp_cont_b, r.d.cp_cont_c);
                                TextView textView3 = this.bXo.aYP;
                                biVar6 = this.bXo.adW;
                                com.baidu.tieba.card.an.a(textView3, biVar6.getId(), r.d.cp_cont_j, r.d.cp_cont_c);
                            }
                        }
                    }
                }
            }
        }
    }
}
