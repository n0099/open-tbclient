package com.baidu.tieba.frs.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.k28;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/baidu/tieba/frs/model/AiCreateForumBgLoopRespondedMessage;", "Lcom/baidu/tbadk/message/http/JsonHttpResponsedMessage;", "()V", "aiCreateForumBgLoopData", "Lcom/baidu/tieba/frs/model/AiCreateForumBgLoopData;", "getAiCreateForumBgLoopData", "()Lcom/baidu/tieba/frs/model/AiCreateForumBgLoopData;", "setAiCreateForumBgLoopData", "(Lcom/baidu/tieba/frs/model/AiCreateForumBgLoopData;)V", "decodeLogicInBackGround", "", "cmd", "", "retJson", "Lorg/json/JSONObject;", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AiCreateForumBgLoopRespondedMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k28 aiCreateForumBgLoopData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiCreateForumBgLoopRespondedMessage() {
        super(CmdConfigHttp.CMD_AI_CREATE_FORUM_BG_MESSAGE);
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

    public final k28 getAiCreateForumBgLoopData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.aiCreateForumBgLoopData;
        }
        return (k28) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                this.aiCreateForumBgLoopData = k28.b.a(optJSONObject);
            }
        }
    }

    public final void setAiCreateForumBgLoopData(k28 k28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k28Var) == null) {
            this.aiCreateForumBgLoopData = k28Var;
        }
    }
}
