package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaFilterAndBeautyResponseMessage extends JsonHttpResponsedMessage {
    private String gjR;
    private AlaFilterAndBeautyData gjS;

    public AlaFilterAndBeautyResponseMessage() {
        super(1021163);
    }

    public AlaFilterAndBeautyData bQn() {
        return this.gjS;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.gjR)) {
                this.gjR = com.baidu.live.d.BM().getString("sp_ar_filter_and_beauty_result", "");
            }
            jSONObject = new JSONObject(this.gjR);
        } else {
            this.gjR = jSONObject.toString();
            com.baidu.live.d.BM().putString("sp_ar_filter_and_beauty_result", this.gjR);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.gjS = new AlaFilterAndBeautyData();
            this.gjS.parse(optJSONObject);
        }
    }

    public AlaFilterAndBeautyData uG(int i) {
        if (i == com.baidu.live.d.BM().getInt("sp_ar_filter_and_beauty_version", -1)) {
            try {
                decodeLogicInBackGround(1021163, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            com.baidu.live.d.BM().putString("sp_ar_filter_and_beauty_result", "");
        }
        return this.gjS;
    }
}
