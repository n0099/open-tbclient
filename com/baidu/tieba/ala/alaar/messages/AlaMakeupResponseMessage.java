package com.baidu.tieba.ala.alaar.messages;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.makeup.e;
import com.baidu.tieba.ala.alaar.makeup.h;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaMakeupResponseMessage extends JsonHttpResponsedMessage {
    private String gbE;
    private com.baidu.tieba.ala.alaar.makeup.a.c gbG;

    public AlaMakeupResponseMessage() {
        super(1021225);
    }

    public com.baidu.tieba.ala.alaar.makeup.a.c bMp() {
        return this.gbG;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (h.isDebug()) {
            h.d("MKNetLoader", "decodeLogicInBackGround: " + jSONObject);
        }
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.gbE)) {
                this.gbE = com.baidu.live.d.Aq().getString("sp_ar_makeup_result", "");
            }
            if (!TextUtils.isEmpty(this.gbE)) {
                jSONObject = new JSONObject(this.gbE);
            }
        } else {
            this.gbE = jSONObject.toString();
            if (!TextUtils.isEmpty(this.gbE)) {
                com.baidu.live.d.Aq().putString("sp_ar_makeup_result", this.gbE);
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.gbG = new com.baidu.tieba.ala.alaar.makeup.a.c(e.bMl());
            this.gbG.dt(optJSONObject);
            if (h.isDebug()) {
                h.d("MKNetLoader", "decodeLogicInBackGround-size: " + this.gbG.size());
            }
        }
    }
}
