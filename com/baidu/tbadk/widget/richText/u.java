package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class u {
    private String a;
    private int b;
    private int c;
    private Object d;

    public u() {
    }

    public u(PbContent pbContent) {
        if (pbContent != null) {
            this.a = pbContent.voice_md5;
            this.b = pbContent.during_time.intValue() / 1000;
            this.c = pbContent.is_sub.intValue();
        }
    }

    public u(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optString("voice_md5");
            this.b = jSONObject.optInt("during_time") / 1000;
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
