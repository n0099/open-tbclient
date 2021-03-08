package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class k {
    public String aLm;
    public String avatar;
    public String hcG;
    public boolean hcH;
    public String id;
    public int level;
    public String liveId;
    public int liveStatus;
    public String name;
    public String score;

    public k dQ(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.id = jSONObject.optString("id");
        String optString = jSONObject.optString("anchor_id");
        if (!TextUtils.isEmpty(optString)) {
            this.aLm = EncryptionHelper.getDecryptUserId(optString);
        }
        this.name = jSONObject.optString("regiment_name");
        this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
        this.hcG = jSONObject.optString("week_score");
        this.avatar = jSONObject.optString("guard_club_portrait");
        this.level = jSONObject.optInt("guard_level");
        this.liveStatus = jSONObject.optInt("live_status");
        this.liveId = jSONObject.optString("live_id");
        this.hcH = jSONObject.optInt("is_join") == 1;
        return this;
    }
}
