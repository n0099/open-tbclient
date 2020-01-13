package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public C0418a euL;
    public b euM;
    public b euN;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.euL = new C0418a();
                this.euL.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.euM = new b();
                this.euM.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.euN = new b();
                this.euN.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0418a {
        public String euO;
        public String euP;
        public String euQ;
        public long euR;
        public long euS;
        public String euT;
        public String euU;

        public C0418a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.euO = jSONObject.optString("pk_id");
            this.euP = jSONObject.optString("pk_ret");
            this.euQ = jSONObject.optString("pk_ret_type");
            this.euR = jSONObject.optLong("anchor_score", 0L);
            this.euS = jSONObject.optLong("rival_score", 0L);
            this.euT = jSONObject.optString("continue_status");
            this.euU = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public String euW;
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
            this.euW = jSONObject.optString("user_status");
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
