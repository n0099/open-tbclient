package com.baidu.tieba.game;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.game.GameInfoData;
import java.util.LinkedList;
import java.util.List;
import tbclient.GameInfo;
import tbclient.GetGameCenter.AdList;
import tbclient.GetGameCenter.GameList;
import tbclient.GetGameCenter.RecommendGame;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends CustomMessageListener {
    final /* synthetic */ ao aIm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as(ao aoVar, int i) {
        super(i);
        this.aIm = aoVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        av avVar;
        av avVar2;
        boolean z;
        au auVar;
        au auVar2;
        au auVar3;
        List<GameInfo> list;
        GameCenterActivity gameCenterActivity;
        ao aoVar = this.aIm;
        avVar = this.aIm.aIh;
        aoVar.hideLoadingView(avVar.HF());
        avVar2 = this.aIm.aIh;
        avVar2.Hx().setVisibility(0);
        this.aIm.bK(true);
        if (!(customResponsedMessage instanceof ResponseGameCenterLocalMessage)) {
            ao aoVar2 = this.aIm;
            gameCenterActivity = this.aIm.aIg;
            aoVar2.showToast(gameCenterActivity.getResources().getString(com.baidu.tieba.y.neterror));
            return;
        }
        ResponseGameCenterLocalMessage responseGameCenterLocalMessage = (ResponseGameCenterLocalMessage) customResponsedMessage;
        if (responseGameCenterLocalMessage.getOrginalMessage() instanceof RequestGameCenterLocalMessage) {
            this.aIm.aIl = true;
            GameList gameList = responseGameCenterLocalMessage.getGameList();
            List<AdList> adList = responseGameCenterLocalMessage.getAdList();
            List<RecommendGame> recommendGames = responseGameCenterLocalMessage.getRecommendGames();
            if (gameList == null) {
                z = false;
            } else {
                z = gameList.has_more.intValue() == 1;
            }
            auVar = this.aIm.aIi;
            auVar.setHasMore(z);
            auVar2 = this.aIm.aIi;
            auVar3 = this.aIm.aIi;
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
            new at(this, linkedList, adList, linkedList2, linkedList3).execute("");
        }
    }
}
