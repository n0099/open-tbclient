package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public C0342a dGN;
    public b dGO;
    public b dGP;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.dGN = new C0342a();
                this.dGN.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.dGO = new b();
                this.dGO.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.dGP = new b();
                this.dGP.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0342a {
        public String dGQ;
        public String dGR;
        public String dGS;
        public long dGT;
        public long dGU;
        public String dGV;
        public String dGW;

        public C0342a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.dGQ = jSONObject.optString("pk_id");
            this.dGR = jSONObject.optString("pk_ret");
            this.dGS = jSONObject.optString("pk_ret_type");
            this.dGT = jSONObject.optLong("anchor_score", 0L);
            this.dGU = jSONObject.optLong("rival_score", 0L);
            this.dGV = jSONObject.optString("continue_status");
            this.dGW = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes6.dex */
    public class b {
        public String dGY;
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
            this.dGY = jSONObject.optString("user_status");
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
