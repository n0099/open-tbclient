package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class PkResultData extends BaseData implements Serializable {
    public int currentStar;
    public long finalWinScore;
    public long honorAddScore;
    public long honorNum;
    public int maxStar;
    public String rankImageUrl;
    public int rankMaxScore;
    public int rankMinScore;
    public String rankName;
    public int rankScore;
    public String rankType;
    public long resultScore;
    public int resultType;
    public long roundAddScore;
    public long roundNum;
    public int totalScore;
    public long winStreakAddScore;
    public int winStreakNum;
    public long winStreakNum2;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        this.resultType = jSONObject.optInt("result_type");
        this.winStreakNum = jSONObject.optInt("win_streak_num");
        this.totalScore = jSONObject.optInt("total_score");
        JSONObject optJSONObject = jSONObject.optJSONObject("total_score_detail");
        if (optJSONObject != null) {
            this.resultScore = optJSONObject.optLong("result_score");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("honor_score");
            if (optJSONObject2 != null) {
                this.honorNum = optJSONObject2.optLong("honor_num");
                this.honorAddScore = optJSONObject2.optLong("honor_add_score");
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("win_streak_score");
            if (optJSONObject3 != null) {
                this.winStreakNum2 = optJSONObject3.optLong("win_streak_num");
                this.winStreakAddScore = optJSONObject3.optLong("win_streak_add_score");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("final_win_score");
            if (optJSONObject3 != null) {
                this.finalWinScore = optJSONObject4.optLong("final_win_add_score");
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("round_score");
            if (optJSONObject5 != null) {
                this.roundNum = optJSONObject5.optLong("round_num");
                this.roundAddScore = optJSONObject5.optLong("round_add_score");
            }
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("user_rank_info");
        if (optJSONObject6 != null) {
            this.rankImageUrl = optJSONObject6.optString("icon_url");
            this.rankType = optJSONObject6.optString("division");
            this.rankName = optJSONObject6.optString("name");
            this.currentStar = optJSONObject6.optInt("cur_star");
            this.maxStar = optJSONObject6.optInt("max_star");
            this.rankScore = optJSONObject6.optInt("current_score");
            this.rankMinScore = optJSONObject6.optInt("min_score");
            this.rankMaxScore = optJSONObject6.optInt("max_score");
        }
    }
}
