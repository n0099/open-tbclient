package com.baidu.tbadk.widget.richText;

import com.baidu.location.LocationClientOption;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private String a;
    private int b;
    private int c;
    private Object d;

    public t() {
    }

    public t(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optString("voice_md5");
            this.b = jSONObject.optInt("during_time") / LocationClientOption.MIN_SCAN_SPAN;
            this.c = jSONObject.optInt("is_sub");
        }
    }

    public String a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public Object d() {
        return this.d;
    }

    public void a(Object obj) {
        this.d = obj;
    }
}
