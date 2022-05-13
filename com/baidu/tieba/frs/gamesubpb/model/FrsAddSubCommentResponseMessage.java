package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dk6;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class FrsAddSubCommentResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dk6 mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsAddSubCommentResponseMessage() {
        super(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
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
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (hasError() || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null || optJSONObject.optJSONArray("sub_comment") == null || optJSONObject.optJSONArray("sub_comment").length() <= 0) {
                return;
            }
            this.mData = new dk6(optJSONObject.optJSONArray("sub_comment").optJSONObject(0));
        }
    }

    public dk6 getSubCommentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData : (dk6) invokeV.objValue;
    }
}
