package com.baidu.tieba.frs.live;

import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FrsLiveTipResponseMessage extends JsonHttpResponsedMessage {
    public AlaLiveInfoCoreData infoCoreData;
    public AlaLiveInfoListCoreData listCoreData;
    public String remindText;
    public int remindType;

    public FrsLiveTipResponseMessage() {
        super(CmdConfigHttp.FRS_LIVE_TIP_CMD);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        AlaLiveInfoCoreData jsonToLiveInfoData;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.remindType = jSONObject.optInt("remind_type");
            this.remindText = jSONObject.optString("remind_text");
            JSONObject optJSONObject = jSONObject.optJSONObject("remind_live_info");
            if (optJSONObject != null) {
                this.infoCoreData = jsonToLiveInfoData(optJSONObject);
            }
            if (this.remindType == 1 && (optJSONArray = jSONObject.optJSONArray("switch_live_list")) != null) {
                this.listCoreData = new AlaLiveInfoListCoreData();
                this.listCoreData.mLiveInfoList = new ArrayList();
                if (optJSONArray.length() >= 1) {
                    this.listCoreData.mLiveInfoList.add(this.infoCoreData);
                }
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i3);
                        if (jSONObject2 != null && (jsonToLiveInfoData = jsonToLiveInfoData(jSONObject2)) != null) {
                            this.listCoreData.mLiveInfoList.add(jsonToLiveInfoData);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
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
        alaLiveInfoCoreData.sessionID = jSONObject.optString("session_id");
        alaLiveInfoCoreData.liveType = jSONObject.optInt("live_type");
        alaLiveInfoCoreData.screenDirection = jSONObject.optInt("screen_direction");
        alaLiveInfoCoreData.liveTitle = jSONObject.optString(SocialConstants.PARAM_COMMENT);
        alaLiveInfoCoreData.liveCover = jSONObject.optString("cover");
        JSONObject optJSONObject = jSONObject.optJSONObject("session_info_backup");
        if (optJSONObject != null) {
            alaLiveInfoCoreData.rtmpUrl = optJSONObject.optString("rtmpUrl");
            alaLiveInfoCoreData.hslUrl = optJSONObject.optString("hlsUrl");
            return alaLiveInfoCoreData;
        }
        return alaLiveInfoCoreData;
    }
}
