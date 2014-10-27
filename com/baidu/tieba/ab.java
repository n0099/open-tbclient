package com.baidu.tieba;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ab extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            switch (customResponsedMessage.getCmd()) {
                case 2005009:
                    aj.wk().wQ();
                    return;
                case 2005010:
                    aj.wk().wR();
                    return;
                case 2005011:
                    aj.wk().wT();
                    return;
                case 2005012:
                    aj.wk().wU();
                    return;
                case 2005013:
                    aj.wk().wP();
                    return;
                case 2005014:
                default:
                    return;
                case 2005015:
                    aj.wk().wS();
                    return;
            }
        }
    }
}
