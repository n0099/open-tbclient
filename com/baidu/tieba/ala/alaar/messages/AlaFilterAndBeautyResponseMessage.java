package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaFilterAndBeautyResponseMessage extends JsonHttpResponsedMessage {
    private String gss;
    private AlaFilterAndBeautyData gst;

    public AlaFilterAndBeautyResponseMessage() {
        super(1021163);
    }

    public AlaFilterAndBeautyData bPz() {
        return this.gst;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null || hasError()) {
            if (StringUtils.isNullObject(this.gss)) {
                this.gss = com.baidu.live.d.xc().getString("sp_ar_filter_and_beauty_result", "");
            }
            jSONObject = new JSONObject(this.gss);
        } else {
            this.gss = jSONObject.toString();
            com.baidu.live.d.xc().putString("sp_ar_filter_and_beauty_result", this.gss);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.gst = new AlaFilterAndBeautyData();
            this.gst.parse(optJSONObject);
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
        return this.gst;
    }
}
