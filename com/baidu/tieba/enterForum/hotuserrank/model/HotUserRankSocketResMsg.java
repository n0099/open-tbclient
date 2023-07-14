package com.baidu.tieba.enterForum.hotuserrank.model;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n17;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetInfluenceRank.GetInfluenceRankResIdl;
/* loaded from: classes5.dex */
public class HotUserRankSocketResMsg extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n17 pageData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotUserRankSocketResMsg() {
        super(309652);
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

    public n17 getPageData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.pageData;
        }
        return (n17) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetInfluenceRankResIdl getInfluenceRankResIdl = (GetInfluenceRankResIdl) new Wire(new Class[0]).parseFrom(bArr, GetInfluenceRankResIdl.class);
            if (getInfluenceRankResIdl == null) {
                return null;
            }
            Error error = getInfluenceRankResIdl.error;
            if (error != null) {
                Integer num = error.errorno;
                if (num != null) {
                    setError(num.intValue());
                }
                setErrorString(getInfluenceRankResIdl.error.usermsg);
            }
            n17 n17Var = new n17();
            this.pageData = n17Var;
            n17Var.c(getInfluenceRankResIdl.data);
            return getInfluenceRankResIdl;
        }
        return invokeIL.objValue;
    }
}
