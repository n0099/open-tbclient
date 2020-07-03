package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AntiContentHttpResponseMessage extends JsonHttpResponsedMessage {
    private int bEP;
    private int fgV;
    private int fgW;
    public List<FuFaceItem> fgX;
    private int mask;

    public AntiContentHttpResponseMessage() {
        super(1021158);
        this.fgX = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fgV = optJSONObject.optInt("auditType");
            this.mask = optJSONObject.optInt("mask");
            this.bEP = optJSONObject.optInt("display");
            this.fgW = optJSONObject.optInt("ansSense");
        }
    }

    public boolean bsd() {
        return this.bEP == 1;
    }
}
