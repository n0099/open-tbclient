package com.baidu.tieba.im.newFriend;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class RecommendFriendResponseMessage extends JsonHttpResponsedMessage {
    private List<com.baidu.tieba.im.data.k> mDatas;
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

    public List<com.baidu.tieba.im.data.k> getDatas() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
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
                    com.baidu.tieba.im.data.k kVar = new com.baidu.tieba.im.data.k();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    kVar.a(jSONObject2.optLong(com.baidu.tbadk.core.frameworkData.a.USER_ID));
                    kVar.a(jSONObject2.optString(com.baidu.tbadk.core.frameworkData.a.USER_NAME));
                    kVar.b(jSONObject2.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT));
                    kVar.c(jSONObject2.optString("message"));
                    if (jSONObject2.optInt("type") == 0) {
                        kVar.a(0);
                    } else {
                        kVar.a(1);
                    }
                    kVar.b(1);
                    this.mDatas.add(kVar);
                }
            }
        }
    }
}
