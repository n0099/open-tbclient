package com.baidu.tbadk.widget.richText;

import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private String a;
    private int b;
    private int c;
    private boolean d;

    public e(JSONObject jSONObject) {
        this.a = null;
        this.b = 1;
        this.c = 1;
        this.d = false;
        if (jSONObject != null) {
            this.a = jSONObject.optString("src");
            try {
                String[] split = jSONObject.optString("bsize").split(",");
                this.b = Integer.valueOf(split[0]).intValue();
                this.c = Integer.valueOf(split[1]).intValue();
            } catch (Exception e) {
                com.baidu.adp.lib.c.b.a(e.getMessage());
            }
            if (this.b <= 0) {
                this.b = 1;
            }
            if (this.c <= 0) {
                this.c = 1;
            }
            if (this.a != null && this.a.indexOf(".baidu.com") != -1) {
                this.d = true;
            }
        }
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public boolean c() {
        return this.d;
    }

    public String d() {
        return this.a;
    }
}
