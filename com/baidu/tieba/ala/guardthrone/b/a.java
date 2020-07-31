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
    public C0563a fSA;
    public b fSB;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.fSA = new C0563a();
                this.fSA.de(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.fSB = new b();
                this.fSB.dg(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0563a {
        public String fSC;
        public String fSD;
        public String fSE;
        public String fSF;
        public String fSG;
        public long fSH;
        public long fSI;
        public long fSJ;
        public List<C0564a> fSK;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0564a {
            public String pic;
            public String text;

            public void df(JSONObject jSONObject) {
                this.pic = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
                this.text = jSONObject.optString("text");
            }
        }

        public void de(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.fSK = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0564a c0564a = new C0564a();
                    c0564a.df(optJSONArray.optJSONObject(i));
                    this.fSK.add(c0564a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.fSC = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.fSG = jSONObject.optString("guard_seat_user");
            }
            this.fSD = jSONObject.optString("frame_pic");
            this.fSE = jSONObject.optString("time_text");
            this.fSF = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.fSH = jSONObject.optLong("count_down");
            this.fSI = jSONObject.optLong("effect_time");
            this.fSJ = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public C0565a fSL;
        public List<C0566b> fSM;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0566b {
            public String nickname;
            public String portrait;
            public String rank;
            public String score;

            public void di(JSONObject jSONObject) {
                this.rank = jSONObject.optString("rank");
                this.nickname = jSONObject.optString("user_nickname");
                this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.portrait = jSONObject.optString("portrait");
            }
        }

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0565a {
            public int rank;
            public String text;

            public void dh(JSONObject jSONObject) {
                this.rank = jSONObject.optInt("rank");
                this.text = jSONObject.optString("bottom_text");
            }
        }

        public void dg(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.fSM = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0566b c0566b = new C0566b();
                        c0566b.di(optJSONArray.optJSONObject(i));
                        this.fSM.add(c0566b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.fSL = new C0565a();
                    this.fSL.dh(optJSONObject);
                }
            }
        }
    }
}
