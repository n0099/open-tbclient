package com.baidu.tieba.ad.incentivevideo.net;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.q66;
import com.baidu.tieba.w66;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class GetIncentiveVideoTaskResMsg extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w66 mAdIncentiveVideoTaskData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetIncentiveVideoTaskResMsg(int i) {
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
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                this.mAdIncentiveVideoTaskData = new w66();
                String optString = optJSONObject.optString("request_key");
                this.mAdIncentiveVideoTaskData.f(optString);
                this.mAdIncentiveVideoTaskData.g(optJSONObject.optString("scheme"));
                q66.i().u(optString);
            }
        }
    }

    public w66 getAdIncentiveVideoTaskData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mAdIncentiveVideoTaskData;
        }
        return (w66) invokeV.objValue;
    }
}
