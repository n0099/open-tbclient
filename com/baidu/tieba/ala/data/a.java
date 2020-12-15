package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public C0652a gIc;
    public b gId;
    public b gIe;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.gIc = new C0652a();
                this.gIc.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.gId = new b();
                this.gId.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.gIe = new b();
                this.gIe.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0652a {
        public String gIf;
        public String gIg;
        public String gIh;
        public long gIi;
        public long gIj;
        public String gIk;
        public String gIl;

        public C0652a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.gIf = jSONObject.optString("pk_id");
            this.gIg = jSONObject.optString("pk_ret");
            this.gIh = jSONObject.optString("pk_ret_type");
            this.gIi = jSONObject.optLong("anchor_score", 0L);
            this.gIj = jSONObject.optLong("rival_score", 0L);
            this.gIk = jSONObject.optString("continue_status");
            this.gIl = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public String gIn;
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
            this.gIn = jSONObject.optString("user_status");
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
