package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public String adM;
    public String apW;
    public String apX;
    public int aqb;
    public long aqc;
    public String aqd;
    public String createTime;
    public String description;
    public String eHu;
    public int eHv;
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
                    this.adM = EncryptionHelper.getDecryptUserId(optString);
                }
                this.apW = jSONObject.optString("regiment_name");
                this.apX = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.score = jSONObject.optString("score");
                this.status = jSONObject.optString("status");
                this.createTime = jSONObject.optString("create_time");
                this.eHu = jSONObject.optString("update_time");
                this.eHv = jSONObject.optInt("member_counts");
                this.aqd = jSONObject.optString("guard_club_portrait");
                this.aqb = jSONObject.optInt("guard_level");
                this.aqc = jSONObject.optLong("next_level_need_score");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optString("live_id");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
