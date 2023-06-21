package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.h9a;
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
/* loaded from: classes5.dex */
public class g9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public o9a b;
    public h9a c;
    public h9a.c d;

    public g9a(Context context) {
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

    public void h(o9a o9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, o9aVar) == null) {
            this.b = o9aVar;
        }
    }

    public void i(h9a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            h9a h9aVar = this.c;
            if (h9aVar != null) {
                h9aVar.h(cVar);
            }
        }
    }

    public static void a(List<o9a> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65537, null, list, i, str, str2) != null) || list == null) {
            return;
        }
        list.add(new o9a(str, i, str2));
    }

    public static List<o9a> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a2, context.getString(R.string.obfuscated_res_0x7f0f0732), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a6, context.getString(R.string.obfuscated_res_0x7f0f072f), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a9, context.getString(R.string.obfuscated_res_0x7f0f0733), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a5, context.getString(R.string.obfuscated_res_0x7f0f072d), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a0, context.getString(R.string.obfuscated_res_0x7f0f072a), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806ad, context.getString(R.string.obfuscated_res_0x7f0f0737), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f08069f, context.getString(R.string.obfuscated_res_0x7f0f0729), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a7, context.getString(R.string.obfuscated_res_0x7f0f0730), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a1, context.getString(R.string.obfuscated_res_0x7f0f072e), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f08069c, context.getString(R.string.obfuscated_res_0x7f0f0726), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a3, context.getString(R.string.obfuscated_res_0x7f0f072b), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806ab, context.getString(R.string.obfuscated_res_0x7f0f0735), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806ac, context.getString(R.string.obfuscated_res_0x7f0f0736), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f08069e, context.getString(R.string.obfuscated_res_0x7f0f0728), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a8, context.getString(R.string.obfuscated_res_0x7f0f0731), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806a4, context.getString(R.string.obfuscated_res_0x7f0f072c), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f0806aa, context.getString(R.string.obfuscated_res_0x7f0f0734), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f08069d, context.getString(R.string.obfuscated_res_0x7f0f0727), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return v8a.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            o9a o9aVar = this.b;
            if (o9aVar != null && !"normal".equalsIgnoreCase(o9aVar.c)) {
                return this.b.c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        h9a h9aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (h9aVar = this.c) != null) {
            h9aVar.e();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            h9a h9aVar = this.c;
            if (h9aVar != null) {
                return h9aVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            h9a h9aVar = this.c;
            if ((h9aVar == null || !h9aVar.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                h9a h9aVar2 = new h9a(this.a, str, d(), str2);
                this.c = h9aVar2;
                h9a.c cVar = this.d;
                if (cVar != null) {
                    h9aVar2.h(cVar);
                }
                this.c.i();
            }
        }
    }
}
