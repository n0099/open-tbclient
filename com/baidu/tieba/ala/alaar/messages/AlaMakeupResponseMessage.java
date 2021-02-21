package com.baidu.tieba.ala.alaar.messages;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.makeup.e;
import com.baidu.tieba.ala.alaar.makeup.h;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaMakeupResponseMessage extends JsonHttpResponsedMessage {
    private String gsG;
    private com.baidu.tieba.ala.alaar.makeup.a.c gsI;

    public AlaMakeupResponseMessage() {
        super(1021214);
    }

    public com.baidu.tieba.ala.alaar.makeup.a.c bPv() {
        return this.gsI;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (h.isDebug()) {
            h.d("MKNetLoader", "decodeLogicInBackGround: " + jSONObject);
        }
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.gsG)) {
                this.gsG = com.baidu.live.d.xc().getString("sp_ar_makeup_result", "");
            }
            if (!TextUtils.isEmpty(this.gsG)) {
                jSONObject = new JSONObject(this.gsG);
            }
        } else {
            this.gsG = jSONObject.toString();
            if (!TextUtils.isEmpty(this.gsG)) {
                com.baidu.live.d.xc().putString("sp_ar_makeup_result", this.gsG);
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.gsI = new com.baidu.tieba.ala.alaar.makeup.a.c(e.bPr());
            this.gsI.dE(optJSONObject);
            if (h.isDebug()) {
                h.d("MKNetLoader", "decodeLogicInBackGround-size: " + this.gsI.size());
            }
        }
    }
}
