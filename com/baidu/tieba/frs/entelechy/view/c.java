package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a bTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.bTB = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        TextView textView;
        bj bjVar4;
        TextView textView2;
        bj bjVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            bjVar = this.bTB.ain;
            if (bjVar != null) {
                bjVar2 = this.bTB.ain;
                if (bjVar2 != null) {
                    bjVar3 = this.bTB.ain;
                    if (bjVar3.getTid() != null) {
                        textView = this.bTB.mTextTitle;
                        if (textView != null) {
                            bjVar4 = this.bTB.ain;
                            if (((String) customResponsedMessage.getData()).equals(bjVar4.getTid())) {
                                textView2 = this.bTB.mTextTitle;
                                bjVar5 = this.bTB.ain;
                                com.baidu.tieba.card.at.a(textView2, bjVar5.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
