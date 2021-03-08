package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> hls;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.hls = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.hls.put("dealId", jSONObject.optString("dealId"));
            this.hls.put("appKey", jSONObject.optString("appKey"));
            this.hls.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.hls.put("timestamp", jSONObject.optString("timestamp"));
            this.hls.put("totalAmount", jSONObject.optString("totalAmount"));
            this.hls.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.hls.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.hls.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.hls.put("dealTitle", jSONObject.optString("dealTitle"));
            this.hls.put("returnData", jSONObject.optString("returnData"));
            this.hls.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.hls.put("channel", jSONObject.optString("channel"));
            this.hls.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.hls.put("rsaSign", jSONObject.optString("rsaSign"));
            this.hls.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bYk() {
        return this.hls;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
