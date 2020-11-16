package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> gOI;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.gOI = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.gOI.put("dealId", jSONObject.optString("dealId"));
            this.gOI.put("appKey", jSONObject.optString("appKey"));
            this.gOI.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.gOI.put("timestamp", jSONObject.optString("timestamp"));
            this.gOI.put("totalAmount", jSONObject.optString("totalAmount"));
            this.gOI.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.gOI.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.gOI.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.gOI.put("dealTitle", jSONObject.optString("dealTitle"));
            this.gOI.put("returnData", jSONObject.optString("returnData"));
            this.gOI.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.gOI.put("channel", jSONObject.optString("channel"));
            this.gOI.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.gOI.put("rsaSign", jSONObject.optString("rsaSign"));
            this.gOI.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bUz() {
        return this.gOI;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
