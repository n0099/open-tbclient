package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> gji;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.gji = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.gji.put("dealId", jSONObject.optString("dealId"));
            this.gji.put("appKey", jSONObject.optString("appKey"));
            this.gji.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.gji.put("timestamp", jSONObject.optString("timestamp"));
            this.gji.put("totalAmount", jSONObject.optString("totalAmount"));
            this.gji.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.gji.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.gji.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.gji.put("dealTitle", jSONObject.optString("dealTitle"));
            this.gji.put("returnData", jSONObject.optString("returnData"));
            this.gji.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.gji.put("channel", jSONObject.optString("channel"));
            this.gji.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.gji.put("rsaSign", jSONObject.optString("rsaSign"));
            this.gji.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bMt() {
        return this.gji;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
