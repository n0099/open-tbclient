package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> fpn;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.fpn = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.fpn.put("dealId", jSONObject.optString("dealId"));
            this.fpn.put("appKey", jSONObject.optString("appKey"));
            this.fpn.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.fpn.put("timestamp", jSONObject.optString("timestamp"));
            this.fpn.put("totalAmount", jSONObject.optString("totalAmount"));
            this.fpn.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.fpn.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.fpn.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.fpn.put("dealTitle", jSONObject.optString("dealTitle"));
            this.fpn.put("returnData", jSONObject.optString("returnData"));
            this.fpn.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.fpn.put("channel", jSONObject.optString("channel"));
            this.fpn.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.fpn.put("rsaSign", jSONObject.optString("rsaSign"));
            this.fpn.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bpM() {
        return this.fpn;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
