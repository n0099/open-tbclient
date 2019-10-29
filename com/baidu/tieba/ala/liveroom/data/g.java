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
    public String PR;
    public AlaLiveUserInfoData Ps;
    public a egg;
    public AlaLiveInfoData mLiveInfo;
    public com.baidu.live.data.h mLiveSdkInfo;
    public int mErrorCode = 0;
    public String mErrorMsg = null;
    public int egb = 0;
    public int egc = 1;
    public String egd = null;
    public int ege = 1;
    public String egf = null;
    public long PT = 0;

    /* loaded from: classes6.dex */
    public static class a {
        public List<String> egh = new ArrayList();
        public String notify;
    }

    public boolean aRR() {
        return this.egb == 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.PT = jSONObject.optLong("logid");
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
                this.egb = optJSONObject2.optInt("user_status");
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("user_info");
                if (optJSONObject3 != null) {
                    this.Ps = new AlaLiveUserInfoData();
                    this.Ps.parserJson(optJSONObject3);
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
                this.PR = optJSONObject2.optString("user_watermark");
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("strategy");
                if (optJSONObject6 != null) {
                    JSONObject optJSONObject7 = optJSONObject6.optJSONObject(LogConfig.VALUE_LIVE_HK_RECORD_START);
                    if (optJSONObject7 != null) {
                        this.egd = optJSONObject7.optString("text");
                        this.egc = optJSONObject7.optInt("switch");
                    }
                    JSONObject optJSONObject8 = optJSONObject6.optJSONObject("user_verify");
                    if (optJSONObject8 != null) {
                        this.ege = optJSONObject8.optInt("switch");
                        this.egf = optJSONObject8.optString("text");
                    }
                }
                JSONObject optJSONObject9 = optJSONObject2.optJSONObject("live_authen_info");
                if (optJSONObject9 != null) {
                    this.egg = new a();
                    this.egg.notify = optJSONObject9.optString("notify");
                    JSONArray optJSONArray = optJSONObject9.optJSONArray("questions");
                    for (int i = 0; optJSONArray != null && i < optJSONArray.length(); i++) {
                        this.egg.egh.add(optJSONArray.optString(i));
                    }
                }
            }
        }
    }
}
