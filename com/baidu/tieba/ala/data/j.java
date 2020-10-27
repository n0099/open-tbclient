package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j extends BaseData {
    private String aUQ;
    private long aUR;
    private String aUT;
    private long anchorId;
    private int countDown;
    private int giftId;
    private long guB;
    private boolean guC;
    private k[] guD;
    private long liveId;

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
            this.guB = jSONObject.optLong("tying_gift_id");
            this.aUQ = jSONObject.optString("tying_gift_name");
            this.liveId = jSONObject.optLong("live_id");
            this.anchorId = jSONObject.optLong("anchor_id");
            this.aUR = jSONObject.optLong("pay_userid");
            this.aUT = jSONObject.optString("pay_username");
            this.countDown = jSONObject.optInt("count_down");
            if (jSONObject.optInt("tying_status") == 1) {
                this.guC = true;
            } else {
                this.guC = false;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("gift_member");
            if (optJSONArray != null) {
                this.guD = new k[optJSONArray.length()];
                for (int i = 0; i < optJSONArray.length(); i++) {
                    try {
                        this.guD[i] = new k(optJSONArray.getJSONObject(i));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public String Gs() {
        return this.aUQ;
    }

    public int bPo() {
        return this.countDown;
    }

    public boolean bPp() {
        return this.guC;
    }

    public k[] bPq() {
        return this.guD;
    }
}
