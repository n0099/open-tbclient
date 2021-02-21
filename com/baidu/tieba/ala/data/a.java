package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public C0626a gSf;
    public b gSg;
    public b gSh;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.gSf = new C0626a();
                this.gSf.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.gSg = new b();
                this.gSg.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.gSh = new b();
                this.gSh.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0626a {
        public String gSi;
        public String gSj;
        public String gSk;
        public long gSl;
        public long gSm;
        public String gSn;
        public String gSo;

        public C0626a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.gSi = jSONObject.optString("pk_id");
            this.gSj = jSONObject.optString("pk_ret");
            this.gSk = jSONObject.optString("pk_ret_type");
            this.gSl = jSONObject.optLong("anchor_score", 0L);
            this.gSm = jSONObject.optLong("rival_score", 0L);
            this.gSn = jSONObject.optString("continue_status");
            this.gSo = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes11.dex */
    public class b {
        public String gSq;
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
            this.gSq = jSONObject.optString("user_status");
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
