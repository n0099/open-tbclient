package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ag {
    private String h;
    private int i;
    private boolean g = false;
    private int a = 0;
    private String b = null;
    private int e = 0;
    private String c = null;
    private String d = null;
    private String f = null;

    public boolean a() {
        return this.g;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b = jSONObject.optString("id");
                this.a = jSONObject.optInt("is_login", 0);
                this.e = jSONObject.optInt("no_un", 0);
                this.c = jSONObject.optString("name");
                this.d = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.NAME_SHOW);
                this.f = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                if (jSONObject.optInt("is_manager", 0) == 1) {
                    this.g = true;
                } else {
                    this.g = false;
                }
                this.h = jSONObject.optString("bimg_url");
                this.i = jSONObject.optInt("bimg_end_time", 0);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public String b() {
        return this.h;
    }

    public int c() {
        return this.i;
    }
}
