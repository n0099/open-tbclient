package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AntiContentHttpResponseMessage extends JsonHttpResponsedMessage {
    private int coT;
    private int gpM;
    private int gpN;
    public List<FuFaceItem> gpO;
    private int mask;

    public AntiContentHttpResponseMessage() {
        super(1021158);
        this.gpO = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gpM = optJSONObject.optInt("auditType");
            this.mask = optJSONObject.optInt("mask");
            this.coT = optJSONObject.optInt("display");
            this.gpN = optJSONObject.optInt("ansSense");
        }
    }

    public boolean bOW() {
        return this.coT == 1;
    }
}
