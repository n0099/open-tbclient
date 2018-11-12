package com.baidu.tieba.frs.smartsort;

import com.baidu.sapi2.share.face.FaceLoginModel;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    public String forumName;
    public long lastTime;

    public d() {
    }

    public d(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new NullPointerException("JSONObject is Null");
        }
        this.forumName = jSONObject.optString("forum_name");
        this.lastTime = jSONObject.optLong(FaceLoginModel.KEY_LAST_LOGIN_TIME);
    }

    public JSONObject aEX() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("forum_name", this.forumName);
            jSONObject.put(FaceLoginModel.KEY_LAST_LOGIN_TIME, this.lastTime);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
