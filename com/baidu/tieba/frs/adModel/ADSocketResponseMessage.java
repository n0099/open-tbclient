package com.baidu.tieba.frs.adModel;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sf7;
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
/* loaded from: classes5.dex */
public class ADSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int has_more;
    public List<sf7> list;
    public long offset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ADSocketResponseMessage() {
        super(309611);
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
        this.list = new ArrayList();
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        GetADListResIdl getADListResIdl;
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            if (bArr == null || (getADListResIdl = (GetADListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetADListResIdl.class)) == null) {
                return null;
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
                return getADListResIdl;
            }
            for (int i2 = 0; i2 < getADListResIdl.data.ad_list.size(); i2++) {
                sf7 sf7Var = new sf7();
                sf7Var.l(getADListResIdl.data.ad_list.get(i2));
                if (getADListResIdl.data.ad_list.size() - 1 == i2) {
                    sf7Var.m(true);
                } else {
                    sf7Var.m(false);
                }
                if (sf7Var.k() == 0 || sf7Var.k() == 2) {
                    this.list.add(sf7Var);
                }
            }
            this.has_more = getADListResIdl.data.has_more.intValue();
            this.offset = getADListResIdl.data.offset.longValue();
            return getADListResIdl;
        }
        return invokeIL.objValue;
    }

    public int getHas_more() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.has_more;
        }
        return invokeV.intValue;
    }

    public List<sf7> getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.list;
        }
        return (List) invokeV.objValue;
    }

    public long getOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.offset;
        }
        return invokeV.longValue;
    }
}
