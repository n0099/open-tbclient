package com.baidu.tieba.ala.livecard.models;

import c.a.e.l.e.n;
import c.a.p0.s.q.c2;
import c.a.q0.v0.b1;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class FrsPageAlaTabResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int alaLiveCount;
    public int errCode;
    public String errMsg;
    public ArrayList<n> mAltList;
    public ArrayList<n> mThreadList;
    public b1 pageInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsPageAlaTabResponseMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode != 200 || error < 0 || jSONObject == null) {
                return;
            }
            this.errCode = jSONObject.optInt("error_code");
            this.errMsg = jSONObject.optString("errmsg");
            this.alaLiveCount = jSONObject.optInt("ala_live_count");
            JSONObject optJSONObject = jSONObject.optJSONObject("page");
            b1 b1Var = new b1();
            this.pageInfo = b1Var;
            b1Var.f25870g = optJSONObject.optInt("has_more") == 1;
            this.pageInfo.f27377c = optJSONObject.optInt("pn");
            if (getOrginalMessage() instanceof FrsPageAlaTabRequestMessage) {
                FrsPageAlaTabRequestMessage frsPageAlaTabRequestMessage = (FrsPageAlaTabRequestMessage) getOrginalMessage();
                this.pageInfo.f27375a = frsPageAlaTabRequestMessage.getForumName();
                this.pageInfo.f27376b = frsPageAlaTabRequestMessage.getForumId();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
            if (optJSONArray.length() > 0) {
                this.mThreadList = new ArrayList<>();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    c2 c2Var = new c2();
                    c2Var.E3(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY);
                    c2Var.R2(jSONObject2);
                    this.mThreadList.add(c2Var);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("alt_list");
            if (optJSONArray2.length() > 0) {
                this.mAltList = new ArrayList<>();
                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i4);
                    c2 c2Var2 = new c2();
                    c2Var2.E3(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY);
                    c2Var2.R2(jSONObject3);
                    this.mAltList.add(c2Var2);
                }
            }
        }
    }
}
