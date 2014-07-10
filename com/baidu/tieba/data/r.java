package com.baidu.tieba.data;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r extends com.baidu.tbadk.core.util.a implements bg {
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
    private ArrayList<MediaData> m;
    private int p;
    private LinkedList<IconData> q;
    private LinkedList<IconData> r;
    private boolean t;
    private ArrayList<VoiceData.VoiceModel> n = new ArrayList<>();
    private final int o = 0;
    private LiveCardData s = new LiveCardData();

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.a = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.FORUM_ID, "");
                this.b = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.FORUM_NAME, "");
                this.c = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.THREAD_ID, "");
                String optString = jSONObject.optString("title", "");
                this.e = jSONObject.optInt("post_num", 0);
                this.k = jSONObject.optInt("is_top", 0);
                this.j = jSONObject.optInt("is_good", 0);
                this.f = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_ID, "");
                this.g = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME, "");
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
                        if (jSONObject2 != null && jSONObject2.optInt("type", -1) == 0) {
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
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray4.getJSONObject(i4));
                        if (mediaData.getPicUrl() != null && mediaData.getPicUrl().length() > 0) {
                            this.m.add(mediaData);
                        }
                    }
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("voice_info");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                        JSONObject jSONObject3 = optJSONArray5.getJSONObject(i5);
                        voiceModel.from = "home_voice_play";
                        voiceModel.voiceId = jSONObject3.optString("voice_md5");
                        voiceModel.duration = jSONObject3.optInt("during_time") / 1000;
                        this.n.add(voiceModel);
                    }
                }
                a(optString);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("anchor_info");
                if (optJSONObject2 == null) {
                    this.t = false;
                    return;
                }
                this.t = true;
                this.s.setPortrait(optJSONObject2.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT));
                this.s.setName(optJSONObject2.optString("name"));
                this.s.setStartTime(optJSONObject2.optLong("start_time"));
                this.s.setAuthorId(optJSONObject2.optInt("author_id"));
                this.s.setAuthorName(optJSONObject2.optString("author_name"));
                this.s.setListeners(optJSONObject2.optInt("listeners"));
                this.s.setLikers(optJSONObject2.optInt("likers"));
                this.s.setGroupId(optJSONObject2.optInt(com.baidu.tbadk.core.frameworkData.a.GROUP_ID));
                this.s.setIntro(optJSONObject2.optString("intro"));
                this.s.setPublisherPortrait(optJSONObject2.optString("publisherPortrait"));
                this.s.setPublisherId(optJSONObject2.optInt(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_ID));
                this.s.setPublisherName(optJSONObject2.optString(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_NAME));
            } catch (Exception e) {
                BdLog.detailException(e);
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
                arrayList.add(Integer.valueOf(com.baidu.tieba.u.icon_voice));
            }
            if (arrayList.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append("1 ");
                }
                SpannableString spannableString2 = new SpannableString(String.valueOf(sb.toString()) + str);
                int i2 = 0;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    Bitmap a = com.baidu.tbadk.core.util.h.a(((Integer) arrayList.get(i3)).intValue());
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

    public ArrayList<MediaData> k() {
        return this.m;
    }

    public ArrayList<VoiceData.VoiceModel> l() {
        return this.n;
    }

    public LinkedList<IconData> m() {
        return this.q;
    }

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ai
    public LinkedList<String> getImageUrl() {
        if (this.m == null) {
            return null;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        Iterator<MediaData> it = this.m.iterator();
        int i = 0;
        while (it.hasNext()) {
            MediaData next = it.next();
            i++;
            if (i > 3) {
                break;
            } else if (next.getType() == 3) {
                linkedList.add(next.getPicUrl());
            }
        }
        return linkedList;
    }

    public LiveCardData n() {
        return this.s;
    }

    public boolean o() {
        return this.t;
    }

    @Override // com.baidu.tbadk.core.util.bg
    public LinkedList<bf> getImages() {
        LinkedList<bf> linkedList = new LinkedList<>();
        Iterator<MediaData> it = this.m.iterator();
        while (it.hasNext()) {
            bf bfVar = new bf();
            bfVar.a = it.next().getPicUrl();
            bfVar.d = 10;
            linkedList.add(bfVar);
        }
        return linkedList;
    }
}
