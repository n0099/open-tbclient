package com.baidu.tieba.forbidden.fans;

import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetForbiddenFansResponse extends JsonHttpResponsedMessage {
    private ArrayList<a> fansList;
    private am pageData;

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
                    aVar.parserJson(optJSONArray.getJSONObject(i2));
                    if (aVar.id != 0) {
                        this.fansList.add(aVar);
                    }
                }
            }
            this.pageData = new am();
            this.pageData.parserJson(jSONObject.optJSONObject("page"));
        }
    }

    public am getPageData() {
        return this.pageData;
    }

    public ArrayList<a> getFansList() {
        return this.fansList;
    }
}
