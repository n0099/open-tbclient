package com.baidu.tieba.ala.alaar.messages;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.makeup.e;
import com.baidu.tieba.ala.alaar.makeup.h;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaMakeupResponseMessage extends JsonHttpResponsedMessage {
    private String gup;
    private com.baidu.tieba.ala.alaar.makeup.a.c gur;

    public AlaMakeupResponseMessage() {
        super(1021214);
    }

    public com.baidu.tieba.ala.alaar.makeup.a.c bPB() {
        return this.gur;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (h.isDebug()) {
            h.d("MKNetLoader", "decodeLogicInBackGround: " + jSONObject);
        }
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.gup)) {
                this.gup = com.baidu.live.d.xf().getString("sp_ar_makeup_result", "");
            }
            if (!TextUtils.isEmpty(this.gup)) {
                jSONObject = new JSONObject(this.gup);
            }
        } else {
            this.gup = jSONObject.toString();
            if (!TextUtils.isEmpty(this.gup)) {
                com.baidu.live.d.xf().putString("sp_ar_makeup_result", this.gup);
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.gur = new com.baidu.tieba.ala.alaar.makeup.a.c(e.bPx());
            this.gur.dG(optJSONObject);
            if (h.isDebug()) {
                h.d("MKNetLoader", "decodeLogicInBackGround-size: " + this.gur.size());
            }
        }
    }
}
