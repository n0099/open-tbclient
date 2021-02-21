package com.baidu.tieba.ala.guardthrone.b;

import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public C0640a hcT;
    public b hcU;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.hcT = new C0640a();
                this.hcT.dP(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.hcU = new b();
                this.hcU.dR(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0640a {
        public long countdown;
        public String hcV;
        public String hcW;
        public String hcX;
        public String hcY;
        public String hcZ;
        public long hda;
        public long hdb;
        public List<C0641a> hdc;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C0641a {
            public String pic;
            public String text;

            public void dQ(JSONObject jSONObject) {
                this.pic = jSONObject.optString("pic");
                this.text = jSONObject.optString("text");
            }
        }

        public void dP(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.hdc = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0641a c0641a = new C0641a();
                    c0641a.dQ(optJSONArray.optJSONObject(i));
                    this.hdc.add(c0641a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.hcV = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.hcZ = jSONObject.optString("guard_seat_user");
            }
            this.hcW = jSONObject.optString("frame_pic");
            this.hcX = jSONObject.optString("time_text");
            this.hcY = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.countdown = jSONObject.optLong("count_down");
            this.hda = jSONObject.optLong("effect_time");
            this.hdb = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public List<C0643b> aGx;
        public C0642a hdd;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C0643b {
            public String nickname;
            public String portrait;
            public String rank;
            public String score;

            public void dT(JSONObject jSONObject) {
                this.rank = jSONObject.optString("rank");
                this.nickname = jSONObject.optString("user_nickname");
                this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.portrait = jSONObject.optString("portrait");
            }
        }

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public static class C0642a {
            public int rank;
            public String text;

            public void dS(JSONObject jSONObject) {
                this.rank = jSONObject.optInt("rank");
                this.text = jSONObject.optString("bottom_text");
            }
        }

        public void dR(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.aGx = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0643b c0643b = new C0643b();
                        c0643b.dT(optJSONArray.optJSONObject(i));
                        this.aGx.add(c0643b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.hdd = new C0642a();
                    this.hdd.dS(optJSONObject);
                }
            }
        }
    }
}
