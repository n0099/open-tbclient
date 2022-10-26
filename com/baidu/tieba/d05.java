package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public int c;
    public String d;

    public d05() {
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
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = null;
    }

    public static String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            switch (i) {
                case 1:
                    return xj.a(R.string.obfuscated_res_0x7f0f1598);
                case 2:
                    return xj.a(R.string.obfuscated_res_0x7f0f159d);
                case 3:
                    return xj.a(R.string.obfuscated_res_0x7f0f0c68);
                case 4:
                    return xj.a(R.string.obfuscated_res_0x7f0f159b);
                case 5:
                    return xj.a(R.string.obfuscated_res_0x7f0f1599);
                case 6:
                    return xj.a(R.string.obfuscated_res_0x7f0f159c);
                case 7:
                    return xj.a(R.string.obfuscated_res_0x7f0f159a);
                default:
                    return "";
            }
        }
        return (String) invokeI.objValue;
    }
}
