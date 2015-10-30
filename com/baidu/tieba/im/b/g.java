package com.baidu.tieba.im.b;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
/* loaded from: classes.dex */
class g extends CustomMessageListener {
    final /* synthetic */ b bFD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(b bVar, int i) {
        super(i);
        this.bFD = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof BackgroundSwitchMessage) {
            if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                this.bFD.Ww();
            } else {
                this.bFD.Wv();
            }
        }
    }
}
