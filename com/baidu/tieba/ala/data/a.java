package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public C0632a gTO;
    public b gTP;
    public b gTQ;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.gTO = new C0632a();
                this.gTO.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.gTP = new b();
                this.gTP.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.gTQ = new b();
                this.gTQ.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0632a {
        public String gTR;
        public String gTS;
        public String gTT;
        public long gTU;
        public long gTV;
        public String gTW;
        public String gTX;

        public C0632a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.gTR = jSONObject.optString("pk_id");
            this.gTS = jSONObject.optString("pk_ret");
            this.gTT = jSONObject.optString("pk_ret_type");
            this.gTU = jSONObject.optLong("anchor_score", 0L);
            this.gTV = jSONObject.optLong("rival_score", 0L);
            this.gTW = jSONObject.optString("continue_status");
            this.gTX = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes10.dex */
    public class b {
        public String gTZ;
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
            this.gTZ = jSONObject.optString("user_status");
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
