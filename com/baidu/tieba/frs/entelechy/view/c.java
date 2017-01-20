package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a bMu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.bMu = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bh bhVar;
        bh bhVar2;
        bh bhVar3;
        TextView textView;
        bh bhVar4;
        TextView textView2;
        bh bhVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            bhVar = this.bMu.acX;
            if (bhVar != null) {
                bhVar2 = this.bMu.acX;
                if (bhVar2 != null) {
                    bhVar3 = this.bMu.acX;
                    if (bhVar3.getTid() != null) {
                        textView = this.bMu.mTextTitle;
                        if (textView != null) {
                            bhVar4 = this.bMu.acX;
                            if (((String) customResponsedMessage.getData()).equals(bhVar4.getTid())) {
                                textView2 = this.bMu.mTextTitle;
                                bhVar5 = this.bMu.acX;
                                com.baidu.tieba.card.at.a(textView2, bhVar5.getId(), r.e.cp_cont_c, r.e.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
