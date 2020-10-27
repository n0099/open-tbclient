package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AntiContentHttpResponseMessage extends JsonHttpResponsedMessage {
    private int cbW;
    private int fWj;
    private int fWk;
    public List<FuFaceItem> fWl;
    private int mask;

    public AntiContentHttpResponseMessage() {
        super(1021158);
        this.fWl = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fWj = optJSONObject.optInt("auditType");
            this.mask = optJSONObject.optInt("mask");
            this.cbW = optJSONObject.optInt("display");
            this.fWk = optJSONObject.optInt("ansSense");
        }
    }

    public boolean bKK() {
        return this.cbW == 1;
    }
}
