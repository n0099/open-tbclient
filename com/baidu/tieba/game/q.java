package com.baidu.tieba.game;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.game.GameRankInfoData;
import com.baidu.tbadk.game.RequestGameDetailMessage;
import com.baidu.tbadk.game.ResponseGameDetailMessage;
/* loaded from: classes.dex */
class q extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ GameDetailActivity aHd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(GameDetailActivity gameDetailActivity, int i) {
        super(i);
        this.aHd = gameDetailActivity;
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
        fVar = this.aHd.aHb;
        if (fVar != null) {
            fVar2 = this.aHd.aHb;
            yVar4 = this.aHd.aGY;
            fVar2.q(yVar4.Hm());
        }
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseGameDetailMessage)) {
            this.aHd.showToast(this.aHd.getString(com.baidu.tieba.y.neterror));
        } else if (socketResponsedMessage.hasError() || socketResponsedMessage.getError() != 0) {
            this.aHd.showToast(socketResponsedMessage.getErrorString());
        } else {
            ResponseGameDetailMessage responseGameDetailMessage = (ResponseGameDetailMessage) socketResponsedMessage;
            if (!(responseGameDetailMessage.getOrginalMessage() instanceof RequestGameDetailMessage)) {
                this.aHd.showToast(this.aHd.getString(com.baidu.tieba.y.neterror));
                return;
            }
            this.aHd.aGZ = GameInfoData.fromGameInfo(responseGameDetailMessage.getGameInfo());
            this.aHd.aHa = GameRankInfoData.parseRankInfoData(responseGameDetailMessage.getRankInfo());
            gameInfoData = this.aHd.aGZ;
            str = this.aHd.aAw;
            gameInfoData.setRefId(str);
            yVar = this.aHd.aGY;
            gameInfoData2 = this.aHd.aGZ;
            yVar.setData(gameInfoData2);
            yVar2 = this.aHd.aGY;
            yVar2.Hr().setVisibility(0);
            this.aHd.Hl();
            yVar3 = this.aHd.aGY;
            yVar3.Hq();
        }
    }
}
