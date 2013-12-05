package com.baidu.tieba.data;

import com.tencent.mm.sdk.platformtools.LocaleUtil;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bb {

    /* renamed from: a  reason: collision with root package name */
    private String f1235a = null;
    private String b = null;
    private String c = null;
    private int d = 0;

    public String a() {
        return this.f1235a;
    }

    public String b() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        try {
            this.f1235a = jSONObject.getString("title");
            this.b = jSONObject.getString("title_link");
            this.c = jSONObject.getString("author");
            this.d = jSONObject.getInt(LocaleUtil.INDONESIAN);
            com.baidu.tieba.util.bd.c("TOPNotice:title:" + this.f1235a + " link:" + this.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
