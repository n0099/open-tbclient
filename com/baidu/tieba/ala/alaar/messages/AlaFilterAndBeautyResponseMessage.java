package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaFilterAndBeautyResponseMessage extends JsonHttpResponsedMessage {
    private String gup;
    private AlaFilterAndBeautyData guq;

    public AlaFilterAndBeautyResponseMessage() {
        super(1021163);
    }

    public AlaFilterAndBeautyData bPM() {
        return this.guq;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.gup)) {
                this.gup = com.baidu.live.d.xf().getString("sp_ar_filter_and_beauty_result", "");
            }
            jSONObject = new JSONObject(this.gup);
        } else {
            this.gup = jSONObject.toString();
            com.baidu.live.d.xf().putString("sp_ar_filter_and_beauty_result", this.gup);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.guq = new AlaFilterAndBeautyData();
            this.guq.parse(optJSONObject);
        }
    }

    public AlaFilterAndBeautyData tu(int i) {
        if (i == com.baidu.live.d.xf().getInt("sp_ar_filter_and_beauty_version", -1)) {
            try {
                decodeLogicInBackGround(1021163, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.live.d.xf().putString("sp_ar_filter_and_beauty_result", "");
        }
        return this.guq;
    }
}
