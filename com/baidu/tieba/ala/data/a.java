package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public C0429a ezl;
    public b ezm;
    public b ezn;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.ezl = new C0429a();
                this.ezl.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.ezm = new b();
                this.ezm.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.ezn = new b();
                this.ezn.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0429a {
        public String ezo;
        public String ezp;
        public String ezq;
        public long ezr;
        public long ezs;
        public String ezt;
        public String ezu;

        public C0429a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.ezo = jSONObject.optString("pk_id");
            this.ezp = jSONObject.optString("pk_ret");
            this.ezq = jSONObject.optString("pk_ret_type");
            this.ezr = jSONObject.optLong("anchor_score", 0L);
            this.ezs = jSONObject.optLong("rival_score", 0L);
            this.ezt = jSONObject.optString("continue_status");
            this.ezu = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public String ezw;
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
            this.ezw = jSONObject.optString("user_status");
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
