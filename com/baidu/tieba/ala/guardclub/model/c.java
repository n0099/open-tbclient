package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    public long OF;
    public long createTime;
    public String dNX;
    public String dNY;
    public long dNZ;
    public long dOa;
    public long dOb;
    public int dOc;
    public long dOd;
    public String dOe;
    public String dOf;
    public JSONObject dOg;
    public String description;
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
                        this.OF = Long.parseLong(EncryptionHelper.getDecryptUserId(optString));
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                this.dNX = jSONObject.optString("regiment_name");
                this.dNY = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.dNZ = jSONObject.optLong("score");
                this.dOa = jSONObject.optLong("week_score");
                this.status = jSONObject.optInt("status");
                this.createTime = jSONObject.optLong("create_time");
                this.updateTime = jSONObject.optLong("update_time");
                this.dOb = jSONObject.optLong("member_counts");
                this.dOc = jSONObject.optInt("guard_level");
                this.dOd = jSONObject.optLong("next_level_need_score");
                this.dOe = jSONObject.optString("guard_club_portrait");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optLong("live_id");
                this.rank = jSONObject.optString("rank");
                this.dOf = jSONObject.optString("week_rank");
                this.dOg = jSONObject.optJSONObject("privilege");
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
