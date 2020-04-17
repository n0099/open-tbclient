package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AntiContentHttpResponseMessage extends JsonHttpResponsedMessage {
    private int bsu;
    private int eJV;
    private int eJW;
    public List<FuFaceItem> eJX;
    private int mask;

    public AntiContentHttpResponseMessage() {
        super(1021158);
        this.eJX = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.eJV = optJSONObject.optInt("auditType");
            this.mask = optJSONObject.optInt("mask");
            this.bsu = optJSONObject.optInt("display");
            this.eJW = optJSONObject.optInt("ansSense");
        }
    }

    public boolean bki() {
        return this.bsu == 1;
    }
}
