package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    private as c;
    private ArrayList<j> d;
    private Context l;

    /* renamed from: a  reason: collision with root package name */
    private String f1122a = null;
    private String b = null;
    private int e = 0;
    private int f = 0;
    private String g = null;
    private String h = null;
    private String i = null;
    private String j = null;
    private int k = -1;

    public ab(Context context) {
        this.c = null;
        this.d = null;
        this.l = null;
        this.l = context;
        this.c = new as();
        this.d = new ArrayList<>();
    }

    public as a() {
        return this.c;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.f1122a;
    }

    public String d() {
        return this.g;
    }

    public String e() {
        return this.i;
    }

    public int f() {
        return this.e;
    }

    public int g() {
        return this.f;
    }

    public int h() {
        return this.k;
    }

    public String i() {
        return this.j;
    }

    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            this.g = jSONObject.optString("post_id");
            this.i = jSONObject.optString("user_name");
            this.j = jSONObject.optString(PushConstants.EXTRA_USER_ID);
            this.h = jSONObject.optString("comment_amount");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("img");
            this.k = jSONObject.optInt("index", -1);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("original")) != null) {
                this.f1122a = optJSONObject.optString(LocaleUtil.INDONESIAN);
                this.b = optJSONObject.optString(SocialConstants.PARAM_URL);
                this.e = optJSONObject.optInt("width", 0);
                this.f = optJSONObject.optInt("height", 0);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("descr");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    j jVar = new j();
                    jVar.a(optJSONArray.optJSONObject(i));
                    this.d.add(jVar);
                }
            }
            this.c.a(this.d);
            if (this.l != null) {
                this.c.c(this.l);
            }
        } catch (Exception e) {
            com.baidu.tieba.util.be.b(getClass().getName(), "paserJson", e.toString());
        }
    }
}
