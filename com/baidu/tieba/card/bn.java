package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends CustomMessageListener {
    final /* synthetic */ bl aUh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(bl blVar, int i) {
        super(i);
        this.aUh = blVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.a.t tVar;
        com.baidu.tieba.card.a.t tVar2;
        com.baidu.tieba.card.a.t tVar3;
        TextView textView;
        TextView textView2;
        com.baidu.tieba.card.a.t tVar4;
        boolean Lm;
        TextView textView3;
        com.baidu.tieba.card.a.t tVar5;
        TextView textView4;
        com.baidu.tieba.card.a.t tVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            tVar = this.aUh.aTW;
            if (tVar != null) {
                tVar2 = this.aUh.aTW;
                if (tVar2.aVJ != null) {
                    tVar3 = this.aUh.aTW;
                    if (tVar3.aVJ.getTid() != null) {
                        textView = this.aUh.aSh;
                        if (textView != null) {
                            textView2 = this.aUh.aSn;
                            if (textView2 != null) {
                                tVar4 = this.aUh.aTW;
                                if (((String) customResponsedMessage.getData()).equals(tVar4.aVJ.getTid())) {
                                    Lm = this.aUh.Lm();
                                    if (!Lm) {
                                        textView3 = this.aUh.aSh;
                                        tVar5 = this.aUh.aTW;
                                        bc.a(textView3, tVar5.LC().getId(), t.d.cp_cont_b, t.d.cp_cont_d);
                                        textView4 = this.aUh.aSn;
                                        tVar6 = this.aUh.aTW;
                                        bc.a(textView4, tVar6.aVJ.getId(), t.d.cp_cont_j, t.d.cp_cont_d);
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
