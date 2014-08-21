package com.baidu.tieba.game;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import java.util.LinkedList;
import java.util.List;
import tbclient.GameInfo;
import tbclient.GetGameCenter.AdList;
import tbclient.GetGameCenter.GameList;
/* loaded from: classes.dex */
class h extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ GameCenterHomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(GameCenterHomeActivity gameCenterHomeActivity, int i) {
        super(i);
        this.a = gameCenterHomeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        n nVar;
        m mVar;
        m mVar2;
        m mVar3;
        List<GameInfo> list;
        this.a.closeLoadingDialog();
        nVar = this.a.a;
        nVar.a().setVisibility(8);
        if (!(socketResponsedMessage instanceof ResponseGameCenterMessage)) {
            this.a.showToast(this.a.getResources().getString(com.baidu.tieba.x.neterror));
            return;
        }
        ResponseGameCenterMessage responseGameCenterMessage = (ResponseGameCenterMessage) socketResponsedMessage;
        if (responseGameCenterMessage.getOrginalMessage() instanceof RequestGameCenterMessage) {
            if (responseGameCenterMessage.hasError()) {
                if (!TextUtils.isEmpty(responseGameCenterMessage.getErrorString())) {
                    this.a.showToast(responseGameCenterMessage.getErrorString());
                    return;
                } else {
                    this.a.showToast(this.a.getResources().getString(com.baidu.tieba.x.neterror));
                    return;
                }
            }
            GameList gameList = responseGameCenterMessage.getGameList();
            List<AdList> adLists = responseGameCenterMessage.getAdLists();
            mVar = this.a.b;
            mVar.a(responseGameCenterMessage.getGameList().has_more.intValue() == 1);
            mVar2 = this.a.b;
            mVar3 = this.a.b;
            mVar2.a(mVar3.a() + 1);
            LinkedList linkedList = new LinkedList();
            if (gameList != null && (list = gameList.game_info) != null) {
                for (int i = 0; i < list.size(); i++) {
                    GameInfo gameInfo = list.get(i);
                    if (gameInfo.game_type.intValue() == 1 || gameInfo.game_type.intValue() == 2) {
                        linkedList.add(com.baidu.tbadk.game.b.a(gameInfo));
                    }
                }
            }
            new i(this, linkedList, adLists).execute("");
        }
    }
}
