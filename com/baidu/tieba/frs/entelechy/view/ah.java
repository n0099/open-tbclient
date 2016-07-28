package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.card.at;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends CustomMessageListener {
    final /* synthetic */ ae bMe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(ae aeVar, int i) {
        super(i);
        this.bMe = aeVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.core.data.ao aoVar;
        com.baidu.tbadk.core.data.ao aoVar2;
        com.baidu.tbadk.core.data.ao aoVar3;
        com.baidu.tbadk.core.data.ao aoVar4;
        com.baidu.tbadk.core.data.ao aoVar5;
        com.baidu.tbadk.core.data.ao aoVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            aoVar = this.bMe.bMc;
            if (aoVar != null) {
                aoVar2 = this.bMe.bMc;
                if (aoVar2 != null) {
                    aoVar3 = this.bMe.bMc;
                    if (aoVar3.getTid() != null && this.bMe.bMd != null && this.bMe.bMd.aVb != null && this.bMe.bMd.aVc != null) {
                        aoVar4 = this.bMe.bMc;
                        if (((String) customResponsedMessage.getData()).equals(aoVar4.getTid())) {
                            TextView textView = this.bMe.bMd.aVb;
                            aoVar5 = this.bMe.bMc;
                            at.a(textView, aoVar5.getId(), u.d.cp_cont_b, u.d.cp_cont_d);
                            TextView textView2 = this.bMe.bMd.aVc;
                            aoVar6 = this.bMe.bMc;
                            at.a(textView2, aoVar6.getId(), u.d.cp_cont_j, u.d.cp_cont_d);
                        }
                    }
                }
            }
        }
    }
}
