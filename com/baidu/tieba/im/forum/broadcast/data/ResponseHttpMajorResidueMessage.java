package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ResponseHttpMajorResidueMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumBroadcastMajorResidueData majorHistoryData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseHttpMajorResidueMessage() {
        super(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) || jSONObject == null || jSONObject.optInt("error_code", -1) != 0 || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        ForumBroadcastMajorResidueData forumBroadcastMajorResidueData = new ForumBroadcastMajorResidueData();
        this.majorHistoryData = forumBroadcastMajorResidueData;
        forumBroadcastMajorResidueData.E(optJSONObject.optInt("used_cnt"));
        this.majorHistoryData.C(optJSONObject.optInt("has_cnt"));
        this.majorHistoryData.D(optJSONObject.optInt("predict_push_usercnt"));
    }

    public ForumBroadcastMajorResidueData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.majorHistoryData : (ForumBroadcastMajorResidueData) invokeV.objValue;
    }
}
