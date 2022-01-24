package com.baidu.tieba.homepage.channel.message;

import c.a.t0.p1.b.a.a;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class HomePageChannelTabHttpResponsedMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a channelTabRespData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageChannelTabHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_HOME_CHANNEL_TAB_LIST);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
            super.decodeLogicInBackGround(i2, jSONObject);
            if (jSONObject != null && jSONObject.optInt("error_code", -1) == 0) {
                this.channelTabRespData = new a();
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
