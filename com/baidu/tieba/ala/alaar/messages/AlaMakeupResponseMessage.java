package com.baidu.tieba.ala.alaar.messages;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.makeup.e;
import com.baidu.tieba.ala.alaar.makeup.h;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaMakeupResponseMessage extends JsonHttpResponsedMessage {
    private String guq;
    private com.baidu.tieba.ala.alaar.makeup.a.c gus;

    public AlaMakeupResponseMessage() {
        super(1021214);
    }

    public com.baidu.tieba.ala.alaar.makeup.a.c bSB() {
        return this.gus;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (h.isDebug()) {
            h.d("MKNetLoader", "decodeLogicInBackGround: " + jSONObject);
        }
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.guq)) {
                this.guq = com.baidu.live.d.Ba().getString("sp_ar_makeup_result", "");
            }
            if (!TextUtils.isEmpty(this.guq)) {
                jSONObject = new JSONObject(this.guq);
            }
        } else {
            this.guq = jSONObject.toString();
            if (!TextUtils.isEmpty(this.guq)) {
                com.baidu.live.d.Ba().putString("sp_ar_makeup_result", this.guq);
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.gus = new com.baidu.tieba.ala.alaar.makeup.a.c(e.bSx());
            this.gus.dD(optJSONObject);
            if (h.isDebug()) {
                h.d("MKNetLoader", "decodeLogicInBackGround-size: " + this.gus.size());
            }
        }
    }
}
