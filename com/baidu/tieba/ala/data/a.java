package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public C0533a frL;
    public b frM;
    public b frN;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.frL = new C0533a();
                this.frL.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.frM = new b();
                this.frM.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.frN = new b();
                this.frN.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0533a {
        public String frO;
        public String frP;
        public String frQ;
        public long frR;
        public long frS;
        public String frT;
        public String frU;

        public C0533a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.frO = jSONObject.optString("pk_id");
            this.frP = jSONObject.optString("pk_ret");
            this.frQ = jSONObject.optString("pk_ret_type");
            this.frR = jSONObject.optLong("anchor_score", 0L);
            this.frS = jSONObject.optLong("rival_score", 0L);
            this.frT = jSONObject.optString("continue_status");
            this.frU = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public String frW;
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
            this.frW = jSONObject.optString("user_status");
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
