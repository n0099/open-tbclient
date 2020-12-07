package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AntiContentHttpResponseMessage extends JsonHttpResponsedMessage {
    private int cmE;
    private int gjS;
    private int gjT;
    public List<FuFaceItem> gjU;
    private int mask;

    public AntiContentHttpResponseMessage() {
        super(1021158);
        this.gjU = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gjS = optJSONObject.optInt("auditType");
            this.mask = optJSONObject.optInt("mask");
            this.cmE = optJSONObject.optInt("display");
            this.gjT = optJSONObject.optInt("ansSense");
        }
    }

    public boolean bQn() {
        return this.cmE == 1;
    }
}
