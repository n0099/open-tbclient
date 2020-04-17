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
    public C0476a fnV;
    public b fnW;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.fnV = new C0476a();
                this.fnV.cI(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.fnW = new b();
                this.fnW.cK(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0476a {
        public String fnX;
        public String fnY;
        public String fnZ;
        public String foa;
        public String fob;
        public long foc;
        public long fod;
        public long foe;
        public List<C0477a> fof;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0477a {
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
                this.fof = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0477a c0477a = new C0477a();
                    c0477a.cJ(optJSONArray.optJSONObject(i));
                    this.fof.add(c0477a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.fnX = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.fob = jSONObject.optString("guard_seat_user");
            }
            this.fnY = jSONObject.optString("frame_pic");
            this.fnZ = jSONObject.optString("time_text");
            this.foa = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.foc = jSONObject.optLong("count_down");
            this.fod = jSONObject.optLong("effect_time");
            this.foe = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public C0478a fog;
        public List<C0479b> foh;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0479b {
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
        public static class C0478a {
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
                    this.foh = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0479b c0479b = new C0479b();
                        c0479b.cM(optJSONArray.optJSONObject(i));
                        this.foh.add(c0479b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.fog = new C0478a();
                    this.fog.cL(optJSONObject);
                }
            }
        }
    }
}
