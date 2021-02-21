package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class j extends BaseData {
    private String aXB;
    private long aXC;
    private String aXE;
    private long anchorId;
    private int countDown;
    private long gSZ;
    private boolean gTa;
    private k[] gTb;
    private int giftId;
    private long liveId;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            this.gSZ = jSONObject.optLong("tying_gift_id");
            this.aXB = jSONObject.optString("tying_gift_name");
            this.liveId = jSONObject.optLong("live_id");
            this.anchorId = jSONObject.optLong("anchor_id");
            this.aXC = jSONObject.optLong("pay_userid");
            this.aXE = jSONObject.optString("pay_username");
            this.countDown = jSONObject.optInt("count_down");
            if (jSONObject.optInt("tying_status") == 1) {
                this.gTa = true;
            } else {
                this.gTa = false;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("gift_member");
            if (optJSONArray != null) {
                this.gTb = new k[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.gTb[i] = new k(optJSONArray.getJSONObject(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public String EV() {
        return this.aXB;
    }

    public int bUr() {
        return this.countDown;
    }

    public boolean bUs() {
        return this.gTa;
    }

    public k[] bUt() {
        return this.gTb;
    }
}
