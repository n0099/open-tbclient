package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> hff;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.hff = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.hff.put("dealId", jSONObject.optString("dealId"));
            this.hff.put("appKey", jSONObject.optString("appKey"));
            this.hff.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.hff.put("timestamp", jSONObject.optString("timestamp"));
            this.hff.put("totalAmount", jSONObject.optString("totalAmount"));
            this.hff.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.hff.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.hff.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.hff.put("dealTitle", jSONObject.optString("dealTitle"));
            this.hff.put("returnData", jSONObject.optString("returnData"));
            this.hff.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.hff.put("channel", jSONObject.optString("channel"));
            this.hff.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.hff.put("rsaSign", jSONObject.optString("rsaSign"));
            this.hff.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bWX() {
        return this.hff;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
