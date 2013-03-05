package com.baidu.tieba.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.tieba.R;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class at {
    private SpannableString r;
    private String b = null;
    private String c = null;
    private String d = null;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private String h = null;
    private long i = 0;
    private int j = 0;
    private int k = 0;
    private af l = new af();
    private String m = null;
    ArrayList a = new ArrayList();
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private String q = null;
    private String s = null;
    private String t = null;

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public long e() {
        return this.i;
    }

    public int f() {
        return this.j;
    }

    public int g() {
        return this.k;
    }

    public af h() {
        return this.l;
    }

    public String i() {
        return this.m;
    }

    public int j() {
        return this.p;
    }

    public String k() {
        return this.q;
    }

    public String l() {
        return this.s;
    }

    public String m() {
        return this.t;
    }

    public ArrayList n() {
        return this.a;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b = jSONObject.optString("id");
                this.c = jSONObject.optString("tid");
                this.d = jSONObject.optString("title");
                this.e = jSONObject.optInt("reply_num", 0);
                this.f = jSONObject.optInt("repost_num", 0);
                this.g = jSONObject.optInt("view_num", 0);
                this.h = jSONObject.optString("last_time");
                this.i = jSONObject.optLong("last_time_int", 0L);
                this.j = jSONObject.optInt("is_top", 0);
                this.k = jSONObject.optInt("is_good", 0);
                this.l.a(jSONObject.optJSONObject("author"));
                this.m = jSONObject.optString("fname");
                this.n = jSONObject.optInt("comment_num", 0);
                this.o = jSONObject.optInt("has_commented", 0);
                this.p = jSONObject.optInt("show_commented", 0);
                this.q = jSONObject.optString("click_url");
                this.t = jSONObject.optString("from");
                JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        if (optJSONArray.getJSONObject(i) != null) {
                            if (optJSONArray.getJSONObject(i).optInt("type") == 0) {
                                this.s = optJSONArray.getJSONObject(i).optString("text");
                            }
                        } else {
                            return;
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ad adVar = new ad();
                        adVar.a(optJSONArray2.getJSONObject(i2));
                        this.a.add(adVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b("ThreadData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public SpannableString o() {
        return this.r;
    }

    public void p() {
        Bitmap a;
        SpannableString spannableString;
        if (f() == 1) {
            a = com.baidu.tieba.c.e.a((int) R.drawable.frs_post_top);
        } else if (g() == 1) {
            a = com.baidu.tieba.c.e.a((int) R.drawable.frs_post_good);
        } else {
            a = j() == 1 ? com.baidu.tieba.c.e.a((int) R.drawable.frs_post_ding) : null;
        }
        if (a != null) {
            spannableString = new SpannableString("1 " + this.d);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(a);
            bitmapDrawable.setBounds(0, 0, a.getWidth(), a.getHeight());
            spannableString.setSpan(new ImageSpan(bitmapDrawable, 0), 0, 1, 33);
        } else {
            spannableString = new SpannableString(this.d);
        }
        this.d = null;
        this.r = spannableString;
    }
}
