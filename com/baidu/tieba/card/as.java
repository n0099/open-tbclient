package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends CustomMessageListener {
    final /* synthetic */ aq bcS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as(aq aqVar, int i) {
        super(i);
        this.bcS = aqVar;
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
        boolean Ow;
        TextView textView3;
        com.baidu.tieba.card.data.m mVar5;
        TextView textView4;
        com.baidu.tieba.card.data.m mVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            mVar = this.bcS.bcN;
            if (mVar != null) {
                mVar2 = this.bcS.bcN;
                if (mVar2.threadData != null) {
                    mVar3 = this.bcS.bcN;
                    if (mVar3.threadData.getTid() != null) {
                        textView = this.bcS.aNY;
                        if (textView != null) {
                            textView2 = this.bcS.bbe;
                            if (textView2 != null) {
                                mVar4 = this.bcS.bcN;
                                if (((String) customResponsedMessage.getData()).equals(mVar4.threadData.getTid())) {
                                    Ow = this.bcS.Ow();
                                    if (!Ow) {
                                        textView3 = this.bcS.aNY;
                                        mVar5 = this.bcS.bcN;
                                        ap.a(textView3, mVar5.IU().getId(), r.d.cp_cont_b, r.d.cp_cont_d);
                                        textView4 = this.bcS.bbe;
                                        mVar6 = this.bcS.bcN;
                                        ap.a(textView4, mVar6.threadData.getId(), r.d.cp_cont_c, r.d.cp_cont_d);
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
