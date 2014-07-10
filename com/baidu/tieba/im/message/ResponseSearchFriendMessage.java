package com.baidu.tieba.im.message;

import com.baidu.gson.Gson;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.im.data.SearchFriendResult;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResponseSearchFriendMessage extends JsonHttpResponsedMessage {
    private SearchFriendResult mSearchFriendResult;

    public SearchFriendResult getSearchFriendResult() {
        if (this.mSearchFriendResult == null) {
            this.mSearchFriendResult = new SearchFriendResult();
        }
        return this.mSearchFriendResult;
    }

    public ResponseSearchFriendMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() == 200 && jSONObject != null) {
            this.mSearchFriendResult = (SearchFriendResult) new Gson().fromJson(jSONObject.toString(), (Class<Object>) SearchFriendResult.class);
        }
    }
}
