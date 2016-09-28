package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a bXh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.bXh = aVar;
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
            biVar = this.bXh.adW;
            if (biVar != null) {
                biVar2 = this.bXh.adW;
                if (biVar2 != null) {
                    biVar3 = this.bXh.adW;
                    if (biVar3.getTid() != null) {
                        textView = this.bXh.mTextTitle;
                        if (textView != null) {
                            biVar4 = this.bXh.adW;
                            if (((String) customResponsedMessage.getData()).equals(biVar4.getTid())) {
                                textView2 = this.bXh.mTextTitle;
                                biVar5 = this.bXh.adW;
                                com.baidu.tieba.card.an.a(textView2, biVar5.getId(), r.d.cp_cont_c, r.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
