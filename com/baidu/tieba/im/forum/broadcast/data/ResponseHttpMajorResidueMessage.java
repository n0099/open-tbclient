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
/* loaded from: classes5.dex */
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
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) || jSONObject == null || jSONObject.optInt("error_code", -1) != 0 || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        ForumBroadcastMajorResidueData forumBroadcastMajorResidueData = new ForumBroadcastMajorResidueData();
        this.majorHistoryData = forumBroadcastMajorResidueData;
        forumBroadcastMajorResidueData.A(optJSONObject.optInt("used_cnt"));
        this.majorHistoryData.y(optJSONObject.optInt("has_cnt"));
        this.majorHistoryData.z(optJSONObject.optInt("predict_push_usercnt"));
    }

    public ForumBroadcastMajorResidueData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.majorHistoryData : (ForumBroadcastMajorResidueData) invokeV.objValue;
    }
}
