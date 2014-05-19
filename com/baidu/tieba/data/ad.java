package com.baidu.tieba.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ad {
    private String h;
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
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public String b() {
        return this.h;
    }
}
