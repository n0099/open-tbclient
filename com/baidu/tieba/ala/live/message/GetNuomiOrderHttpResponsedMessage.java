package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> fDh;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.fDh = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.fDh.put("dealId", jSONObject.optString("dealId"));
            this.fDh.put("appKey", jSONObject.optString("appKey"));
            this.fDh.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.fDh.put("timestamp", jSONObject.optString("timestamp"));
            this.fDh.put("totalAmount", jSONObject.optString("totalAmount"));
            this.fDh.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.fDh.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.fDh.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.fDh.put("dealTitle", jSONObject.optString("dealTitle"));
            this.fDh.put("returnData", jSONObject.optString("returnData"));
            this.fDh.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.fDh.put("channel", jSONObject.optString("channel"));
            this.fDh.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.fDh.put("rsaSign", jSONObject.optString("rsaSign"));
            this.fDh.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bvC() {
        return this.fDh;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
