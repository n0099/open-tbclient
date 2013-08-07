package com.baidu.tieba.data;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ay {

    /* renamed from: a  reason: collision with root package name */
    private long f987a;
    private String b;
    private String c;

    public ay() {
        this.f987a = -1L;
        this.b = null;
        this.c = null;
    }

    public ay(long j, String str, String str2) {
        this.f987a = -1L;
        this.b = null;
        this.c = null;
        this.f987a = j;
        this.b = str;
        this.c = str2;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b("MssageData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        if (optJSONArray.optJSONObject(i) != null) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (this.f987a < optJSONObject.optLong("message_id")) {
                                this.f987a = optJSONObject.optLong("message_id");
                                this.b = optJSONObject.optString("link");
                                this.c = optJSONObject.optString("content");
                            }
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("pk");
                if (optJSONObject2 != null && !TextUtils.isEmpty(TiebaApplication.G())) {
                    this.f987a = -1L;
                    this.b = optJSONObject2.optString("link");
                    this.c = optJSONObject2.optString("content");
                    String optString = optJSONObject2.optString("pk_before_id");
                    String optString2 = optJSONObject2.optString("pk_after_id");
                    if (!TextUtils.isEmpty(optString)) {
                        TiebaApplication.f().l(optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        TiebaApplication.f().m(optString2);
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b("MssageData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public long a() {
        return this.f987a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }
}
