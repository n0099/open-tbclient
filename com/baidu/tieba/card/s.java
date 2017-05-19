package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends CustomMessageListener {
    final /* synthetic */ p buU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(p pVar, int i) {
        super(i);
        this.buU = pVar;
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
            kVar = this.buU.buM;
            if (kVar != null) {
                kVar2 = this.buU.buM;
                if (kVar2.bcB != null) {
                    kVar3 = this.buU.buM;
                    if (kVar3.bcB.getTid() != null && this.buU.mTextTitle != null) {
                        kVar4 = this.buU.buM;
                        if (((String) customResponsedMessage.getData()).equals(kVar4.bcB.getTid())) {
                            TextView textView = this.buU.mTextTitle;
                            kVar5 = this.buU.buM;
                            ap.a(textView, kVar5.bcB.getId(), w.e.cp_cont_d, w.e.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
