package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public long Vt;
    public long createTime;
    public String description;
    public String eCA;
    public long eCB;
    public long eCC;
    public long eCD;
    public int eCE;
    public long eCF;
    public String eCG;
    public String eCH;
    public JSONObject eCI;
    public String eCz;
    public int id;
    public long liveId;
    public int liveStatus;
    public String rank;
    public int status;
    public long updateTime;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.id = jSONObject.optInt("id");
                try {
                    String optString = jSONObject.optString("anchor_id");
                    if (!TextUtils.isEmpty(optString)) {
                        this.Vt = Long.parseLong(EncryptionHelper.getDecryptUserId(optString));
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                this.eCz = jSONObject.optString("regiment_name");
                this.eCA = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.eCB = jSONObject.optLong("score");
                this.eCC = jSONObject.optLong("week_score");
                this.status = jSONObject.optInt("status");
                this.createTime = jSONObject.optLong("create_time");
                this.updateTime = jSONObject.optLong("update_time");
                this.eCD = jSONObject.optLong("member_counts");
                this.eCE = jSONObject.optInt("guard_level");
                this.eCF = jSONObject.optLong("next_level_need_score");
                this.eCG = jSONObject.optString("guard_club_portrait");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optLong("live_id");
                this.rank = jSONObject.optString("rank");
                this.eCH = jSONObject.optString("week_rank");
                this.eCI = jSONObject.optJSONObject(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
