package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> eKl;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.eKl = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.eKl.put("dealId", jSONObject.optString("dealId"));
            this.eKl.put("appKey", jSONObject.optString("appKey"));
            this.eKl.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.eKl.put("timestamp", jSONObject.optString("timestamp"));
            this.eKl.put("totalAmount", jSONObject.optString("totalAmount"));
            this.eKl.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.eKl.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.eKl.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.eKl.put("dealTitle", jSONObject.optString("dealTitle"));
            this.eKl.put("returnData", jSONObject.optString("returnData"));
            this.eKl.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.eKl.put("channel", jSONObject.optString("channel"));
            this.eKl.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.eKl.put("rsaSign", jSONObject.optString("rsaSign"));
            this.eKl.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bgn() {
        return this.eKl;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
