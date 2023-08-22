package com.baidu.tieba.im.lib.socket.msg;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class TbSubscribeSysMsg extends TbSysMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_TYPE = -7015;
    public transient /* synthetic */ FieldHolder $fh;
    public String subscribeTips;

    public TbSubscribeSysMsg() {
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
        setType(-7015);
    }

    public String getSubscribeTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.subscribeTips;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static TbSubscribeSysMsg create(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            TbSubscribeSysMsg tbSubscribeSysMsg = new TbSubscribeSysMsg();
            tbSubscribeSysMsg.subscribeTips = str;
            return tbSubscribeSysMsg;
        }
        return (TbSubscribeSysMsg) invokeL.objValue;
    }
}
