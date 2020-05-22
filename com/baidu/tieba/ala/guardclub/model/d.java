package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public String aBs;
    public long aOA;
    public String aOB;
    public String aOu;
    public String aOv;
    public int aOz;
    public String createTime;
    public String description;
    public String fzx;
    public int fzy;
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
                    this.aBs = EncryptionHelper.getDecryptUserId(optString);
                }
                this.aOu = jSONObject.optString("regiment_name");
                this.aOv = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.status = jSONObject.optString("status");
                this.createTime = jSONObject.optString("create_time");
                this.fzx = jSONObject.optString("update_time");
                this.fzy = jSONObject.optInt("member_counts");
                this.aOB = jSONObject.optString("guard_club_portrait");
                this.aOz = jSONObject.optInt("guard_level");
                this.aOA = jSONObject.optLong("next_level_need_score");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optString("live_id");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
