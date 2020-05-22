package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.c;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaFilterAndBeautyResponseMessage extends JsonHttpResponsedMessage {
    private String eWv;
    private AlaFilterAndBeautyData eWw;

    public AlaFilterAndBeautyResponseMessage() {
        super(1021163);
    }

    public AlaFilterAndBeautyData bpz() {
        return this.eWw;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.eWv)) {
                this.eWv = c.uN().getString("sp_ar_filter_and_beauty_result", "");
            }
            jSONObject = new JSONObject(this.eWv);
        } else {
            this.eWv = jSONObject.toString();
            c.uN().putString("sp_ar_filter_and_beauty_result", this.eWv);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.eWw = new AlaFilterAndBeautyData();
            this.eWw.parse(optJSONObject);
        }
    }

    public AlaFilterAndBeautyData pr(int i) {
        if (i == c.uN().getInt("sp_ar_filter_and_beauty_version", -1)) {
            try {
                decodeLogicInBackGround(1021163, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            c.uN().putString("sp_ar_filter_and_beauty_result", "");
        }
        return this.eWw;
    }
}
