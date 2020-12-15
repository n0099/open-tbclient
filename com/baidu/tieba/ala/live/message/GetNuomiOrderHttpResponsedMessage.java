package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> gXX;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.gXX = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.gXX.put("dealId", jSONObject.optString("dealId"));
            this.gXX.put("appKey", jSONObject.optString("appKey"));
            this.gXX.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.gXX.put("timestamp", jSONObject.optString("timestamp"));
            this.gXX.put("totalAmount", jSONObject.optString("totalAmount"));
            this.gXX.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.gXX.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.gXX.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.gXX.put("dealTitle", jSONObject.optString("dealTitle"));
            this.gXX.put("returnData", jSONObject.optString("returnData"));
            this.gXX.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.gXX.put("channel", jSONObject.optString("channel"));
            this.gXX.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.gXX.put("rsaSign", jSONObject.optString("rsaSign"));
            this.gXX.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bYj() {
        return this.gXX;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
