package com.baidu.tieba.frs.itemtab.gamecode;

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
public class GameCodeGetResponseMsg extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PARAM_CODE_VALUE = "code_value";
    public static final String PARAM_ERROR_CODE = "error_code";
    public static final String PARAM_ERROR_MSG = "error_msg";
    public transient /* synthetic */ FieldHolder $fh;
    public String codeValue;
    public int errCode;
    public String errMsg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameCodeGetResponseMsg() {
        super(CmdConfigHttp.CMD_GET_GAME_CODE);
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
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                this.errCode = jSONObject.optInt("error_code");
                this.errMsg = jSONObject.optString(PARAM_ERROR_MSG);
                this.codeValue = jSONObject.optString(PARAM_CODE_VALUE);
            }
        }
    }

    public String getCodeValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.codeValue : (String) invokeV.objValue;
    }
}
