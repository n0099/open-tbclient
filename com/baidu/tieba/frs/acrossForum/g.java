package com.baidu.tieba.frs.acrossForum;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ c bCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c cVar, int i) {
        super(i);
        this.bCT = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        FrsActivity frsActivity;
        boolean z;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId)) {
            frsActivity = this.bCT.bzH;
            if (frsActivity.getUniqueId().equals((BdUniqueId) customResponsedMessage.getData())) {
                z = this.bCT.bCP;
                if (!z) {
                    this.bCT.Ym();
                }
            }
        }
    }
}
