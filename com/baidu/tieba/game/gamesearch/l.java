package com.baidu.tieba.game.gamesearch;

import com.baidu.tbadk.game.GameInfoData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GameInfo;
import tbclient.SearchGame.DataRes;
/* loaded from: classes.dex */
public class l {
    private List<GameInfoData> aIr;
    private boolean mHasMore;

    public List<GameInfoData> getGameList() {
        return this.aIr;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.has_more != null && dataRes.has_more.intValue() == 1) {
                this.mHasMore = true;
            }
            if (dataRes.game_list != null) {
                this.aIr = new ArrayList();
                for (GameInfo gameInfo : dataRes.game_list) {
                    if (gameInfo != null) {
                        this.aIr.add(GameInfoData.fromGameInfo(gameInfo));
                    }
                }
            }
        }
    }
}
