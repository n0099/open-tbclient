package com.baidu.tieba.ala.liveroom.data;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.j;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {
    public AlaLiveUserInfoData VP;
    public String Wi;
    public boolean Wl;
    public a eVj;
    public AlaLiveInfoData mLiveInfo;
    public j mLiveSdkInfo;
    public int mErrorCode = 0;
    public String mErrorMsg = null;
    public int eVe = 0;
    public int eVf = 1;
    public String eVg = null;
    public int eVh = 1;
    public String eVi = null;
    public long Wj = 0;

    /* loaded from: classes2.dex */
    public static class a {
        public List<String> eVk = new ArrayList();
        public String notify;
    }

    public boolean bjp() {
        return this.eVe == 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Wj = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
            if (optJSONObject != null) {
                this.mErrorCode = optJSONObject.optInt("errno");
                this.mErrorMsg = optJSONObject.optString("usermsg");
                if (this.mErrorMsg == null) {
                    this.mErrorMsg = optJSONObject.optString(BaseJsonData.TAG_ERRMSG);
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 != null) {
                this.eVe = optJSONObject2.optInt("user_status");
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("user_info");
                if (optJSONObject3 != null) {
                    this.VP = new AlaLiveUserInfoData();
                    this.VP.parserJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("live_info");
                if (optJSONObject4 != null) {
                    this.mLiveInfo = new AlaLiveInfoData();
                    this.mLiveInfo.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = optJSONObject2.optJSONObject(CashierData.SDK);
                if (optJSONObject5 != null) {
                    this.mLiveSdkInfo = new j();
                    this.mLiveSdkInfo.parseJson(optJSONObject5);
                }
                this.Wi = optJSONObject2.optString("user_watermark");
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("strategy");
                if (optJSONObject6 != null) {
                    JSONObject optJSONObject7 = optJSONObject6.optJSONObject(LogConfig.VALUE_LIVE_HK_RECORD_START);
                    if (optJSONObject7 != null) {
                        this.eVg = optJSONObject7.optString("text");
                        this.eVf = optJSONObject7.optInt("switch");
                    }
                    JSONObject optJSONObject8 = optJSONObject6.optJSONObject("user_verify");
                    if (optJSONObject8 != null) {
                        this.eVh = optJSONObject8.optInt("switch");
                        this.eVi = optJSONObject8.optString("text");
                    }
                }
                JSONObject optJSONObject9 = optJSONObject2.optJSONObject("live_authen_info");
                if (optJSONObject9 != null) {
                    this.eVj = new a();
                    this.eVj.notify = optJSONObject9.optString("notify");
                    JSONArray optJSONArray = optJSONObject9.optJSONArray("questions");
                    for (int i = 0; optJSONArray != null && i < optJSONArray.length(); i++) {
                        this.eVj.eVk.add(optJSONArray.optString(i));
                    }
                }
                this.Wl = optJSONObject2.optInt("switch_guard_seat") == 1;
            }
        }
    }
}
