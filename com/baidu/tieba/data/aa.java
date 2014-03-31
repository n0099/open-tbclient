package com.baidu.tieba.data;

import com.baidu.tieba.person.PersonInfoActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class aa {
    private String a = null;

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString(PersonInfoActivity.TAG_NAME);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("LocationData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
