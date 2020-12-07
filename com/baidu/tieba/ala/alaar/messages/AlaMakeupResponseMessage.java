package com.baidu.tieba.ala.alaar.messages;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.makeup.e;
import com.baidu.tieba.ala.alaar.makeup.h;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaMakeupResponseMessage extends JsonHttpResponsedMessage {
    private String gjP;
    private com.baidu.tieba.ala.alaar.makeup.a.c gjR;

    public AlaMakeupResponseMessage() {
        super(1021214);
    }

    public com.baidu.tieba.ala.alaar.makeup.a.c bQa() {
        return this.gjR;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (h.isDebug()) {
            h.d("MKNetLoader", "decodeLogicInBackGround: " + jSONObject);
        }
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.gjP)) {
                this.gjP = com.baidu.live.d.BM().getString("sp_ar_makeup_result", "");
            }
            if (!TextUtils.isEmpty(this.gjP)) {
                jSONObject = new JSONObject(this.gjP);
            }
        } else {
            this.gjP = jSONObject.toString();
            if (!TextUtils.isEmpty(this.gjP)) {
                com.baidu.live.d.BM().putString("sp_ar_makeup_result", this.gjP);
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.gjR = new com.baidu.tieba.ala.alaar.makeup.a.c(e.bPW());
            this.gjR.du(optJSONObject);
            if (h.isDebug()) {
                h.d("MKNetLoader", "decodeLogicInBackGround-size: " + this.gjR.size());
            }
        }
    }
}
