package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public C0429a ezH;
    public b ezI;
    public b ezJ;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.ezH = new C0429a();
                this.ezH.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.ezI = new b();
                this.ezI.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.ezJ = new b();
                this.ezJ.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0429a {
        public String ezK;
        public String ezL;
        public String ezM;
        public long ezN;
        public long ezO;
        public String ezP;
        public String ezQ;

        public C0429a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.ezK = jSONObject.optString("pk_id");
            this.ezL = jSONObject.optString("pk_ret");
            this.ezM = jSONObject.optString("pk_ret_type");
            this.ezN = jSONObject.optLong("anchor_score", 0L);
            this.ezO = jSONObject.optLong("rival_score", 0L);
            this.ezP = jSONObject.optString("continue_status");
            this.ezQ = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public String ezS;
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
            this.ezS = jSONObject.optString("user_status");
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
