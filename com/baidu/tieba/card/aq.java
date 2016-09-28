package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends CustomMessageListener {
    final /* synthetic */ ao baq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(ao aoVar, int i) {
        super(i);
        this.baq = aoVar;
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
        boolean NW;
        TextView textView3;
        com.baidu.tieba.card.data.m mVar5;
        TextView textView4;
        com.baidu.tieba.card.data.m mVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            mVar = this.baq.bal;
            if (mVar != null) {
                mVar2 = this.baq.bal;
                if (mVar2.threadData != null) {
                    mVar3 = this.baq.bal;
                    if (mVar3.threadData.getTid() != null) {
                        textView = this.baq.aMI;
                        if (textView != null) {
                            textView2 = this.baq.aYP;
                            if (textView2 != null) {
                                mVar4 = this.baq.bal;
                                if (((String) customResponsedMessage.getData()).equals(mVar4.threadData.getTid())) {
                                    NW = this.baq.NW();
                                    if (!NW) {
                                        textView3 = this.baq.aMI;
                                        mVar5 = this.baq.bal;
                                        an.a(textView3, mVar5.Jv().getId(), r.d.cp_cont_b, r.d.cp_cont_d);
                                        textView4 = this.baq.aYP;
                                        mVar6 = this.baq.bal;
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
