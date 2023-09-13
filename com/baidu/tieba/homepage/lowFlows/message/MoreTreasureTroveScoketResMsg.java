package com.baidu.tieba.homepage.lowFlows.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b58;
import com.baidu.tieba.cn;
import com.baidu.tieba.g58;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.MoreTreasureTrove.MoreTreasureTroveResIdl;
/* loaded from: classes6.dex */
public class MoreTreasureTroveScoketResMsg extends SocketResponsedMessage implements b58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<cn> mMoreTreasureTroveDataList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreTreasureTroveScoketResMsg() {
        super(309691);
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

    @Override // com.baidu.tieba.b58
    public List<cn> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mMoreTreasureTroveDataList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            MoreTreasureTroveResIdl moreTreasureTroveResIdl = (MoreTreasureTroveResIdl) new Wire(new Class[0]).parseFrom(bArr, MoreTreasureTroveResIdl.class);
            if (moreTreasureTroveResIdl != null) {
                Error error = moreTreasureTroveResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(moreTreasureTroveResIdl.error.usermsg);
                }
                this.mMoreTreasureTroveDataList = g58.b(moreTreasureTroveResIdl);
            }
            return moreTreasureTroveResIdl;
        }
        return invokeIL.objValue;
    }
}
