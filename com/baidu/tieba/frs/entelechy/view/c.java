package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a bXm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.bXm = aVar;
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
            bgVar = this.bXm.adL;
            if (bgVar != null) {
                bgVar2 = this.bXm.adL;
                if (bgVar2 != null) {
                    bgVar3 = this.bXm.adL;
                    if (bgVar3.getTid() != null) {
                        textView = this.bXm.mTextTitle;
                        if (textView != null) {
                            bgVar4 = this.bXm.adL;
                            if (((String) customResponsedMessage.getData()).equals(bgVar4.getTid())) {
                                textView2 = this.bXm.mTextTitle;
                                bgVar5 = this.bXm.adL;
                                com.baidu.tieba.card.ap.a(textView2, bgVar5.getId(), t.d.cp_cont_c, t.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
