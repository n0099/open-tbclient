package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.card.at;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends CustomMessageListener {
    final /* synthetic */ v bMb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(v vVar, int i) {
        super(i);
        this.bMb = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        be beVar;
        be beVar2;
        be beVar3;
        TextView textView;
        be beVar4;
        TextView textView2;
        be beVar5;
        be beVar6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            beVar = this.bMb.abb;
            if (beVar != null) {
                beVar2 = this.bMb.abb;
                if (beVar2 != null) {
                    beVar3 = this.bMb.abb;
                    if (beVar3.getTid() != null) {
                        textView = this.bMb.aSZ;
                        if (textView != null && this.bMb.aTf != null) {
                            beVar4 = this.bMb.abb;
                            if (((String) customResponsedMessage.getData()).equals(beVar4.getTid())) {
                                textView2 = this.bMb.aSZ;
                                beVar5 = this.bMb.abb;
                                at.a(textView2, beVar5.getId(), u.d.cp_cont_b, u.d.cp_cont_c);
                                TextView textView3 = this.bMb.aTf;
                                beVar6 = this.bMb.abb;
                                at.a(textView3, beVar6.getId(), u.d.cp_cont_j, u.d.cp_cont_c);
                            }
                        }
                    }
                }
            }
        }
    }
}
