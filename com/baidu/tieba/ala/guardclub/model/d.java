package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public String adC;
    public String apL;
    public String apM;
    public int apQ;
    public long apR;
    public String apS;
    public String createTime;
    public String description;
    public String eGK;
    public int eGL;
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
                this.apL = jSONObject.optString("regiment_name");
                this.apM = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.score = jSONObject.optString("score");
                this.status = jSONObject.optString("status");
                this.createTime = jSONObject.optString("create_time");
                this.eGK = jSONObject.optString("update_time");
                this.eGL = jSONObject.optInt("member_counts");
                this.apS = jSONObject.optString("guard_club_portrait");
                this.apQ = jSONObject.optInt("guard_level");
                this.apR = jSONObject.optLong("next_level_need_score");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optString("live_id");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
