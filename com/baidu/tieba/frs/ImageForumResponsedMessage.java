package com.baidu.tieba.frs;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ImageForumResponsedMessage extends JsonHttpResponsedMessage {
    public JSONObject a;

    public ImageForumResponsedMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public final void a(JSONObject jSONObject) {
        this.a = jSONObject;
    }
}
