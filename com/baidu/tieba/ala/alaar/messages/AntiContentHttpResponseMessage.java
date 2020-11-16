package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AntiContentHttpResponseMessage extends JsonHttpResponsedMessage {
    private int cfX;
    private int gbH;
    private int gbI;
    public List<FuFaceItem> gbJ;
    private int mask;

    public AntiContentHttpResponseMessage() {
        super(1021158);
        this.gbJ = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gbH = optJSONObject.optInt("auditType");
            this.mask = optJSONObject.optInt("mask");
            this.cfX = optJSONObject.optInt("display");
            this.gbI = optJSONObject.optInt("ansSense");
        }
    }

    public boolean bMC() {
        return this.cfX == 1;
    }
}
