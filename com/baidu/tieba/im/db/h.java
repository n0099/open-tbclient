package com.baidu.tieba.im.db;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ ImDbShrinkStatic bct;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(ImDbShrinkStatic imDbShrinkStatic, int i) {
        super(i);
        this.bct = imDbShrinkStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        i iVar;
        i iVar2;
        i iVar3;
        if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
            if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                iVar2 = this.bct.bcp;
                iVar3 = this.bct.bcp;
                iVar2.sendMessageDelayed(iVar3.obtainMessage(1), 30000L);
                return;
            }
            iVar = this.bct.bcp;
            iVar.removeMessages(1);
            this.bct.stop();
        }
    }
}
