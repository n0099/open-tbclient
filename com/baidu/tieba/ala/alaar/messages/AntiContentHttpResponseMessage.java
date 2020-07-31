package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AntiContentHttpResponseMessage extends JsonHttpResponsedMessage {
    private int bFm;
    private int fmd;
    private int fme;
    public List<FuFaceItem> fmf;
    private int mask;

    public AntiContentHttpResponseMessage() {
        super(1021158);
        this.fmf = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fmd = optJSONObject.optInt("auditType");
            this.mask = optJSONObject.optInt("mask");
            this.bFm = optJSONObject.optInt("display");
            this.fme = optJSONObject.optInt("ansSense");
        }
    }

    public boolean bvn() {
        return this.bFm == 1;
    }
}
