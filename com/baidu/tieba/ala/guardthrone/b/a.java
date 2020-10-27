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
    public C0639a gEh;
    public b gEi;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.gEh = new C0639a();
                this.gEh.dD(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.gEi = new b();
                this.gEi.dF(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0639a {
        public long bCa;
        public String gEj;
        public String gEk;
        public String gEl;
        public String gEm;
        public String gEn;
        public long gEo;
        public long gEp;
        public List<C0640a> gEq;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0640a {
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
                this.gEq = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0640a c0640a = new C0640a();
                    c0640a.dE(optJSONArray.optJSONObject(i));
                    this.gEq.add(c0640a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.gEj = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.gEn = jSONObject.optString("guard_seat_user");
            }
            this.gEk = jSONObject.optString("frame_pic");
            this.gEl = jSONObject.optString("time_text");
            this.gEm = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.bCa = jSONObject.optLong("count_down");
            this.gEo = jSONObject.optLong("effect_time");
            this.gEp = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public List<C0642b> aHk;
        public C0641a gEr;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0642b {
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
        public static class C0641a {
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
                    this.aHk = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0642b c0642b = new C0642b();
                        c0642b.dH(optJSONArray.optJSONObject(i));
                        this.aHk.add(c0642b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.gEr = new C0641a();
                    this.gEr.dG(optJSONObject);
                }
            }
        }
    }
}
