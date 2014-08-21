package com.baidu.tieba.game;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.game.RequestGameDetailMessage;
import com.baidu.tbadk.game.ResponseGameDetailMessage;
/* loaded from: classes.dex */
class w extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ GameDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(GameDetailActivity gameDetailActivity, int i) {
        super(i);
        this.a = gameDetailActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        aa aaVar;
        com.baidu.tbadk.game.b bVar;
        com.baidu.tbadk.game.b bVar2;
        CustomMessageListener customMessageListener;
        this.a.closeLoadingDialog();
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseGameDetailMessage)) {
            this.a.showToast(this.a.getString(com.baidu.tieba.x.neterror));
            return;
        }
        ResponseGameDetailMessage responseGameDetailMessage = (ResponseGameDetailMessage) socketResponsedMessage;
        if (!(responseGameDetailMessage.getOrginalMessage() instanceof RequestGameDetailMessage)) {
            this.a.showToast(this.a.getString(com.baidu.tieba.x.neterror));
            return;
        }
        this.a.b = com.baidu.tbadk.game.b.a(responseGameDetailMessage.getGameInfo());
        aaVar = this.a.a;
        bVar = this.a.b;
        aaVar.b(bVar);
        bVar2 = this.a.b;
        if (bVar2.c() == 1) {
            GameDetailActivity gameDetailActivity = this.a;
            customMessageListener = this.a.e;
            gameDetailActivity.registerListener(customMessageListener);
        }
    }
}
