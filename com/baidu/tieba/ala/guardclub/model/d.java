package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public String aOR;
    public String bdB;
    public String bdC;
    public int bdG;
    public long bdH;
    public String bdI;
    public String createTime;
    public String description;
    public String grP;
    public int grQ;
    public String id;
    public String liveId;
    public int liveStatus;
    public String score;
    public String status;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.id = jSONObject.optString("id");
                String optString = jSONObject.optString("anchor_id");
                if (!TextUtils.isEmpty(optString)) {
                    this.aOR = EncryptionHelper.getDecryptUserId(optString);
                }
                this.bdB = jSONObject.optString("regiment_name");
                this.bdC = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.status = jSONObject.optString("status");
                this.createTime = jSONObject.optString("create_time");
                this.grP = jSONObject.optString("update_time");
                this.grQ = jSONObject.optInt("member_counts");
                this.bdI = jSONObject.optString("guard_club_portrait");
                this.bdG = jSONObject.optInt("guard_level");
                this.bdH = jSONObject.optLong("next_level_need_score");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optString("live_id");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
