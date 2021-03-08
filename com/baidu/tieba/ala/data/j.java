package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class j extends BaseData {
    private String aZb;
    private long aZc;
    private String aZe;
    private long anchorId;
    private int countDown;
    private long gUI;
    private boolean gUJ;
    private k[] gUK;
    private int giftId;
    private long liveId;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            this.gUI = jSONObject.optLong("tying_gift_id");
            this.aZb = jSONObject.optString("tying_gift_name");
            this.liveId = jSONObject.optLong("live_id");
            this.anchorId = jSONObject.optLong("anchor_id");
            this.aZc = jSONObject.optLong("pay_userid");
            this.aZe = jSONObject.optString("pay_username");
            this.countDown = jSONObject.optInt("count_down");
            if (jSONObject.optInt("tying_status") == 1) {
                this.gUJ = true;
            } else {
                this.gUJ = false;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("gift_member");
            if (optJSONArray != null) {
                this.gUK = new k[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.gUK[i] = new k(optJSONArray.getJSONObject(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public String EY() {
        return this.aZb;
    }

    public int bUx() {
        return this.countDown;
    }

    public boolean bUy() {
        return this.gUJ;
    }

    public k[] bUz() {
        return this.gUK;
    }
}
