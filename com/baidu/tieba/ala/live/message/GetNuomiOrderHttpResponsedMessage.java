package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> gPb;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.gPb = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.gPb.put("dealId", jSONObject.optString("dealId"));
            this.gPb.put("appKey", jSONObject.optString("appKey"));
            this.gPb.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.gPb.put("timestamp", jSONObject.optString("timestamp"));
            this.gPb.put("totalAmount", jSONObject.optString("totalAmount"));
            this.gPb.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.gPb.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.gPb.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.gPb.put("dealTitle", jSONObject.optString("dealTitle"));
            this.gPb.put("returnData", jSONObject.optString("returnData"));
            this.gPb.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.gPb.put("channel", jSONObject.optString("channel"));
            this.gPb.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.gPb.put("rsaSign", jSONObject.optString("rsaSign"));
            this.gPb.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bVg() {
        return this.gPb;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
