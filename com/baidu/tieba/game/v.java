package com.baidu.tieba.game;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.message.RequestGameDetailMessage;
import com.baidu.tieba.message.ResponseGameDetailMessage;
/* loaded from: classes.dex */
class v extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ GameDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(GameDetailActivity gameDetailActivity, int i) {
        super(i);
        this.a = gameDetailActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        z zVar;
        ab abVar;
        ab abVar2;
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
        this.a.b = ab.a(responseGameDetailMessage.getGameInfo());
        zVar = this.a.a;
        abVar = this.a.b;
        zVar.b(abVar);
        abVar2 = this.a.b;
        if (abVar2.c() == 1) {
            GameDetailActivity gameDetailActivity = this.a;
            customMessageListener = this.a.d;
            gameDetailActivity.registerListener(customMessageListener);
        }
    }
}
