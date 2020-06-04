package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.o;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    public String avJ;
    public boolean avN;
    public AlaLiveUserInfoData avj;
    public a fUb;
    public AlaLiveInfoData mLiveInfo;
    public o mLiveSdkInfo;
    public int mErrorCode = 0;
    public String mErrorMsg = null;
    public int fTV = 0;
    public int fTW = 1;
    public String fTX = null;
    public int fTY = 1;
    public String fTZ = null;
    public int fUa = 0;
    public long avL = 0;

    /* loaded from: classes3.dex */
    public static class a {
        public List<String> fUc = new ArrayList();
        public String notify;
    }

    public boolean bBm() {
        return this.fTV == 0;
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.avL = jSONObject.optLong("logid");
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
                this.fTV = optJSONObject2.optInt("user_status");
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("user_info");
                if (optJSONObject3 != null) {
                    this.avj = new AlaLiveUserInfoData();
                    this.avj.parserJson(optJSONObject3);
                }
                JSONObject optJSONObject4 = optJSONObject2.optJSONObject("live_info");
                if (optJSONObject4 != null) {
                    this.mLiveInfo = new AlaLiveInfoData();
                    this.mLiveInfo.parserJson(optJSONObject4);
                }
                JSONObject optJSONObject5 = optJSONObject2.optJSONObject(CashierData.SDK);
                if (optJSONObject5 != null) {
                    this.mLiveSdkInfo = new o();
                    this.mLiveSdkInfo.parseJson(optJSONObject5);
                }
                if (this.mLiveInfo != null && this.mLiveSdkInfo != null && this.mLiveInfo.room_id == 0 && this.mLiveSdkInfo.mRoomId != 0) {
                    this.mLiveInfo.room_id = this.mLiveSdkInfo.mRoomId;
                }
                this.avJ = optJSONObject2.optString("user_watermark");
                JSONObject optJSONObject6 = optJSONObject2.optJSONObject(UbcStatConstant.ContentType.UBC_TYPE_STRATEGY);
                if (optJSONObject6 != null) {
                    JSONObject optJSONObject7 = optJSONObject6.optJSONObject(LogConfig.VALUE_LIVE_HK_RECORD_START);
                    if (optJSONObject7 != null) {
                        this.fTX = optJSONObject7.optString("text");
                        this.fTW = optJSONObject7.optInt("switch");
                    }
                    JSONObject optJSONObject8 = optJSONObject6.optJSONObject("user_verify");
                    if (optJSONObject8 != null) {
                        this.fTY = optJSONObject8.optInt("switch");
                        this.fTZ = optJSONObject8.optString("text");
                    }
                    JSONObject optJSONObject9 = optJSONObject6.optJSONObject("certify");
                    if (optJSONObject9 != null) {
                        this.fUa = optJSONObject9.optInt("switch");
                    }
                }
                JSONObject optJSONObject10 = optJSONObject2.optJSONObject("live_authen_info");
                if (optJSONObject10 != null) {
                    this.fUb = new a();
                    this.fUb.notify = optJSONObject10.optString("notify");
                    JSONArray optJSONArray = optJSONObject10.optJSONArray("questions");
                    for (int i = 0; optJSONArray != null && i < optJSONArray.length(); i++) {
                        this.fUb.fUc.add(optJSONArray.optString(i));
                    }
                }
                this.avN = optJSONObject2.optInt("switch_guard_seat") == 1;
            }
        }
    }
}
