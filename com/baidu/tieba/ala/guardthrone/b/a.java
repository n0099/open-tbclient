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
    public C0552a fNh;
    public b fNi;
    public int status;

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.status = jSONObject.optInt("status");
            JSONObject optJSONObject = jSONObject.optJSONObject("config");
            if (optJSONObject != null) {
                this.fNh = new C0552a();
                this.fNh.cY(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("rank");
            if (optJSONObject2 != null) {
                this.fNi = new b();
                this.fNi.da(optJSONObject2);
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0552a {
        public String fNj;
        public String fNk;
        public String fNl;
        public String fNm;
        public String fNn;
        public long fNo;
        public long fNp;
        public long fNq;
        public List<C0553a> fNr;
        public long startTime;
        public String username;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0553a {
            public String pic;
            public String text;

            public void cZ(JSONObject jSONObject) {
                this.pic = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
                this.text = jSONObject.optString("text");
            }
        }

        public void cY(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.fNr = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0553a c0553a = new C0553a();
                    c0553a.cZ(optJSONArray.optJSONObject(i));
                    this.fNr.add(c0553a);
                }
            }
            if (!jSONObject.isNull("portrait")) {
                this.fNj = jSONObject.optString("portrait");
            }
            if (!jSONObject.isNull("user_name")) {
                this.username = jSONObject.optString("user_name");
            }
            if (!jSONObject.isNull("guard_seat_user")) {
                this.fNn = jSONObject.optString("guard_seat_user");
            }
            this.fNk = jSONObject.optString("frame_pic");
            this.fNl = jSONObject.optString("time_text");
            this.fNm = jSONObject.optString("rule_url");
            this.startTime = jSONObject.optLong("start_time");
            this.fNo = jSONObject.optLong("count_down");
            this.fNp = jSONObject.optLong("effect_time");
            this.fNq = jSONObject.optLong("polling_time");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public C0554a fNs;
        public List<C0555b> fNt;

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0555b {
            public String nickname;
            public String portrait;
            public String rank;
            public String score;

            public void dc(JSONObject jSONObject) {
                this.rank = jSONObject.optString("rank");
                this.nickname = jSONObject.optString("user_nickname");
                this.score = jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
                this.portrait = jSONObject.optString("portrait");
            }
        }

        /* renamed from: com.baidu.tieba.ala.guardthrone.b.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0554a {
            public int rank;
            public String text;

            public void db(JSONObject jSONObject) {
                this.rank = jSONObject.optInt("rank");
                this.text = jSONObject.optString("bottom_text");
            }
        }

        public void da(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("list");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.fNt = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        C0555b c0555b = new C0555b();
                        c0555b.dc(optJSONArray.optJSONObject(i));
                        this.fNt.add(c0555b);
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("info");
                if (optJSONObject != null) {
                    this.fNs = new C0554a();
                    this.fNs.db(optJSONObject);
                }
            }
        }
    }
}
