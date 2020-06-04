package com.baidu.tieba.ala.guardthrone.b;

import com.baidu.ar.gesture.GestureAR;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public C0544a fBY;
    public b fBZ;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.fBY = new C0544a();
                this.fBY.cP(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.fBZ = new b();
                this.fBZ.cR(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0544a {
        public String fCa;
        public String fCb;
        public String fCc;
        public String fCd;
        public String fCe;
        public long fCf;
        public long fCg;
        public long fCh;
        public List<C0545a> fCi;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0545a {
            public String pic;
            public String text;

            public void cQ(JSONObject jSONObject) {
                this.pic = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
                this.text = jSONObject.optString("text");
            }
        }

        public void cP(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.fCi = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0545a c0545a = new C0545a();
                    c0545a.cQ(optJSONArray.optJSONObject(i));
                    this.fCi.add(c0545a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.fCa = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.fCe = jSONObject.optString("guard_seat_user");
            }
            this.fCb = jSONObject.optString("frame_pic");
            this.fCc = jSONObject.optString("time_text");
            this.fCd = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.fCf = jSONObject.optLong("count_down");
            this.fCg = jSONObject.optLong("effect_time");
            this.fCh = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public C0546a fCj;
        public List<C0547b> fCk;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0547b {
            public String nickname;
            public String portrait;
            public String rank;
            public String score;

            public void cT(JSONObject jSONObject) {
                this.rank = jSONObject.optString("rank");
                this.nickname = jSONObject.optString("user_nickname");
                this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.portrait = jSONObject.optString("portrait");
            }
        }

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0546a {
            public int rank;
            public String text;

            public void cS(JSONObject jSONObject) {
                this.rank = jSONObject.optInt("rank");
                this.text = jSONObject.optString("bottom_text");
            }
        }

        public void cR(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.fCk = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0547b c0547b = new C0547b();
                        c0547b.cT(optJSONArray.optJSONObject(i));
                        this.fCk.add(c0547b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.fCj = new C0546a();
                    this.fCj.cS(optJSONObject);
                }
            }
        }
    }
}
