package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> fDs;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.fDs = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.fDs.put("dealId", jSONObject.optString("dealId"));
            this.fDs.put("appKey", jSONObject.optString("appKey"));
            this.fDs.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.fDs.put("timestamp", jSONObject.optString("timestamp"));
            this.fDs.put("totalAmount", jSONObject.optString("totalAmount"));
            this.fDs.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.fDs.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.fDs.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.fDs.put("dealTitle", jSONObject.optString("dealTitle"));
            this.fDs.put("returnData", jSONObject.optString("returnData"));
            this.fDs.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.fDs.put("channel", jSONObject.optString("channel"));
            this.fDs.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.fDs.put("rsaSign", jSONObject.optString("rsaSign"));
            this.fDs.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bvE() {
        return this.fDs;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
