package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.l;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    public String aqE;
    public boolean aqI;
    public AlaLiveUserInfoData aqe;
    public a fFQ;
    public AlaLiveInfoData mLiveInfo;
    public l mLiveSdkInfo;
    public int mErrorCode = 0;
    public String mErrorMsg = null;
    public int fFL = 0;
    public int fFM = 1;
    public String fFN = null;
    public int fFO = 1;
    public String fFP = null;
    public long aqG = 0;

    /* loaded from: classes3.dex */
    public static class a {
        public List<String> fFR = new ArrayList();
        public String notify;
    }

    public boolean bvn() {
        return this.fFL == 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aqG = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
            if (optJSONObject != null) {
                this.mErrorCode = optJSONObject.optInt(BaseJsonData.TAG_ERRNO);
                this.mErrorMsg = optJSONObject.optString("usermsg");
                if (TextUtils.isEmpty(this.mErrorMsg)) {
                    this.mErrorMsg = optJSONObject.optString(BaseJsonData.TAG_ERRMSG);
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 != null) {
                this.fFL = optJSONObject2.optInt("user_status");
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("user_info");
                if (optJSONObject3 != null) {
                    this.aqe = new AlaLiveUserInfoData();
                    this.aqe.parserJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("live_info");
                if (optJSONObject4 != null) {
                    this.mLiveInfo = new AlaLiveInfoData();
                    this.mLiveInfo.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = optJSONObject2.optJSONObject(CashierData.SDK);
                if (optJSONObject5 != null) {
                    this.mLiveSdkInfo = new l();
                    this.mLiveSdkInfo.parseJson(optJSONObject5);
                }
                if (this.mLiveInfo != null && this.mLiveSdkInfo != null && this.mLiveInfo.room_id == 0 && this.mLiveSdkInfo.mRoomId != 0) {
                    this.mLiveInfo.room_id = this.mLiveSdkInfo.mRoomId;
                }
                this.aqE = optJSONObject2.optString("user_watermark");
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("strategy");
                if (optJSONObject6 != null) {
                    JSONObject optJSONObject7 = optJSONObject6.optJSONObject(LogConfig.VALUE_LIVE_HK_RECORD_START);
                    if (optJSONObject7 != null) {
                        this.fFN = optJSONObject7.optString("text");
                        this.fFM = optJSONObject7.optInt("switch");
                    }
                    JSONObject optJSONObject8 = optJSONObject6.optJSONObject("user_verify");
                    if (optJSONObject8 != null) {
                        this.fFO = optJSONObject8.optInt("switch");
                        this.fFP = optJSONObject8.optString("text");
                    }
                }
                JSONObject optJSONObject9 = optJSONObject2.optJSONObject("live_authen_info");
                if (optJSONObject9 != null) {
                    this.fFQ = new a();
                    this.fFQ.notify = optJSONObject9.optString("notify");
                    JSONArray optJSONArray = optJSONObject9.optJSONArray("questions");
                    for (int i = 0; optJSONArray != null && i < optJSONArray.length(); i++) {
                        this.fFQ.fFR.add(optJSONArray.optString(i));
                    }
                }
                this.aqI = optJSONObject2.optInt("switch_guard_seat") == 1;
            }
        }
    }
}
