package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    public long Of;
    public long createTime;
    public String dNg;
    public String dNh;
    public long dNi;
    public long dNj;
    public long dNk;
    public int dNl;
    public long dNm;
    public String dNn;
    public String dNo;
    public JSONObject dNp;
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
                        this.Of = Long.parseLong(EncryptionHelper.getDecryptUserId(optString));
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                this.dNg = jSONObject.optString("regiment_name");
                this.dNh = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.dNi = jSONObject.optLong("score");
                this.dNj = jSONObject.optLong("week_score");
                this.status = jSONObject.optInt("status");
                this.createTime = jSONObject.optLong("create_time");
                this.updateTime = jSONObject.optLong("update_time");
                this.dNk = jSONObject.optLong("member_counts");
                this.dNl = jSONObject.optInt("guard_level");
                this.dNm = jSONObject.optLong("next_level_need_score");
                this.dNn = jSONObject.optString("guard_club_portrait");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optLong("live_id");
                this.rank = jSONObject.optString("rank");
                this.dNo = jSONObject.optString("week_rank");
                this.dNp = jSONObject.optJSONObject("privilege");
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
