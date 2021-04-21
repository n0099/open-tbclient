package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.j0.e1.g.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class RecommendFriendResponseMessage extends JsonHttpResponsedMessage {
    public List<a> mDatas;
    public int mErrCode;
    public String mErrMsg;

    public RecommendFriendResponseMessage(int i) {
        super(i);
        this.mErrCode = 0;
        this.mErrMsg = "";
        this.mDatas = null;
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
            if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("recommend_list")) == null) {
                return;
            }
            this.mDatas = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                a aVar = new a();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                aVar.h(jSONObject2.optLong("user_id"));
                aVar.j(jSONObject2.optString("user_name"));
                aVar.k(jSONObject2.optString("portrait"));
                aVar.g(jSONObject2.optString("message"));
                if (jSONObject2.optInt("type") == 0) {
                    aVar.l(0);
                } else {
                    aVar.l(1);
                }
                aVar.i(1);
                this.mDatas.add(aVar);
            }
        }
    }

    public List<a> getDatas() {
        return this.mDatas;
    }

    public int getErrCode() {
        return this.mErrCode;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }
}
