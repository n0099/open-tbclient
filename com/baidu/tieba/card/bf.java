package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends CustomMessageListener {
    final /* synthetic */ bd aQB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf(bd bdVar, int i) {
        super(i);
        this.aQB = bdVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.a.l lVar;
        com.baidu.tieba.card.a.l lVar2;
        com.baidu.tieba.card.a.l lVar3;
        TextView textView;
        TextView textView2;
        com.baidu.tieba.card.a.l lVar4;
        boolean JT;
        TextView textView3;
        com.baidu.tieba.card.a.l lVar5;
        TextView textView4;
        com.baidu.tieba.card.a.l lVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            lVar = this.aQB.aQq;
            if (lVar != null) {
                lVar2 = this.aQB.aQq;
                if (lVar2.aRG != null) {
                    lVar3 = this.aQB.aQq;
                    if (lVar3.aRG.getTid() != null) {
                        textView = this.aQB.aOG;
                        if (textView != null) {
                            textView2 = this.aQB.aOM;
                            if (textView2 != null) {
                                lVar4 = this.aQB.aQq;
                                if (((String) customResponsedMessage.getData()).equals(lVar4.aRG.getTid())) {
                                    JT = this.aQB.JT();
                                    if (!JT) {
                                        textView3 = this.aQB.aOG;
                                        lVar5 = this.aQB.aQq;
                                        au.a(textView3, lVar5.Kl().getId(), t.d.cp_cont_b, t.d.cp_cont_d);
                                        textView4 = this.aQB.aOM;
                                        lVar6 = this.aQB.aQq;
                                        au.a(textView4, lVar6.aRG.getId(), t.d.cp_cont_j, t.d.cp_cont_d);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
