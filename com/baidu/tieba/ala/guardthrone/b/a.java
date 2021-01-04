package com.baidu.tieba.ala.guardthrone.b;

import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public C0656a heB;
    public b heC;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.heB = new C0656a();
                this.heB.dO(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.heC = new b();
                this.heC.dQ(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0656a {
        public long countdown;
        public String heD;
        public String heE;
        public String heF;
        public String heG;
        public String heH;
        public long heI;
        public long heJ;
        public List<C0657a> heK;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C0657a {
            public String pic;
            public String text;

            public void dP(JSONObject jSONObject) {
                this.pic = jSONObject.optString("pic");
                this.text = jSONObject.optString("text");
            }
        }

        public void dO(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.heK = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0657a c0657a = new C0657a();
                    c0657a.dP(optJSONArray.optJSONObject(i));
                    this.heK.add(c0657a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.heD = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.heH = jSONObject.optString("guard_seat_user");
            }
            this.heE = jSONObject.optString("frame_pic");
            this.heF = jSONObject.optString("time_text");
            this.heG = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.countdown = jSONObject.optLong("count_down");
            this.heI = jSONObject.optLong("effect_time");
            this.heJ = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public List<C0659b> aJx;
        public C0658a heL;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C0659b {
            public String nickname;
            public String portrait;
            public String rank;
            public String score;

            public void dS(JSONObject jSONObject) {
                this.rank = jSONObject.optString("rank");
                this.nickname = jSONObject.optString("user_nickname");
                this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.portrait = jSONObject.optString("portrait");
            }
        }

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C0658a {
            public int rank;
            public String text;

            public void dR(JSONObject jSONObject) {
                this.rank = jSONObject.optInt("rank");
                this.text = jSONObject.optString("bottom_text");
            }
        }

        public void dQ(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.aJx = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0659b c0659b = new C0659b();
                        c0659b.dS(optJSONArray.optJSONObject(i));
                        this.aJx.add(c0659b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.heL = new C0658a();
                    this.heL.dR(optJSONObject);
                }
            }
        }
    }
}
