package com.baidu.tieba.faceshop.forumpackage.message;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ForumEmotionCenterResponseMessage extends JsonHttpResponsedMessage {
    public ForumEmotionData data;

    public ForumEmotionCenterResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.data = (ForumEmotionData) OrmObject.objectWithJson(jSONObject.optJSONObject("data"), ForumEmotionData.class);
        }
    }
}
