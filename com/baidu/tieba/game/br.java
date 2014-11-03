package com.baidu.tieba.game;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br extends CustomMessageListener {
    final /* synthetic */ bp aJy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(bp bpVar, int i, boolean z) {
        super(i, z);
        this.aJy = bpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bsVar = this.aJy.aJr;
        if (bsVar != null) {
            if (!(customResponsedMessage instanceof ResponseRecommendGameLocalMessage)) {
                bsVar2 = this.aJy.aJr;
                bsVar2.c(null);
                return;
            }
            an gameData = ((ResponseRecommendGameLocalMessage) customResponsedMessage).getGameData();
            bsVar3 = this.aJy.aJr;
            bsVar3.c(gameData);
        }
    }
}
