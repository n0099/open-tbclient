package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AntiContentHttpResponseMessage extends JsonHttpResponsedMessage {
    private int bMQ;
    private int fAP;
    private int fAQ;
    public List<FuFaceItem> fAR;
    private int mask;

    public AntiContentHttpResponseMessage() {
        super(1021158);
        this.fAR = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fAP = optJSONObject.optInt("auditType");
            this.mask = optJSONObject.optInt("mask");
            this.bMQ = optJSONObject.optInt("display");
            this.fAQ = optJSONObject.optInt("ansSense");
        }
    }

    public boolean bFz() {
        return this.bMQ == 1;
    }
}
