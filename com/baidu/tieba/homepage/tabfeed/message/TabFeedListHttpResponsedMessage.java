package com.baidu.tieba.homepage.tabfeed.message;

import c.a.t0.p1.j.h.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.ActivityPage.ActivityPageResIdl;
import tbclient.Error;
/* loaded from: classes12.dex */
public class TabFeedListHttpResponsedMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b tabFeedData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabFeedListHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            ActivityPageResIdl activityPageResIdl = (ActivityPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ActivityPageResIdl.class);
            Error error = activityPageResIdl.error;
            if (error != null && (num = error.errorno) != null) {
                setError(num.intValue());
            }
            Error error2 = activityPageResIdl.error;
            if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
                setErrorString(activityPageResIdl.error.usermsg);
            }
            if (getError() == 0 && activityPageResIdl.data != null) {
                b bVar = new b();
                this.tabFeedData = bVar;
                bVar.j(activityPageResIdl.data);
            }
        }
    }
}
