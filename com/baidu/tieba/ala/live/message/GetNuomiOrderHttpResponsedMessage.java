package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> gXV;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.gXV = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.gXV.put("dealId", jSONObject.optString("dealId"));
            this.gXV.put("appKey", jSONObject.optString("appKey"));
            this.gXV.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.gXV.put("timestamp", jSONObject.optString("timestamp"));
            this.gXV.put("totalAmount", jSONObject.optString("totalAmount"));
            this.gXV.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.gXV.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.gXV.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.gXV.put("dealTitle", jSONObject.optString("dealTitle"));
            this.gXV.put("returnData", jSONObject.optString("returnData"));
            this.gXV.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.gXV.put("channel", jSONObject.optString("channel"));
            this.gXV.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.gXV.put("rsaSign", jSONObject.optString("rsaSign"));
            this.gXV.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bYi() {
        return this.gXV;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
