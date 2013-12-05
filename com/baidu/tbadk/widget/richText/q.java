package com.baidu.tbadk.widget.richText;

import com.baidu.location.LocationClientOption;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private String f1002a;
    private int b;
    private int c;
    private Object d;

    public q() {
    }

    public q(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f1002a = jSONObject.optString("voice_md5");
            this.b = jSONObject.optInt("during_time") / LocationClientOption.MIN_SCAN_SPAN;
            this.c = jSONObject.optInt("is_sub");
        }
    }

    public String a() {
        return this.f1002a;
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
