package com.baidu.tieba.data;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.util.bo;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w extends com.baidu.tieba.util.ap {
    private String a;
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
    private ArrayList<aj> m;
    private ArrayList<VoiceManager.VoiceModel> n = new ArrayList<>();
    private int o = 0;
    private int p;
    private LinkedList<IconData> q;
    private LinkedList<IconData> r;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString("forum_id", "");
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
                JSONObject optJSONObject = jSONObject.optJSONObject("userinfo");
                JSONArray optJSONArray = optJSONObject.optJSONArray("iconinfo");
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("tshow_icon");
                if (optJSONArray != null) {
                    if (this.q == null) {
                        this.q = new LinkedList<>();
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        IconData iconData = new IconData();
                        iconData.parserJson(optJSONArray.getJSONObject(i));
                        this.q.add(iconData);
                    }
                }
                if (optJSONArray2 != null) {
                    if (this.r == null) {
                        this.r = new LinkedList<>();
                    }
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        IconData iconData2 = new IconData();
                        iconData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.r.add(iconData2);
                    }
                }
                StringBuilder sb = new StringBuilder();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("abstract");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    int length = optJSONArray3.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject jSONObject2 = optJSONArray3.getJSONObject(i3);
                        if (jSONObject2 != null && jSONObject2.optInt("type", -1) == this.o) {
                            sb.append(jSONObject2.optString("text", ""));
                        }
                    }
                }
                this.i = sb.toString();
                JSONArray optJSONArray4 = jSONObject.optJSONArray("media");
                if (optJSONArray4 != null) {
                    if (this.m == null) {
                        this.m = new ArrayList<>();
                    }
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        aj ajVar = new aj();
                        ajVar.a(optJSONArray4.getJSONObject(i4));
                        if (ajVar.b() != null && ajVar.b().length() > 0) {
                            this.m.add(ajVar);
                        }
                    }
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("voice_info");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        VoiceManager.VoiceModel voiceModel = new VoiceManager.VoiceModel();
                        JSONObject jSONObject3 = optJSONArray5.getJSONObject(i5);
                        voiceModel.from = "home_voice_play";
                        voiceModel.voiceId = jSONObject3.optString("voice_md5");
                        voiceModel.duration = jSONObject3.optInt("during_time") / LocationClientOption.MIN_SCAN_SPAN;
                        this.n.add(voiceModel);
                    }
                }
                a(optString);
            } catch (Exception e) {
                bo.b(w.class.getName(), "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public LinkedList<IconData> a() {
        return this.r;
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
                SpannableString spannableString2 = new SpannableString(sb.toString() + str);
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
                spannableString = new SpannableString(str);
            }
            this.d = spannableString;
        }
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b != null ? this.b : "";
    }

    public String d() {
        return this.c != null ? this.c : "";
    }

    public SpannableString e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    public String g() {
        return this.g != null ? this.g : "";
    }

    public long h() {
        return this.h;
    }

    public String i() {
        return this.i != null ? this.i : "";
    }

    public int j() {
        return this.j;
    }

    public ArrayList<aj> k() {
        return this.m;
    }

    public ArrayList<VoiceManager.VoiceModel> l() {
        return this.n;
    }

    public LinkedList<IconData> m() {
        return this.q;
    }

    @Override // com.baidu.tieba.util.ap, com.baidu.tieba.util.ar
    public LinkedList<String> getImageUrl() {
        if (this.m == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        Iterator<aj> it = this.m.iterator();
        int i = 0;
        while (it.hasNext()) {
            aj next = it.next();
            i++;
            if (i > 3) {
                break;
            } else if (next.a() == 3) {
                linkedList.add(next.b());
            }
        }
        return linkedList;
    }
}
