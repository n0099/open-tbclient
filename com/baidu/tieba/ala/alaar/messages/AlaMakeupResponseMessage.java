package com.baidu.tieba.ala.alaar.messages;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.makeup.e;
import com.baidu.tieba.ala.alaar.makeup.h;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaMakeupResponseMessage extends JsonHttpResponsedMessage {
    private String gjR;
    private com.baidu.tieba.ala.alaar.makeup.a.c gjT;

    public AlaMakeupResponseMessage() {
        super(1021214);
    }

    public com.baidu.tieba.ala.alaar.makeup.a.c bQb() {
        return this.gjT;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (h.isDebug()) {
            h.d("MKNetLoader", "decodeLogicInBackGround: " + jSONObject);
        }
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.gjR)) {
                this.gjR = com.baidu.live.d.BM().getString("sp_ar_makeup_result", "");
            }
            if (!TextUtils.isEmpty(this.gjR)) {
                jSONObject = new JSONObject(this.gjR);
            }
        } else {
            this.gjR = jSONObject.toString();
            if (!TextUtils.isEmpty(this.gjR)) {
                com.baidu.live.d.BM().putString("sp_ar_makeup_result", this.gjR);
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.gjT = new com.baidu.tieba.ala.alaar.makeup.a.c(e.bPX());
            this.gjT.du(optJSONObject);
            if (h.isDebug()) {
                h.d("MKNetLoader", "decodeLogicInBackGround-size: " + this.gjT.size());
            }
        }
    }
}
