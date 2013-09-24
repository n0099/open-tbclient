package com.baidu.tieba.data;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.location.LocationClientOption;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class x implements com.baidu.tieba.util.x {

    /* renamed from: a  reason: collision with root package name */
    private String f1049a;
    private String b;
    private String c;
    private SpannableString d;
    private int e;
    private String f;
    private String g;
    private long h;
    private String i;
    private int j;
    private int k;
    private int l;
    private ArrayList<ai> m;
    private ArrayList<com.baidu.tieba.voice.ai> n = new ArrayList<>();
    private int o = 0;
    private int p;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1049a = jSONObject.optString("forum_id", "");
                this.b = jSONObject.optString("forum_name", "");
                this.c = jSONObject.optString("thread_id", "");
                String optString = jSONObject.optString("title", "");
                this.e = jSONObject.optInt("post_num", 0);
                this.k = jSONObject.optInt("is_top", 0);
                this.j = jSONObject.optInt("is_good", 0);
                this.f = jSONObject.optString(PushConstants.EXTRA_USER_ID, "");
                this.g = jSONObject.optString("user_name", "");
                this.l = jSONObject.optInt("is_up", 0);
                this.h = jSONObject.optLong("create_time", 0L);
                this.p = jSONObject.optInt("is_voice_thread");
                StringBuilder sb = new StringBuilder();
                JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null && jSONObject2.optInt("type", -1) == this.o) {
                            sb.append(jSONObject2.optString("text", ""));
                        }
                    }
                }
                this.i = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    if (this.m == null) {
                        this.m = new ArrayList<>();
                    }
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ai aiVar = new ai();
                        aiVar.a(optJSONArray2.getJSONObject(i2));
                        if (aiVar.b() != null && aiVar.b().length() > 0) {
                            this.m.add(aiVar);
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
                if (optJSONArray3 != null) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        com.baidu.tieba.voice.ai aiVar2 = new com.baidu.tieba.voice.ai();
                        JSONObject jSONObject3 = optJSONArray3.getJSONObject(i3);
                        aiVar2.f2028a = "home_voice_play";
                        aiVar2.b = jSONObject3.optString("voice_md5");
                        aiVar2.d = jSONObject3.optInt("during_time") / LocationClientOption.MIN_SCAN_SPAN;
                        this.n.add(aiVar2);
                    }
                }
                a(optString);
            } catch (Exception e) {
                com.baidu.tieba.util.av.b(x.class.getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void a(String str) {
        SpannableString spannableString;
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            if (this.p == 1) {
                arrayList.add(Integer.valueOf((int) R.drawable.icon_voice));
            }
            if (arrayList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append("1 ");
                }
                SpannableString spannableString2 = new SpannableString(String.valueOf(sb.toString()) + str);
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
                spannableString = new SpannableString(str);
            }
            this.d = spannableString;
        }
    }

    public String a() {
        return this.f1049a;
    }

    public String b() {
        return this.b != null ? this.b : "";
    }

    public String c() {
        return this.c != null ? this.c : "";
    }

    public SpannableString d() {
        return this.d;
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

    public ArrayList<ai> j() {
        return this.m;
    }

    public ArrayList<com.baidu.tieba.voice.ai> k() {
        return this.n;
    }

    @Override // com.baidu.tieba.util.x
    public LinkedList<String> l() {
        if (this.m == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        Iterator<ai> it = this.m.iterator();
        int i = 0;
        while (it.hasNext()) {
            ai next = it.next();
            i++;
            if (i > 3) {
                break;
            } else if (next.a() == 3) {
                linkedList.add(next.b());
            }
        }
        return linkedList;
    }

    @Override // com.baidu.tieba.util.x
    public LinkedList<String> m() {
        return null;
    }
}
