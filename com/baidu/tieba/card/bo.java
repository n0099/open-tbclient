package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends CustomMessageListener {
    final /* synthetic */ bl aQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo(bl blVar, int i) {
        super(i);
        this.aQG = blVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.card.a.m mVar;
        com.baidu.tieba.card.a.m mVar2;
        com.baidu.tieba.card.a.m mVar3;
        com.baidu.tieba.card.a.m mVar4;
        com.baidu.tieba.card.a.m mVar5;
        com.baidu.tieba.card.a.m mVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            mVar = this.aQG.aQC;
            if (mVar != null) {
                mVar2 = this.aQG.aQC;
                if (mVar2.aRZ != null) {
                    mVar3 = this.aQG.aQC;
                    if (mVar3.aRZ.getTid() != null && this.aQG.aQD != null && this.aQG.aQD.aQJ != null && this.aQG.aQD.aQK != null) {
                        mVar4 = this.aQG.aQC;
                        if (((String) customResponsedMessage.getData()).equals(mVar4.aRZ.getTid())) {
                            TextView textView = this.aQG.aQD.aQJ;
                            mVar5 = this.aQG.aQC;
                            au.a(textView, mVar5.aRZ.getId(), t.d.cp_cont_b, t.d.cp_cont_d);
                            TextView textView2 = this.aQG.aQD.aQK;
                            mVar6 = this.aQG.aQC;
                            au.a(textView2, mVar6.aRZ.getId(), t.d.cp_cont_j, t.d.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
