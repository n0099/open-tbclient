package com.baidu.tieba.frs.adModel;

import c.a.q0.v0.g1.c;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetADList.GetADListResIdl;
/* loaded from: classes7.dex */
public class ADSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int has_more;
    public List<c> list;
    public long offset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ADSocketResponseMessage() {
        super(309611);
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
        this.list = new ArrayList();
    }

    public int getHas_more() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.has_more : invokeV.intValue;
    }

    public List<c> getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.list : (List) invokeV.objValue;
    }

    public long getOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.offset : invokeV.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetADListResIdl getADListResIdl;
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || bArr == null || (getADListResIdl = (GetADListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetADListResIdl.class)) == null) {
            return;
        }
        Error error = getADListResIdl.error;
        if (error != null && (num = error.errorno) != null) {
            setError(num.intValue());
        }
        Error error2 = getADListResIdl.error;
        if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
            setErrorString(getADListResIdl.error.usermsg);
        }
        if (getADListResIdl.data == null) {
            return;
        }
        for (int i3 = 0; i3 < getADListResIdl.data.ad_list.size(); i3++) {
            c cVar = new c();
            cVar.w(getADListResIdl.data.ad_list.get(i3));
            if (getADListResIdl.data.ad_list.size() - 1 == i3) {
                cVar.x(true);
            } else {
                cVar.x(false);
            }
            if (cVar.t() == 0 || cVar.t() == 2) {
                this.list.add(cVar);
            }
        }
        this.has_more = getADListResIdl.data.has_more.intValue();
        this.offset = getADListResIdl.data.offset.longValue();
    }
}
