package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public String aIL;
    public String aIM;
    public int aIQ;
    public long aIR;
    public String aIS;
    public String awj;
    public String createTime;
    public String description;
    public String flQ;
    public int flR;
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
                    this.awj = EncryptionHelper.getDecryptUserId(optString);
                }
                this.aIL = jSONObject.optString("regiment_name");
                this.aIM = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.status = jSONObject.optString("status");
                this.createTime = jSONObject.optString("create_time");
                this.flQ = jSONObject.optString("update_time");
                this.flR = jSONObject.optInt("member_counts");
                this.aIS = jSONObject.optString("guard_club_portrait");
                this.aIQ = jSONObject.optInt("guard_level");
                this.aIR = jSONObject.optLong("next_level_need_score");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optString("live_id");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
