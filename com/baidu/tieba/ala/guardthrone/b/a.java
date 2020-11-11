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
    public C0651a gJU;
    public b gJV;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.gJU = new C0651a();
                this.gJU.dJ(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.gJV = new b();
                this.gJV.dL(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0651a {
        public long bvC;
        public String gJW;
        public String gJX;
        public String gJY;
        public String gJZ;
        public String gKa;
        public long gKb;
        public long gKc;
        public List<C0652a> gKd;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0652a {
            public String pic;
            public String text;

            public void dK(JSONObject jSONObject) {
                this.pic = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
                this.text = jSONObject.optString("text");
            }
        }

        public void dJ(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.gKd = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0652a c0652a = new C0652a();
                    c0652a.dK(optJSONArray.optJSONObject(i));
                    this.gKd.add(c0652a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.gJW = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.gKa = jSONObject.optString("guard_seat_user");
            }
            this.gJX = jSONObject.optString("frame_pic");
            this.gJY = jSONObject.optString("time_text");
            this.gJZ = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.bvC = jSONObject.optLong("count_down");
            this.gKb = jSONObject.optLong("effect_time");
            this.gKc = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public List<C0654b> aIb;
        public C0653a gKe;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0654b {
            public String nickname;
            public String portrait;
            public String rank;
            public String score;

            public void dN(JSONObject jSONObject) {
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

            public void dM(JSONObject jSONObject) {
                this.rank = jSONObject.optInt("rank");
                this.text = jSONObject.optString("bottom_text");
            }
        }

        public void dL(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.aIb = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0654b c0654b = new C0654b();
                        c0654b.dN(optJSONArray.optJSONObject(i));
                        this.aIb.add(c0654b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.gKe = new C0653a();
                    this.gKe.dM(optJSONObject);
                }
            }
        }
    }
}
