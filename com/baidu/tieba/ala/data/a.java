package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public C0639a gzx;
    public b gzy;
    public b gzz;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.gzx = new C0639a();
                this.gzx.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.gzy = new b();
                this.gzy.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.gzz = new b();
                this.gzz.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0639a {
        public String gzA;
        public String gzB;
        public String gzC;
        public long gzD;
        public long gzE;
        public String gzF;
        public String gzG;

        public C0639a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.gzA = jSONObject.optString("pk_id");
            this.gzB = jSONObject.optString("pk_ret");
            this.gzC = jSONObject.optString("pk_ret_type");
            this.gzD = jSONObject.optLong("anchor_score", 0L);
            this.gzE = jSONObject.optLong("rival_score", 0L);
            this.gzF = jSONObject.optString("continue_status");
            this.gzG = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public String gzI;
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
            this.gzI = jSONObject.optString("user_status");
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
