package com.baidu.tieba.data;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private boolean b;
    private long c = 0;

    /* renamed from: a  reason: collision with root package name */
    private af f1024a = new af();

    public q() {
        this.b = true;
        this.b = false;
    }

    public void a(String str) {
        if (str == null || str.length() < 1) {
            this.b = false;
            return;
        }
        try {
            a(new JSONObject(str));
            this.b = true;
        } catch (Exception e) {
            this.b = false;
            com.baidu.tieba.util.aq.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            this.f1024a.a(jSONObject.optJSONArray("like_forum"));
            this.c = jSONObject.optLong("time");
        } catch (Exception e) {
            this.b = false;
            com.baidu.tieba.util.aq.b(getClass().getName(), "parserJson", e.toString());
        }
    }

    public af a() {
        return this.f1024a;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return System.currentTimeMillis() / g.f.longValue() == (this.c * 1000) / g.f.longValue();
    }
}
