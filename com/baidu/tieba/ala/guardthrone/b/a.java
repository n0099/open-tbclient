package com.baidu.tieba.ala.guardthrone.b;

import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public C0646a heC;
    public b heD;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.heC = new C0646a();
                this.heC.dR(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.heD = new b();
                this.heD.dT(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0646a {
        public long countdown;
        public String heE;
        public String heF;
        public String heG;
        public String heH;
        public String heI;
        public long heJ;
        public long heK;
        public List<C0647a> heL;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C0647a {
            public String pic;
            public String text;

            public void dS(JSONObject jSONObject) {
                this.pic = jSONObject.optString("pic");
                this.text = jSONObject.optString("text");
            }
        }

        public void dR(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.heL = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0647a c0647a = new C0647a();
                    c0647a.dS(optJSONArray.optJSONObject(i));
                    this.heL.add(c0647a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.heE = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.heI = jSONObject.optString("guard_seat_user");
            }
            this.heF = jSONObject.optString("frame_pic");
            this.heG = jSONObject.optString("time_text");
            this.heH = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.countdown = jSONObject.optLong("count_down");
            this.heJ = jSONObject.optLong("effect_time");
            this.heK = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public List<C0649b> aHX;
        public C0648a heM;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C0649b {
            public String nickname;
            public String portrait;
            public String rank;
            public String score;

            public void dV(JSONObject jSONObject) {
                this.rank = jSONObject.optString("rank");
                this.nickname = jSONObject.optString("user_nickname");
                this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.portrait = jSONObject.optString("portrait");
            }
        }

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C0648a {
            public int rank;
            public String text;

            public void dU(JSONObject jSONObject) {
                this.rank = jSONObject.optInt("rank");
                this.text = jSONObject.optString("bottom_text");
            }
        }

        public void dT(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.aHX = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0649b c0649b = new C0649b();
                        c0649b.dV(optJSONArray.optJSONObject(i));
                        this.aHX.add(c0649b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.heM = new C0648a();
                    this.heM.dU(optJSONObject);
                }
            }
        }
    }
}
