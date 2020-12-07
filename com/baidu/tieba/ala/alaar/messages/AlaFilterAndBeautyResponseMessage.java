package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaFilterAndBeautyResponseMessage extends JsonHttpResponsedMessage {
    private String gjP;
    private AlaFilterAndBeautyData gjQ;

    public AlaFilterAndBeautyResponseMessage() {
        super(1021163);
    }

    public AlaFilterAndBeautyData bQm() {
        return this.gjQ;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.gjP)) {
                this.gjP = com.baidu.live.d.BM().getString("sp_ar_filter_and_beauty_result", "");
            }
            jSONObject = new JSONObject(this.gjP);
        } else {
            this.gjP = jSONObject.toString();
            com.baidu.live.d.BM().putString("sp_ar_filter_and_beauty_result", this.gjP);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.gjQ = new AlaFilterAndBeautyData();
            this.gjQ.parse(optJSONObject);
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
        return this.gjQ;
    }
}
