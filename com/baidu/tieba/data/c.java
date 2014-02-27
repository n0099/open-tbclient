package com.baidu.tieba.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c {
    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;

    public final boolean a() {
        return this.a;
    }

    public final void a(boolean z) {
        this.a = false;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public final void a(String str) {
        JSONObject jSONObject;
        try {
            if (!TextUtils.isEmpty(str) && (jSONObject = new JSONObject(str)) != null) {
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
                    com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", e.getMessage());
                }
            }
        } catch (Exception e2) {
            this.a = false;
            com.baidu.adp.lib.util.e.b(getClass().getName(), "parserJson", e2.getMessage());
        }
    }
}
