package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public String adC;
    public String apM;
    public String apN;
    public int apR;
    public long apS;
    public String apT;
    public String createTime;
    public String description;
    public String eGY;
    public int eGZ;
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
                    this.adC = EncryptionHelper.getDecryptUserId(optString);
                }
                this.apM = jSONObject.optString("regiment_name");
                this.apN = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.score = jSONObject.optString("score");
                this.status = jSONObject.optString("status");
                this.createTime = jSONObject.optString("create_time");
                this.eGY = jSONObject.optString("update_time");
                this.eGZ = jSONObject.optInt("member_counts");
                this.apT = jSONObject.optString("guard_club_portrait");
                this.apR = jSONObject.optInt("guard_level");
                this.apS = jSONObject.optLong("next_level_need_score");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optString("live_id");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
