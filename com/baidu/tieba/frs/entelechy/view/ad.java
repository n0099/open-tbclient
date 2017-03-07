package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends CustomMessageListener {
    final /* synthetic */ aa bTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(aa aaVar, int i) {
        super(i);
        this.bTK = aaVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        TextView textView;
        bj bjVar4;
        TextView textView2;
        bj bjVar5;
        bj bjVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            bjVar = this.bTK.ain;
            if (bjVar != null) {
                bjVar2 = this.bTK.ain;
                if (bjVar2 != null) {
                    bjVar3 = this.bTK.ain;
                    if (bjVar3.getTid() != null) {
                        textView = this.bTK.aSO;
                        if (textView != null && this.bTK.brK != null) {
                            bjVar4 = this.bTK.ain;
                            if (((String) customResponsedMessage.getData()).equals(bjVar4.getTid())) {
                                textView2 = this.bTK.aSO;
                                bjVar5 = this.bTK.ain;
                                com.baidu.tieba.card.at.a(textView2, bjVar5.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                                TextView textView3 = this.bTK.brK;
                                bjVar6 = this.bTK.ain;
                                com.baidu.tieba.card.at.a(textView3, bjVar6.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
