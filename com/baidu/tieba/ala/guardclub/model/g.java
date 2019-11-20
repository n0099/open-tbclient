package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {
    public String createTime;
    public String dND;
    public String dNE;
    public int dNF;
    public String dNg;
    public String dNh;
    public int dNl;
    public long dNm;
    public String dNn;
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
                    this.dND = EncryptionHelper.getDecryptUserId(optString);
                }
                this.dNg = jSONObject.optString("regiment_name");
                this.dNh = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.score = jSONObject.optString("score");
                this.status = jSONObject.optString("status");
                this.createTime = jSONObject.optString("create_time");
                this.dNE = jSONObject.optString("update_time");
                this.dNF = jSONObject.optInt("member_counts");
                this.dNn = jSONObject.optString("guard_club_portrait");
                this.dNl = jSONObject.optInt("guard_level");
                this.dNm = jSONObject.optLong("next_level_need_score");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optString("live_id");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
