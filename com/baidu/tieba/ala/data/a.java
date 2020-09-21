package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public C0594a fXk;
    public b fXl;
    public b fXm;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.fXk = new C0594a();
                this.fXk.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.fXl = new b();
                this.fXl.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.fXm = new b();
                this.fXm.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0594a {
        public String fXn;
        public String fXo;
        public String fXp;
        public long fXq;
        public long fXr;
        public String fXs;
        public String fXt;

        public C0594a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.fXn = jSONObject.optString("pk_id");
            this.fXo = jSONObject.optString("pk_ret");
            this.fXp = jSONObject.optString("pk_ret_type");
            this.fXq = jSONObject.optLong("anchor_score", 0L);
            this.fXr = jSONObject.optLong("rival_score", 0L);
            this.fXs = jSONObject.optString("continue_status");
            this.fXt = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public String fXv;
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
            this.fXv = jSONObject.optString("user_status");
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
