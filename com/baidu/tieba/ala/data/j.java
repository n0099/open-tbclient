package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j extends BaseData {
    private String aWi;
    private long aWj;
    private String aWl;
    private long anchorId;
    private int countDown;
    private long gAp;
    private boolean gAq;
    private k[] gAr;
    private int giftId;
    private long liveId;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            this.gAp = jSONObject.optLong("tying_gift_id");
            this.aWi = jSONObject.optString("tying_gift_name");
            this.liveId = jSONObject.optLong("live_id");
            this.anchorId = jSONObject.optLong("anchor_id");
            this.aWj = jSONObject.optLong("pay_userid");
            this.aWl = jSONObject.optString("pay_username");
            this.countDown = jSONObject.optInt("count_down");
            if (jSONObject.optInt("tying_status") == 1) {
                this.gAq = true;
            } else {
                this.gAq = false;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("gift_member");
            if (optJSONArray != null) {
                this.gAr = new k[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.gAr[i] = new k(optJSONArray.getJSONObject(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public String GT() {
        return this.aWi;
    }

    public int bRO() {
        return this.countDown;
    }

    public boolean bRP() {
        return this.gAq;
    }

    public k[] bRQ() {
        return this.gAr;
    }
}
