package com.baidu.tieba.ala.guardthrone.b;

import com.baidu.live.tbadk.statics.AlaStaticKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public C0430a eFa;
    public b eFb;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.eFa = new C0430a();
                this.eFa.cx(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.eFb = new b();
                this.eFb.cz(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0430a {
        public String eFc;
        public String eFd;
        public String eFe;
        public String eFf;
        public String eFg;
        public long eFh;
        public long eFi;
        public long eFj;
        public List<C0431a> eFk;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0431a {
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
                this.eFk = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0431a c0431a = new C0431a();
                    c0431a.cy(optJSONArray.optJSONObject(i));
                    this.eFk.add(c0431a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.eFc = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.eFg = jSONObject.optString("guard_seat_user");
            }
            this.eFd = jSONObject.optString("frame_pic");
            this.eFe = jSONObject.optString("time_text");
            this.eFf = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.eFh = jSONObject.optLong("count_down");
            this.eFi = jSONObject.optLong("effect_time");
            this.eFj = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public C0432a eFl;
        public List<C0433b> eFm;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0433b {
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
        public static class C0432a {
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
                    this.eFm = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0433b c0433b = new C0433b();
                        c0433b.cB(optJSONArray.optJSONObject(i));
                        this.eFm.add(c0433b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.eFl = new C0432a();
                    this.eFl.cA(optJSONObject);
                }
            }
        }
    }
}
