package com.baidu.tieba.forbidden.fans;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.h0.r.q.z0;
import d.b.i0.m0.a.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetForbiddenFansResponse extends JsonHttpResponsedMessage {
    public ArrayList<a> fansList;
    public z0 pageData;

    public GetForbiddenFansResponse(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("block_user_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                this.fansList = new ArrayList<>();
                for (int i2 = 0; i2 < length; i2++) {
                    a aVar = new a();
                    aVar.a(optJSONArray.getJSONObject(i2));
                    if (aVar.f56806a != 0) {
                        this.fansList.add(aVar);
                    }
                }
            }
            z0 z0Var = new z0();
            this.pageData = z0Var;
            z0Var.i(jSONObject.optJSONObject("page"));
        }
    }

    public ArrayList<a> getFansList() {
        return this.fansList;
    }

    public z0 getPageData() {
        return this.pageData;
    }
}
