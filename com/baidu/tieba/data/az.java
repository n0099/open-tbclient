package com.baidu.tieba.data;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class az implements com.baidu.tieba.util.al {
    private SpannableString t;
    private int y;
    private int z;
    private String x = null;
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
    private int m = 0;
    private bc n = new bc();
    private MetaData o = new MetaData();
    private String p = null;
    ArrayList<ai> a = new ArrayList<>();
    ArrayList<VoiceManager.VoiceModel> b = new ArrayList<>();
    private int q = 0;
    private int r = 0;
    private String s = null;
    private String u = null;
    private String v = null;
    private int w = 0;

    public void a(String str) {
        this.c = str;
    }

    public String a() {
        return this.c;
    }

    public void b(String str) {
        this.d = str;
    }

    public String b() {
        return this.d;
    }

    public void c(String str) {
        this.e = str;
    }

    public String c() {
        return this.e;
    }

    public int d() {
        return this.f;
    }

    public long e() {
        return this.j;
    }

    public void a(long j) {
        this.j = j;
    }

    public int f() {
        return this.k;
    }

    public void a(int i) {
        this.k = i;
    }

    public int g() {
        return this.l;
    }

    public void b(int i) {
        this.l = i;
    }

    public int h() {
        return this.m;
    }

    public bc i() {
        return this.n;
    }

    public MetaData j() {
        return this.o;
    }

    public int k() {
        return this.r;
    }

    public String l() {
        return this.s;
    }

    public String m() {
        return this.u;
    }

    public int n() {
        return this.w;
    }

    public void c(int i) {
        this.w = i;
    }

    public String o() {
        return this.x;
    }

    public void d(String str) {
        this.x = str;
    }

    public ArrayList<ai> p() {
        return this.a;
    }

    public ArrayList<VoiceManager.VoiceModel> q() {
        return this.b;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.c = jSONObject.optString("id");
                this.d = jSONObject.optString("tid");
                this.e = jSONObject.optString("title");
                this.f = jSONObject.optInt("reply_num", 0);
                this.g = jSONObject.optInt("repost_num", 0);
                this.h = jSONObject.optInt("view_num", 0);
                this.i = jSONObject.optString("last_time");
                this.j = jSONObject.optLong("last_time_int", 0L);
                this.k = jSONObject.optInt("is_top", 0);
                this.l = jSONObject.optInt("is_good", 0);
                this.m = jSONObject.optInt("is_livepost", 0);
                this.n.a(jSONObject.optJSONObject("topic"));
                this.o.parserJson(jSONObject.optJSONObject("author"));
                this.p = jSONObject.optString("fname");
                this.q = jSONObject.optInt("has_commented", 0);
                this.r = jSONObject.optInt("show_commented", 0);
                this.s = jSONObject.optString("click_url");
                this.v = jSONObject.optString("from");
                this.w = jSONObject.optInt("collect_status");
                this.x = jSONObject.optString("collect_mark_pid");
                this.y = jSONObject.optInt("is_voice_thread");
                this.z = jSONObject.optInt("thread_type");
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
                this.u = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ai aiVar = new ai();
                        aiVar.a(optJSONArray2.getJSONObject(i2));
                        this.a.add(aiVar);
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
                if (optJSONArray3 != null) {
                    int length = optJSONArray3.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        VoiceManager.VoiceModel voiceModel = new VoiceManager.VoiceModel();
                        JSONObject jSONObject2 = optJSONArray3.getJSONObject(i3);
                        voiceModel.from = "frs_voice_play";
                        voiceModel.voiceId = jSONObject2.optString("voice_md5");
                        voiceModel.duration = jSONObject2.optInt("during_time") / LocationClientOption.MIN_SCAN_SPAN;
                        this.b.add(voiceModel);
                    }
                }
            } catch (Exception e) {
                com.baidu.tieba.util.be.b("ThreadData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public SpannableString r() {
        return this.t;
    }

    public boolean s() {
        return f() != 0;
    }

    public void t() {
        SpannableString spannableString;
        if (this.e != null) {
            ArrayList arrayList = new ArrayList();
            if (TiebaApplication.h().an() == 1) {
                if (f() == 1) {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_top_1));
                } else if (f() == 2) {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_notice_1));
                }
                if (h() == 1 || this.n.a() != 0) {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_live_1));
                }
                if (g() == 1 && !s()) {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_elite_1));
                }
                if (this.y == 1 || this.z == 11) {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_voice_1));
                }
            } else {
                if (f() == 1) {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_top));
                } else if (f() == 2) {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_notice));
                }
                if (h() == 1 || this.n.a() != 0) {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_live));
                }
                if (g() == 1 && !s()) {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_elite));
                }
                if (this.y == 1 || this.z == 11) {
                    arrayList.add(Integer.valueOf((int) R.drawable.icon_voice));
                }
            }
            if (k() == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.frs_post_ding));
            }
            if (arrayList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append("1 ");
                }
                SpannableString spannableString2 = new SpannableString(sb.toString() + this.e);
                int i2 = 0;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    Bitmap a = com.baidu.tieba.util.m.a(((Integer) arrayList.get(i3)).intValue());
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(a);
                    bitmapDrawable.setBounds(0, 0, a.getWidth(), a.getHeight());
                    spannableString2.setSpan(new ImageSpan(bitmapDrawable, 1), i2, i2 + 1, 33);
                    i2 += 2;
                }
                spannableString = spannableString2;
            } else {
                spannableString = new SpannableString(this.e);
            }
            this.t = spannableString;
        }
    }

    @Override // com.baidu.tieba.util.al
    public LinkedList<String> getImageUrl() {
        ArrayList<ai> p = p();
        if (p == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= p.size() || i2 >= 3) {
                break;
            }
            if (p.get(i2).a() == 3) {
                linkedList.add(p.get(i2).b());
            }
            i = i2 + 1;
        }
        return linkedList;
    }

    @Override // com.baidu.tieba.util.al
    public LinkedList<String> getPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.al
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }
}
