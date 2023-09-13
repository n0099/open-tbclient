package com.baidu.tbadk.growth;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.vm5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ActivityChangeSchemeHttpResMsg extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject data;
    public String scheme;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityChangeSchemeHttpResMsg() {
        super(CmdConfigHttp.CMD_SPLASH_CHANGE_SCHEME);
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

    public JSONObject getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.data;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String getScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.scheme;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (jSONObject != null) {
                this.data = jSONObject.optJSONObject("data");
            }
            if (statusCode == 200 && error >= 0) {
                JSONObject jSONObject2 = this.data;
                if (jSONObject2 != null) {
                    this.scheme = jSONObject2.optString("scheme");
                }
                vm5.d(true, this.data);
                return;
            }
            vm5.d(false, this.data);
        }
    }
}
