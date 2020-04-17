package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.c;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaFilterAndBeautyResponseMessage extends JsonHttpResponsedMessage {
    private String eJT;
    private AlaFilterAndBeautyData eJU;

    public AlaFilterAndBeautyResponseMessage() {
        super(1021163);
    }

    public AlaFilterAndBeautyData bkh() {
        return this.eJU;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.eJT)) {
                this.eJT = c.tH().getString("sp_ar_filter_and_beauty_result", "");
            }
            jSONObject = new JSONObject(this.eJT);
        } else {
            this.eJT = jSONObject.toString();
            c.tH().putString("sp_ar_filter_and_beauty_result", this.eJT);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.eJU = new AlaFilterAndBeautyData();
            this.eJU.parse(optJSONObject);
        }
    }

    public AlaFilterAndBeautyData oQ(int i) {
        if (i == c.tH().getInt("sp_ar_filter_and_beauty_version", -1)) {
            try {
                decodeLogicInBackGround(1021163, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            c.tH().putString("sp_ar_filter_and_beauty_result", "");
        }
        return this.eJU;
    }
}
