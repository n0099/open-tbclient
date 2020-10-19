package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> gxB;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.gxB = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.gxB.put("dealId", jSONObject.optString("dealId"));
            this.gxB.put("appKey", jSONObject.optString("appKey"));
            this.gxB.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.gxB.put("timestamp", jSONObject.optString("timestamp"));
            this.gxB.put("totalAmount", jSONObject.optString("totalAmount"));
            this.gxB.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.gxB.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.gxB.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.gxB.put("dealTitle", jSONObject.optString("dealTitle"));
            this.gxB.put("returnData", jSONObject.optString("returnData"));
            this.gxB.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.gxB.put("channel", jSONObject.optString("channel"));
            this.gxB.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.gxB.put("rsaSign", jSONObject.optString("rsaSign"));
            this.gxB.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bPK() {
        return this.gxB;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
