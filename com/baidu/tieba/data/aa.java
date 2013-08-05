package com.baidu.tieba.data;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    private String f965a;
    private String b;
    private int c;
    private AntiData d;
    private Context e;
    private LinkedList f;
    private String g;
    private String h;
    private String i;
    private String j;

    public aa(Context context) {
        this.f965a = null;
        this.b = null;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.e = context;
        this.f = new LinkedList();
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

    public aa() {
        this.f965a = null;
        this.b = null;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.f = new LinkedList();
        this.d = new AntiData();
    }

    public void a(String str, boolean z) {
        try {
            a(new JSONObject(str), Boolean.valueOf(z));
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "paserJson", e.toString());
        }
    }

    public LinkedList h() {
        return this.f;
    }

    public void c(String str) {
        this.f965a = str;
    }

    public String i() {
        return this.f965a;
    }

    public String j() {
        return this.b;
    }

    public int k() {
        return this.c;
    }

    public String l() {
        return this.f.size() > 0 ? ((z) this.f.get(this.f.size() - 1)).c() : "";
    }

    public void a(JSONObject jSONObject, Boolean bool) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("forum");
                if (optJSONObject != null) {
                    this.f965a = optJSONObject.getString("name");
                    this.b = optJSONObject.optString(LocaleUtil.INDONESIAN);
                }
                this.c = jSONObject.optInt("pic_amount", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
                if (optJSONArray != null) {
                    if (bool.booleanValue()) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            z zVar = new z(this.e);
                            zVar.a(optJSONArray.getJSONObject(i));
                            int h = zVar.h();
                            if (h >= 1 && h <= this.c) {
                                this.f.addLast(zVar);
                            }
                        }
                    } else {
                        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                            z zVar2 = new z(this.e);
                            zVar2.a(optJSONArray.getJSONObject(length));
                            int h2 = zVar2.h();
                            if (h2 >= 1 && h2 <= this.c) {
                                this.f.addFirst(zVar2);
                            }
                        }
                    }
                }
                JSONObject jSONObject2 = jSONObject.getJSONArray("album_list").getJSONObject(0);
                this.g = jSONObject2.optString("tid");
                this.h = jSONObject2.optString("title");
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "paserJson", e.toString());
            }
        }
    }
}
