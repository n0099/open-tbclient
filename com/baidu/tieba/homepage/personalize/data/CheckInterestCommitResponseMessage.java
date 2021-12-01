package com.baidu.tieba.homepage.personalize.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/baidu/tieba/homepage/personalize/data/CheckInterestCommitResponseMessage;", "Lcom/baidu/tbadk/message/http/JsonHttpResponsedMessage;", "cmd", "", "(I)V", "finishInterestStage", "getFinishInterestStage", "()I", "setFinishInterestStage", "personalizedSwitchStatus", "getPersonalizedSwitchStatus", "setPersonalizedSwitchStatus", "decodeLogicInBackGround", "", "retJson", "Lorg/json/JSONObject;", "recommendfrs_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class CheckInterestCommitResponseMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int finishInterestStage;
    public int personalizedSwitchStatus;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckInterestCommitResponseMessage(int i2) {
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
        this.finishInterestStage = -1;
        this.personalizedSwitchStatus = -1;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0) {
                this.finishInterestStage = jSONObject == null ? -1 : jSONObject.getInt("finish_interest_stage");
                this.personalizedSwitchStatus = jSONObject != null ? jSONObject.getInt("personalized_switch_status") : -1;
            }
        }
    }

    public final int getFinishInterestStage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.finishInterestStage : invokeV.intValue;
    }

    public final int getPersonalizedSwitchStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.personalizedSwitchStatus : invokeV.intValue;
    }

    public final void setFinishInterestStage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.finishInterestStage = i2;
        }
    }

    public final void setPersonalizedSwitchStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.personalizedSwitchStatus = i2;
        }
    }
}
