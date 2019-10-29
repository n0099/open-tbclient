package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {
    public String createTime;
    public String dNX;
    public String dNY;
    public int dOc;
    public long dOd;
    public String dOe;
    public String dOu;
    public String dOv;
    public int dOw;
    public String description;
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
                    this.dOu = EncryptionHelper.getDecryptUserId(optString);
                }
                this.dNX = jSONObject.optString("regiment_name");
                this.dNY = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.score = jSONObject.optString("score");
                this.status = jSONObject.optString("status");
                this.createTime = jSONObject.optString("create_time");
                this.dOv = jSONObject.optString("update_time");
                this.dOw = jSONObject.optInt("member_counts");
                this.dOe = jSONObject.optString("guard_club_portrait");
                this.dOc = jSONObject.optInt("guard_level");
                this.dOd = jSONObject.optLong("next_level_need_score");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optString("live_id");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
