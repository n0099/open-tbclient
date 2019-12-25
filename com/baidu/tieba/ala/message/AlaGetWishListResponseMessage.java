package com.baidu.tieba.ala.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaGetWishListResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<c> cRE;
    private String fjq;
    private long fjr;

    public AlaGetWishListResponseMessage(int i) {
        super(1021161);
        this.cRE = new ArrayList<>();
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            this.fjq = optJSONObject.optString("tips");
            this.fjr = optJSONObject.optLong("sys_time");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    c cVar = new c();
                    cVar.parserJson(optJSONArray.getJSONObject(i2));
                    this.cRE.add(cVar);
                }
            }
        }
    }

    public ArrayList<c> getData() {
        return this.cRE;
    }

    public String getTips() {
        return this.fjq;
    }

    public long getSysTime() {
        return this.fjr;
    }
}
