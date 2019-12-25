package com.baidu.tieba.ala.guardthrone.b;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public C0427a eDP;
    public b eDQ;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.eDP = new C0427a();
                this.eDP.cx(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.eDQ = new b();
                this.eDQ.cz(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0427a {
        public String eDR;
        public String eDS;
        public String eDT;
        public String eDU;
        public String eDV;
        public long eDW;
        public long eDX;
        public long eDY;
        public List<C0428a> eDZ;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0428a {
            public String pic;
            public String text;

            public void cy(JSONObject jSONObject) {
                this.pic = jSONObject.optString("pic");
                this.text = jSONObject.optString("text");
            }
        }

        public void cx(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.eDZ = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0428a c0428a = new C0428a();
                    c0428a.cy(optJSONArray.optJSONObject(i));
                    this.eDZ.add(c0428a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.eDR = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.eDV = jSONObject.optString("guard_seat_user");
            }
            this.eDS = jSONObject.optString("frame_pic");
            this.eDT = jSONObject.optString("time_text");
            this.eDU = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.eDW = jSONObject.optLong("count_down");
            this.eDX = jSONObject.optLong("effect_time");
            this.eDY = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public C0429a eEa;
        public List<C0430b> eEb;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0430b {
            public String nickname;
            public String portrait;
            public String rank;
            public String score;

            public void cB(JSONObject jSONObject) {
                this.rank = jSONObject.optString("rank");
                this.nickname = jSONObject.optString("user_nickname");
                this.score = jSONObject.optString("score");
                this.portrait = jSONObject.optString("portrait");
            }
        }

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0429a {
            public int rank;
            public String text;

            public void cA(JSONObject jSONObject) {
                this.rank = jSONObject.optInt("rank");
                this.text = jSONObject.optString("bottom_text");
            }
        }

        public void cz(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.eEb = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0430b c0430b = new C0430b();
                        c0430b.cB(optJSONArray.optJSONObject(i));
                        this.eEb.add(c0430b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.eEa = new C0429a();
                    this.eEa.cA(optJSONObject);
                }
            }
        }
    }
}
