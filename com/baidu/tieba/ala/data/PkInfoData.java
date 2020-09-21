package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.core.data.BaseData;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PkInfoData extends BaseData implements Serializable {
    public String H5URL;
    public long logId;
    public int pkInfoInterval;
    public int resultInterval;
    public int showMvpTime;
    public int showRankTime;
    public int showScoreTime;
    public PkResultData pkResultData = new PkResultData();
    public PkUserInfoData myPkData = new PkUserInfoData();
    public PkUserInfoData otherPkData = new PkUserInfoData();
    public PkMvpInfoData mvpInfoData = new PkMvpInfoData();
    public PkStatusInfoData pkStatusInfoData = new PkStatusInfoData();

    @Override // com.baidu.live.tbadk.core.data.BaseData
    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("anchor_info");
        if (optJSONObject != null) {
            this.myPkData.parserJson(optJSONObject);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("rival_info");
        if (optJSONObject2 != null) {
            this.otherPkData.parserJson(optJSONObject2);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("pk_result");
        if (optJSONObject3 != null) {
            this.pkResultData.parserJson(optJSONObject3);
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("mvp_info");
        if (optJSONObject4 != null) {
            this.mvpInfoData.parserJson(optJSONObject4);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("pk_info");
        if (optJSONObject5 != null) {
            this.pkStatusInfoData.parserJson(optJSONObject5);
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("pk_conf");
        this.pkInfoInterval = optJSONObject6.optInt("pk_info_interval") * 1000;
        this.showScoreTime = optJSONObject6.optInt("show_score_time") * 1000;
        this.showRankTime = optJSONObject6.optInt("show_fragment_time") * 1000;
        this.showMvpTime = optJSONObject6.optInt("show_mvp_time") * 1000;
        this.resultInterval = optJSONObject6.optInt("settle_time") * 1000;
        this.H5URL = optJSONObject6.optString("division_url");
    }
}
