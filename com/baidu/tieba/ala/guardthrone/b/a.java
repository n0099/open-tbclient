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
    public C0606a ghO;
    public b ghP;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.ghO = new C0606a();
                this.ghO.dt(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.ghP = new b();
                this.ghP.dv(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0606a {
        public String ghQ;
        public String ghR;
        public String ghS;
        public String ghT;
        public String ghU;
        public long ghV;
        public long ghW;
        public long ghX;
        public List<C0607a> ghY;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0607a {
            public String pic;
            public String text;

            public void du(JSONObject jSONObject) {
                this.pic = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
                this.text = jSONObject.optString("text");
            }
        }

        public void dt(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.ghY = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0607a c0607a = new C0607a();
                    c0607a.du(optJSONArray.optJSONObject(i));
                    this.ghY.add(c0607a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.ghQ = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.ghU = jSONObject.optString("guard_seat_user");
            }
            this.ghR = jSONObject.optString("frame_pic");
            this.ghS = jSONObject.optString("time_text");
            this.ghT = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.ghV = jSONObject.optLong("count_down");
            this.ghW = jSONObject.optLong("effect_time");
            this.ghX = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public List<C0609b> aDV;
        public C0608a ghZ;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0609b {
            public String nickname;
            public String portrait;
            public String rank;
            public String score;

            public void dx(JSONObject jSONObject) {
                this.rank = jSONObject.optString("rank");
                this.nickname = jSONObject.optString("user_nickname");
                this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.portrait = jSONObject.optString("portrait");
            }
        }

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0608a {
            public int rank;
            public String text;

            public void dw(JSONObject jSONObject) {
                this.rank = jSONObject.optInt("rank");
                this.text = jSONObject.optString("bottom_text");
            }
        }

        public void dv(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.aDV = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0609b c0609b = new C0609b();
                        c0609b.dx(optJSONArray.optJSONObject(i));
                        this.aDV.add(c0609b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.ghZ = new C0608a();
                    this.ghZ.dw(optJSONObject);
                }
            }
        }
    }
}
