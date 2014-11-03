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
                    aj.wm().wS();
                    return;
                case 2005010:
                    aj.wm().wT();
                    return;
                case 2005011:
                    aj.wm().wV();
                    return;
                case 2005012:
                    aj.wm().wW();
                    return;
                case 2005013:
                    aj.wm().wR();
                    return;
                case 2005014:
                default:
                    return;
                case 2005015:
                    aj.wm().wU();
                    return;
            }
        }
    }
}
