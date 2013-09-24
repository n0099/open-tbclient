package com.baidu.tieba.data;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.location.LocationClientOption;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bh implements com.baidu.tieba.util.x {
    private SpannableString r;
    private int w;
    private int x;
    private String v = null;
    private String c = null;
    private String d = null;
    private String e = null;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private String i = null;
    private long j = 0;
    private int k = 0;
    private int l = 0;
    private MetaData m = new MetaData();
    private String n = null;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<ai> f1024a = new ArrayList<>();
    ArrayList<com.baidu.tieba.voice.ai> b = new ArrayList<>();
    private int o = 0;
    private int p = 0;
    private String q = null;
    private String s = null;
    private String t = null;
    private int u = 0;

    public String a() {
        return this.c;
    }

    public String b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public long d() {
        return this.j;
    }

    public void a(long j) {
        this.j = j;
    }

    public int e() {
        return this.k;
    }

    public void a(int i) {
        this.k = i;
    }

    public int f() {
        return this.l;
    }

    public void b(int i) {
        this.l = i;
    }

    public MetaData g() {
        return this.m;
    }

    public int h() {
        return this.p;
    }

    public String i() {
        return this.q;
    }

    public String j() {
        return this.s;
    }

    public int k() {
        return this.u;
    }

    public void c(int i) {
        this.u = i;
    }

    public String n() {
        return this.v;
    }

    public void a(String str) {
        this.v = str;
    }

    public ArrayList<ai> o() {
        return this.f1024a;
    }

    public ArrayList<com.baidu.tieba.voice.ai> p() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.c = jSONObject.optString(LocaleUtil.INDONESIAN);
                this.d = jSONObject.optString("tid");
                this.e = jSONObject.optString("title");
                this.f = jSONObject.optInt("reply_num", 0);
                this.g = jSONObject.optInt("repost_num", 0);
                this.h = jSONObject.optInt("view_num", 0);
                this.i = jSONObject.optString("last_time");
                this.j = jSONObject.optLong("last_time_int", 0L);
                this.k = jSONObject.optInt("is_top", 0);
                this.l = jSONObject.optInt("is_good", 0);
                this.m.parserJson(jSONObject.optJSONObject("author"));
                this.n = jSONObject.optString("fname");
                this.o = jSONObject.optInt("has_commented", 0);
                this.p = jSONObject.optInt("show_commented", 0);
                this.q = jSONObject.optString("click_url");
                this.t = jSONObject.optString("from");
                this.u = jSONObject.optInt("collect_status");
                this.v = jSONObject.optString("collect_mark_pid");
                this.w = jSONObject.optInt("is_voice_thread");
                this.x = jSONObject.optInt("thread_type");
                StringBuilder sb = new StringBuilder();
                JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        if (optJSONArray.getJSONObject(i) != null) {
                            if (optJSONArray.getJSONObject(i).optInt("type") == 0) {
                                sb.append(optJSONArray.getJSONObject(i).optString("text"));
                            }
                        } else {
                            return;
                        }
                    }
                }
                this.s = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ai aiVar = new ai();
                        aiVar.a(optJSONArray2.getJSONObject(i2));
                        this.f1024a.add(aiVar);
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
                if (optJSONArray3 != null) {
                    int length = optJSONArray3.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        com.baidu.tieba.voice.ai aiVar2 = new com.baidu.tieba.voice.ai();
                        JSONObject jSONObject2 = optJSONArray3.getJSONObject(i3);
                        aiVar2.f2028a = "frs_voice_play";
                        aiVar2.b = jSONObject2.optString("voice_md5");
                        aiVar2.d = jSONObject2.optInt("during_time") / LocationClientOption.MIN_SCAN_SPAN;
                        this.b.add(aiVar2);
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.av.b("ThreadData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public SpannableString q() {
        return this.r;
    }

    public void r() {
        SpannableString spannableString;
        if (this.e != null) {
            ArrayList arrayList = new ArrayList();
            if (e() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
            }
            if (f() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
            }
            if (h() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
            }
            if (this.w == 1 || this.x == 11) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_voice));
            }
            if (arrayList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append("1 ");
                }
                SpannableString spannableString2 = new SpannableString(String.valueOf(sb.toString()) + this.e);
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
                spannableString = new SpannableString(this.e);
            }
            this.r = spannableString;
        }
    }

    @Override // com.baidu.tieba.util.x
    public LinkedList<String> l() {
        ArrayList<ai> o = o();
        if (o == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= o.size() || i2 >= 3) {
                break;
            }
            if (o.get(i2).a() == 3) {
                linkedList.add(o.get(i2).b());
            }
            i = i2 + 1;
        }
        return linkedList;
    }

    @Override // com.baidu.tieba.util.x
    public LinkedList<String> m() {
        return null;
    }
}
