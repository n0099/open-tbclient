package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends CustomMessageListener {
    final /* synthetic */ t bAB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(t tVar, int i) {
        super(i);
        this.bAB = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.data.k kVar;
        com.baidu.tieba.card.data.k kVar2;
        com.baidu.tieba.card.data.k kVar3;
        com.baidu.tieba.card.data.k kVar4;
        com.baidu.tieba.card.data.k kVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            kVar = this.bAB.bAy;
            if (kVar != null) {
                kVar2 = this.bAB.bAy;
                if (kVar2.aYA != null) {
                    kVar3 = this.bAB.bAy;
                    if (kVar3.aYA.getTid() != null && this.bAB.mTextTitle != null) {
                        kVar4 = this.bAB.bAy;
                        if (((String) customResponsedMessage.getData()).equals(kVar4.aYA.getTid())) {
                            TextView textView = this.bAB.mTextTitle;
                            kVar5 = this.bAB.bAy;
                            at.a(textView, kVar5.aYA.getId(), w.e.cp_cont_d, w.e.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
