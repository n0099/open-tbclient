package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public long Vc;
    public long createTime;
    public String description;
    public String eBo;
    public String eBp;
    public long eBq;
    public long eBr;
    public long eBs;
    public int eBt;
    public long eBu;
    public String eBv;
    public String eBw;
    public JSONObject eBx;
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
                        this.Vc = Long.parseLong(EncryptionHelper.getDecryptUserId(optString));
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                this.eBo = jSONObject.optString("regiment_name");
                this.eBp = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.eBq = jSONObject.optLong("score");
                this.eBr = jSONObject.optLong("week_score");
                this.status = jSONObject.optInt("status");
                this.createTime = jSONObject.optLong("create_time");
                this.updateTime = jSONObject.optLong("update_time");
                this.eBs = jSONObject.optLong("member_counts");
                this.eBt = jSONObject.optInt("guard_level");
                this.eBu = jSONObject.optLong("next_level_need_score");
                this.eBv = jSONObject.optString("guard_club_portrait");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optLong("live_id");
                this.rank = jSONObject.optString("rank");
                this.eBw = jSONObject.optString("week_rank");
                this.eBx = jSONObject.optJSONObject(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
