package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class RecommendFriendResponseMessage extends JsonHttpResponsedMessage {
    private List<com.baidu.tieba.im.data.a> mDatas;
    private int mErrCode;
    private String mErrMsg;

    public RecommendFriendResponseMessage(int i) {
        super(i);
        this.mErrCode = 0;
        this.mErrMsg = "";
        this.mDatas = null;
    }

    public int getErrCode() {
        return this.mErrCode;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public List<com.baidu.tieba.im.data.a> getDatas() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0) {
            this.mErrCode = jSONObject.optInt("errno");
            this.mErrMsg = jSONObject.optString("errmsg");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("recommend_list")) != null) {
                this.mDatas = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    aVar.setId(jSONObject2.optLong("user_id"));
                    aVar.setName(jSONObject2.optString("user_name"));
                    aVar.setPortrait(jSONObject2.optString(IntentConfig.PORTRAIT));
                    aVar.setContent(jSONObject2.optString("message"));
                    if (jSONObject2.optInt("type") == 0) {
                        aVar.setStatus(0);
                    } else {
                        aVar.setStatus(1);
                    }
                    aVar.pQ(1);
                    this.mDatas.add(aVar);
                }
            }
        }
    }
}
