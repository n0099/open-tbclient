package com.baidu.tieba.frs;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImageForumResponsedMessage extends JsonHttpResponsedMessage {
    public JSONObject mJSONObject;

    public ImageForumResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        this.mJSONObject = jSONObject;
    }
}
