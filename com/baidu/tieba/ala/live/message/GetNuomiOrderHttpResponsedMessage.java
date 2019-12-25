package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> eFh;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.eFh = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.eFh.put("dealId", jSONObject.optString("dealId"));
            this.eFh.put("appKey", jSONObject.optString("appKey"));
            this.eFh.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.eFh.put("timestamp", jSONObject.optString("timestamp"));
            this.eFh.put("totalAmount", jSONObject.optString("totalAmount"));
            this.eFh.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.eFh.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.eFh.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.eFh.put("dealTitle", jSONObject.optString("dealTitle"));
            this.eFh.put("returnData", jSONObject.optString("returnData"));
            this.eFh.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.eFh.put("channel", jSONObject.optString("channel"));
            this.eFh.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.eFh.put("rsaSign", jSONObject.optString("rsaSign"));
            this.eFh.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bdI() {
        return this.eFh;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
