package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AntiContentHttpResponseMessage extends JsonHttpResponsedMessage {
    private int bAb;
    private int eWI;
    private int eWJ;
    public List<FuFaceItem> eWK;
    private int mask;

    public AntiContentHttpResponseMessage() {
        super(1021158);
        this.eWK = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.eWI = optJSONObject.optInt("auditType");
            this.mask = optJSONObject.optInt("mask");
            this.bAb = optJSONObject.optInt("display");
            this.eWJ = optJSONObject.optInt("ansSense");
        }
    }

    public boolean bpC() {
        return this.bAb == 1;
    }
}
