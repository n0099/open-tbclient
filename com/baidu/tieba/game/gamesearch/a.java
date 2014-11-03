package com.baidu.tieba.game.gamesearch;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.view.o;
import com.baidu.tbadk.game.GameInfoData;
import java.util.List;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ GameSearchActivity aJU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(GameSearchActivity gameSearchActivity, int i, int i2) {
        super(i, i2);
        this.aJU = gameSearchActivity;
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
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == this.aJU.getUniqueId()) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    this.aJU.showToast(responsedMessage.getErrorString());
                    return;
                }
                if (responsedMessage instanceof GameSearchHttpResponse) {
                    GameSearchHttpResponse gameSearchHttpResponse = (GameSearchHttpResponse) responsedMessage;
                    if (gameSearchHttpResponse.getOrginalMessage() != null && (gameSearchHttpResponse.getOrginalMessage().getExtra() instanceof GameSearchNetMessage)) {
                        String query = ((GameSearchNetMessage) gameSearchHttpResponse.getOrginalMessage().getExtra()).getQuery();
                        if (query != null) {
                            str2 = this.aJU.aJO;
                            if (!query.equals(str2)) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    this.aJU.aJQ = false;
                    GameSearchActivity gameSearchActivity = this.aJU;
                    i2 = gameSearchActivity.aJP;
                    gameSearchActivity.aJP = i2 + 1;
                    l gameSearchData = gameSearchHttpResponse.getGameSearchData();
                    if (gameSearchData == null) {
                        oVar2 = this.aJU.aJN;
                        oVar2.setVisibility(0);
                        return;
                    }
                    if (gameSearchData.isHasMore()) {
                        this.aJU.mHasMore = true;
                    } else {
                        this.aJU.mHasMore = false;
                    }
                    List<GameInfoData> gameList = gameSearchData.getGameList();
                    this.aJU.J(gameList);
                    com.baidu.tieba.game.a.a.In().M(gameList);
                    this.aJU.I(gameList);
                }
                if (responsedMessage instanceof GameSearchSocketResponse) {
                    GameSearchSocketResponse gameSearchSocketResponse = (GameSearchSocketResponse) responsedMessage;
                    if (gameSearchSocketResponse.getOrginalMessage() != null && (gameSearchSocketResponse.getOrginalMessage().getExtra() instanceof GameSearchNetMessage)) {
                        String query2 = ((GameSearchNetMessage) gameSearchSocketResponse.getOrginalMessage().getExtra()).getQuery();
                        if (query2 != null) {
                            str = this.aJU.aJO;
                            if (!query2.equals(str)) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    this.aJU.aJQ = false;
                    GameSearchActivity gameSearchActivity2 = this.aJU;
                    i = gameSearchActivity2.aJP;
                    gameSearchActivity2.aJP = i + 1;
                    l gameSearchData2 = gameSearchSocketResponse.getGameSearchData();
                    if (gameSearchData2 == null) {
                        oVar = this.aJU.aJN;
                        oVar.setVisibility(0);
                        return;
                    }
                    if (gameSearchData2.isHasMore()) {
                        this.aJU.mHasMore = true;
                    } else {
                        this.aJU.mHasMore = false;
                    }
                    List<GameInfoData> gameList2 = gameSearchData2.getGameList();
                    this.aJU.J(gameList2);
                    com.baidu.tieba.game.a.a.In().M(gameList2);
                    this.aJU.I(gameList2);
                }
            }
        }
    }
}
