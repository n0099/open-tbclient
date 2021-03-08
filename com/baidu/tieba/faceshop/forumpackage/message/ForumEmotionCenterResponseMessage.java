package com.baidu.tieba.faceshop.forumpackage.message;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionData;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ForumEmotionCenterResponseMessage extends JsonHttpResponsedMessage {
    public ForumEmotionData data;

    public ForumEmotionCenterResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.data = (ForumEmotionData) OrmObject.objectWithJson(jSONObject.optJSONObject("data"), ForumEmotionData.class);
        }
    }
}
