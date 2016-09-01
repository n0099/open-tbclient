package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends CustomMessageListener {
    final /* synthetic */ aq aZZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as(aq aqVar, int i) {
        super(i);
        this.aZZ = aqVar;
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
        boolean Nv;
        TextView textView3;
        com.baidu.tieba.card.data.m mVar5;
        TextView textView4;
        com.baidu.tieba.card.data.m mVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            mVar = this.aZZ.aZU;
            if (mVar != null) {
                mVar2 = this.aZZ.aZU;
                if (mVar2.threadData != null) {
                    mVar3 = this.aZZ.aZU;
                    if (mVar3.threadData.getTid() != null) {
                        textView = this.aZZ.aYh;
                        if (textView != null) {
                            textView2 = this.aZZ.aYn;
                            if (textView2 != null) {
                                mVar4 = this.aZZ.aZU;
                                if (((String) customResponsedMessage.getData()).equals(mVar4.threadData.getTid())) {
                                    Nv = this.aZZ.Nv();
                                    if (!Nv) {
                                        textView3 = this.aZZ.aYh;
                                        mVar5 = this.aZZ.aZU;
                                        ap.a(textView3, mVar5.Kw().getId(), t.d.cp_cont_b, t.d.cp_cont_d);
                                        textView4 = this.aZZ.aYn;
                                        mVar6 = this.aZZ.aZU;
                                        ap.a(textView4, mVar6.threadData.getId(), t.d.cp_cont_j, t.d.cp_cont_d);
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
