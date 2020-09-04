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
    public C0610a geD;
    public b geE;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.geD = new C0610a();
                this.geD.dn(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.geE = new b();
                this.geE.dp(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0610a {
        public String geF;
        public String geG;
        public String geH;
        public String geI;
        public String geJ;
        public long geK;
        public long geL;
        public long geM;
        public List<C0611a> geN;
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
                this.geN = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0611a c0611a = new C0611a();
                    c0611a.m41do(optJSONArray.optJSONObject(i));
                    this.geN.add(c0611a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.geF = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.geJ = jSONObject.optString("guard_seat_user");
            }
            this.geG = jSONObject.optString("frame_pic");
            this.geH = jSONObject.optString("time_text");
            this.geI = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.geK = jSONObject.optLong("count_down");
            this.geL = jSONObject.optLong("effect_time");
            this.geM = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public C0612a geO;
        public List<C0613b> geP;

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
                    this.geP = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0613b c0613b = new C0613b();
                        c0613b.dr(optJSONArray.optJSONObject(i));
                        this.geP.add(c0613b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.geO = new C0612a();
                    this.geO.dq(optJSONObject);
                }
            }
        }
    }
}
