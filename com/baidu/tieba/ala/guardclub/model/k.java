package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k {
    public String aBs;
    public String avatar;
    public String fzS;
    public boolean fzT;
    public String id;
    public int level;
    public String liveId;
    public int liveStatus;
    public String name;
    public String score;

    public k cO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.id = jSONObject.optString("id");
        String optString = jSONObject.optString("anchor_id");
        if (!TextUtils.isEmpty(optString)) {
            this.aBs = EncryptionHelper.getDecryptUserId(optString);
        }
        this.name = jSONObject.optString("regiment_name");
        this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
        this.fzS = jSONObject.optString("week_score");
        this.avatar = jSONObject.optString("guard_club_portrait");
        this.level = jSONObject.optInt("guard_level");
        this.liveStatus = jSONObject.optInt("live_status");
        this.liveId = jSONObject.optString("live_id");
        this.fzT = jSONObject.optInt("is_join") == 1;
        return this;
    }
}
