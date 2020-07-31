package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public C0552a fIA;
    public b fIB;
    public b fIC;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.fIA = new C0552a();
                this.fIA.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.fIB = new b();
                this.fIB.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.fIC = new b();
                this.fIC.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0552a {
        public String fID;
        public String fIE;
        public String fIF;
        public long fIG;
        public long fIH;
        public String fII;
        public String fIJ;

        public C0552a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.fID = jSONObject.optString("pk_id");
            this.fIE = jSONObject.optString("pk_ret");
            this.fIF = jSONObject.optString("pk_ret_type");
            this.fIG = jSONObject.optLong("anchor_score", 0L);
            this.fIH = jSONObject.optLong("rival_score", 0L);
            this.fII = jSONObject.optString("continue_status");
            this.fIJ = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public String fIL;
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
            this.fIL = jSONObject.optString("user_status");
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
