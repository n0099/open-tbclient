package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public C0415a etA;
    public b etB;
    public b etC;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.etA = new C0415a();
                this.etA.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.etB = new b();
                this.etB.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.etC = new b();
                this.etC.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0415a {
        public String etD;
        public String etE;
        public String etF;
        public long etG;
        public long etH;
        public String etI;
        public String etJ;

        public C0415a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.etD = jSONObject.optString("pk_id");
            this.etE = jSONObject.optString("pk_ret");
            this.etF = jSONObject.optString("pk_ret_type");
            this.etG = jSONObject.optLong("anchor_score", 0L);
            this.etH = jSONObject.optLong("rival_score", 0L);
            this.etI = jSONObject.optString("continue_status");
            this.etJ = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public String etL;
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
            this.etL = jSONObject.optString("user_status");
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
