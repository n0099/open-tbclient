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
    public C0497a foa;
    public b fob;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.foa = new C0497a();
                this.foa.cI(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.fob = new b();
                this.fob.cK(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0497a {
        public String foc;
        public String fod;
        public String foe;
        public String fof;
        public String fog;
        public long foh;
        public long foi;
        public long foj;
        public List<C0498a> fok;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0498a {
            public String pic;
            public String text;

            public void cJ(JSONObject jSONObject) {
                this.pic = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
                this.text = jSONObject.optString("text");
            }
        }

        public void cI(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.fok = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0498a c0498a = new C0498a();
                    c0498a.cJ(optJSONArray.optJSONObject(i));
                    this.fok.add(c0498a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.foc = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.fog = jSONObject.optString("guard_seat_user");
            }
            this.fod = jSONObject.optString("frame_pic");
            this.foe = jSONObject.optString("time_text");
            this.fof = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.foh = jSONObject.optLong("count_down");
            this.foi = jSONObject.optLong("effect_time");
            this.foj = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public C0499a fol;
        public List<C0500b> fom;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0500b {
            public String nickname;
            public String portrait;
            public String rank;
            public String score;

            public void cM(JSONObject jSONObject) {
                this.rank = jSONObject.optString("rank");
                this.nickname = jSONObject.optString("user_nickname");
                this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.portrait = jSONObject.optString("portrait");
            }
        }

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0499a {
            public int rank;
            public String text;

            public void cL(JSONObject jSONObject) {
                this.rank = jSONObject.optInt("rank");
                this.text = jSONObject.optString("bottom_text");
            }
        }

        public void cK(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.fom = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0500b c0500b = new C0500b();
                        c0500b.cM(optJSONArray.optJSONObject(i));
                        this.fom.add(c0500b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.fol = new C0499a();
                    this.fol.cL(optJSONObject);
                }
            }
        }
    }
}
