package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {
    public String avatar;
    public String awj;
    public String fml;
    public boolean fmm;
    public String id;
    public int level;
    public String liveId;
    public int liveStatus;
    public String name;
    public String score;

    public k cH(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.id = jSONObject.optString("id");
        String optString = jSONObject.optString("anchor_id");
        if (!TextUtils.isEmpty(optString)) {
            this.awj = EncryptionHelper.getDecryptUserId(optString);
        }
        this.name = jSONObject.optString("regiment_name");
        this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
        this.fml = jSONObject.optString("week_score");
        this.avatar = jSONObject.optString("guard_club_portrait");
        this.level = jSONObject.optInt("guard_level");
        this.liveStatus = jSONObject.optInt("live_status");
        this.liveId = jSONObject.optString("live_id");
        this.fmm = jSONObject.optInt("is_join") == 1;
        return this;
    }
}
