package com.baidu.tieba.im.db;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ ImDbShrinkStatic daG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(ImDbShrinkStatic imDbShrinkStatic, int i) {
        super(i);
        this.daG = imDbShrinkStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
            if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                this.daG.daC.sendMessageDelayed(this.daG.daC.obtainMessage(1), 30000L);
                return;
            }
            this.daG.daC.removeMessages(1);
            this.daG.stop();
        }
    }
}
