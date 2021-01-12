package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class j extends BaseData {
    private String aUw;
    private long aUx;
    private String aUz;
    private long anchorId;
    private int countDown;
    private long gQb;
    private boolean gQc;
    private k[] gQd;
    private int giftId;
    private long liveId;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            this.gQb = jSONObject.optLong("tying_gift_id");
            this.aUw = jSONObject.optString("tying_gift_name");
            this.liveId = jSONObject.optLong("live_id");
            this.anchorId = jSONObject.optLong("anchor_id");
            this.aUx = jSONObject.optLong("pay_userid");
            this.aUz = jSONObject.optString("pay_username");
            this.countDown = jSONObject.optInt("count_down");
            if (jSONObject.optInt("tying_status") == 1) {
                this.gQc = true;
            } else {
                this.gQc = false;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("gift_member");
            if (optJSONArray != null) {
                this.gQd = new k[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.gQd[i] = new k(optJSONArray.getJSONObject(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public String DF() {
        return this.aUw;
    }

    public int bTF() {
        return this.countDown;
    }

    public boolean bTG() {
        return this.gQc;
    }

    public k[] bTH() {
        return this.gQd;
    }
}
