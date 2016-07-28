package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be extends CustomMessageListener {
    final /* synthetic */ bc aUU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(bc bcVar, int i) {
        super(i);
        this.aUU = bcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.a.m mVar;
        com.baidu.tieba.card.a.m mVar2;
        com.baidu.tieba.card.a.m mVar3;
        TextView textView;
        TextView textView2;
        com.baidu.tieba.card.a.m mVar4;
        boolean KT;
        TextView textView3;
        com.baidu.tieba.card.a.m mVar5;
        TextView textView4;
        com.baidu.tieba.card.a.m mVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            mVar = this.aUU.aUJ;
            if (mVar != null) {
                mVar2 = this.aUU.aUJ;
                if (mVar2.threadData != null) {
                    mVar3 = this.aUU.aUJ;
                    if (mVar3.threadData.getTid() != null) {
                        textView = this.aUU.aSZ;
                        if (textView != null) {
                            textView2 = this.aUU.aTf;
                            if (textView2 != null) {
                                mVar4 = this.aUU.aUJ;
                                if (((String) customResponsedMessage.getData()).equals(mVar4.threadData.getTid())) {
                                    KT = this.aUU.KT();
                                    if (!KT) {
                                        textView3 = this.aUU.aSZ;
                                        mVar5 = this.aUU.aUJ;
                                        at.a(textView3, mVar5.Iw().getId(), u.d.cp_cont_b, u.d.cp_cont_d);
                                        textView4 = this.aUU.aTf;
                                        mVar6 = this.aUU.aUJ;
                                        at.a(textView4, mVar6.threadData.getId(), u.d.cp_cont_j, u.d.cp_cont_d);
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
