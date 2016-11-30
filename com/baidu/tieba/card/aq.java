package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends CustomMessageListener {
    final /* synthetic */ ao bdA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(ao aoVar, int i) {
        super(i);
        this.bdA = aoVar;
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
            mVar = this.bdA.bdv;
            if (mVar != null) {
                mVar2 = this.bdA.bdv;
                if (mVar2.threadData != null) {
                    mVar3 = this.bdA.bdv;
                    if (mVar3.threadData.getTid() != null) {
                        textView = this.bdA.aOH;
                        if (textView != null) {
                            textView2 = this.bdA.bbY;
                            if (textView2 != null) {
                                mVar4 = this.bdA.bdv;
                                if (((String) customResponsedMessage.getData()).equals(mVar4.threadData.getTid())) {
                                    Pa = this.bdA.Pa();
                                    if (!Pa) {
                                        textView3 = this.bdA.aOH;
                                        mVar5 = this.bdA.bdv;
                                        an.a(textView3, mVar5.Jz().getId(), r.d.cp_cont_b, r.d.cp_cont_d);
                                        textView4 = this.bdA.bbY;
                                        mVar6 = this.bdA.bdv;
                                        an.a(textView4, mVar6.threadData.getId(), r.d.cp_cont_c, r.d.cp_cont_d);
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
