package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaFilterAndBeautyResponseMessage extends JsonHttpResponsedMessage {
    private String fMW;
    private AlaFilterAndBeautyData fMX;

    public AlaFilterAndBeautyResponseMessage() {
        super(1021163);
    }

    public AlaFilterAndBeautyData bIk() {
        return this.fMX;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.fMW)) {
                this.fMW = com.baidu.live.c.AZ().getString("sp_ar_filter_and_beauty_result", "");
            }
            jSONObject = new JSONObject(this.fMW);
        } else {
            this.fMW = jSONObject.toString();
            com.baidu.live.c.AZ().putString("sp_ar_filter_and_beauty_result", this.fMW);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.fMX = new AlaFilterAndBeautyData();
            this.fMX.parse(optJSONObject);
        }
    }

    public AlaFilterAndBeautyData ti(int i) {
        if (i == com.baidu.live.c.AZ().getInt("sp_ar_filter_and_beauty_version", -1)) {
            try {
                decodeLogicInBackGround(1021163, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.live.c.AZ().putString("sp_ar_filter_and_beauty_result", "");
        }
        return this.fMX;
    }
}
