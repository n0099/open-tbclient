package com.baidu.tbadk.coreExtra.search;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.data.SearchFriendResult;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ResponseSearchFriendMessage extends JsonHttpResponsedMessage {
    public SearchFriendResult mSearchFriendResult;

    public ResponseSearchFriendMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() != 200 || jSONObject == null) {
            return;
        }
        this.mSearchFriendResult = (SearchFriendResult) OrmObject.objectWithJson(jSONObject, SearchFriendResult.class);
    }

    public SearchFriendResult getSearchFriendResult() {
        if (this.mSearchFriendResult == null) {
            this.mSearchFriendResult = new SearchFriendResult();
        }
        return this.mSearchFriendResult;
    }
}
