package com.baidu.tieba.frs.live;

import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FrsLiveTipResponseMessage extends JsonHttpResponsedMessage {
    public AlaLiveInfoCoreData infoCoreData;
    public AlaLiveInfoListCoreData listCoreData;
    public String remindText;
    public int remindType;

    public FrsLiveTipResponseMessage() {
        super(CmdConfigHttp.FRS_LIVE_TIP_CMD);
    }

    private AlaLiveInfoCoreData jsonToLiveInfoData(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.liveID = jSONObject.optLong("live_id");
        alaLiveInfoCoreData.userID = jSONObject.optLong("user_id");
        alaLiveInfoCoreData.userName = jSONObject.optString("user_name");
        alaLiveInfoCoreData.groupID = jSONObject.optLong("group_id");
        alaLiveInfoCoreData.sessionID = jSONObject.optString(ETAG.KEY_STATISTICS_SEESIONID);
        alaLiveInfoCoreData.liveType = jSONObject.optInt("live_type");
        alaLiveInfoCoreData.screenDirection = jSONObject.optInt("screen_direction");
        alaLiveInfoCoreData.liveTitle = jSONObject.optString("description");
        alaLiveInfoCoreData.liveCover = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
        JSONObject optJSONObject = jSONObject.optJSONObject("session_info_backup");
        if (optJSONObject != null) {
            alaLiveInfoCoreData.rtmpUrl = optJSONObject.optString("rtmpUrl");
            alaLiveInfoCoreData.hslUrl = optJSONObject.optString("hlsUrl");
        }
        return alaLiveInfoCoreData;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        AlaLiveInfoCoreData jsonToLiveInfoData;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.remindType = jSONObject.optInt("remind_type");
        this.remindText = jSONObject.optString("remind_text");
        JSONObject optJSONObject = jSONObject.optJSONObject("remind_live_info");
        if (optJSONObject != null) {
            this.infoCoreData = jsonToLiveInfoData(optJSONObject);
        }
        if (this.remindType != 1 || (optJSONArray = jSONObject.optJSONArray("switch_live_list")) == null) {
            return;
        }
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        this.listCoreData = alaLiveInfoListCoreData;
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        if (optJSONArray.length() >= 1) {
            this.listCoreData.mLiveInfoList.add(this.infoCoreData);
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i2);
            if (jSONObject2 != null && (jsonToLiveInfoData = jsonToLiveInfoData(jSONObject2)) != null) {
                this.listCoreData.mLiveInfoList.add(jsonToLiveInfoData);
            }
        }
    }
}
