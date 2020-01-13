package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {
    public String abx;
    public String createTime;
    public String description;
    public String eCA;
    public int eCE;
    public long eCF;
    public String eCG;
    public String eCW;
    public int eCX;
    public String eCz;
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
                    this.abx = EncryptionHelper.getDecryptUserId(optString);
                }
                this.eCz = jSONObject.optString("regiment_name");
                this.eCA = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.score = jSONObject.optString("score");
                this.status = jSONObject.optString("status");
                this.createTime = jSONObject.optString("create_time");
                this.eCW = jSONObject.optString("update_time");
                this.eCX = jSONObject.optInt("member_counts");
                this.eCG = jSONObject.optString("guard_club_portrait");
                this.eCE = jSONObject.optInt("guard_level");
                this.eCF = jSONObject.optLong("next_level_need_score");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optString("live_id");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
