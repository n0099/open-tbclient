package com.baidu.tieba.ala.message;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.data.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetWishListResponseMessage extends JsonHttpResponsedMessage {
    private ArrayList<d> eVV;
    private long hTu;
    private String mTips;

    public AlaGetWishListResponseMessage(int i) {
        super(1021165);
        this.eVV = new ArrayList<>();
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            this.mTips = optJSONObject.optString(TableDefine.MessageColumns.COLUME_TIPS);
            this.hTu = optJSONObject.optLong("sys_time");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    d dVar = new d();
                    dVar.parserJson(optJSONArray.getJSONObject(i2));
                    this.eVV.add(dVar);
                }
            }
        }
    }

    public ArrayList<d> getData() {
        return this.eVV;
    }

    public String getTips() {
        return this.mTips;
    }

    public long getSysTime() {
        return this.hTu;
    }
}
