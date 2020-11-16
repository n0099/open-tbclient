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
    public C0651a gJB;
    public b gJC;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.gJB = new C0651a();
                this.gJB.dD(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.gJC = new b();
                this.gJC.dF(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0651a {
        public long btQ;
        public String gJD;
        public String gJE;
        public String gJF;
        public String gJG;
        public String gJH;
        public long gJI;
        public long gJJ;
        public List<C0652a> gJK;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0652a {
            public String pic;
            public String text;

            public void dE(JSONObject jSONObject) {
                this.pic = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
                this.text = jSONObject.optString("text");
            }
        }

        public void dD(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.gJK = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0652a c0652a = new C0652a();
                    c0652a.dE(optJSONArray.optJSONObject(i));
                    this.gJK.add(c0652a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.gJD = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.gJH = jSONObject.optString("guard_seat_user");
            }
            this.gJE = jSONObject.optString("frame_pic");
            this.gJF = jSONObject.optString("time_text");
            this.gJG = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.btQ = jSONObject.optLong("count_down");
            this.gJI = jSONObject.optLong("effect_time");
            this.gJJ = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public List<C0654b> aGq;
        public C0653a gJL;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0654b {
            public String nickname;
            public String portrait;
            public String rank;
            public String score;

            public void dH(JSONObject jSONObject) {
                this.rank = jSONObject.optString("rank");
                this.nickname = jSONObject.optString("user_nickname");
                this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.portrait = jSONObject.optString("portrait");
            }
        }

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0653a {
            public int rank;
            public String text;

            public void dG(JSONObject jSONObject) {
                this.rank = jSONObject.optInt("rank");
                this.text = jSONObject.optString("bottom_text");
            }
        }

        public void dF(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.aGq = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0654b c0654b = new C0654b();
                        c0654b.dH(optJSONArray.optJSONObject(i));
                        this.aGq.add(c0654b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.gJL = new C0653a();
                    this.gJL.dG(optJSONObject);
                }
            }
        }
    }
}
