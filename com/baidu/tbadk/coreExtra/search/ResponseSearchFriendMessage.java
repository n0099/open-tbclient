package com.baidu.tbadk.coreExtra.search;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.data.SearchFriendResult;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
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
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() == 200 && jSONObject != null) {
            this.mSearchFriendResult = (SearchFriendResult) i.objectWithJson(jSONObject, SearchFriendResult.class);
        }
    }
}
