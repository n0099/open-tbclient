package com.baidu.tbadk.widget.richText;

import com.baidu.location.LocationClientOption;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class t {
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

    public final String a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final Object d() {
        return this.d;
    }

    public final void a(Object obj) {
        this.d = obj;
    }
}
