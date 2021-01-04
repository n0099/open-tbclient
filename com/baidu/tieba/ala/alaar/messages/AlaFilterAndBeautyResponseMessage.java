package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaFilterAndBeautyResponseMessage extends JsonHttpResponsedMessage {
    private String guq;
    private AlaFilterAndBeautyData gur;

    public AlaFilterAndBeautyResponseMessage() {
        super(1021163);
    }

    public AlaFilterAndBeautyData bSM() {
        return this.gur;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.guq)) {
                this.guq = com.baidu.live.d.Ba().getString("sp_ar_filter_and_beauty_result", "");
            }
            jSONObject = new JSONObject(this.guq);
        } else {
            this.guq = jSONObject.toString();
            com.baidu.live.d.Ba().putString("sp_ar_filter_and_beauty_result", this.guq);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.gur = new AlaFilterAndBeautyData();
            this.gur.parse(optJSONObject);
        }
    }

    public AlaFilterAndBeautyData uS(int i) {
        if (i == com.baidu.live.d.Ba().getInt("sp_ar_filter_and_beauty_version", -1)) {
            try {
                decodeLogicInBackGround(1021163, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.live.d.Ba().putString("sp_ar_filter_and_beauty_result", "");
        }
        return this.gur;
    }
}
