package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.c19;
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
public class b19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public j19 b;
    public c19 c;
    public c19.c d;

    public b19(Context context) {
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

    public void h(j19 j19Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, j19Var) == null) {
            this.b = j19Var;
        }
    }

    public void i(c19.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            c19 c19Var = this.c;
            if (c19Var != null) {
                c19Var.h(cVar);
            }
        }
    }

    public static void a(List<j19> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65537, null, list, i, str, str2) != null) || list == null) {
            return;
        }
        list.add(new j19(str, i, str2));
    }

    public static List<j19> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f08057c, context.getString(R.string.obfuscated_res_0x7f0f064e), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f080580, context.getString(R.string.obfuscated_res_0x7f0f064b), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f080583, context.getString(R.string.obfuscated_res_0x7f0f064f), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f08057f, context.getString(R.string.obfuscated_res_0x7f0f0649), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f08057a, context.getString(R.string.obfuscated_res_0x7f0f0646), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f080587, context.getString(R.string.obfuscated_res_0x7f0f0653), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f080579, context.getString(R.string.obfuscated_res_0x7f0f0645), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f080581, context.getString(R.string.obfuscated_res_0x7f0f064c), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f08057b, context.getString(R.string.obfuscated_res_0x7f0f064a), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f080576, context.getString(R.string.obfuscated_res_0x7f0f0642), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f08057d, context.getString(R.string.obfuscated_res_0x7f0f0647), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f080585, context.getString(R.string.obfuscated_res_0x7f0f0651), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f080586, context.getString(R.string.obfuscated_res_0x7f0f0652), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f080578, context.getString(R.string.obfuscated_res_0x7f0f0644), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f080582, context.getString(R.string.obfuscated_res_0x7f0f064d), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f08057e, context.getString(R.string.obfuscated_res_0x7f0f0648), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f080584, context.getString(R.string.obfuscated_res_0x7f0f0650), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f080577, context.getString(R.string.obfuscated_res_0x7f0f0643), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return q09.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            j19 j19Var = this.b;
            if (j19Var != null && !"normal".equalsIgnoreCase(j19Var.c)) {
                return this.b.c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        c19 c19Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (c19Var = this.c) != null) {
            c19Var.e();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c19 c19Var = this.c;
            if (c19Var != null) {
                return c19Var.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            c19 c19Var = this.c;
            if ((c19Var == null || !c19Var.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                c19 c19Var2 = new c19(this.a, str, d(), str2);
                this.c = c19Var2;
                c19.c cVar = this.d;
                if (cVar != null) {
                    c19Var2.h(cVar);
                }
                this.c.i();
            }
        }
    }
}
