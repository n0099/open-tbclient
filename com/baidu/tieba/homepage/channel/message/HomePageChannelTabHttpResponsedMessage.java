package com.baidu.tieba.homepage.channel.message;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.bv7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class HomePageChannelTabHttpResponsedMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bv7 channelTabRespData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageChannelTabHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_HOME_CHANNEL_TAB_LIST);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (jSONObject != null && jSONObject.optInt("error_code", -1) == 0) {
                this.channelTabRespData = new bv7();
                Message<?> orginalMessage = getOrginalMessage();
                if (orginalMessage instanceof HttpMessage) {
                    Object obj = ((HttpMessage) orginalMessage).getParams().get("tab_code");
                    if (obj instanceof String) {
                        this.channelTabRespData.h((String) obj);
                    }
                }
                this.channelTabRespData.g(jSONObject);
            }
        }
    }
}
