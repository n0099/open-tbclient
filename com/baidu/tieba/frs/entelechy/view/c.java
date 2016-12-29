package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a bGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.bGf = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bg bgVar;
        bg bgVar2;
        bg bgVar3;
        TextView textView;
        bg bgVar4;
        TextView textView2;
        bg bgVar5;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            bgVar = this.bGf.adN;
            if (bgVar != null) {
                bgVar2 = this.bGf.adN;
                if (bgVar2 != null) {
                    bgVar3 = this.bGf.adN;
                    if (bgVar3.getTid() != null) {
                        textView = this.bGf.mTextTitle;
                        if (textView != null) {
                            bgVar4 = this.bGf.adN;
                            if (((String) customResponsedMessage.getData()).equals(bgVar4.getTid())) {
                                textView2 = this.bGf.mTextTitle;
                                bgVar5 = this.bGf.adN;
                                com.baidu.tieba.card.ap.a(textView2, bgVar5.getId(), r.d.cp_cont_c, r.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
