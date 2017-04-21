package com.baidu.tieba.frs.g;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends CustomMessageListener {
    final /* synthetic */ ah cei;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(ah ahVar, int i) {
        super(i);
        this.cei = ahVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        az azVar;
        az azVar2;
        if (customResponsedMessage != null) {
            azVar = this.cei.bOU;
            if (azVar != null) {
                azVar2 = this.cei.bOU;
                azVar2.startPullRefresh();
            }
        }
    }
}
