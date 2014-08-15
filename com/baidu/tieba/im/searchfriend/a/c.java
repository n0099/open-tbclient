package com.baidu.tieba.im.searchfriend.a;

import android.text.TextUtils;
import com.baidu.tbadk.data.IconData;
import org.json.JSONObject;
import protobuf.RecommendFriend.UserInfo;
/* loaded from: classes.dex */
public class c {
    private int a;
    private String b;
    private String c;
    private int d;
    private int e;
    private String f;
    private IconData g = new IconData();
    private boolean h;

    public void a() {
        this.h = true;
    }

    public boolean b() {
        return this.h;
    }

    public void a(UserInfo userInfo) {
        if (userInfo != null) {
            this.h = false;
            this.a = userInfo.id.intValue();
            this.b = userInfo.portrait;
            this.c = userInfo.name;
            this.d = userInfo.sex.intValue();
            this.e = userInfo.distance.intValue();
            this.f = userInfo.intro;
            if (userInfo.tshow_icon != null) {
                this.g.setIcon(userInfo.tshow_icon.icon);
                this.g.setIconName(userInfo.tshow_icon.name);
                this.g.setUrl(userInfo.tshow_icon.url);
            }
        }
    }

    public int c() {
        return this.a;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.c;
    }

    public boolean f() {
        return 2 == this.d;
    }

    public int g() {
        return this.e;
    }

    public String h() {
        return this.f;
    }

    public IconData i() {
        return this.g;
    }

    public boolean j() {
        return this.a == 0 && TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.c);
    }

    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.a);
        jSONObject.put("name", this.c);
        jSONObject.put("portait", this.b);
        jSONObject.put("sex", this.d);
        jSONObject.put("recommend_is_added", this.h);
        jSONObject.put("distance", this.e);
        jSONObject.put("intro", this.f);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("icon", this.g.getIcon());
        jSONObject2.put("name", this.g.getIconName());
        jSONObject2.put("url", this.g.getUrl());
        jSONObject.put("crown_info", jSONObject2);
        return jSONObject;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optInt("id");
            this.c = jSONObject.optString("name");
            this.b = jSONObject.optString("portait");
            this.d = jSONObject.optInt("sex");
            this.h = jSONObject.optBoolean("recommend_is_added");
            this.e = jSONObject.optInt("distance");
            this.f = jSONObject.optString("intro");
            JSONObject optJSONObject = jSONObject.optJSONObject("crown_info");
            if (optJSONObject != null) {
                this.g.setIcon(optJSONObject.optString("icon"));
                this.g.setIconName(optJSONObject.optString("name"));
                this.g.setUrl(optJSONObject.optString("url"));
            }
        }
    }
}
