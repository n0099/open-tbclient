package com.baidu.tieba.ala.alaar.messages;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.makeup.e;
import com.baidu.tieba.ala.alaar.makeup.h;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaMakeupResponseMessage extends JsonHttpResponsedMessage {
    private String gss;
    private com.baidu.tieba.ala.alaar.makeup.a.c gsu;

    public AlaMakeupResponseMessage() {
        super(1021214);
    }

    public com.baidu.tieba.ala.alaar.makeup.a.c bPo() {
        return this.gsu;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (h.isDebug()) {
            h.d("MKNetLoader", "decodeLogicInBackGround: " + jSONObject);
        }
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.gss)) {
                this.gss = com.baidu.live.d.xc().getString("sp_ar_makeup_result", "");
            }
            if (!TextUtils.isEmpty(this.gss)) {
                jSONObject = new JSONObject(this.gss);
            }
        } else {
            this.gss = jSONObject.toString();
            if (!TextUtils.isEmpty(this.gss)) {
                com.baidu.live.d.xc().putString("sp_ar_makeup_result", this.gss);
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.gsu = new com.baidu.tieba.ala.alaar.makeup.a.c(e.bPk());
            this.gsu.dE(optJSONObject);
            if (h.isDebug()) {
                h.d("MKNetLoader", "decodeLogicInBackGround-size: " + this.gsu.size());
            }
        }
    }
}
