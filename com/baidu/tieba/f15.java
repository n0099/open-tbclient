package com.baidu.tieba;

import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public int c;
    public String d;
    public boolean e;
    public boolean f;
    public String g;

    public f15() {
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
        this.a = -202;
        this.c = -100000;
        this.d = "未触发任何实名操作返回或实名时放弃返回";
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.e && this.f) {
                return 3;
            }
            if (this.f) {
                return 2;
            }
            if (this.e) {
                return 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static f15 b(AccountRealNameResult accountRealNameResult) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, accountRealNameResult)) == null) {
            f15 f15Var = new f15();
            f15Var.a = accountRealNameResult.getResultCode();
            f15Var.b = accountRealNameResult.getResultMsg();
            int i = accountRealNameResult.errorStep;
            f15Var.g = accountRealNameResult.callbackkey;
            f15Var.e = accountRealNameResult.juniorRealNameSuc;
            f15Var.f = accountRealNameResult.seniorRealNameSuc;
            f15Var.c = accountRealNameResult.subResultCode;
            f15Var.d = accountRealNameResult.subResultMsg;
            return f15Var;
        }
        return (f15) invokeL.objValue;
    }
}
