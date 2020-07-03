package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public C0541a fDh;
    public b fDi;
    public b fDj;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.fDh = new C0541a();
                this.fDh.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.fDi = new b();
                this.fDi.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.fDj = new b();
                this.fDj.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0541a {
        public String fDk;
        public String fDl;
        public String fDm;
        public long fDn;
        public long fDo;
        public String fDp;
        public String fDq;

        public C0541a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.fDk = jSONObject.optString("pk_id");
            this.fDl = jSONObject.optString("pk_ret");
            this.fDm = jSONObject.optString("pk_ret_type");
            this.fDn = jSONObject.optLong("anchor_score", 0L);
            this.fDo = jSONObject.optLong("rival_score", 0L);
            this.fDp = jSONObject.optString("continue_status");
            this.fDq = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public String fDs;
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
            this.fDs = jSONObject.optString("user_status");
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
