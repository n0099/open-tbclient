package com.baidu.tieba.ala.charm.model;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.charm.data.ALaCharmDataList;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaCharmDetailHttpResponsedMessage extends JsonHttpResponsedMessage {
    public ALaCharmDataList fUt;

    public AlaCharmDetailHttpResponsedMessage() {
        super(1021002);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.fUt = new ALaCharmDataList();
            this.fUt.parserJson(jSONObject);
        }
    }
}
