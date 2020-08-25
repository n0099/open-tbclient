package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AntiContentHttpResponseMessage extends JsonHttpResponsedMessage {
    private int bKM;
    private int fxA;
    public List<FuFaceItem> fxB;
    private int fxz;
    private int mask;

    public AntiContentHttpResponseMessage() {
        super(1021158);
        this.fxB = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fxz = optJSONObject.optInt("auditType");
            this.mask = optJSONObject.optInt("mask");
            this.bKM = optJSONObject.optInt("display");
            this.fxA = optJSONObject.optInt("ansSense");
        }
    }

    public boolean bEi() {
        return this.bKM == 1;
    }
}
