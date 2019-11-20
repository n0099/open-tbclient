package com.baidu.tieba.ala.liveroom.data;

import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.tbadk.log.LogConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {
    public AlaLiveUserInfoData OR;
    public String Pn;
    public a efp;
    public AlaLiveInfoData mLiveInfo;
    public com.baidu.live.data.h mLiveSdkInfo;
    public int mErrorCode = 0;
    public String mErrorMsg = null;
    public int efk = 0;
    public int efl = 1;
    public String efm = null;
    public int efn = 1;
    public String efo = null;
    public long Po = 0;

    /* loaded from: classes6.dex */
    public static class a {
        public List<String> efq = new ArrayList();
        public String notify;
    }

    public boolean aRP() {
        return this.efk == 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Po = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
            if (optJSONObject != null) {
                this.mErrorCode = optJSONObject.optInt("errno");
                this.mErrorMsg = optJSONObject.optString("usermsg");
                if (this.mErrorMsg == null) {
                    this.mErrorMsg = optJSONObject.optString("errmsg");
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 != null) {
                this.efk = optJSONObject2.optInt("user_status");
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("user_info");
                if (optJSONObject3 != null) {
                    this.OR = new AlaLiveUserInfoData();
                    this.OR.parserJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("live_info");
                if (optJSONObject4 != null) {
                    this.mLiveInfo = new AlaLiveInfoData();
                    this.mLiveInfo.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = optJSONObject2.optJSONObject("sdk");
                if (optJSONObject5 != null) {
                    this.mLiveSdkInfo = new com.baidu.live.data.h();
                    this.mLiveSdkInfo.parseJson(optJSONObject5);
                }
                this.Pn = optJSONObject2.optString("user_watermark");
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("strategy");
                if (optJSONObject6 != null) {
                    JSONObject optJSONObject7 = optJSONObject6.optJSONObject(LogConfig.VALUE_LIVE_HK_RECORD_START);
                    if (optJSONObject7 != null) {
                        this.efm = optJSONObject7.optString("text");
                        this.efl = optJSONObject7.optInt("switch");
                    }
                    JSONObject optJSONObject8 = optJSONObject6.optJSONObject("user_verify");
                    if (optJSONObject8 != null) {
                        this.efn = optJSONObject8.optInt("switch");
                        this.efo = optJSONObject8.optString("text");
                    }
                }
                JSONObject optJSONObject9 = optJSONObject2.optJSONObject("live_authen_info");
                if (optJSONObject9 != null) {
                    this.efp = new a();
                    this.efp.notify = optJSONObject9.optString("notify");
                    JSONArray optJSONArray = optJSONObject9.optJSONArray("questions");
                    for (int i = 0; optJSONArray != null && i < optJSONArray.length(); i++) {
                        this.efp.efq.add(optJSONArray.optString(i));
                    }
                }
            }
        }
    }
}
