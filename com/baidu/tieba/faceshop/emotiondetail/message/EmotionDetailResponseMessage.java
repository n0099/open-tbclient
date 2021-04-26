package com.baidu.tieba.faceshop.emotiondetail.message;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.faceshop.emotiondetail.data.EmotionDetailData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class EmotionDetailResponseMessage extends JsonHttpResponsedMessage {
    public EmotionDetailData data;

    public EmotionDetailResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.data = (EmotionDetailData) OrmObject.objectWithJson(jSONObject.optJSONObject("data"), EmotionDetailData.class);
        }
    }
}
