package com.baidu.tieba.frs.adModel;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bg6;
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
    public List<bg6> list;
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

    public int getHas_more() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.has_more : invokeV.intValue;
    }

    public List<bg6> getList() {
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
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetADListResIdl getADListResIdl;
        String str;
        Integer num;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || bArr == null || (getADListResIdl = (GetADListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetADListResIdl.class)) == null) {
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
        for (int i2 = 0; i2 < getADListResIdl.data.ad_list.size(); i2++) {
            bg6 bg6Var = new bg6();
            bg6Var.s(getADListResIdl.data.ad_list.get(i2));
            if (getADListResIdl.data.ad_list.size() - 1 == i2) {
                bg6Var.v(true);
            } else {
                bg6Var.v(false);
            }
            if (bg6Var.r() == 0 || bg6Var.r() == 2) {
                this.list.add(bg6Var);
            }
        }
        this.has_more = getADListResIdl.data.has_more.intValue();
        this.offset = getADListResIdl.data.offset.longValue();
    }
}
