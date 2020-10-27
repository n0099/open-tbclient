package com.baidu.tieba.ala.alaar.messages;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.makeup.e;
import com.baidu.tieba.ala.alaar.makeup.h;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaMakeupResponseMessage extends JsonHttpResponsedMessage {
    private String fWg;
    private com.baidu.tieba.ala.alaar.makeup.a.c fWi;

    public AlaMakeupResponseMessage() {
        super(1021214);
    }

    public com.baidu.tieba.ala.alaar.makeup.a.c bKx() {
        return this.fWi;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (h.isDebug()) {
            h.d("MKNetLoader", "decodeLogicInBackGround: " + jSONObject);
        }
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.fWg)) {
                this.fWg = com.baidu.live.d.AZ().getString("sp_ar_makeup_result", "");
            }
            if (!TextUtils.isEmpty(this.fWg)) {
                jSONObject = new JSONObject(this.fWg);
            }
        } else {
            this.fWg = jSONObject.toString();
            if (!TextUtils.isEmpty(this.fWg)) {
                com.baidu.live.d.AZ().putString("sp_ar_makeup_result", this.fWg);
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.fWi = new com.baidu.tieba.ala.alaar.makeup.a.c(e.bKt());
            this.fWi.dt(optJSONObject);
            if (h.isDebug()) {
                h.d("MKNetLoader", "decodeLogicInBackGround-size: " + this.fWi.size());
            }
        }
    }
}
