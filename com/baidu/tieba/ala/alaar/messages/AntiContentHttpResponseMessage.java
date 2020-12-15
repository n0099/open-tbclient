package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AntiContentHttpResponseMessage extends JsonHttpResponsedMessage {
    private int cmE;
    private int gjU;
    private int gjV;
    public List<FuFaceItem> gjW;
    private int mask;

    public AntiContentHttpResponseMessage() {
        super(1021158);
        this.gjW = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gjU = optJSONObject.optInt("auditType");
            this.mask = optJSONObject.optInt("mask");
            this.cmE = optJSONObject.optInt("display");
            this.gjV = optJSONObject.optInt("ansSense");
        }
    }

    public boolean bQo() {
        return this.cmE == 1;
    }
}
