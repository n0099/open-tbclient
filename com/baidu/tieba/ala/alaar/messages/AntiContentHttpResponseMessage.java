package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AntiContentHttpResponseMessage extends JsonHttpResponsedMessage {
    private int bsy;
    private int eKa;
    private int eKb;
    public List<FuFaceItem> eKc;
    private int mask;

    public AntiContentHttpResponseMessage() {
        super(1021158);
        this.eKc = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.eKa = optJSONObject.optInt("auditType");
            this.mask = optJSONObject.optInt("mask");
            this.bsy = optJSONObject.optInt("display");
            this.eKb = optJSONObject.optInt("ansSense");
        }
    }

    public boolean bkg() {
        return this.bsy == 1;
    }
}
