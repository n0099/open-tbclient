package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends CustomMessageListener {
    final /* synthetic */ t blS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(t tVar, int i) {
        super(i);
        this.blS = tVar;
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
            mVar = this.blS.blL;
            if (mVar != null) {
                mVar2 = this.blS.blL;
                if (mVar2.aVi != null) {
                    mVar3 = this.blS.blL;
                    if (mVar3.aVi.getTid() != null && this.blS.mTextTitle != null) {
                        mVar4 = this.blS.blL;
                        if (((String) customResponsedMessage.getData()).equals(mVar4.aVi.getTid())) {
                            TextView textView = this.blS.mTextTitle;
                            mVar5 = this.blS.blL;
                            at.a(textView, mVar5.aVi.getId(), r.e.cp_cont_c, r.e.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
