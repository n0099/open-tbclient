package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaFilterAndBeautyResponseMessage extends JsonHttpResponsedMessage {
    private String fmb;
    private AlaFilterAndBeautyData fmc;

    public AlaFilterAndBeautyResponseMessage() {
        super(1021163);
    }

    public AlaFilterAndBeautyData bvm() {
        return this.fmc;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.fmb)) {
                this.fmb = com.baidu.live.c.vf().getString("sp_ar_filter_and_beauty_result", "");
            }
            jSONObject = new JSONObject(this.fmb);
        } else {
            this.fmb = jSONObject.toString();
            com.baidu.live.c.vf().putString("sp_ar_filter_and_beauty_result", this.fmb);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.fmc = new AlaFilterAndBeautyData();
            this.fmc.parse(optJSONObject);
        }
    }

    public AlaFilterAndBeautyData qg(int i) {
        if (i == com.baidu.live.c.vf().getInt("sp_ar_filter_and_beauty_version", -1)) {
            try {
                decodeLogicInBackGround(1021163, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.live.c.vf().putString("sp_ar_filter_and_beauty_result", "");
        }
        return this.fmc;
    }
}
