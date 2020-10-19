package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public C0611a gjD;
    public b gjE;
    public b gjF;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.gjD = new C0611a();
                this.gjD.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.gjE = new b();
                this.gjE.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.gjF = new b();
                this.gjF.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0611a {
        public String gjG;
        public String gjH;
        public String gjI;
        public long gjJ;
        public long gjK;
        public String gjL;
        public String gjM;

        public C0611a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.gjG = jSONObject.optString("pk_id");
            this.gjH = jSONObject.optString("pk_ret");
            this.gjI = jSONObject.optString("pk_ret_type");
            this.gjJ = jSONObject.optLong("anchor_score", 0L);
            this.gjK = jSONObject.optLong("rival_score", 0L);
            this.gjL = jSONObject.optString("continue_status");
            this.gjM = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public String gjO;
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
            this.gjO = jSONObject.optString("user_status");
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
