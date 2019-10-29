package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class p {
    public String avatar;
    public String dOU;
    public boolean dOV;
    public String dOu;
    public String id;
    public int level;
    public String liveId;
    public int liveStatus;
    public String name;
    public String score;

    public p bK(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.id = jSONObject.optString("id");
        String optString = jSONObject.optString("anchor_id");
        if (!TextUtils.isEmpty(optString)) {
            this.dOu = EncryptionHelper.getDecryptUserId(optString);
        }
        this.name = jSONObject.optString("regiment_name");
        this.score = jSONObject.optString("score");
        this.dOU = jSONObject.optString("week_score");
        this.avatar = jSONObject.optString("guard_club_portrait");
        this.level = jSONObject.optInt("guard_level");
        this.liveStatus = jSONObject.optInt("live_status");
        this.liveId = jSONObject.optString("live_id");
        this.dOV = jSONObject.optInt("is_join") == 1;
        return this;
    }
}
