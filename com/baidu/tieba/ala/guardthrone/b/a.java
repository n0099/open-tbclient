package com.baidu.tieba.ala.guardthrone.b;

import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public C0639a gZV;
    public b gZW;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.gZV = new C0639a();
                this.gZV.dO(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.gZW = new b();
                this.gZW.dQ(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0639a {
        public long countdown;
        public String gZX;
        public String gZY;
        public String gZZ;
        public String haa;
        public String hab;
        public long hac;
        public long had;
        public List<C0640a> hae;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C0640a {
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
                this.hae = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0640a c0640a = new C0640a();
                    c0640a.dP(optJSONArray.optJSONObject(i));
                    this.hae.add(c0640a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.gZX = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.hab = jSONObject.optString("guard_seat_user");
            }
            this.gZY = jSONObject.optString("frame_pic");
            this.gZZ = jSONObject.optString("time_text");
            this.haa = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.countdown = jSONObject.optLong("count_down");
            this.hac = jSONObject.optLong("effect_time");
            this.had = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public List<C0642b> aEK;
        public C0641a haf;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C0642b {
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
        /* loaded from: classes10.dex */
        public static class C0641a {
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
                    this.aEK = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0642b c0642b = new C0642b();
                        c0642b.dS(optJSONArray.optJSONObject(i));
                        this.aEK.add(c0642b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.haf = new C0641a();
                    this.haf.dR(optJSONObject);
                }
            }
        }
    }
}
