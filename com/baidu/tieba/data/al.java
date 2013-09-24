package com.baidu.tieba.data;

import com.tencent.mm.sdk.platformtools.LocaleUtil;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    private int f1002a = 0;
    private String b = null;
    private int e = 0;
    private String c = null;
    private String d = null;
    private String f = null;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b = jSONObject.optString(LocaleUtil.INDONESIAN);
                this.f1002a = jSONObject.optInt("is_login", 0);
                this.e = jSONObject.optInt("no_un", 0);
                this.c = jSONObject.optString("name");
                this.d = jSONObject.optString("name_show");
                this.f = jSONObject.optString("portrait");
            } catch (Exception e) {
                com.baidu.tieba.util.av.b(getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
