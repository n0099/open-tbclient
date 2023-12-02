package com.baidu.tbadk.editortools.meme.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.hg5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeQueryRespondedMessage;", "Lcom/baidu/tbadk/message/http/JsonHttpResponsedMessage;", "()V", "spriteMemeQueryData", "Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeQueryData;", "getSpriteMemeQueryData", "()Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeQueryData;", "setSpriteMemeQueryData", "(Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeQueryData;)V", "decodeLogicInBackGround", "", "cmd", "", "retJson", "Lorg/json/JSONObject;", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpriteMemeQueryRespondedMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hg5 spriteMemeQueryData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpriteMemeQueryRespondedMessage() {
        super(CmdConfigHttp.CMD_HTTP_SPRITE_MEME_QUERY);
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

    public final hg5 getSpriteMemeQueryData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.spriteMemeQueryData;
        }
        return (hg5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.spriteMemeQueryData = hg5.c.a(optJSONObject);
        }
    }

    public final void setSpriteMemeQueryData(hg5 hg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hg5Var) == null) {
            this.spriteMemeQueryData = hg5Var;
        }
    }
}
