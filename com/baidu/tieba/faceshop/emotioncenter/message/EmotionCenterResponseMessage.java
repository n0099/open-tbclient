package com.baidu.tieba.faceshop.emotioncenter.message;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class EmotionCenterResponseMessage extends JsonHttpResponsedMessage {
    public EmotionCenterData data;

    public EmotionCenterResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.data = (EmotionCenterData) OrmObject.objectWithJson(jSONObject.optJSONObject("data"), EmotionCenterData.class);
        }
    }
}
