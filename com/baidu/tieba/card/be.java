package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be extends CustomMessageListener {
    final /* synthetic */ bc aTY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(bc bcVar, int i) {
        super(i);
        this.aTY = bcVar;
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
        boolean KU;
        TextView textView3;
        com.baidu.tieba.card.a.m mVar5;
        TextView textView4;
        com.baidu.tieba.card.a.m mVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            mVar = this.aTY.aTN;
            if (mVar != null) {
                mVar2 = this.aTY.aTN;
                if (mVar2.threadData != null) {
                    mVar3 = this.aTY.aTN;
                    if (mVar3.threadData.getTid() != null) {
                        textView = this.aTY.aSd;
                        if (textView != null) {
                            textView2 = this.aTY.aSj;
                            if (textView2 != null) {
                                mVar4 = this.aTY.aTN;
                                if (((String) customResponsedMessage.getData()).equals(mVar4.threadData.getTid())) {
                                    KU = this.aTY.KU();
                                    if (!KU) {
                                        textView3 = this.aTY.aSd;
                                        mVar5 = this.aTY.aTN;
                                        at.a(textView3, mVar5.Ix().getId(), u.d.cp_cont_b, u.d.cp_cont_d);
                                        textView4 = this.aTY.aSj;
                                        mVar6 = this.aTY.aTN;
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
