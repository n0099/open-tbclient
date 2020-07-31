package com.baidu.tieba.ala.guardclub.model;

import android.text.TextUtils;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public String aEX;
    public String aSA;
    public String aSt;
    public String aSu;
    public int aSy;
    public long aSz;
    public String createTime;
    public String description;
    public String fQl;
    public int fQm;
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
                    this.aEX = EncryptionHelper.getDecryptUserId(optString);
                }
                this.aSt = jSONObject.optString("regiment_name");
                this.aSu = jSONObject.optString("regiment_icon");
                this.description = jSONObject.optString("description");
                this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.status = jSONObject.optString("status");
                this.createTime = jSONObject.optString("create_time");
                this.fQl = jSONObject.optString("update_time");
                this.fQm = jSONObject.optInt("member_counts");
                this.aSA = jSONObject.optString("guard_club_portrait");
                this.aSy = jSONObject.optInt("guard_level");
                this.aSz = jSONObject.optLong("next_level_need_score");
                this.liveStatus = jSONObject.optInt("live_status");
                this.liveId = jSONObject.optString("live_id");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
