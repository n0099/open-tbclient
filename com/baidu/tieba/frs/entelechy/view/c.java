package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.card.at;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a bLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.bLV = aVar;
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            beVar = this.bLV.abb;
            if (beVar != null) {
                beVar2 = this.bLV.abb;
                if (beVar2 != null) {
                    beVar3 = this.bLV.abb;
                    if (beVar3.getTid() != null) {
                        textView = this.bLV.mTextTitle;
                        if (textView != null) {
                            beVar4 = this.bLV.abb;
                            if (((String) customResponsedMessage.getData()).equals(beVar4.getTid())) {
                                textView2 = this.bLV.mTextTitle;
                                beVar5 = this.bLV.abb;
                                at.a(textView2, beVar5.getId(), u.d.cp_cont_c, u.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
