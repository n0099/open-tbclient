package com.baidu.tieba.homepage;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.UserPk.DataRes;
import tbclient.UserPk.UserPkResIdl;
/* loaded from: classes4.dex */
public class BlessSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long pkID;
    public long userPkId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlessSocketResponseMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            UserPkResIdl userPkResIdl = (UserPkResIdl) new Wire(new Class[0]).parseFrom(bArr, UserPkResIdl.class);
            if (userPkResIdl != null && (dataRes = userPkResIdl.data) != null) {
                this.userPkId = dataRes.user_pk_id.longValue();
                this.pkID = userPkResIdl.data.pk_id.longValue();
            }
            return userPkResIdl;
        }
        return invokeIL.objValue;
    }
}
