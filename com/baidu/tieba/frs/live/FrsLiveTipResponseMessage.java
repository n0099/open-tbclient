package com.baidu.tieba.frs.live;

import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class FrsLiveTipResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaLiveInfoCoreData infoCoreData;
    public AlaLiveInfoListCoreData listCoreData;
    public String remindText;
    public int remindType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLiveTipResponseMessage() {
        super(CmdConfigHttp.FRS_LIVE_TIP_CMD);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private AlaLiveInfoCoreData jsonToLiveInfoData(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONObject)) == null) {
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
            alaLiveInfoCoreData.liveTitle = jSONObject.optString("description");
            alaLiveInfoCoreData.liveCover = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
            JSONObject optJSONObject = jSONObject.optJSONObject("session_info_backup");
            if (optJSONObject != null) {
                alaLiveInfoCoreData.rtmpUrl = optJSONObject.optString("rtmpUrl");
                alaLiveInfoCoreData.hslUrl = optJSONObject.optString("hlsUrl");
            }
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        AlaLiveInfoCoreData jsonToLiveInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            super.decodeLogicInBackGround(i2, jSONObject);
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
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i3);
                if (jSONObject2 != null && (jsonToLiveInfoData = jsonToLiveInfoData(jSONObject2)) != null) {
                    this.listCoreData.mLiveInfoList.add(jsonToLiveInfoData);
                }
            }
        }
    }
}
