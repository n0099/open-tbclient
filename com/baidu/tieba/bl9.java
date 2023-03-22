package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.cl9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.muxer.VideoMuxer;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class bl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public jl9 b;
    public cl9 c;
    public cl9.c d;

    public bl9(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public void h(jl9 jl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jl9Var) == null) {
            this.b = jl9Var;
        }
    }

    public void i(cl9.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            cl9 cl9Var = this.c;
            if (cl9Var != null) {
                cl9Var.h(cVar);
            }
        }
    }

    public static void a(List<jl9> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65537, null, list, i, str, str2) != null) || list == null) {
            return;
        }
        list.add(new jl9(str, i, str2));
    }

    public static List<jl9> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f08059d, context.getString(R.string.obfuscated_res_0x7f0f0688), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f0805a1, context.getString(R.string.obfuscated_res_0x7f0f0685), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f0805a4, context.getString(R.string.obfuscated_res_0x7f0f0689), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f0805a0, context.getString(R.string.obfuscated_res_0x7f0f0683), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059b, context.getString(R.string.obfuscated_res_0x7f0f0680), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f0805a8, context.getString(R.string.obfuscated_res_0x7f0f068d), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059a, context.getString(R.string.obfuscated_res_0x7f0f067f), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f0805a2, context.getString(R.string.obfuscated_res_0x7f0f0686), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059c, context.getString(R.string.obfuscated_res_0x7f0f0684), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f080597, context.getString(R.string.obfuscated_res_0x7f0f067c), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059e, context.getString(R.string.obfuscated_res_0x7f0f0681), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f0805a6, context.getString(R.string.obfuscated_res_0x7f0f068b), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f0805a7, context.getString(R.string.obfuscated_res_0x7f0f068c), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f080599, context.getString(R.string.obfuscated_res_0x7f0f067e), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f0805a3, context.getString(R.string.obfuscated_res_0x7f0f0687), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059f, context.getString(R.string.obfuscated_res_0x7f0f0682), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f0805a5, context.getString(R.string.obfuscated_res_0x7f0f068a), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f080598, context.getString(R.string.obfuscated_res_0x7f0f067d), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return qk9.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            jl9 jl9Var = this.b;
            if (jl9Var != null && !"normal".equalsIgnoreCase(jl9Var.c)) {
                return this.b.c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        cl9 cl9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (cl9Var = this.c) != null) {
            cl9Var.e();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            cl9 cl9Var = this.c;
            if (cl9Var != null) {
                return cl9Var.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            cl9 cl9Var = this.c;
            if ((cl9Var == null || !cl9Var.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                cl9 cl9Var2 = new cl9(this.a, str, d(), str2);
                this.c = cl9Var2;
                cl9.c cVar = this.d;
                if (cVar != null) {
                    cl9Var2.h(cVar);
                }
                this.c.i();
            }
        }
    }
}
