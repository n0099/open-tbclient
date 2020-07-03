package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetWishListResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<c> dQf;
    private long gwj;
    private String mTips;

    public AlaGetWishListResponseMessage(int i) {
        super(1021165);
        this.dQf = new ArrayList<>();
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            this.mTips = optJSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.gwj = optJSONObject.optLong("sys_time");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    c cVar = new c();
                    cVar.parserJson(optJSONArray.getJSONObject(i2));
                    this.dQf.add(cVar);
                }
            }
        }
    }

    public ArrayList<c> getData() {
        return this.dQf;
    }

    public String getTips() {
        return this.mTips;
    }

    public long getSysTime() {
        return this.gwj;
    }
}
