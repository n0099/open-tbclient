package com.baidu.tieba.frs.unreadbawu;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BawuUnreadRequestMessage extends HttpMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String forumId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BawuUnreadRequestMessage(String str) {
        super(CmdConfigHttp.CMD_BAWU_NOTICE_READ);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
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
        this.forumId = str;
        addParam("forum_id", str);
    }
}
