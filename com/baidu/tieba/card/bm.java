package com.baidu.tieba.card;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm extends CustomMessageListener {
    final /* synthetic */ bj bBJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm(bj bjVar, int i) {
        super(i);
        this.bBJ = bjVar;
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
            mVar = this.bBJ.bBF;
            if (mVar != null) {
                mVar2 = this.bBJ.bBF;
                if (mVar2.aYA != null) {
                    mVar3 = this.bBJ.bBF;
                    if (mVar3.aYA.getTid() != null && this.bBJ.bBG != null && this.bBJ.bBG.bzn != null) {
                        mVar4 = this.bBJ.bBF;
                        if (((String) customResponsedMessage.getData()).equals(mVar4.aYA.getTid())) {
                            TextView textView = this.bBJ.bBG.bzn;
                            mVar5 = this.bBJ.bBF;
                            at.a(textView, mVar5.aYA.getId(), w.e.cp_cont_b, w.e.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
