package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends CustomMessageListener {
    final /* synthetic */ t bBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(t tVar, int i) {
        super(i);
        this.bBu = tVar;
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
            kVar = this.bBu.bBr;
            if (kVar != null) {
                kVar2 = this.bBu.bBr;
                if (kVar2.bai != null) {
                    kVar3 = this.bBu.bBr;
                    if (kVar3.bai.getTid() != null && this.bBu.mTextTitle != null) {
                        kVar4 = this.bBu.bBr;
                        if (((String) customResponsedMessage.getData()).equals(kVar4.bai.getTid())) {
                            TextView textView = this.bBu.mTextTitle;
                            kVar5 = this.bBu.bBr;
                            at.a(textView, kVar5.bai.getId(), w.e.cp_cont_d, w.e.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
