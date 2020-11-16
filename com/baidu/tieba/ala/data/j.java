package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j extends BaseData {
    private String aUA;
    private String aUx;
    private long aUy;
    private long anchorId;
    private int countDown;
    private int giftId;
    private long gzW;
    private boolean gzX;
    private k[] gzY;
    private long liveId;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            this.gzW = jSONObject.optLong("tying_gift_id");
            this.aUx = jSONObject.optString("tying_gift_name");
            this.liveId = jSONObject.optLong("live_id");
            this.anchorId = jSONObject.optLong("anchor_id");
            this.aUy = jSONObject.optLong("pay_userid");
            this.aUA = jSONObject.optString("pay_username");
            this.countDown = jSONObject.optInt("count_down");
            if (jSONObject.optInt("tying_status") == 1) {
                this.gzX = true;
            } else {
                this.gzX = false;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("gift_member");
            if (optJSONArray != null) {
                this.gzY = new k[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.gzY[i] = new k(optJSONArray.getJSONObject(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public String Gk() {
        return this.aUx;
    }

    public int bRh() {
        return this.countDown;
    }

    public boolean bRi() {
        return this.gzX;
    }

    public k[] bRj() {
        return this.gzY;
    }
}
