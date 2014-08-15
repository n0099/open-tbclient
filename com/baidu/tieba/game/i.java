package com.baidu.tieba.game;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.LinkedList;
import java.util.List;
import tbclient.GameInfo;
import tbclient.GetGameCenter.AdList;
import tbclient.GetGameCenter.GameList;
/* loaded from: classes.dex */
class i extends CustomMessageListener {
    final /* synthetic */ GameCenterHomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(GameCenterHomeActivity gameCenterHomeActivity, int i) {
        super(i);
        this.a = gameCenterHomeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        n nVar;
        nVar = this.a.a;
        nVar.b().setVisibility(0);
        this.a.closeLoadingDialog();
        this.a.a(true);
        if (!(customResponsedMessage instanceof ResponseGameCenterLocalMessage)) {
            this.a.showToast(this.a.getResources().getString(com.baidu.tieba.x.neterror));
            return;
        }
        ResponseGameCenterLocalMessage responseGameCenterLocalMessage = (ResponseGameCenterLocalMessage) customResponsedMessage;
        if (responseGameCenterLocalMessage.getOrginalMessage() instanceof RequestGameCenterLocalMessage) {
            GameList gameList = responseGameCenterLocalMessage.getGameList();
            List<AdList> adList = responseGameCenterLocalMessage.getAdList();
            List<GameInfo> list = gameList.game_info;
            LinkedList linkedList = new LinkedList();
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    GameInfo gameInfo = list.get(i);
                    if (gameInfo.game_type.intValue() == 1 || gameInfo.game_type.intValue() == 2) {
                        linkedList.add(ab.a(gameInfo));
                    }
                }
            }
            new j(this, linkedList, adList).execute("");
        }
    }
}
