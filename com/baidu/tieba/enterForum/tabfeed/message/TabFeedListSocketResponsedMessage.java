package com.baidu.tieba.enterForum.tabfeed.message;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.nd5;
import com.baidu.tieba.xd6;
import com.baidu.tieba.xn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.Error;
import tbclient.Tabfeedlist.TabfeedlistResIdl;
/* loaded from: classes4.dex */
public class TabFeedListSocketResponsedMessage extends TbSocketReponsedMessage implements nd5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xd6 enterForumTabFeedData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabFeedListSocketResponsedMessage() {
        super(309651);
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

    public Object getExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.enterForumTabFeedData.c();
        }
        return invokeV.objValue;
    }

    public ArrayList<xn> getThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.enterForumTabFeedData.e();
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            TabfeedlistResIdl tabfeedlistResIdl = (TabfeedlistResIdl) new Wire(new Class[0]).parseFrom(bArr, TabfeedlistResIdl.class);
            Error error = tabfeedlistResIdl.error;
            if (error != null && (num = error.errorno) != null) {
                setError(num.intValue());
            }
            Error error2 = tabfeedlistResIdl.error;
            if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
                setErrorString(tabfeedlistResIdl.error.usermsg);
            }
            if (getError() != 0) {
                return tabfeedlistResIdl;
            }
            if (tabfeedlistResIdl.data == null) {
                return tabfeedlistResIdl;
            }
            xd6 xd6Var = new xd6();
            this.enterForumTabFeedData = xd6Var;
            xd6Var.g(tabfeedlistResIdl.data);
            return tabfeedlistResIdl;
        }
        return invokeIL.objValue;
    }
}
