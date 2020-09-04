package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AntiContentHttpResponseMessage extends JsonHttpResponsedMessage {
    private int bKQ;
    private int fxD;
    private int fxE;
    public List<FuFaceItem> fxF;
    private int mask;

    public AntiContentHttpResponseMessage() {
        super(1021158);
        this.fxF = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fxD = optJSONObject.optInt("auditType");
            this.mask = optJSONObject.optInt("mask");
            this.bKQ = optJSONObject.optInt("display");
            this.fxE = optJSONObject.optInt("ansSense");
        }
    }

    public boolean bEj() {
        return this.bKQ == 1;
    }
}
