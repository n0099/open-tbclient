package com.baidu.tieba.data;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au {

    /* renamed from: a  reason: collision with root package name */
    private long f993a;
    private String b;
    private String c;

    public au() {
        this.f993a = -1L;
        this.b = null;
        this.c = null;
    }

    public au(long j, String str, String str2) {
        this.f993a = -1L;
        this.b = null;
        this.c = null;
        this.f993a = j;
        this.b = str;
        this.c = str2;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.aq.b("MssageData", "parserJson", "error = " + e.getMessage());
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
                            if (this.f993a < optJSONObject.optLong("message_id")) {
                                this.f993a = optJSONObject.optLong("message_id");
                                this.b = optJSONObject.optString("link");
                                this.c = optJSONObject.optString("content");
                            }
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("pk");
                if (optJSONObject2 != null && !TextUtils.isEmpty(TiebaApplication.G())) {
                    this.f993a = -1L;
                    this.b = optJSONObject2.optString("link");
                    this.c = optJSONObject2.optString("content");
                    String optString = optJSONObject2.optString("pk_before_id");
                    String optString2 = optJSONObject2.optString("pk_after_id");
                    if (!TextUtils.isEmpty(optString)) {
                        TiebaApplication.g().o(optString);
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        TiebaApplication.g().p(optString2);
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b("MssageData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public long a() {
        return this.f993a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }
}
