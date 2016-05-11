package com.baidu.tieba.card;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends CustomMessageListener {
    final /* synthetic */ z aQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(z zVar, int i) {
        super(i);
        this.aQe = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        boolean z2;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            if (com.baidu.adp.lib.util.i.fr()) {
                z2 = this.aQe.aPU;
                if (!z2) {
                    z = false;
                    this.aQe.cg(z);
                }
            }
            z = true;
            this.aQe.cg(z);
        }
    }
}
