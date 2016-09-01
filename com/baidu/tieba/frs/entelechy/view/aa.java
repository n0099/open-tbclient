package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends CustomMessageListener {
    final /* synthetic */ x bXt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(x xVar, int i) {
        super(i);
        this.bXt = xVar;
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
        bg bgVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            bgVar = this.bXt.adL;
            if (bgVar != null) {
                bgVar2 = this.bXt.adL;
                if (bgVar2 != null) {
                    bgVar3 = this.bXt.adL;
                    if (bgVar3.getTid() != null) {
                        textView = this.bXt.aYh;
                        if (textView != null && this.bXt.aYn != null) {
                            bgVar4 = this.bXt.adL;
                            if (((String) customResponsedMessage.getData()).equals(bgVar4.getTid())) {
                                textView2 = this.bXt.aYh;
                                bgVar5 = this.bXt.adL;
                                com.baidu.tieba.card.ap.a(textView2, bgVar5.getId(), t.d.cp_cont_b, t.d.cp_cont_c);
                                TextView textView3 = this.bXt.aYn;
                                bgVar6 = this.bXt.adL;
                                com.baidu.tieba.card.ap.a(textView3, bgVar6.getId(), t.d.cp_cont_j, t.d.cp_cont_c);
                            }
                        }
                    }
                }
            }
        }
    }
}
