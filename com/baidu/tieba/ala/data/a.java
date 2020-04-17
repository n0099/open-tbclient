package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public C0464a feb;
    public b fec;
    public b fed;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.feb = new C0464a();
                this.feb.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.fec = new b();
                this.fec.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.fed = new b();
                this.fed.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0464a {
        public String fee;
        public String fef;
        public String feg;
        public long feh;
        public long fei;
        public String fej;
        public String fek;

        public C0464a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.fee = jSONObject.optString("pk_id");
            this.fef = jSONObject.optString("pk_ret");
            this.feg = jSONObject.optString("pk_ret_type");
            this.feh = jSONObject.optLong("anchor_score", 0L);
            this.fei = jSONObject.optLong("rival_score", 0L);
            this.fej = jSONObject.optString("continue_status");
            this.fek = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public String fem;
        public String pass_name;
        public String portrait;
        public String sex;
        public String user_id;
        public String user_name;

        public b() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.user_id = jSONObject.optString("user_id");
            this.user_name = jSONObject.optString("user_name");
            this.pass_name = jSONObject.optString("pass_name");
            this.fem = jSONObject.optString("user_status");
            this.sex = jSONObject.optString("sex");
            this.portrait = jSONObject.optString("bd_portrait");
            if (StringUtils.isNull(this.portrait)) {
                this.portrait = jSONObject.optString("portrait");
            }
        }

        public String getName_show() {
            return !StringHelper.isEmpty(this.user_name) ? this.user_name : this.pass_name;
        }
    }
}
