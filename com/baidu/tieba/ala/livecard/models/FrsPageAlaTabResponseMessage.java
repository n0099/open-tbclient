package com.baidu.tieba.ala.livecard.models;

import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.uj7;
import com.baidu.tieba.yn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class FrsPageAlaTabResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int alaLiveCount;
    public int errCode;
    public String errMsg;
    public ArrayList<yn> mAltList;
    public ArrayList<yn> mThreadList;
    public uj7 pageInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsPageAlaTabResponseMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
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

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error >= 0 && jSONObject != null) {
                this.errCode = jSONObject.optInt("error_code");
                this.errMsg = jSONObject.optString("errmsg");
                this.alaLiveCount = jSONObject.optInt("ala_live_count");
                JSONObject optJSONObject = jSONObject.optJSONObject("page");
                uj7 uj7Var = new uj7();
                this.pageInfo = uj7Var;
                boolean z = true;
                if (optJSONObject.optInt("has_more") != 1) {
                    z = false;
                }
                uj7Var.g = z;
                this.pageInfo.c = optJSONObject.optInt("pn");
                if (getOrginalMessage() instanceof FrsPageAlaTabRequestMessage) {
                    FrsPageAlaTabRequestMessage frsPageAlaTabRequestMessage = (FrsPageAlaTabRequestMessage) getOrginalMessage();
                    this.pageInfo.a = frsPageAlaTabRequestMessage.getForumName();
                    this.pageInfo.b = frsPageAlaTabRequestMessage.getForumId();
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
                if (optJSONArray.length() > 0) {
                    this.mThreadList = new ArrayList<>();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        ThreadData threadData = new ThreadData();
                        threadData.setFromType(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY);
                        threadData.parserJson(jSONObject2);
                        this.mThreadList.add(threadData);
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("alt_list");
                if (optJSONArray2.length() > 0) {
                    this.mAltList = new ArrayList<>();
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i3);
                        ThreadData threadData2 = new ThreadData();
                        threadData2.setFromType(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY);
                        threadData2.parserJson(jSONObject3);
                        this.mAltList.add(threadData2);
                    }
                }
            }
        }
    }
}
