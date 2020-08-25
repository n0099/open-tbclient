package com.baidu.tieba.ala.guardthrone.b;

import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public b geA;
    public C0610a gez;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.gez = new C0610a();
                this.gez.dn(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.geA = new b();
                this.geA.dp(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0610a {
        public String geB;
        public String geC;
        public String geD;
        public String geE;
        public String geF;
        public long geG;
        public long geH;
        public long geI;
        public List<C0611a> geJ;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0611a {
            public String pic;
            public String text;

            /* renamed from: do  reason: not valid java name */
            public void m41do(JSONObject jSONObject) {
                this.pic = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
                this.text = jSONObject.optString("text");
            }
        }

        public void dn(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.geJ = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0611a c0611a = new C0611a();
                    c0611a.m41do(optJSONArray.optJSONObject(i));
                    this.geJ.add(c0611a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.geB = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.geF = jSONObject.optString("guard_seat_user");
            }
            this.geC = jSONObject.optString("frame_pic");
            this.geD = jSONObject.optString("time_text");
            this.geE = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.geG = jSONObject.optLong("count_down");
            this.geH = jSONObject.optLong("effect_time");
            this.geI = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public C0612a geK;
        public List<C0613b> geL;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0613b {
            public String nickname;
            public String portrait;
            public String rank;
            public String score;

            public void dr(JSONObject jSONObject) {
                this.rank = jSONObject.optString("rank");
                this.nickname = jSONObject.optString("user_nickname");
                this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.portrait = jSONObject.optString("portrait");
            }
        }

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0612a {
            public int rank;
            public String text;

            public void dq(JSONObject jSONObject) {
                this.rank = jSONObject.optInt("rank");
                this.text = jSONObject.optString("bottom_text");
            }
        }

        public void dp(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.geL = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0613b c0613b = new C0613b();
                        c0613b.dr(optJSONArray.optJSONObject(i));
                        this.geL.add(c0613b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.geK = new C0612a();
                    this.geK.dq(optJSONObject);
                }
            }
        }
    }
}
