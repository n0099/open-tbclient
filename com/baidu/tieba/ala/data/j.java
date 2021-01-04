package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class j extends BaseData {
    private String aZj;
    private long aZk;
    private String aZm;
    private long anchorId;
    private int countDown;
    private long gUH;
    private boolean gUI;
    private k[] gUJ;
    private int giftId;
    private long liveId;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            this.gUH = jSONObject.optLong("tying_gift_id");
            this.aZj = jSONObject.optString("tying_gift_name");
            this.liveId = jSONObject.optLong("live_id");
            this.anchorId = jSONObject.optLong("anchor_id");
            this.aZk = jSONObject.optLong("pay_userid");
            this.aZm = jSONObject.optString("pay_username");
            this.countDown = jSONObject.optInt("count_down");
            if (jSONObject.optInt("tying_status") == 1) {
                this.gUI = true;
            } else {
                this.gUI = false;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("gift_member");
            if (optJSONArray != null) {
                this.gUJ = new k[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.gUJ[i] = new k(optJSONArray.getJSONObject(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public String HA() {
        return this.aZj;
    }

    public int bXw() {
        return this.countDown;
    }

    public boolean bXx() {
        return this.gUI;
    }

    public k[] bXy() {
        return this.gUJ;
    }
}
