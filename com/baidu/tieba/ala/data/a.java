package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public C0652a gIa;
    public b gIb;
    public b gIc;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.gIa = new C0652a();
                this.gIa.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.gIb = new b();
                this.gIb.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.gIc = new b();
                this.gIc.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0652a {
        public String gId;
        public String gIe;
        public String gIf;
        public long gIg;
        public long gIh;
        public String gIi;
        public String gIj;

        public C0652a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.gId = jSONObject.optString("pk_id");
            this.gIe = jSONObject.optString("pk_ret");
            this.gIf = jSONObject.optString("pk_ret_type");
            this.gIg = jSONObject.optLong("anchor_score", 0L);
            this.gIh = jSONObject.optLong("rival_score", 0L);
            this.gIi = jSONObject.optString("continue_status");
            this.gIj = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public String gIl;
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
            this.gIl = jSONObject.optString("user_status");
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
