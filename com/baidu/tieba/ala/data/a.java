package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public C0598a fTV;
    public b fTW;
    public b fTX;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.fTV = new C0598a();
                this.fTV.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.fTW = new b();
                this.fTW.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.fTX = new b();
                this.fTX.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0598a {
        public String fTY;
        public String fTZ;
        public String fUa;
        public long fUb;
        public long fUc;
        public String fUd;
        public String fUe;

        public C0598a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.fTY = jSONObject.optString("pk_id");
            this.fTZ = jSONObject.optString("pk_ret");
            this.fUa = jSONObject.optString("pk_ret_type");
            this.fUb = jSONObject.optLong("anchor_score", 0L);
            this.fUc = jSONObject.optLong("rival_score", 0L);
            this.fUd = jSONObject.optString("continue_status");
            this.fUe = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        public String fUg;
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
            this.fUg = jSONObject.optString("user_status");
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
