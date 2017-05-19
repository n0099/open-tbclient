package com.baidu.tieba.im.db;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ h cPB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(h hVar, int i) {
        super(i);
        this.cPB = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
            if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                this.cPB.cPx.sendMessageDelayed(this.cPB.cPx.obtainMessage(1), 30000L);
                return;
            }
            this.cPB.cPx.removeMessages(1);
            this.cPB.stop();
        }
    }
}
