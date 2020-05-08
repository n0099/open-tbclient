package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.c;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaFilterAndBeautyResponseMessage extends JsonHttpResponsedMessage {
    private String eJY;
    private AlaFilterAndBeautyData eJZ;

    public AlaFilterAndBeautyResponseMessage() {
        super(1021163);
    }

    public AlaFilterAndBeautyData bkf() {
        return this.eJZ;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.eJY)) {
                this.eJY = c.tG().getString("sp_ar_filter_and_beauty_result", "");
            }
            jSONObject = new JSONObject(this.eJY);
        } else {
            this.eJY = jSONObject.toString();
            c.tG().putString("sp_ar_filter_and_beauty_result", this.eJY);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.eJZ = new AlaFilterAndBeautyData();
            this.eJZ.parse(optJSONObject);
        }
    }

    public AlaFilterAndBeautyData oQ(int i) {
        if (i == c.tG().getInt("sp_ar_filter_and_beauty_version", -1)) {
            try {
                decodeLogicInBackGround(1021163, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            c.tG().putString("sp_ar_filter_and_beauty_result", "");
        }
        return this.eJZ;
    }
}
