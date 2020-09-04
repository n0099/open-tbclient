package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> gfX;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.gfX = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.gfX.put("dealId", jSONObject.optString("dealId"));
            this.gfX.put("appKey", jSONObject.optString("appKey"));
            this.gfX.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.gfX.put("timestamp", jSONObject.optString("timestamp"));
            this.gfX.put("totalAmount", jSONObject.optString("totalAmount"));
            this.gfX.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.gfX.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.gfX.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.gfX.put("dealTitle", jSONObject.optString("dealTitle"));
            this.gfX.put("returnData", jSONObject.optString("returnData"));
            this.gfX.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.gfX.put("channel", jSONObject.optString("channel"));
            this.gfX.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.gfX.put("rsaSign", jSONObject.optString("rsaSign"));
            this.gfX.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bLj() {
        return this.gfX;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
