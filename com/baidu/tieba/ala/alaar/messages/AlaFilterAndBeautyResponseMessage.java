package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaFilterAndBeautyResponseMessage extends JsonHttpResponsedMessage {
    private String gbE;
    private AlaFilterAndBeautyData gbF;

    public AlaFilterAndBeautyResponseMessage() {
        super(1021163);
    }

    public AlaFilterAndBeautyData bMB() {
        return this.gbF;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.gbE)) {
                this.gbE = com.baidu.live.d.Aq().getString("sp_ar_filter_and_beauty_result", "");
            }
            jSONObject = new JSONObject(this.gbE);
        } else {
            this.gbE = jSONObject.toString();
            com.baidu.live.d.Aq().putString("sp_ar_filter_and_beauty_result", this.gbE);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.gbF = new AlaFilterAndBeautyData();
            this.gbF.parse(optJSONObject);
        }
    }

    public AlaFilterAndBeautyData uc(int i) {
        if (i == com.baidu.live.d.Aq().getInt("sp_ar_filter_and_beauty_version", -1)) {
            try {
                decodeLogicInBackGround(1021163, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.live.d.Aq().putString("sp_ar_filter_and_beauty_result", "");
        }
        return this.gbF;
    }
}
