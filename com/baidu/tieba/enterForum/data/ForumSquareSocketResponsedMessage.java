package com.baidu.tieba.enterForum.data;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.g56;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetForumSquare.GetForumSquareResIdl;
/* loaded from: classes3.dex */
public class ForumSquareSocketResponsedMessage extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g56 mForumSquareRespData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumSquareSocketResponsedMessage() {
        super(309653);
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetForumSquareResIdl getForumSquareResIdl = (GetForumSquareResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumSquareResIdl.class);
            Error error = getForumSquareResIdl.error;
            if (error != null && (num = error.errorno) != null) {
                setError(num.intValue());
            }
            Error error2 = getForumSquareResIdl.error;
            if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
                setErrorString(getForumSquareResIdl.error.usermsg);
            }
            if (getError() == 0 && getForumSquareResIdl.data != null) {
                g56 g56Var = new g56();
                this.mForumSquareRespData = g56Var;
                g56Var.a(getForumSquareResIdl.data);
                return getForumSquareResIdl;
            }
            return getForumSquareResIdl;
        }
        return invokeIL.objValue;
    }

    public g56 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mForumSquareRespData : (g56) invokeV.objValue;
    }
}
