package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public C0598a fTR;
    public b fTS;
    public b fTT;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.fTR = new C0598a();
                this.fTR.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.fTS = new b();
                this.fTS.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.fTT = new b();
                this.fTT.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0598a {
        public String fTU;
        public String fTV;
        public String fTW;
        public long fTX;
        public long fTY;
        public String fTZ;
        public String fUa;

        public C0598a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.fTU = jSONObject.optString("pk_id");
            this.fTV = jSONObject.optString("pk_ret");
            this.fTW = jSONObject.optString("pk_ret_type");
            this.fTX = jSONObject.optLong("anchor_score", 0L);
            this.fTY = jSONObject.optLong("rival_score", 0L);
            this.fTZ = jSONObject.optString("continue_status");
            this.fUa = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes7.dex */
    public class b {
        public String fUc;
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
            this.fUc = jSONObject.optString("user_status");
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
