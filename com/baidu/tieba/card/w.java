package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends CustomMessageListener {
    final /* synthetic */ t buX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(t tVar, int i) {
        super(i);
        this.buX = tVar;
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
            mVar = this.buX.buP;
            if (mVar != null) {
                mVar2 = this.buX.buP;
                if (mVar2.bck != null) {
                    mVar3 = this.buX.buP;
                    if (mVar3.bck.getTid() != null && this.buX.mTextTitle != null) {
                        mVar4 = this.buX.buP;
                        if (((String) customResponsedMessage.getData()).equals(mVar4.bck.getTid())) {
                            TextView textView = this.buX.mTextTitle;
                            mVar5 = this.buX.buP;
                            at.a(textView, mVar5.bck.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
