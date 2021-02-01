package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AntiContentHttpResponseMessage extends JsonHttpResponsedMessage {
    private int gsv;
    private int gsw;
    private int gsx;
    public List<FuFaceItem> gsy;
    private int mask;

    public AntiContentHttpResponseMessage() {
        super(1021158);
        this.gsy = null;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gsv = optJSONObject.optInt("auditType");
            this.mask = optJSONObject.optInt("mask");
            this.gsw = optJSONObject.optInt("display");
            this.gsx = optJSONObject.optInt("ansSense");
        }
    }

    public boolean bPA() {
        return this.gsw == 1;
    }
}
