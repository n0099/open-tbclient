package com.baidu.tieba.frs;

import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class g extends com.baidu.tieba.data.az {
    private int c;
    private int d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;

    public final int r() {
        return this.d;
    }

    public final String s() {
        return this.e;
    }

    public final String t() {
        return this.g;
    }

    public final String u() {
        return this.h;
    }

    public final String v() {
        return this.i;
    }

    public final String w() {
        return this.j;
    }

    public final void d(int i) {
        this.k = i;
    }

    public final int x() {
        return this.k;
    }

    @Override // com.baidu.tieba.data.az
    public final void a(JSONObject jSONObject) {
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
                com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.data.az, com.baidu.tieba.util.au, com.baidu.tieba.util.aw
    public final LinkedList<String> getImageUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(this.e);
        return linkedList;
    }
}
