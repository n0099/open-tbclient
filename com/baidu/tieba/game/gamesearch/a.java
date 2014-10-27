package com.baidu.tieba.game.gamesearch;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.game.GameInfoData;
import java.util.List;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ GameSearchActivity aJH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(GameSearchActivity gameSearchActivity, int i, int i2) {
        super(i, i2);
        this.aJH = gameSearchActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        o oVar;
        String str;
        int i2;
        o oVar2;
        String str2;
        if ((responsedMessage instanceof GameSearchHttpResponse) || (responsedMessage instanceof GameSearchSocketResponse)) {
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == this.aJH.getUniqueId()) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    this.aJH.showToast(responsedMessage.getErrorString());
                    return;
                }
                if (responsedMessage instanceof GameSearchHttpResponse) {
                    GameSearchHttpResponse gameSearchHttpResponse = (GameSearchHttpResponse) responsedMessage;
                    if (gameSearchHttpResponse.getOrginalMessage() != null && (gameSearchHttpResponse.getOrginalMessage().getExtra() instanceof GameSearchNetMessage)) {
                        String query = ((GameSearchNetMessage) gameSearchHttpResponse.getOrginalMessage().getExtra()).getQuery();
                        if (query != null) {
                            str2 = this.aJH.aJB;
                            if (!query.equals(str2)) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    this.aJH.aJD = false;
                    GameSearchActivity gameSearchActivity = this.aJH;
                    i2 = gameSearchActivity.aJC;
                    gameSearchActivity.aJC = i2 + 1;
                    l gameSearchData = gameSearchHttpResponse.getGameSearchData();
                    if (gameSearchData == null) {
                        oVar2 = this.aJH.aJA;
                        oVar2.setVisibility(0);
                        return;
                    }
                    if (gameSearchData.isHasMore()) {
                        this.aJH.mHasMore = true;
                    } else {
                        this.aJH.mHasMore = false;
                    }
                    List<GameInfoData> gameList = gameSearchData.getGameList();
                    this.aJH.J(gameList);
                    com.baidu.tieba.game.a.a.Ij().M(gameList);
                    this.aJH.I(gameList);
                }
                if (responsedMessage instanceof GameSearchSocketResponse) {
                    GameSearchSocketResponse gameSearchSocketResponse = (GameSearchSocketResponse) responsedMessage;
                    if (gameSearchSocketResponse.getOrginalMessage() != null && (gameSearchSocketResponse.getOrginalMessage().getExtra() instanceof GameSearchNetMessage)) {
                        String query2 = ((GameSearchNetMessage) gameSearchSocketResponse.getOrginalMessage().getExtra()).getQuery();
                        if (query2 != null) {
                            str = this.aJH.aJB;
                            if (!query2.equals(str)) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    this.aJH.aJD = false;
                    GameSearchActivity gameSearchActivity2 = this.aJH;
                    i = gameSearchActivity2.aJC;
                    gameSearchActivity2.aJC = i + 1;
                    l gameSearchData2 = gameSearchSocketResponse.getGameSearchData();
                    if (gameSearchData2 == null) {
                        oVar = this.aJH.aJA;
                        oVar.setVisibility(0);
                        return;
                    }
                    if (gameSearchData2.isHasMore()) {
                        this.aJH.mHasMore = true;
                    } else {
                        this.aJH.mHasMore = false;
                    }
                    List<GameInfoData> gameList2 = gameSearchData2.getGameList();
                    this.aJH.J(gameList2);
                    com.baidu.tieba.game.a.a.Ij().M(gameList2);
                    this.aJH.I(gameList2);
                }
            }
        }
    }
}
