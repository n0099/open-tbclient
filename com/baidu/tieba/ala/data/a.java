package com.baidu.tieba.ala.data;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public C0429a eyX;
    public b eyY;
    public b eyZ;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.optJSONObject("pk_info") != null) {
                this.eyX = new C0429a();
                this.eyX.parseJson(jSONObject.optJSONObject("pk_info"));
            }
            if (jSONObject.optJSONObject("user_info") != null) {
                this.eyY = new b();
                this.eyY.parseJson(jSONObject.optJSONObject("user_info"));
            }
            if (jSONObject.optJSONObject("rival_info") != null) {
                this.eyZ = new b();
                this.eyZ.parseJson(jSONObject.optJSONObject("rival_info"));
            }
        }
    }

    /* renamed from: com.baidu.tieba.ala.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0429a {
        public String eza;
        public String ezb;
        public String ezc;
        public long ezd;
        public long eze;
        public String ezf;
        public String ezg;

        public C0429a() {
        }

        public void parseJson(JSONObject jSONObject) {
            this.eza = jSONObject.optString("pk_id");
            this.ezb = jSONObject.optString("pk_ret");
            this.ezc = jSONObject.optString("pk_ret_type");
            this.ezd = jSONObject.optLong("anchor_score", 0L);
            this.eze = jSONObject.optLong("rival_score", 0L);
            this.ezf = jSONObject.optString("continue_status");
            this.ezg = jSONObject.optString("continue_number");
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public String ezi;
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
            this.ezi = jSONObject.optString("user_status");
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
