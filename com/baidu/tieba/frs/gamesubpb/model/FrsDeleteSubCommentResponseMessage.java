package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.u0.v1.d.d;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FrsDeleteSubCommentResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsDeleteSubCommentResponseMessage() {
        super(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
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
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            super.decodeLogicInBackGround(i2, jSONObject);
            if (hasError() || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null || optJSONObject.optJSONObject("sub_comment") == null) {
                return;
            }
            this.mData = new d(optJSONObject.optJSONObject("sub_comment"));
        }
    }

    public d getSubCommentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData : (d) invokeV.objValue;
    }
}
