package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a cax;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.cax = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bk bkVar;
        bk bkVar2;
        bk bkVar3;
        TextView textView;
        bk bkVar4;
        TextView textView2;
        bk bkVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            bkVar = this.cax.aeu;
            if (bkVar != null) {
                bkVar2 = this.cax.aeu;
                if (bkVar2 != null) {
                    bkVar3 = this.cax.aeu;
                    if (bkVar3.getTid() != null) {
                        textView = this.cax.mTextTitle;
                        if (textView != null) {
                            bkVar4 = this.cax.aeu;
                            if (((String) customResponsedMessage.getData()).equals(bkVar4.getTid())) {
                                textView2 = this.cax.mTextTitle;
                                bkVar5 = this.cax.aeu;
                                com.baidu.tieba.card.an.a(textView2, bkVar5.getId(), r.d.cp_cont_c, r.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
