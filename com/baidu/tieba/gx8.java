package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.hx8;
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
/* loaded from: classes4.dex */
public class gx8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ox8 b;
    public hx8 c;
    public hx8.c d;

    public gx8(Context context) {
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

    public void h(ox8 ox8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ox8Var) == null) {
            this.b = ox8Var;
        }
    }

    public void i(hx8.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            hx8 hx8Var = this.c;
            if (hx8Var != null) {
                hx8Var.h(cVar);
            }
        }
    }

    public static void a(List<ox8> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65537, null, list, i, str, str2) != null) || list == null) {
            return;
        }
        list.add(new ox8(str, i, str2));
    }

    public static List<ox8> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f080571, context.getString(R.string.obfuscated_res_0x7f0f0646), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f080575, context.getString(R.string.obfuscated_res_0x7f0f0643), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f080578, context.getString(R.string.obfuscated_res_0x7f0f0647), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f080574, context.getString(R.string.obfuscated_res_0x7f0f0641), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056f, context.getString(R.string.obfuscated_res_0x7f0f063e), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f08057c, context.getString(R.string.obfuscated_res_0x7f0f064b), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056e, context.getString(R.string.obfuscated_res_0x7f0f063d), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f080576, context.getString(R.string.obfuscated_res_0x7f0f0644), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f080570, context.getString(R.string.obfuscated_res_0x7f0f0642), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056b, context.getString(R.string.obfuscated_res_0x7f0f063a), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f080572, context.getString(R.string.obfuscated_res_0x7f0f063f), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f08057a, context.getString(R.string.obfuscated_res_0x7f0f0649), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f08057b, context.getString(R.string.obfuscated_res_0x7f0f064a), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056d, context.getString(R.string.obfuscated_res_0x7f0f063c), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f080577, context.getString(R.string.obfuscated_res_0x7f0f0645), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f080573, context.getString(R.string.obfuscated_res_0x7f0f0640), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f080579, context.getString(R.string.obfuscated_res_0x7f0f0648), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f08056c, context.getString(R.string.obfuscated_res_0x7f0f063b), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return vw8.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ox8 ox8Var = this.b;
            if (ox8Var != null && !"normal".equalsIgnoreCase(ox8Var.c)) {
                return this.b.c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        hx8 hx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (hx8Var = this.c) != null) {
            hx8Var.e();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            hx8 hx8Var = this.c;
            if (hx8Var != null) {
                return hx8Var.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            hx8 hx8Var = this.c;
            if ((hx8Var == null || !hx8Var.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                hx8 hx8Var2 = new hx8(this.a, str, d(), str2);
                this.c = hx8Var2;
                hx8.c cVar = this.d;
                if (cVar != null) {
                    hx8Var2.h(cVar);
                }
                this.c.i();
            }
        }
    }
}
