package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> gJp;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.gJp = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.gJp.put("dealId", jSONObject.optString("dealId"));
            this.gJp.put("appKey", jSONObject.optString("appKey"));
            this.gJp.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.gJp.put("timestamp", jSONObject.optString("timestamp"));
            this.gJp.put("totalAmount", jSONObject.optString("totalAmount"));
            this.gJp.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.gJp.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.gJp.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.gJp.put("dealTitle", jSONObject.optString("dealTitle"));
            this.gJp.put("returnData", jSONObject.optString("returnData"));
            this.gJp.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.gJp.put("channel", jSONObject.optString("channel"));
            this.gJp.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.gJp.put("rsaSign", jSONObject.optString("rsaSign"));
            this.gJp.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bSH() {
        return this.gJp;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
