package com.baidu.tieba.data;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bm {
    private SpannableString q;
    private String u = null;
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
    private MetaData l = new MetaData();
    private String m = null;

    /* renamed from: a  reason: collision with root package name */
    ArrayList f1001a = new ArrayList();
    private int n = 0;
    private int o = 0;
    private String p = null;
    private String r = null;
    private String s = null;
    private int t = 0;

    public String a() {
        return this.b;
    }

    public String b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public long d() {
        return this.i;
    }

    public void a(long j) {
        this.i = j;
    }

    public int e() {
        return this.j;
    }

    public void a(int i) {
        this.j = i;
    }

    public int f() {
        return this.k;
    }

    public void b(int i) {
        this.k = i;
    }

    public MetaData g() {
        return this.l;
    }

    public int h() {
        return this.o;
    }

    public String i() {
        return this.p;
    }

    public String j() {
        return this.r;
    }

    public int k() {
        return this.t;
    }

    public void c(int i) {
        this.t = i;
    }

    public String l() {
        return this.u;
    }

    public void a(String str) {
        this.u = str;
    }

    public ArrayList m() {
        return this.f1001a;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.b = jSONObject.optString(LocaleUtil.INDONESIAN);
                this.c = jSONObject.optString("tid");
                this.d = jSONObject.optString("title");
                this.e = jSONObject.optInt("reply_num", 0);
                this.f = jSONObject.optInt("repost_num", 0);
                this.g = jSONObject.optInt("view_num", 0);
                this.h = jSONObject.optString("last_time");
                this.i = jSONObject.optLong("last_time_int", 0L);
                this.j = jSONObject.optInt("is_top", 0);
                this.k = jSONObject.optInt("is_good", 0);
                this.l.parserJson(jSONObject.optJSONObject("author"));
                this.m = jSONObject.optString("fname");
                this.n = jSONObject.optInt("has_commented", 0);
                this.o = jSONObject.optInt("show_commented", 0);
                this.p = jSONObject.optString("click_url");
                this.s = jSONObject.optString("from");
                this.t = jSONObject.optInt("collect_status");
                this.u = jSONObject.optString("collect_mark_pid");
                JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        if (optJSONArray.getJSONObject(i) != null) {
                            if (optJSONArray.getJSONObject(i).optInt("type") == 0) {
                                this.r = optJSONArray.getJSONObject(i).optString("text");
                            }
                        } else {
                            return;
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        am amVar = new am();
                        amVar.a(optJSONArray2.getJSONObject(i2));
                        this.f1001a.add(amVar);
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b("ThreadData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public SpannableString n() {
        return this.q;
    }

    public void o() {
        SpannableString spannableString;
        if (this.d != null) {
            ArrayList arrayList = new ArrayList();
            if (f() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
            }
            if (e() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
            }
            if (h() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
            }
            if (arrayList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append("1 ");
                }
                SpannableString spannableString2 = new SpannableString(String.valueOf(sb.toString()) + this.d);
                int i2 = 0;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    Bitmap a2 = com.baidu.tieba.util.e.a(((Integer) arrayList.get(i3)).intValue());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(a2);
                    bitmapDrawable.setBounds(0, 0, a2.getWidth(), a2.getHeight());
                    spannableString2.setSpan(new ImageSpan(bitmapDrawable, 1), i2, i2 + 1, 33);
                    i2 += 2;
                }
                spannableString = spannableString2;
            } else {
                spannableString = new SpannableString(this.d);
            }
            this.q = spannableString;
        }
    }
}
