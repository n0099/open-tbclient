package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaFilterAndBeautyResponseMessage extends JsonHttpResponsedMessage {
    private String fWg;
    private AlaFilterAndBeautyData fWh;

    public AlaFilterAndBeautyResponseMessage() {
        super(1021163);
    }

    public AlaFilterAndBeautyData bKJ() {
        return this.fWh;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.fWg)) {
                this.fWg = com.baidu.live.d.AZ().getString("sp_ar_filter_and_beauty_result", "");
            }
            jSONObject = new JSONObject(this.fWg);
        } else {
            this.fWg = jSONObject.toString();
            com.baidu.live.d.AZ().putString("sp_ar_filter_and_beauty_result", this.fWg);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.fWh = new AlaFilterAndBeautyData();
            this.fWh.parse(optJSONObject);
        }
    }

    public AlaFilterAndBeautyData tu(int i) {
        if (i == com.baidu.live.d.AZ().getInt("sp_ar_filter_and_beauty_version", -1)) {
            try {
                decodeLogicInBackGround(1021163, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.live.d.AZ().putString("sp_ar_filter_and_beauty_result", "");
        }
        return this.fWh;
    }
}
