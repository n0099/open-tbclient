package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi extends CustomMessageListener {
    final /* synthetic */ bf bvZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(bf bfVar, int i) {
        super(i);
        this.bvZ = bfVar;
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
            mVar = this.bvZ.bvV;
            if (mVar != null) {
                mVar2 = this.bvZ.bvV;
                if (mVar2.bcB != null) {
                    mVar3 = this.bvZ.bvV;
                    if (mVar3.bcB.getTid() != null && this.bvZ.bvW != null && this.bvZ.bvW.aSr != null) {
                        mVar4 = this.bvZ.bvV;
                        if (((String) customResponsedMessage.getData()).equals(mVar4.bcB.getTid())) {
                            TextView textView = this.bvZ.bvW.aSr;
                            mVar5 = this.bvZ.bvV;
                            ap.a(textView, mVar5.bcB.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
