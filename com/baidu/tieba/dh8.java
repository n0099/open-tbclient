package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dh8 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String f;
    public static final String g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947704661, "Lcom/baidu/tieba/dh8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947704661, "Lcom/baidu/tieba/dh8;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0920);
        b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0922);
        c = TbadkCoreApplication.getInst().getString(R.string.group_chat_group_had_close);
        d = TbadkCoreApplication.getInst().getString(R.string.group_chat_no_speak_all);
        e = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0939);
        f = TbadkCoreApplication.getInst().getString(R.string.group_chat_no_speak_person);
        g = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f092e);
    }
}
