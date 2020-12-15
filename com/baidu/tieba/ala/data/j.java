package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j extends BaseData {
    private String aXE;
    private long aXF;
    private String aXH;
    private long anchorId;
    private int countDown;
    private long gIV;
    private boolean gIW;
    private k[] gIX;
    private int giftId;
    private long liveId;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            this.gIV = jSONObject.optLong("tying_gift_id");
            this.aXE = jSONObject.optString("tying_gift_name");
            this.liveId = jSONObject.optLong("live_id");
            this.anchorId = jSONObject.optLong("anchor_id");
            this.aXF = jSONObject.optLong("pay_userid");
            this.aXH = jSONObject.optString("pay_username");
            this.countDown = jSONObject.optInt("count_down");
            if (jSONObject.optInt("tying_status") == 1) {
                this.gIW = true;
            } else {
                this.gIW = false;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("gift_member");
            if (optJSONArray != null) {
                this.gIX = new k[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.gIX[i] = new k(optJSONArray.getJSONObject(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public String HZ() {
        return this.aXE;
    }

    public int bUS() {
        return this.countDown;
    }

    public boolean bUT() {
        return this.gIW;
    }

    public k[] bUU() {
        return this.gIX;
    }
}
