package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PkResultData extends BaseData implements Serializable {
    public long antiKillScore;
    public int currentStar;
    public long divisionAddScore;
    public int divisionType;
    public long finalWinScore;
    public long honorAddScore;
    public long honorNum;
    public long killScore;
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
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("division_score");
            if (optJSONObject2 != null) {
                this.divisionType = optJSONObject2.optInt("division_type");
                this.divisionAddScore = optJSONObject2.optLong("division_add_score");
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("kill_score");
            if (optJSONObject3 != null) {
                this.killScore = optJSONObject3.optLong("kill_score");
                this.antiKillScore = optJSONObject3.optLong("anti_kill_score");
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("honor_score");
            if (optJSONObject4 != null) {
                this.honorNum = optJSONObject4.optLong("honor_num");
                this.honorAddScore = optJSONObject4.optLong("honor_add_score");
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("win_streak_score");
            if (optJSONObject5 != null) {
                this.winStreakNum2 = optJSONObject5.optLong("win_streak_num");
                this.winStreakAddScore = optJSONObject5.optLong("win_streak_add_score");
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("final_win_score");
            if (optJSONObject5 != null) {
                this.finalWinScore = optJSONObject6.optLong("final_win_add_score");
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("round_score");
            if (optJSONObject7 != null) {
                this.roundNum = optJSONObject7.optLong("round_num");
                this.roundAddScore = optJSONObject7.optLong("round_add_score");
            }
        }
        JSONObject optJSONObject8 = jSONObject.optJSONObject("user_rank_info");
        if (optJSONObject8 != null) {
            this.rankImageUrl = optJSONObject8.optString("icon_url");
            this.rankType = optJSONObject8.optString("division");
            this.rankName = optJSONObject8.optString("name");
            this.currentStar = optJSONObject8.optInt("cur_star");
            this.maxStar = optJSONObject8.optInt("max_star");
            this.rankScore = optJSONObject8.optInt("current_score");
            this.rankMinScore = optJSONObject8.optInt("min_score");
            this.rankMaxScore = optJSONObject8.optInt("max_score");
        }
    }
}
