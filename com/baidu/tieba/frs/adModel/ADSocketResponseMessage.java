package com.baidu.tieba.frs.adModel;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.wf6;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetADList.GetADListResIdl;
/* loaded from: classes3.dex */
public class ADSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int has_more;
    public List<wf6> list;
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
                wf6 wf6Var = new wf6();
                wf6Var.s(getADListResIdl.data.ad_list.get(i2));
                if (getADListResIdl.data.ad_list.size() - 1 == i2) {
                    wf6Var.t(true);
                } else {
                    wf6Var.t(false);
                }
                if (wf6Var.o() == 0 || wf6Var.o() == 2) {
                    this.list.add(wf6Var);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.has_more : invokeV.intValue;
    }

    public List<wf6> getList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.list : (List) invokeV.objValue;
    }

    public long getOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.offset : invokeV.longValue;
    }
}
