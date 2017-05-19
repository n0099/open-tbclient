package com.baidu.tieba.frs.e;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.at;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends CustomMessageListener {
    final /* synthetic */ ag cbR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(ag agVar, int i) {
        super(i);
        this.cbR = agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        at atVar;
        at atVar2;
        if (customResponsedMessage != null) {
            atVar = this.cbR.bOn;
            if (atVar != null) {
                atVar2 = this.cbR.bOn;
                atVar2.startPullRefresh();
            }
        }
    }
}
