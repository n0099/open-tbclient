package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public C0626a gPi;
    public b gPj;
    public b gPk;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.gPi = new C0626a();
                this.gPi.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.gPj = new b();
                this.gPj.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.gPk = new b();
                this.gPk.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0626a {
        public String gPl;
        public String gPm;
        public String gPn;
        public long gPo;
        public long gPp;
        public String gPq;
        public String gPr;

        public C0626a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.gPl = jSONObject.optString("pk_id");
            this.gPm = jSONObject.optString("pk_ret");
            this.gPn = jSONObject.optString("pk_ret_type");
            this.gPo = jSONObject.optLong("anchor_score", 0L);
            this.gPp = jSONObject.optLong("rival_score", 0L);
            this.gPq = jSONObject.optString("continue_status");
            this.gPr = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes10.dex */
    public class b {
        public String gPt;
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
            this.gPt = jSONObject.optString("user_status");
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
