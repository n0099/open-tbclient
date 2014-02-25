package com.baidu.tieba.data;

import android.content.Context;
import com.baidu.cloudsdk.social.core.SocialConstants;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ab {
    private String a;
    private String b;
    private int c;
    private AntiData d;
    private Context e;
    private LinkedList<aa> f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;

    public ab(Context context) {
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = 0;
        this.e = context;
        this.f = new LinkedList<>();
        this.d = new AntiData();
    }

    public boolean a() {
        return this.c > 0 && this.c <= this.f.size();
    }

    public boolean b() {
        return (this.g == null || this.g.length() == 0 || this.h == null || this.h.length() == 0) ? false : true;
    }

    public void a(String str) {
        this.i = str;
    }

    public void b(String str) {
        this.j = str;
    }

    public String c() {
        return this.i;
    }

    public String d() {
        return this.j;
    }

    public AntiData e() {
        return this.d;
    }

    public String f() {
        return this.g;
    }

    public String g() {
        return this.h;
    }

    public ab() {
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = 0;
        this.f = new LinkedList<>();
        this.d = new AntiData();
    }

    public void a(String str, boolean z) {
        try {
            a(new JSONObject(str), Boolean.valueOf(z));
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "paserJson", e.toString());
        }
    }

    public LinkedList<aa> h() {
        return this.f;
    }

    public void c(String str) {
        this.a = str;
    }

    public String i() {
        return this.a;
    }

    public String j() {
        return this.b;
    }

    public int k() {
        return this.c;
    }

    public String l() {
        return this.f.size() > 0 ? this.f.get(this.f.size() - 1).c() : "";
    }

    public void a(JSONObject jSONObject, Boolean bool) {
        if (jSONObject != null) {
            try {
                a(jSONObject.optInt("is_new_url", 0));
                JSONObject optJSONObject = jSONObject.optJSONObject("forum");
                if (optJSONObject != null) {
                    this.a = optJSONObject.optString(SocialConstants.PARAM_MEDIA_UNAME);
                    this.b = optJSONObject.optString("id");
                }
                this.c = jSONObject.optInt("pic_amount", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
                if (optJSONArray != null) {
                    if (bool.booleanValue()) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            aa aaVar = new aa(this.e);
                            aaVar.a(optJSONArray.optJSONObject(i));
                            int h = aaVar.h();
                            if (h >= 1 && h <= this.c) {
                                this.f.addLast(aaVar);
                            }
                        }
                    } else {
                        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                            aa aaVar2 = new aa(this.e);
                            aaVar2.a(optJSONArray.getJSONObject(length));
                            int h2 = aaVar2.h();
                            if (h2 >= 1 && h2 <= this.c) {
                                this.f.addFirst(aaVar2);
                            }
                        }
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONArray("album_list").optJSONObject(0);
                this.g = optJSONObject2.optString("tid");
                this.h = optJSONObject2.optString("title");
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "paserJson", e.toString());
            }
        }
    }

    public int m() {
        return this.k;
    }

    public void a(int i) {
        this.k = i;
    }
}
