package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public C0627a gtJ;
    public b gtK;
    public b gtL;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.gtJ = new C0627a();
                this.gtJ.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.gtK = new b();
                this.gtK.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.gtL = new b();
                this.gtL.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0627a {
        public String gtM;
        public String gtN;
        public String gtO;
        public long gtP;
        public long gtQ;
        public String gtR;
        public String gtS;

        public C0627a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.gtM = jSONObject.optString("pk_id");
            this.gtN = jSONObject.optString("pk_ret");
            this.gtO = jSONObject.optString("pk_ret_type");
            this.gtP = jSONObject.optLong("anchor_score", 0L);
            this.gtQ = jSONObject.optLong("rival_score", 0L);
            this.gtR = jSONObject.optString("continue_status");
            this.gtS = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public String gtU;
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
            this.gtU = jSONObject.optString("user_status");
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
