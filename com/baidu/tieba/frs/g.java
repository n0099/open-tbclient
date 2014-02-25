package com.baidu.tieba.frs;

import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.data.az {
    private int c;
    private int d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;

    public int u() {
        return this.d;
    }

    public String v() {
        return this.e;
    }

    public String w() {
        return this.g;
    }

    public String x() {
        return this.h;
    }

    public String y() {
        return this.i;
    }

    public String z() {
        return this.j;
    }

    public void d(int i) {
        this.k = i;
    }

    public int A() {
        return this.k;
    }

    @Override // com.baidu.tieba.data.az
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.c = jSONObject.optInt("type", 0);
                this.d = jSONObject.optInt("pos", 1);
                this.e = jSONObject.optString("icon_url", "");
                this.f = jSONObject.optString("icon_link", "");
                this.g = jSONObject.optString("app_name", "");
                this.h = jSONObject.optString("app_desc", "");
                this.i = jSONObject.optString("p_name", "");
                this.j = jSONObject.optString("p_url", "");
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.data.az, com.baidu.tieba.util.au, com.baidu.tieba.util.aw
    public LinkedList<String> getImageUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.e);
        return linkedList;
    }
}
