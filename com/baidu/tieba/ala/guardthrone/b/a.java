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
    public C0664a gSO;
    public b gSP;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.gSO = new C0664a();
                this.gSO.dF(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.gSP = new b();
                this.gSP.dH(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0664a {
        public long bzb;
        public String gSQ;
        public String gSR;
        public String gSS;
        public String gST;
        public String gSU;
        public long gSV;
        public long gSW;
        public List<C0665a> gSX;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0665a {
            public String pic;
            public String text;

            public void dG(JSONObject jSONObject) {
                this.pic = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
                this.text = jSONObject.optString("text");
            }
        }

        public void dF(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.gSX = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0665a c0665a = new C0665a();
                    c0665a.dG(optJSONArray.optJSONObject(i));
                    this.gSX.add(c0665a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.gSQ = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.gSU = jSONObject.optString("guard_seat_user");
            }
            this.gSR = jSONObject.optString("frame_pic");
            this.gSS = jSONObject.optString("time_text");
            this.gST = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.bzb = jSONObject.optLong("count_down");
            this.gSV = jSONObject.optLong("effect_time");
            this.gSW = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public List<C0667b> aIZ;
        public C0666a gSY;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0667b {
            public String nickname;
            public String portrait;
            public String rank;
            public String score;

            public void dJ(JSONObject jSONObject) {
                this.rank = jSONObject.optString("rank");
                this.nickname = jSONObject.optString("user_nickname");
                this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.portrait = jSONObject.optString("portrait");
            }
        }

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0666a {
            public int rank;
            public String text;

            public void dI(JSONObject jSONObject) {
                this.rank = jSONObject.optInt("rank");
                this.text = jSONObject.optString("bottom_text");
            }
        }

        public void dH(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.aIZ = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0667b c0667b = new C0667b();
                        c0667b.dJ(optJSONArray.optJSONObject(i));
                        this.aIZ.add(c0667b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.gSY = new C0666a();
                    this.gSY.dI(optJSONObject);
                }
            }
        }
    }
}
