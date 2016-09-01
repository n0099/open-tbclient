package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class ba extends CustomMessageListener {
    final /* synthetic */ ay baf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba(ay ayVar, int i) {
        super(i);
        this.baf = ayVar;
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
            mVar = this.baf.aZU;
            if (mVar != null) {
                mVar2 = this.baf.aZU;
                if (mVar2.threadData != null) {
                    mVar3 = this.baf.aZU;
                    if (mVar3.threadData.getTid() != null) {
                        textView = this.baf.aYh;
                        if (textView != null) {
                            textView2 = this.baf.aYn;
                            if (textView2 != null) {
                                mVar4 = this.baf.aZU;
                                if (((String) customResponsedMessage.getData()).equals(mVar4.threadData.getTid())) {
                                    Nv = this.baf.Nv();
                                    if (!Nv) {
                                        textView3 = this.baf.aYh;
                                        mVar5 = this.baf.aZU;
                                        ap.a(textView3, mVar5.Kw().getId(), t.d.cp_cont_b, t.d.cp_cont_d);
                                        textView4 = this.baf.aYn;
                                        mVar6 = this.baf.aZU;
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
