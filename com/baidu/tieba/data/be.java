package com.baidu.tieba.data;

import com.tencent.mm.sdk.platformtools.LocaleUtil;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class be {

    /* renamed from: a  reason: collision with root package name */
    private String f1238a = null;
    private int b = 0;
    private int d = 0;
    private int e = 0;
    private int c = 0;

    public int a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public String c() {
        return this.f1238a;
    }

    public int d() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public int e() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1238a = jSONObject.optString(LocaleUtil.INDONESIAN);
                this.d = jSONObject.optInt("width", 0);
                this.e = jSONObject.optInt("height", 0);
            } catch (Exception e) {
                com.baidu.tieba.util.bd.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
