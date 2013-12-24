package com.baidu.tieba.data;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.location.LocationClientOption;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class w implements com.baidu.tieba.util.al {
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
    private ArrayList<ai> m;
    private ArrayList<VoiceManager.VoiceModel> n = new ArrayList<>();
    private int o = 0;
    private int p;
    private LinkedList<IconData> q;

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
                JSONArray optJSONArray = jSONObject.optJSONObject("userinfo").optJSONArray("iconinfo");
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
                StringBuilder sb = new StringBuilder();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("abstract");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    int length = optJSONArray2.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                        if (jSONObject2 != null && jSONObject2.optInt("type", -1) == this.o) {
                            sb.append(jSONObject2.optString("text", ""));
                        }
                    }
                }
                this.i = sb.toString();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("media");
                if (optJSONArray3 != null) {
                    if (this.m == null) {
                        this.m = new ArrayList<>();
                    }
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        ai aiVar = new ai();
                        aiVar.a(optJSONArray3.getJSONObject(i3));
                        if (aiVar.b() != null && aiVar.b().length() > 0) {
                            this.m.add(aiVar);
                        }
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("voice_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        VoiceManager.VoiceModel voiceModel = new VoiceManager.VoiceModel();
                        JSONObject jSONObject3 = optJSONArray4.getJSONObject(i4);
                        voiceModel.from = "home_voice_play";
                        voiceModel.voiceId = jSONObject3.optString("voice_md5");
                        voiceModel.duration = jSONObject3.optInt("during_time") / LocationClientOption.MIN_SCAN_SPAN;
                        this.n.add(voiceModel);
                    }
                }
                a(optString);
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(w.class.getName(), "parserJson", "error = " + e.getMessage());
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

    public String a() {
        return this.a;
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

    public ArrayList<VoiceManager.VoiceModel> k() {
        return this.n;
    }

    public LinkedList<IconData> l() {
        return this.q;
    }

    @Override // com.baidu.tieba.util.al
    public LinkedList<String> getImageUrl() {
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

    @Override // com.baidu.tieba.util.al
    public LinkedList<String> getPhotoUrl() {
        return null;
    }

    @Override // com.baidu.tieba.util.al
    public LinkedList<String> getForumPhotoUrl() {
        return null;
    }
}
