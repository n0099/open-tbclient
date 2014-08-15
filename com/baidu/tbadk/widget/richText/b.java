package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes.dex */
public class b {
    private String a;
    private String b;

    public b(JSONObject jSONObject) {
        this.a = null;
        this.b = null;
        if (jSONObject != null) {
            this.a = jSONObject.optString("text");
            this.b = jSONObject.optString("link");
        }
    }

    public b(PbContent pbContent) {
        this.a = null;
        this.b = null;
        if (pbContent != null) {
            this.a = pbContent.text;
            this.b = pbContent.link;
        }
    }

    public b(String str, String str2) {
        this.a = null;
        this.b = null;
        this.a = str;
        this.b = str2;
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public void c() {
        if (this.a != null) {
            this.a = this.a.replaceAll("\n", "");
        }
        if (this.b != null) {
            this.b = this.b.replaceAll("\n", "");
        }
    }
}
