package com.baidu.tieba.aiapps.apps.share;

import android.net.Uri;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.tbadk.coreExtra.c.d {
    public void aX(JSONObject jSONObject) throws JSONException {
        this.title = jSONObject.getString("title");
        this.linkUrl = jSONObject.getString("linkUrl");
        this.content = jSONObject.optString("content");
        this.imageUri = Uri.parse(jSONObject.optString("imageUrl"));
    }
}
