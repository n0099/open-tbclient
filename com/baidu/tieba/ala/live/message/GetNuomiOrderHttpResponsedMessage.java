package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> hjv;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.hjv = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.hjv.put("dealId", jSONObject.optString("dealId"));
            this.hjv.put("appKey", jSONObject.optString("appKey"));
            this.hjv.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.hjv.put("timestamp", jSONObject.optString("timestamp"));
            this.hjv.put("totalAmount", jSONObject.optString("totalAmount"));
            this.hjv.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.hjv.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.hjv.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.hjv.put("dealTitle", jSONObject.optString("dealTitle"));
            this.hjv.put("returnData", jSONObject.optString("returnData"));
            this.hjv.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.hjv.put("channel", jSONObject.optString("channel"));
            this.hjv.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.hjv.put("rsaSign", jSONObject.optString("rsaSign"));
            this.hjv.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bXX() {
        return this.hjv;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
