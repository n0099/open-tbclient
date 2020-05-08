package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public C0485a feg;
    public b feh;
    public b fei;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.feg = new C0485a();
                this.feg.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.feh = new b();
                this.feh.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.fei = new b();
                this.fei.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0485a {
        public String fej;
        public String fek;
        public String fel;
        public long fem;
        public long fen;
        public String feo;
        public String fep;

        public C0485a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.fej = jSONObject.optString("pk_id");
            this.fek = jSONObject.optString("pk_ret");
            this.fel = jSONObject.optString("pk_ret_type");
            this.fem = jSONObject.optLong("anchor_score", 0L);
            this.fen = jSONObject.optLong("rival_score", 0L);
            this.feo = jSONObject.optString("continue_status");
            this.fep = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public String fer;
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
            this.fer = jSONObject.optString("user_status");
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
