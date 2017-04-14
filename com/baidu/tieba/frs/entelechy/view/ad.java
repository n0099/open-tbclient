package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends CustomMessageListener {
    final /* synthetic */ aa bTy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(aa aaVar, int i) {
        super(i);
        this.bTy = aaVar;
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
            biVar = this.bTy.aiB;
            if (biVar != null) {
                biVar2 = this.bTy.aiB;
                if (biVar2 != null) {
                    biVar3 = this.bTy.aiB;
                    if (biVar3.getTid() != null) {
                        textView = this.bTy.mTitle;
                        if (textView != null && this.bTy.brC != null) {
                            biVar4 = this.bTy.aiB;
                            if (((String) customResponsedMessage.getData()).equals(biVar4.getTid())) {
                                textView2 = this.bTy.mTitle;
                                biVar5 = this.bTy.aiB;
                                com.baidu.tieba.card.at.a(textView2, biVar5.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                                TextView textView3 = this.bTy.brC;
                                biVar6 = this.bTy.aiB;
                                com.baidu.tieba.card.at.a(textView3, biVar6.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
