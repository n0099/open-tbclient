package com.baidu.tieba.game;

import com.baidu.tbadk.game.GameInfoData;
import java.util.ArrayList;
import java.util.List;
import tbclient.GameInfo;
import tbclient.GetMutilGameList.AdvInfo;
import tbclient.GetMutilGameList.DataRes;
/* loaded from: classes.dex */
public class an {
    private List<GameInfoData> aIf;
    private List<a> mAdList;
    private boolean mHasMore;

    public List<GameInfoData> getGameList() {
        return this.aIf;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public List<a> getAdLists() {
        return this.mAdList;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            if (dataRes.has_more != null && dataRes.has_more.intValue() == 1) {
                this.mHasMore = true;
            }
            if (dataRes.game_list != null) {
                this.aIf = new ArrayList();
                for (GameInfo gameInfo : dataRes.game_list) {
                    if (gameInfo != null) {
                        this.aIf.add(GameInfoData.fromGameInfo(gameInfo));
                    }
                }
            }
            if (dataRes.adv_list != null) {
                this.mAdList = new ArrayList();
                for (AdvInfo advInfo : dataRes.adv_list) {
                    if (advInfo != null) {
                        this.mAdList.add(new a().a(advInfo));
                    }
                }
            }
        }
    }
}
