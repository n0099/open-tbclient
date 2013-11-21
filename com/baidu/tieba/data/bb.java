package com.baidu.tieba.data;

import com.baidu.tieba.util.bg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    private String f1188a = null;
    private String b = null;
    private String c = null;
    private int d = 0;

    public String a() {
        return this.f1188a;
    }

    public String b() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        try {
            this.f1188a = jSONObject.getString("title");
            this.b = jSONObject.getString("title_link");
            this.c = jSONObject.getString("author");
            this.d = jSONObject.getInt(LocaleUtil.INDONESIAN);
            bg.c("TOPNotice:title:" + this.f1188a + " link:" + this.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
