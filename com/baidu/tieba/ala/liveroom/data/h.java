package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.k;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    public AlaLiveUserInfoData XQ;
    public String Yk;
    public boolean Yo;
    public a faW;
    public AlaLiveInfoData mLiveInfo;
    public k mLiveSdkInfo;
    public int mErrorCode = 0;
    public String mErrorMsg = null;
    public int faR = 0;
    public int faS = 1;
    public String faT = null;
    public int faU = 1;
    public String faV = null;
    public long Ym = 0;

    /* loaded from: classes3.dex */
    public static class a {
        public List<String> faX = new ArrayList();
        public String notify;
    }

    public boolean blR() {
        return this.faR == 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.Ym = jSONObject.optLong("logid");
            JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
            if (optJSONObject != null) {
                this.mErrorCode = optJSONObject.optInt("errno");
                this.mErrorMsg = optJSONObject.optString("usermsg");
                if (TextUtils.isEmpty(this.mErrorMsg)) {
                    this.mErrorMsg = optJSONObject.optString(BaseJsonData.TAG_ERRMSG);
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 != null) {
                this.faR = optJSONObject2.optInt("user_status");
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("user_info");
                if (optJSONObject3 != null) {
                    this.XQ = new AlaLiveUserInfoData();
                    this.XQ.parserJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("live_info");
                if (optJSONObject4 != null) {
                    this.mLiveInfo = new AlaLiveInfoData();
                    this.mLiveInfo.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = optJSONObject2.optJSONObject(CashierData.SDK);
                if (optJSONObject5 != null) {
                    this.mLiveSdkInfo = new k();
                    this.mLiveSdkInfo.parseJson(optJSONObject5);
                }
                if (this.mLiveInfo != null && this.mLiveSdkInfo != null && this.mLiveInfo.room_id == 0 && this.mLiveSdkInfo.mRoomId != 0) {
                    this.mLiveInfo.room_id = this.mLiveSdkInfo.mRoomId;
                }
                this.Yk = optJSONObject2.optString("user_watermark");
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject("strategy");
                if (optJSONObject6 != null) {
                    JSONObject optJSONObject7 = optJSONObject6.optJSONObject(LogConfig.VALUE_LIVE_HK_RECORD_START);
                    if (optJSONObject7 != null) {
                        this.faT = optJSONObject7.optString("text");
                        this.faS = optJSONObject7.optInt("switch");
                    }
                    JSONObject optJSONObject8 = optJSONObject6.optJSONObject("user_verify");
                    if (optJSONObject8 != null) {
                        this.faU = optJSONObject8.optInt("switch");
                        this.faV = optJSONObject8.optString("text");
                    }
                }
                JSONObject optJSONObject9 = optJSONObject2.optJSONObject("live_authen_info");
                if (optJSONObject9 != null) {
                    this.faW = new a();
                    this.faW.notify = optJSONObject9.optString("notify");
                    JSONArray optJSONArray = optJSONObject9.optJSONArray("questions");
                    for (int i = 0; optJSONArray != null && i < optJSONArray.length(); i++) {
                        this.faW.faX.add(optJSONArray.optString(i));
                    }
                }
                this.Yo = optJSONObject2.optInt("switch_guard_seat") == 1;
            }
        }
    }
}
