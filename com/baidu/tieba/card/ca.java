package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca extends CustomMessageListener {
    final /* synthetic */ by aUv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ca(by byVar, int i) {
        super(i);
        this.aUv = byVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.a.v vVar;
        com.baidu.tieba.card.a.v vVar2;
        com.baidu.tieba.card.a.v vVar3;
        com.baidu.tieba.card.a.v vVar4;
        boolean Lm;
        com.baidu.tieba.card.a.v vVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            vVar = this.aUv.aTD;
            if (vVar != null) {
                vVar2 = this.aUv.aTD;
                if (vVar2.aWf != null) {
                    vVar3 = this.aUv.aTD;
                    if (vVar3.aWf.getTid() != null && this.aUv.aUu != null && this.aUv.aUu.mTextTitle != null) {
                        vVar4 = this.aUv.aTD;
                        if (((String) customResponsedMessage.getData()).equals(vVar4.aWf.getTid())) {
                            Lm = this.aUv.Lm();
                            if (!Lm) {
                                TextView textView = this.aUv.aUu.mTextTitle;
                                vVar5 = this.aUv.aTD;
                                bc.a(textView, vVar5.aWf.getId(), t.d.cp_cont_b, t.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
