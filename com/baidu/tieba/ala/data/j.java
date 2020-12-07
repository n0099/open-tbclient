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
    private long gIT;
    private boolean gIU;
    private k[] gIV;
    private int giftId;
    private long liveId;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            this.gIT = jSONObject.optLong("tying_gift_id");
            this.aXE = jSONObject.optString("tying_gift_name");
            this.liveId = jSONObject.optLong("live_id");
            this.anchorId = jSONObject.optLong("anchor_id");
            this.aXF = jSONObject.optLong("pay_userid");
            this.aXH = jSONObject.optString("pay_username");
            this.countDown = jSONObject.optInt("count_down");
            if (jSONObject.optInt("tying_status") == 1) {
                this.gIU = true;
            } else {
                this.gIU = false;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("gift_member");
            if (optJSONArray != null) {
                this.gIV = new k[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.gIV[i] = new k(optJSONArray.getJSONObject(i));
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

    public int bUR() {
        return this.countDown;
    }

    public boolean bUS() {
        return this.gIU;
    }

    public k[] bUT() {
        return this.gIV;
    }
}
