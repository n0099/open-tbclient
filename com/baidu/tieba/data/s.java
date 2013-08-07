package com.baidu.tieba.data;

import com.tencent.mm.sdk.platformtools.LocaleUtil;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private String f1023a = null;
    private String b = null;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private String h = null;
    private String i = null;

    public String a() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1023a = jSONObject.optString(LocaleUtil.INDONESIAN);
                this.b = jSONObject.optString("name");
                this.c = jSONObject.optInt("member_count", 0);
                this.d = jSONObject.optInt("is_like", 0);
                this.e = this.d;
                this.f = jSONObject.optInt("level_id", 1);
                this.g = jSONObject.optInt("favo_type", 0);
                this.h = jSONObject.optString("desc");
                this.i = jSONObject.optString("avatar", "");
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b("LikeForumData", "parserJson", "error = " + e.getMessage());
            }
        }
    }
}
