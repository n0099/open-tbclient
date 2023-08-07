package com.baidu.tbadk.pay;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class YYPayResult {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Long amount;
    public int appid;
    public Long currencyAmount;
    public int currencyType;
    public String expand;
    public String orderId;
    public int status;
    public Long uid;
    public int usedChannel;

    public YYPayResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "YYPayResult{amount=" + this.amount + ", appid=" + this.appid + ", currencyAmount=" + this.currencyAmount + ", currencyType=" + this.currencyType + ", expand='" + this.expand + "', orderId='" + this.orderId + "', status=" + this.status + ", uid=" + this.uid + ", usedChannel=" + this.usedChannel + '}';
        }
        return (String) invokeV.objValue;
    }
}
