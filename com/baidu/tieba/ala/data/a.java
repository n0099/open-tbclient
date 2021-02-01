package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    public C0625a gRR;
    public b gRS;
    public b gRT;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.gRR = new C0625a();
                this.gRR.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.gRS = new b();
                this.gRS.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.gRT = new b();
                this.gRT.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0625a {
        public String gRU;
        public String gRV;
        public String gRW;
        public long gRX;
        public long gRY;
        public String gRZ;
        public String gSa;

        public C0625a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.gRU = jSONObject.optString("pk_id");
            this.gRV = jSONObject.optString("pk_ret");
            this.gRW = jSONObject.optString("pk_ret_type");
            this.gRX = jSONObject.optLong("anchor_score", 0L);
            this.gRY = jSONObject.optLong("rival_score", 0L);
            this.gRZ = jSONObject.optString("continue_status");
            this.gSa = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes11.dex */
    public class b {
        public String gSc;
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
            this.gSc = jSONObject.optString("user_status");
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
