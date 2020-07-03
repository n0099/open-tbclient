package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> fOB;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.fOB = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.fOB.put("dealId", jSONObject.optString("dealId"));
            this.fOB.put("appKey", jSONObject.optString("appKey"));
            this.fOB.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.fOB.put("timestamp", jSONObject.optString("timestamp"));
            this.fOB.put("totalAmount", jSONObject.optString("totalAmount"));
            this.fOB.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.fOB.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.fOB.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.fOB.put("dealTitle", jSONObject.optString("dealTitle"));
            this.fOB.put("returnData", jSONObject.optString("returnData"));
            this.fOB.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.fOB.put("channel", jSONObject.optString("channel"));
            this.fOB.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.fOB.put("rsaSign", jSONObject.optString("rsaSign"));
            this.fOB.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> byz() {
        return this.fOB;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
