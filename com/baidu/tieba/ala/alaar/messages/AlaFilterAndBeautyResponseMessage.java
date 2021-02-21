package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaFilterAndBeautyResponseMessage extends JsonHttpResponsedMessage {
    private String gsG;
    private AlaFilterAndBeautyData gsH;

    public AlaFilterAndBeautyResponseMessage() {
        super(1021163);
    }

    public AlaFilterAndBeautyData bPG() {
        return this.gsH;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.gsG)) {
                this.gsG = com.baidu.live.d.xc().getString("sp_ar_filter_and_beauty_result", "");
            }
            jSONObject = new JSONObject(this.gsG);
        } else {
            this.gsG = jSONObject.toString();
            com.baidu.live.d.xc().putString("sp_ar_filter_and_beauty_result", this.gsG);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.gsH = new AlaFilterAndBeautyData();
            this.gsH.parse(optJSONObject);
        }
    }

    public AlaFilterAndBeautyData ts(int i) {
        if (i == com.baidu.live.d.xc().getInt("sp_ar_filter_and_beauty_version", -1)) {
            try {
                decodeLogicInBackGround(1021163, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.live.d.xc().putString("sp_ar_filter_and_beauty_result", "");
        }
        return this.gsH;
    }
}
