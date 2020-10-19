package com.baidu.tieba.ala.guardthrone.b;

import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public C0623a gud;
    public b gue;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.gud = new C0623a();
                this.gud.dy(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.gue = new b();
                this.gue.dA(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0623a {
        public long bze;
        public String guf;
        public String gug;
        public String guh;
        public String gui;
        public String guj;
        public long guk;
        public long gul;
        public List<C0624a> gum;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0624a {
            public String pic;
            public String text;

            public void dz(JSONObject jSONObject) {
                this.pic = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
                this.text = jSONObject.optString("text");
            }
        }

        public void dy(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.gum = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0624a c0624a = new C0624a();
                    c0624a.dz(optJSONArray.optJSONObject(i));
                    this.gum.add(c0624a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.guf = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.guj = jSONObject.optString("guard_seat_user");
            }
            this.gug = jSONObject.optString("frame_pic");
            this.guh = jSONObject.optString("time_text");
            this.gui = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.bze = jSONObject.optLong("count_down");
            this.guk = jSONObject.optLong("effect_time");
            this.gul = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public List<C0626b> aGZ;
        public C0625a gun;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0626b {
            public String nickname;
            public String portrait;
            public String rank;
            public String score;

            public void dC(JSONObject jSONObject) {
                this.rank = jSONObject.optString("rank");
                this.nickname = jSONObject.optString("user_nickname");
                this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.portrait = jSONObject.optString("portrait");
            }
        }

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0625a {
            public int rank;
            public String text;

            public void dB(JSONObject jSONObject) {
                this.rank = jSONObject.optInt("rank");
                this.text = jSONObject.optString("bottom_text");
            }
        }

        public void dA(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.aGZ = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0626b c0626b = new C0626b();
                        c0626b.dC(optJSONArray.optJSONObject(i));
                        this.aGZ.add(c0626b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.gun = new C0625a();
                    this.gun.dB(optJSONObject);
                }
            }
        }
    }
}
