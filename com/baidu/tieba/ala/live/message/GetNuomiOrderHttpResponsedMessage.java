package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> eKz;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.eKz = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.eKz.put("dealId", jSONObject.optString("dealId"));
            this.eKz.put("appKey", jSONObject.optString("appKey"));
            this.eKz.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.eKz.put("timestamp", jSONObject.optString("timestamp"));
            this.eKz.put("totalAmount", jSONObject.optString("totalAmount"));
            this.eKz.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.eKz.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.eKz.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.eKz.put("dealTitle", jSONObject.optString("dealTitle"));
            this.eKz.put("returnData", jSONObject.optString("returnData"));
            this.eKz.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.eKz.put("channel", jSONObject.optString("channel"));
            this.eKz.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.eKz.put("rsaSign", jSONObject.optString("rsaSign"));
            this.eKz.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bgq() {
        return this.eKz;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
