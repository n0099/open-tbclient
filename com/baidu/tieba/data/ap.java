package com.baidu.tieba.data;

import com.baidu.android.pushservice.PushConstants;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {

    /* renamed from: a  reason: collision with root package name */
    private long f766a = 0;
    private String b = null;
    private String c = null;

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("MssageData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (jSONArray.getJSONObject(i) != null) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (this.f766a < jSONObject2.getLong("message_id")) {
                            this.f766a = jSONObject2.getLong("message_id");
                            this.b = jSONObject2.getString("link");
                            this.c = jSONObject2.getString(PushConstants.EXTRA_CONTENT);
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.z.b("MssageData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public long a() {
        return this.f766a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }
}
