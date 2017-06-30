package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm extends CustomMessageListener {
    final /* synthetic */ bj bCC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm(bj bjVar, int i) {
        super(i);
        this.bCC = bjVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.data.m mVar;
        com.baidu.tieba.card.data.m mVar2;
        com.baidu.tieba.card.data.m mVar3;
        com.baidu.tieba.card.data.m mVar4;
        com.baidu.tieba.card.data.m mVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            mVar = this.bCC.bCy;
            if (mVar != null) {
                mVar2 = this.bCC.bCy;
                if (mVar2.bai != null) {
                    mVar3 = this.bCC.bCy;
                    if (mVar3.bai.getTid() != null && this.bCC.bCz != null && this.bCC.bCz.bAg != null) {
                        mVar4 = this.bCC.bCy;
                        if (((String) customResponsedMessage.getData()).equals(mVar4.bai.getTid())) {
                            TextView textView = this.bCC.bCz.bAg;
                            mVar5 = this.bCC.bCy;
                            at.a(textView, mVar5.bai.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
