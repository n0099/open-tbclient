package com.baidu.tieba.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;

    public boolean a() {
        return this.a;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                a(new JSONObject(str));
            }
        } catch (Exception e) {
            this.a = false;
            com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.a = true;
                } else {
                    this.a = false;
                }
                this.b = jSONObject.optInt("number");
                this.d = jSONObject.optInt("time");
                this.c = jSONObject.optInt("ab_num");
                this.e = this.c;
                if (this.b <= 0 || this.d <= 0 || this.c <= 0 || this.e <= 0) {
                    this.a = false;
                }
            } catch (Exception e) {
                this.a = false;
                com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
            }
        }
    }
}
