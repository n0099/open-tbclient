package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends CustomMessageListener {
    final /* synthetic */ aa bGn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(aa aaVar, int i) {
        super(i);
        this.bGn = aaVar;
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
            bgVar = this.bGn.adN;
            if (bgVar != null) {
                bgVar2 = this.bGn.adN;
                if (bgVar2 != null) {
                    bgVar3 = this.bGn.adN;
                    if (bgVar3.getTid() != null) {
                        textView = this.bGn.aNY;
                        if (textView != null && this.bGn.bbe != null) {
                            bgVar4 = this.bGn.adN;
                            if (((String) customResponsedMessage.getData()).equals(bgVar4.getTid())) {
                                textView2 = this.bGn.aNY;
                                bgVar5 = this.bGn.adN;
                                com.baidu.tieba.card.ap.a(textView2, bgVar5.getId(), r.d.cp_cont_b, r.d.cp_cont_d);
                                TextView textView3 = this.bGn.bbe;
                                bgVar6 = this.bGn.adN;
                                com.baidu.tieba.card.ap.a(textView3, bgVar6.getId(), r.d.cp_cont_c, r.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
