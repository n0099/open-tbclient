package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.bv9;
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
public class av9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public iv9 b;
    public bv9 c;
    public bv9.c d;

    public av9(Context context) {
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

    public void h(iv9 iv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iv9Var) == null) {
            this.b = iv9Var;
        }
    }

    public void i(bv9.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            bv9 bv9Var = this.c;
            if (bv9Var != null) {
                bv9Var.h(cVar);
            }
        }
    }

    public static void a(List<iv9> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65537, null, list, i, str, str2) != null) || list == null) {
            return;
        }
        list.add(new iv9(str, i, str2));
    }

    public static List<iv9> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f080597, context.getString(R.string.obfuscated_res_0x7f0f0680), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059b, context.getString(R.string.obfuscated_res_0x7f0f067d), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059e, context.getString(R.string.obfuscated_res_0x7f0f0681), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059a, context.getString(R.string.obfuscated_res_0x7f0f067b), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f080595, context.getString(R.string.obfuscated_res_0x7f0f0678), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f0805a2, context.getString(R.string.obfuscated_res_0x7f0f0685), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f080594, context.getString(R.string.obfuscated_res_0x7f0f0677), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059c, context.getString(R.string.obfuscated_res_0x7f0f067e), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f080596, context.getString(R.string.obfuscated_res_0x7f0f067c), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f080591, context.getString(R.string.obfuscated_res_0x7f0f0674), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f080598, context.getString(R.string.obfuscated_res_0x7f0f0679), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f0805a0, context.getString(R.string.obfuscated_res_0x7f0f0683), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f0805a1, context.getString(R.string.obfuscated_res_0x7f0f0684), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f080593, context.getString(R.string.obfuscated_res_0x7f0f0676), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059d, context.getString(R.string.obfuscated_res_0x7f0f067f), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f080599, context.getString(R.string.obfuscated_res_0x7f0f067a), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f08059f, context.getString(R.string.obfuscated_res_0x7f0f0682), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f080592, context.getString(R.string.obfuscated_res_0x7f0f0675), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return pu9.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            iv9 iv9Var = this.b;
            if (iv9Var != null && !"normal".equalsIgnoreCase(iv9Var.c)) {
                return this.b.c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        bv9 bv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bv9Var = this.c) != null) {
            bv9Var.e();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            bv9 bv9Var = this.c;
            if (bv9Var != null) {
                return bv9Var.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            bv9 bv9Var = this.c;
            if ((bv9Var == null || !bv9Var.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                bv9 bv9Var2 = new bv9(this.a, str, d(), str2);
                this.c = bv9Var2;
                bv9.c cVar = this.d;
                if (cVar != null) {
                    bv9Var2.h(cVar);
                }
                this.c.i();
            }
        }
    }
}
