package com.baidu.tieba;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hia {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public int c;
    public String d;
    public long e;

    public hia() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = false;
        this.c = 0;
        this.d = "";
        this.e = 0L;
    }

    public static hia a(ResponsedMessage responsedMessage) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, responsedMessage)) == null) {
            hia hiaVar = new hia();
            if (BdNetTypeUtil.isNetWorkAvailable() && (responsedMessage.getError() < -13 || responsedMessage.getError() > -10)) {
                z = true;
            } else {
                z = false;
            }
            hiaVar.a = z;
            hiaVar.b = !responsedMessage.hasError();
            hiaVar.c = responsedMessage.getError();
            hiaVar.d = responsedMessage.getErrorString();
            hiaVar.e = responsedMessage.getDownSize();
            return hiaVar;
        }
        return (hia) invokeL.objValue;
    }
}
