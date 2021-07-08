package com.baidu.tieba.enterForum.tabfeed.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.c.k.e.n;
import d.a.o0.g0.b.a;
import java.util.ArrayList;
import tbclient.Error;
import tbclient.Tabfeedlist.TabfeedlistResIdl;
/* loaded from: classes4.dex */
public class TabFeedListHttpResponsedMessage extends TbHttpResponsedMessage implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.p0.l0.l.d.a enterForumTabFeedData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabFeedListHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_TAB_FEED_LIST);
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

    public Object getExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.enterForumTabFeedData.c() : invokeV.objValue;
    }

    public ArrayList<n> getThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.enterForumTabFeedData.e() : (ArrayList) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            TabfeedlistResIdl tabfeedlistResIdl = (TabfeedlistResIdl) new Wire(new Class[0]).parseFrom(bArr, TabfeedlistResIdl.class);
            Error error = tabfeedlistResIdl.error;
            if (error != null && (num = error.errorno) != null) {
                setError(num.intValue());
            }
            Error error2 = tabfeedlistResIdl.error;
            if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
                setErrorString(tabfeedlistResIdl.error.usermsg);
            }
            if (getError() == 0 && tabfeedlistResIdl.data != null) {
                d.a.p0.l0.l.d.a aVar = new d.a.p0.l0.l.d.a();
                this.enterForumTabFeedData = aVar;
                aVar.g(tabfeedlistResIdl.data);
            }
        }
    }
}
