package com.baidu.tieba.data;

import com.baidu.android.pushservice.PushConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    private String f1031a;
    private String b;
    private String c;
    private String d;
    private int e;
    private String f;
    private String g;
    private long h;
    private String i;
    private int j;
    private int k;
    private int l;
    private ArrayList m;
    private int n = 0;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1031a = jSONObject.optString("forum_id", "");
                this.b = jSONObject.optString("forum_name", "");
                this.c = jSONObject.optString("thread_id", "");
                this.d = jSONObject.optString("title", "");
                this.e = jSONObject.optInt("post_num", 0);
                this.k = jSONObject.optInt("is_top", 0);
                this.j = jSONObject.optInt("is_good", 0);
                this.f = jSONObject.optString(PushConstants.EXTRA_USER_ID, "");
                this.g = jSONObject.optString("user_name", "");
                this.l = jSONObject.optInt("is_up", 0);
                this.h = jSONObject.optLong("create_time", 0L);
                JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null && jSONObject2.optInt("type", -1) == this.n) {
                            this.i = jSONObject2.optString("text", "");
                            if (this.i != "") {
                                break;
                            }
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    if (this.m == null) {
                        this.m = new ArrayList();
                    }
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ai aiVar = new ai();
                        aiVar.a(optJSONArray2.getJSONObject(i2));
                        if (aiVar.b() != null && aiVar.b().length() > 0) {
                            this.m.add(aiVar);
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b(x.class.getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public String a() {
        return this.f1031a;
    }

    public String b() {
        return this.b != null ? this.b : "";
    }

    public String c() {
        return this.c != null ? this.c : "";
    }

    public String d() {
        return this.d != null ? this.d : "";
    }

    public int e() {
        return this.e;
    }

    public String f() {
        return this.g != null ? this.g : "";
    }

    public long g() {
        return this.h;
    }

    public String h() {
        return this.i != null ? this.i : "";
    }

    public int i() {
        return this.j;
    }

    public ArrayList j() {
        return this.m;
    }
}
