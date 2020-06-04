package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public C0533a frW;
    public b frX;
    public b frY;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.frW = new C0533a();
                this.frW.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.frX = new b();
                this.frX.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.frY = new b();
                this.frY.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0533a {
        public String frZ;
        public String fsa;
        public String fsb;
        public long fsc;
        public long fsd;
        public String fse;
        public String fsf;

        public C0533a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.frZ = jSONObject.optString("pk_id");
            this.fsa = jSONObject.optString("pk_ret");
            this.fsb = jSONObject.optString("pk_ret_type");
            this.fsc = jSONObject.optLong("anchor_score", 0L);
            this.fsd = jSONObject.optLong("rival_score", 0L);
            this.fse = jSONObject.optString("continue_status");
            this.fsf = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public String fsh;
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
            this.fsh = jSONObject.optString("user_status");
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
