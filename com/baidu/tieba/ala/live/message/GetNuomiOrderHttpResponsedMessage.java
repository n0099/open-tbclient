package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> gfT;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.gfT = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.gfT.put("dealId", jSONObject.optString("dealId"));
            this.gfT.put("appKey", jSONObject.optString("appKey"));
            this.gfT.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.gfT.put("timestamp", jSONObject.optString("timestamp"));
            this.gfT.put("totalAmount", jSONObject.optString("totalAmount"));
            this.gfT.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.gfT.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.gfT.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.gfT.put("dealTitle", jSONObject.optString("dealTitle"));
            this.gfT.put("returnData", jSONObject.optString("returnData"));
            this.gfT.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.gfT.put("channel", jSONObject.optString("channel"));
            this.gfT.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.gfT.put("rsaSign", jSONObject.optString("rsaSign"));
            this.gfT.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bLi() {
        return this.gfT;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
