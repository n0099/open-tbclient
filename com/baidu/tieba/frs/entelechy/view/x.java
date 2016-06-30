package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.az;
import com.baidu.tieba.card.at;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends CustomMessageListener {
    final /* synthetic */ u bKt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(u uVar, int i) {
        super(i);
        this.bKt = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        az azVar;
        az azVar2;
        az azVar3;
        TextView textView;
        az azVar4;
        TextView textView2;
        az azVar5;
        az azVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            azVar = this.bKt.aas;
            if (azVar != null) {
                azVar2 = this.bKt.aas;
                if (azVar2 != null) {
                    azVar3 = this.bKt.aas;
                    if (azVar3.getTid() != null) {
                        textView = this.bKt.aSd;
                        if (textView != null && this.bKt.aSj != null) {
                            azVar4 = this.bKt.aas;
                            if (((String) customResponsedMessage.getData()).equals(azVar4.getTid())) {
                                textView2 = this.bKt.aSd;
                                azVar5 = this.bKt.aas;
                                at.a(textView2, azVar5.getId(), u.d.cp_cont_b, u.d.cp_cont_c);
                                TextView textView3 = this.bKt.aSj;
                                azVar6 = this.bKt.aas;
                                at.a(textView3, azVar6.getId(), u.d.cp_cont_j, u.d.cp_cont_c);
                            }
                        }
                    }
                }
            }
        }
    }
}
