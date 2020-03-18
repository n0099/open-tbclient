package com.baidu.tieba.ala.guardthrone.b;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public C0441a eJE;
    public b eJF;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.eJE = new C0441a();
                this.eJE.cx(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.eJF = new b();
                this.eJF.cz(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0441a {
        public String eJG;
        public String eJH;
        public String eJI;
        public String eJJ;
        public String eJK;
        public long eJL;
        public long eJM;
        public long eJN;
        public List<C0442a> eJO;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0442a {
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
                this.eJO = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0442a c0442a = new C0442a();
                    c0442a.cy(optJSONArray.optJSONObject(i));
                    this.eJO.add(c0442a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.eJG = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.eJK = jSONObject.optString("guard_seat_user");
            }
            this.eJH = jSONObject.optString("frame_pic");
            this.eJI = jSONObject.optString("time_text");
            this.eJJ = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.eJL = jSONObject.optLong("count_down");
            this.eJM = jSONObject.optLong("effect_time");
            this.eJN = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public C0443a eJP;
        public List<C0444b> eJQ;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0444b {
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
        /* loaded from: classes3.dex */
        public static class C0443a {
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
                    this.eJQ = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0444b c0444b = new C0444b();
                        c0444b.cB(optJSONArray.optJSONObject(i));
                        this.eJQ.add(c0444b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.eJP = new C0443a();
                    this.eJP.cA(optJSONObject);
                }
            }
        }
    }
}
