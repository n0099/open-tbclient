package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a bVG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.bVG = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        TextView textView;
        bi biVar4;
        TextView textView2;
        bi biVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            biVar = this.bVG.aiC;
            if (biVar != null) {
                biVar2 = this.bVG.aiC;
                if (biVar2 != null) {
                    biVar3 = this.bVG.aiC;
                    if (biVar3.getTid() != null) {
                        textView = this.bVG.mTextTitle;
                        if (textView != null) {
                            biVar4 = this.bVG.aiC;
                            if (((String) customResponsedMessage.getData()).equals(biVar4.getTid())) {
                                textView2 = this.bVG.mTextTitle;
                                biVar5 = this.bVG.aiC;
                                com.baidu.tieba.card.at.a(textView2, biVar5.getId(), w.e.cp_cont_c, w.e.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
