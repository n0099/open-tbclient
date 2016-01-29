package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends CustomMessageListener {
    final /* synthetic */ ar aQJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at(ar arVar, int i) {
        super(i);
        this.aQJ = arVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.a.s sVar;
        com.baidu.tieba.card.a.s sVar2;
        com.baidu.tieba.card.a.s sVar3;
        com.baidu.tieba.card.a.s sVar4;
        boolean JY;
        com.baidu.tieba.card.a.s sVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            sVar = this.aQJ.aQI;
            if (sVar != null) {
                sVar2 = this.aQJ.aQI;
                if (sVar2.aSu != null) {
                    sVar3 = this.aQJ.aQI;
                    if (sVar3.aSu.getTid() != null && this.aQJ.aQH != null && this.aQJ.aQH.mTextTitle != null) {
                        sVar4 = this.aQJ.aQI;
                        if (((String) customResponsedMessage.getData()).equals(sVar4.aSu.getTid())) {
                            JY = this.aQJ.JY();
                            if (!JY) {
                                TextView textView = this.aQJ.aQH.mTextTitle;
                                sVar5 = this.aQJ.aQI;
                                ae.a(textView, sVar5.aSu.getId(), t.d.cp_cont_b, t.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
