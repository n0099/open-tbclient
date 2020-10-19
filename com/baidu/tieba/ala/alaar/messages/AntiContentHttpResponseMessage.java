package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AntiContentHttpResponseMessage extends JsonHttpResponsedMessage {
    private int bTz;
    private int fMY;
    private int fMZ;
    public List<FuFaceItem> fNa;
    private int mask;

    public AntiContentHttpResponseMessage() {
        super(1021158);
        this.fNa = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fMY = optJSONObject.optInt("auditType");
            this.mask = optJSONObject.optInt("mask");
            this.bTz = optJSONObject.optInt("display");
            this.fMZ = optJSONObject.optInt("ansSense");
        }
    }

    public boolean bIl() {
        return this.bTz == 1;
    }
}
