package com.baidu.tieba;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes4.dex */
public class i05 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i05 c;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947799707, "Lcom/baidu/tieba/i05;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947799707, "Lcom/baidu/tieba/i05;");
        }
    }

    public i05() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = 0;
        try {
            pc pcVar = new pc("", "apk_ab_test.txt", DiskFileOperate.Action.READ);
            pcVar.setSdCard(true);
            pcVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            if (pcVar.call()) {
                String a = pcVar.a();
                if (a != null) {
                    this.b = Integer.parseInt(a);
                }
                if (this.b == 1 || this.b == 2) {
                    this.a = true;
                }
            }
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }

    public static i05 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (i05.class) {
                    if (c == null) {
                        c = new i05();
                    }
                }
            }
            return c;
        }
        return (i05) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a ? "pub_env=" + this.b + ParamableElem.DIVIDE_PARAM : "";
        }
        return (String) invokeV.objValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : invokeV.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.booleanValue;
    }
}
