package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaChallengeRewardData implements IBaseDialogData {
    public static final int CHALLENGE_FAIL = 0;
    public static final int CHALLENGE_SUCCESS = 2;
    public static final int CHALLENGE_TIE = 1;
    private static final long serialVersionUID = 7229226004044969785L;
    public int challengeLevel;
    public String challengeLevelIcon;
    public String challengeLevelName;
    public long challengeLevelNextScore;
    public long challengeLevelScore;
    public int challengeResult;
    public String charmExt;
    public int isUseAllIn;
    public String mResultDescription;
    public String streakSuccessNum;
    public String successRateNum;
    public int errno = 0;
    public String errMsg = "";
    public long charmNum = 0;
    public long watcherNum = 0;
    public long giftNum = 0;

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData
    public int getType() {
        return 0;
    }

    @Override // com.baidu.live.tieba.pb.interactionpopupwindow.IBaseDialogData
    public int getFrom() {
        return 0;
    }

    public void parseJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.challengeResult = optJSONObject.optInt("status");
            this.isUseAllIn = optJSONObject.optInt("allin");
            this.watcherNum = optJSONObject.optLong("audience_count");
            this.charmNum = optJSONObject.optLong(SdkStaticKeys.RANK_TYPE_CHARM);
            this.charmExt = optJSONObject.optString("charm_ext");
            this.giftNum = optJSONObject.optLong("gift_num");
            this.streakSuccessNum = optJSONObject.optString("win_streak");
            this.successRateNum = optJSONObject.optString("win_rate");
            this.challengeLevel = optJSONObject.optInt("level");
            this.challengeLevelName = optJSONObject.optString("level_name");
            this.challengeLevelScore = optJSONObject.optLong("current_score");
            this.challengeLevelNextScore = optJSONObject.optLong("next_level_score");
            this.challengeLevelIcon = optJSONObject.optString("level_icon");
            this.mResultDescription = optJSONObject.optString("result_description");
        }
    }

    public int getChallengeResult() {
        return this.challengeResult;
    }

    public boolean isUseAllIn() {
        return this.isUseAllIn == 1;
    }
}
