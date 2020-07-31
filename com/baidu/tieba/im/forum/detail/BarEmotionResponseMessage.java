package com.baidu.tieba.im.forum.detail;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class BarEmotionResponseMessage extends JsonHttpResponsedMessage {
    public ForumEmotionData data;

    /* loaded from: classes20.dex */
    public static class ForumEmotionData extends OrmObject {
        public static final int STATUS_OK = 1;
        public int forum_pkg_status;
        public String url;
    }

    public BarEmotionResponseMessage(int i) {
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
