package com.baidu.tieba.im.newFriend;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class RecommendFriendResponseMessage extends JsonHttpResponsedMessage {
    private List<com.baidu.tieba.im.data.b> mDatas;
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

    public List<com.baidu.tieba.im.data.b> getDatas() {
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
                    com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    bVar.setId(jSONObject2.optLong("user_id"));
                    bVar.setName(jSONObject2.optString("user_name"));
                    bVar.setPortrait(jSONObject2.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT));
                    bVar.setContent(jSONObject2.optString("message"));
                    if (jSONObject2.optInt("type") == 0) {
                        bVar.setStatus(0);
                    } else {
                        bVar.setStatus(1);
                    }
                    bVar.fz(1);
                    this.mDatas.add(bVar);
                }
            }
        }
    }
}
