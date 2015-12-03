package com.baidu.tbadk.game;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ b atO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.atO = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseGameDetailMessage) && !socketResponsedMessage.hasError()) {
            ResponseGameDetailMessage responseGameDetailMessage = (ResponseGameDetailMessage) socketResponsedMessage;
            if (responseGameDetailMessage.getOrginalMessage() instanceof RequestGameDetailMessage) {
                this.atO.atM = GameInfoData.fromGameInfo(responseGameDetailMessage.getGameInfo());
            }
        }
    }
}
