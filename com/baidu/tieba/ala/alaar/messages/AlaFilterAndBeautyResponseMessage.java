package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaFilterAndBeautyResponseMessage extends JsonHttpResponsedMessage {
    private String fgT;
    private AlaFilterAndBeautyData fgU;

    public AlaFilterAndBeautyResponseMessage() {
        super(1021163);
    }

    public AlaFilterAndBeautyData bsc() {
        return this.fgU;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.fgT)) {
                this.fgT = com.baidu.live.c.vf().getString("sp_ar_filter_and_beauty_result", "");
            }
            jSONObject = new JSONObject(this.fgT);
        } else {
            this.fgT = jSONObject.toString();
            com.baidu.live.c.vf().putString("sp_ar_filter_and_beauty_result", this.fgT);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.fgU = new AlaFilterAndBeautyData();
            this.fgU.parse(optJSONObject);
        }
    }

    public AlaFilterAndBeautyData pR(int i) {
        if (i == com.baidu.live.c.vf().getInt("sp_ar_filter_and_beauty_version", -1)) {
            try {
                decodeLogicInBackGround(1021163, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.live.c.vf().putString("sp_ar_filter_and_beauty_result", "");
        }
        return this.fgU;
    }
}
