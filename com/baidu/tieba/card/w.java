package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends CustomMessageListener {
    final /* synthetic */ t bsE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(t tVar, int i) {
        super(i);
        this.bsE = tVar;
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
            mVar = this.bsE.bsw;
            if (mVar != null) {
                mVar2 = this.bsE.bsw;
                if (mVar2.bbo != null) {
                    mVar3 = this.bsE.bsw;
                    if (mVar3.bbo.getTid() != null && this.bsE.mTextTitle != null) {
                        mVar4 = this.bsE.bsw;
                        if (((String) customResponsedMessage.getData()).equals(mVar4.bbo.getTid())) {
                            TextView textView = this.bsE.mTextTitle;
                            mVar5 = this.bsE.bsw;
                            at.a(textView, mVar5.bbo.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
