package com.baidu.tieba.game;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.game.GameRankInfoData;
import com.baidu.tbadk.game.RequestGameDetailMessage;
import com.baidu.tbadk.game.ResponseGameDetailMessage;
/* loaded from: classes.dex */
class q extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ GameDetailActivity aHn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(GameDetailActivity gameDetailActivity, int i) {
        super(i);
        this.aHn = gameDetailActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tbadk.c.f fVar;
        GameInfoData gameInfoData;
        String str;
        y yVar;
        GameInfoData gameInfoData2;
        y yVar2;
        y yVar3;
        com.baidu.tbadk.c.f fVar2;
        y yVar4;
        fVar = this.aHn.aHl;
        if (fVar != null) {
            fVar2 = this.aHn.aHl;
            yVar4 = this.aHn.aHi;
            fVar2.q(yVar4.Ho());
        }
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseGameDetailMessage)) {
            this.aHn.showToast(this.aHn.getString(com.baidu.tieba.y.neterror));
        } else if (socketResponsedMessage.hasError() || socketResponsedMessage.getError() != 0) {
            this.aHn.showToast(socketResponsedMessage.getErrorString());
        } else {
            ResponseGameDetailMessage responseGameDetailMessage = (ResponseGameDetailMessage) socketResponsedMessage;
            if (!(responseGameDetailMessage.getOrginalMessage() instanceof RequestGameDetailMessage)) {
                this.aHn.showToast(this.aHn.getString(com.baidu.tieba.y.neterror));
                return;
            }
            this.aHn.aHj = GameInfoData.fromGameInfo(responseGameDetailMessage.getGameInfo());
            this.aHn.aHk = GameRankInfoData.parseRankInfoData(responseGameDetailMessage.getRankInfo());
            gameInfoData = this.aHn.aHj;
            str = this.aHn.aAG;
            gameInfoData.setRefId(str);
            yVar = this.aHn.aHi;
            gameInfoData2 = this.aHn.aHj;
            yVar.a(gameInfoData2);
            yVar2 = this.aHn.aHi;
            yVar2.Ht().setVisibility(0);
            this.aHn.Hn();
            yVar3 = this.aHn.aHi;
            yVar3.Hs();
        }
    }
}
