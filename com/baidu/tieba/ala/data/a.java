package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public C0337a dFW;
    public b dFX;
    public b dFY;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.dFW = new C0337a();
                this.dFW.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.dFX = new b();
                this.dFX.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.dFY = new b();
                this.dFY.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0337a {
        public String dFZ;
        public String dGa;
        public String dGb;
        public long dGc;
        public long dGd;
        public String dGe;
        public String dGf;

        public C0337a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.dFZ = jSONObject.optString("pk_id");
            this.dGa = jSONObject.optString("pk_ret");
            this.dGb = jSONObject.optString("pk_ret_type");
            this.dGc = jSONObject.optLong("anchor_score", 0L);
            this.dGd = jSONObject.optLong("rival_score", 0L);
            this.dGe = jSONObject.optString("continue_status");
            this.dGf = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes6.dex */
    public class b {
        public String dGh;
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
            this.dGh = jSONObject.optString("user_status");
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
