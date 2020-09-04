package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaFilterAndBeautyResponseMessage extends JsonHttpResponsedMessage {
    private String fxB;
    private AlaFilterAndBeautyData fxC;

    public AlaFilterAndBeautyResponseMessage() {
        super(1021163);
    }

    public AlaFilterAndBeautyData bEi() {
        return this.fxC;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.fxB)) {
                this.fxB = com.baidu.live.c.AD().getString("sp_ar_filter_and_beauty_result", "");
            }
            jSONObject = new JSONObject(this.fxB);
        } else {
            this.fxB = jSONObject.toString();
            com.baidu.live.c.AD().putString("sp_ar_filter_and_beauty_result", this.fxB);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.fxC = new AlaFilterAndBeautyData();
            this.fxC.parse(optJSONObject);
        }
    }

    public AlaFilterAndBeautyData ss(int i) {
        if (i == com.baidu.live.c.AD().getInt("sp_ar_filter_and_beauty_version", -1)) {
            try {
                decodeLogicInBackGround(1021163, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.live.c.AD().putString("sp_ar_filter_and_beauty_result", "");
        }
        return this.fxC;
    }
}
