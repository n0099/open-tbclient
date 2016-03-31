package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends CustomMessageListener {
    final /* synthetic */ al aTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(al alVar, int i) {
        super(i);
        this.aTK = alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.a.v vVar;
        com.baidu.tieba.card.a.v vVar2;
        com.baidu.tieba.card.a.v vVar3;
        TextView textView;
        com.baidu.tieba.card.a.v vVar4;
        boolean Lm;
        TextView textView2;
        com.baidu.tieba.card.a.v vVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            vVar = this.aTK.aTD;
            if (vVar != null) {
                vVar2 = this.aTK.aTD;
                if (vVar2.aWf != null) {
                    vVar3 = this.aTK.aTD;
                    if (vVar3.aWf.getTid() != null) {
                        textView = this.aTK.mTextTitle;
                        if (textView != null) {
                            vVar4 = this.aTK.aTD;
                            if (((String) customResponsedMessage.getData()).equals(vVar4.aWf.getTid())) {
                                Lm = this.aTK.Lm();
                                if (!Lm) {
                                    textView2 = this.aTK.mTextTitle;
                                    vVar5 = this.aTK.aTD;
                                    bc.a(textView2, vVar5.aWf.getId(), t.d.cp_cont_c, t.d.cp_cont_d);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
