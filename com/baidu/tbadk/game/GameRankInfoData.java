package com.baidu.tbadk.game;

import com.baidu.tbadk.core.data.UserData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetGameDetail.RankInfo;
import tbclient.GetGameDetail.RankItem;
/* loaded from: classes.dex */
public class GameRankInfoData implements Serializable {
    private static final long serialVersionUID = 7332418717314248175L;
    private List<UserData> rankList = new ArrayList();

    public List<UserData> getRankList() {
        return this.rankList;
    }

    public static GameRankInfoData parseRankInfoData(RankInfo rankInfo) {
        List<RankItem> list;
        GameRankInfoData gameRankInfoData = new GameRankInfoData();
        if (rankInfo != null && (list = rankInfo.rank_list) != null) {
            int i = 0;
            for (RankItem rankItem : list) {
                i++;
                if (i > 20) {
                    break;
                }
                UserData userData = new UserData();
                userData.setUserId(String.valueOf(rankItem.user_id));
                userData.setUserName(rankItem.user_name);
                userData.setPortrait(rankItem.portrait);
                userData.setGrade(String.valueOf(rankItem.grade));
                gameRankInfoData.getRankList().add(userData);
            }
        }
        return gameRankInfoData;
    }
}
