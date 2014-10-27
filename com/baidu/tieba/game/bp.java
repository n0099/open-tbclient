package com.baidu.tieba.game;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends CustomMessageListener {
    final /* synthetic */ bn aJl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bp(bn bnVar, int i, boolean z) {
        super(i, z);
        this.aJl = bnVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bqVar = this.aJl.aJe;
        if (bqVar != null) {
            if (!(customResponsedMessage instanceof ResponseRecommendGameLocalMessage)) {
                bqVar2 = this.aJl.aJe;
                bqVar2.c(null);
                return;
            }
            an gameData = ((ResponseRecommendGameLocalMessage) customResponsedMessage).getGameData();
            bqVar3 = this.aJl.aJe;
            bqVar3.c(gameData);
        }
    }
}
