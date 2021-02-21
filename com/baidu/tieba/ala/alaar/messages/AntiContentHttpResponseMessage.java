package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AntiContentHttpResponseMessage extends JsonHttpResponsedMessage {
    private int gsJ;
    private int gsK;
    private int gsL;
    public List<FuFaceItem> gsM;
    private int mask;

    public AntiContentHttpResponseMessage() {
        super(1021158);
        this.gsM = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gsJ = optJSONObject.optInt("auditType");
            this.mask = optJSONObject.optInt("mask");
            this.gsK = optJSONObject.optInt("display");
            this.gsL = optJSONObject.optInt("ansSense");
        }
    }

    public boolean bPH() {
        return this.gsK == 1;
    }
}
