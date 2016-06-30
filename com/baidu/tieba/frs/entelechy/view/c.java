package com.baidu.tieba.frs.entelechy.view;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.az;
import com.baidu.tieba.card.at;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a bKn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.bKn = aVar;
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
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
            azVar = this.bKn.aas;
            if (azVar != null) {
                azVar2 = this.bKn.aas;
                if (azVar2 != null) {
                    azVar3 = this.bKn.aas;
                    if (azVar3.getTid() != null) {
                        textView = this.bKn.mTextTitle;
                        if (textView != null) {
                            azVar4 = this.bKn.aas;
                            if (((String) customResponsedMessage.getData()).equals(azVar4.getTid())) {
                                textView2 = this.bKn.mTextTitle;
                                azVar5 = this.bKn.aas;
                                at.a(textView2, azVar5.getId(), u.d.cp_cont_c, u.d.cp_cont_d);
                            }
                        }
                    }
                }
            }
        }
    }
}
