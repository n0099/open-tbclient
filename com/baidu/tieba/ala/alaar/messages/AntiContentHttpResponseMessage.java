package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AntiContentHttpResponseMessage extends JsonHttpResponsedMessage {
    private int gus;
    private int gut;
    private int guu;
    public List<FuFaceItem> guv;
    private int mask;

    public AntiContentHttpResponseMessage() {
        super(1021158);
        this.guv = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gus = optJSONObject.optInt("auditType");
            this.mask = optJSONObject.optInt("mask");
            this.gut = optJSONObject.optInt("display");
            this.guu = optJSONObject.optInt("ansSense");
        }
    }

    public boolean bPN() {
        return this.gut == 1;
    }
}
