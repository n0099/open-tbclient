package com.baidu.tieba.enterForum.tabfeed.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.o66;
import com.repackage.ro;
import com.repackage.y65;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.Error;
import tbclient.Tabfeedlist.TabfeedlistResIdl;
/* loaded from: classes3.dex */
public class TabFeedListSocketResponsedMessage extends TbSocketReponsedMessage implements y65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o66 enterForumTabFeedData;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.enterForumTabFeedData.c() : invokeV.objValue;
    }

    public ArrayList<ro> getThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.enterForumTabFeedData.e() : (ArrayList) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
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
                o66 o66Var = new o66();
                this.enterForumTabFeedData = o66Var;
                o66Var.g(tabfeedlistResIdl.data);
            }
        }
    }
}
