package com.baidu.tieba.game;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.game.GameInfoData;
import java.util.LinkedList;
import java.util.List;
import tbclient.GameInfo;
import tbclient.GetGameCenter.AdList;
import tbclient.GetGameCenter.GameList;
import tbclient.GetGameCenter.RecommendGame;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ao aIz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(ao aoVar, int i) {
        super(i);
        this.aIz = aoVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        av avVar;
        au auVar;
        au auVar2;
        au auVar3;
        List<GameInfo> list;
        GameCenterActivity gameCenterActivity;
        GameCenterActivity gameCenterActivity2;
        ao aoVar = this.aIz;
        avVar = this.aIz.aIt;
        aoVar.hideLoadingView(avVar.HJ());
        if (!(socketResponsedMessage instanceof ResponseGameCenterMessage)) {
            ao aoVar2 = this.aIz;
            gameCenterActivity2 = this.aIz.aIs;
            aoVar2.showToast(gameCenterActivity2.getResources().getString(com.baidu.tieba.y.neterror));
            return;
        }
        ResponseGameCenterMessage responseGameCenterMessage = (ResponseGameCenterMessage) socketResponsedMessage;
        if (responseGameCenterMessage.getOrginalMessage() instanceof RequestGameCenterMessage) {
            if (!responseGameCenterMessage.hasError()) {
                this.aIz.aIw = true;
                GameList gameList = responseGameCenterMessage.getGameList();
                List<AdList> adLists = responseGameCenterMessage.getAdLists();
                List<RecommendGame> recommendGames = responseGameCenterMessage.getRecommendGames();
                auVar = this.aIz.aIu;
                auVar.setHasMore(responseGameCenterMessage.getGameList().has_more.intValue() == 1);
                auVar2 = this.aIz.aIu;
                auVar3 = this.aIz.aIu;
                auVar2.setPageNum(auVar3.getPageNum() + 1);
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                LinkedList linkedList3 = new LinkedList();
                if (gameList != null && (list = gameList.game_info) != null) {
                    for (int i = 0; i < list.size(); i++) {
                        GameInfo gameInfo = list.get(i);
                        if ((gameInfo.game_type.intValue() == 1 || gameInfo.game_type.intValue() == 2) && !TextUtils.isEmpty(gameInfo.game_id)) {
                            GameInfoData fromGameInfo = GameInfoData.fromGameInfo(gameInfo);
                            linkedList2.add(fromGameInfo);
                            linkedList.add(fromGameInfo);
                        }
                    }
                }
                if (recommendGames != null && recommendGames != null) {
                    for (int i2 = 0; i2 < recommendGames.size(); i2++) {
                        RecommendGame recommendGame = recommendGames.get(i2);
                        if (recommendGame.game_type.intValue() == 1 && recommendGame.mark.intValue() != 1 && !TextUtils.isEmpty(recommendGame.package_link) && !TextUtils.isEmpty(recommendGame.game_id) && !TextUtils.isEmpty(recommendGame.game_name)) {
                            GameInfoData fromRecommendGames = GameInfoData.fromRecommendGames(recommendGame);
                            linkedList3.add(fromRecommendGames);
                            linkedList.add(fromRecommendGames);
                        }
                    }
                }
                new ar(this, linkedList, adLists, linkedList2, linkedList3).execute("");
            } else if (!TextUtils.isEmpty(responseGameCenterMessage.getErrorString())) {
                this.aIz.showToast(responseGameCenterMessage.getErrorString());
            } else {
                ao aoVar3 = this.aIz;
                gameCenterActivity = this.aIz.aIs;
                aoVar3.showToast(gameCenterActivity.getResources().getString(com.baidu.tieba.y.neterror));
            }
        }
    }
}
