package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class ay extends CustomMessageListener {
    final /* synthetic */ aw bdG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(aw awVar, int i) {
        super(i);
        this.bdG = awVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.data.m mVar;
        com.baidu.tieba.card.data.m mVar2;
        com.baidu.tieba.card.data.m mVar3;
        TextView textView;
        TextView textView2;
        com.baidu.tieba.card.data.m mVar4;
        boolean Pa;
        TextView textView3;
        com.baidu.tieba.card.data.m mVar5;
        TextView textView4;
        com.baidu.tieba.card.data.m mVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            mVar = this.bdG.bdv;
            if (mVar != null) {
                mVar2 = this.bdG.bdv;
                if (mVar2.threadData != null) {
                    mVar3 = this.bdG.bdv;
                    if (mVar3.threadData.getTid() != null) {
                        textView = this.bdG.aOH;
                        if (textView != null) {
                            textView2 = this.bdG.bbY;
                            if (textView2 != null) {
                                mVar4 = this.bdG.bdv;
                                if (((String) customResponsedMessage.getData()).equals(mVar4.threadData.getTid())) {
                                    Pa = this.bdG.Pa();
                                    if (!Pa) {
                                        textView3 = this.bdG.aOH;
                                        mVar5 = this.bdG.bdv;
                                        an.a(textView3, mVar5.Jz().getId(), r.d.cp_cont_b, r.d.cp_cont_d);
                                        textView4 = this.bdG.bbY;
                                        mVar6 = this.bdG.bdv;
                                        an.a(textView4, mVar6.threadData.getId(), r.d.cp_cont_j, r.d.cp_cont_d);
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
