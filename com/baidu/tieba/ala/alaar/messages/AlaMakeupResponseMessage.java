package com.baidu.tieba.ala.alaar.messages;

import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.makeup.e;
import com.baidu.tieba.ala.alaar.makeup.h;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaMakeupResponseMessage extends JsonHttpResponsedMessage {
    private String gbX;
    private com.baidu.tieba.ala.alaar.makeup.a.c gbZ;

    public AlaMakeupResponseMessage() {
        super(1021225);
    }

    public com.baidu.tieba.ala.alaar.makeup.a.c bMW() {
        return this.gbZ;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (h.isDebug()) {
            h.d("MKNetLoader", "decodeLogicInBackGround: " + jSONObject);
        }
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.gbX)) {
                this.gbX = com.baidu.live.d.AZ().getString("sp_ar_makeup_result", "");
            }
            if (!TextUtils.isEmpty(this.gbX)) {
                jSONObject = new JSONObject(this.gbX);
            }
        } else {
            this.gbX = jSONObject.toString();
            if (!TextUtils.isEmpty(this.gbX)) {
                com.baidu.live.d.AZ().putString("sp_ar_makeup_result", this.gbX);
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.gbZ = new com.baidu.tieba.ala.alaar.makeup.a.c(e.bMS());
            this.gbZ.dz(optJSONObject);
            if (h.isDebug()) {
                h.d("MKNetLoader", "decodeLogicInBackGround-size: " + this.gbZ.size());
            }
        }
    }
}
