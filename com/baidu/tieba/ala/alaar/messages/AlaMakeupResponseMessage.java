package com.baidu.tieba.ala.alaar.messages;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.makeup.e;
import com.baidu.tieba.ala.alaar.makeup.h;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaMakeupResponseMessage extends JsonHttpResponsedMessage {
    private String gpJ;
    private com.baidu.tieba.ala.alaar.makeup.a.c gpL;

    public AlaMakeupResponseMessage() {
        super(1021214);
    }

    public com.baidu.tieba.ala.alaar.makeup.a.c bOK() {
        return this.gpL;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (h.isDebug()) {
            h.d("MKNetLoader", "decodeLogicInBackGround: " + jSONObject);
        }
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.gpJ)) {
                this.gpJ = com.baidu.live.d.xf().getString("sp_ar_makeup_result", "");
            }
            if (!TextUtils.isEmpty(this.gpJ)) {
                jSONObject = new JSONObject(this.gpJ);
            }
        } else {
            this.gpJ = jSONObject.toString();
            if (!TextUtils.isEmpty(this.gpJ)) {
                com.baidu.live.d.xf().putString("sp_ar_makeup_result", this.gpJ);
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.gpL = new com.baidu.tieba.ala.alaar.makeup.a.c(e.bOG());
            this.gpL.dD(optJSONObject);
            if (h.isDebug()) {
                h.d("MKNetLoader", "decodeLogicInBackGround-size: " + this.gpL.size());
            }
        }
    }
}
