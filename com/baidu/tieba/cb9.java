package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.db9;
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
public class cb9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public kb9 b;
    public db9 c;
    public db9.c d;

    public cb9(Context context) {
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

    public void h(kb9 kb9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kb9Var) == null) {
            this.b = kb9Var;
        }
    }

    public void i(db9.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.d = cVar;
            db9 db9Var = this.c;
            if (db9Var != null) {
                db9Var.h(cVar);
            }
        }
    }

    public static void a(List<kb9> list, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65537, null, list, i, str, str2) != null) || list == null) {
            return;
        }
        list.add(new kb9(str, i, str2));
    }

    public static List<kb9> c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            a(arrayList, R.drawable.obfuscated_res_0x7f08058c, context.getString(R.string.obfuscated_res_0x7f0f0681), "origin");
            a(arrayList, R.drawable.obfuscated_res_0x7f080590, context.getString(R.string.obfuscated_res_0x7f0f067e), "hongkong");
            a(arrayList, R.drawable.obfuscated_res_0x7f080593, context.getString(R.string.obfuscated_res_0x7f0f0682), "refreshing");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058f, context.getString(R.string.obfuscated_res_0x7f0f067c), "girly");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058a, context.getString(R.string.obfuscated_res_0x7f0f0679), "concrete");
            a(arrayList, R.drawable.obfuscated_res_0x7f080597, context.getString(R.string.obfuscated_res_0x7f0f0686), "warm");
            a(arrayList, R.drawable.obfuscated_res_0x7f080589, context.getString(R.string.obfuscated_res_0x7f0f0678), "cold");
            a(arrayList, R.drawable.obfuscated_res_0x7f080591, context.getString(R.string.obfuscated_res_0x7f0f067f), "Japanese");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058b, context.getString(R.string.obfuscated_res_0x7f0f067d), "cruz");
            a(arrayList, R.drawable.obfuscated_res_0x7f080586, context.getString(R.string.obfuscated_res_0x7f0f0675), "abao");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058d, context.getString(R.string.obfuscated_res_0x7f0f067a), "dew");
            a(arrayList, R.drawable.obfuscated_res_0x7f080595, context.getString(R.string.obfuscated_res_0x7f0f0684), "slowlived");
            a(arrayList, R.drawable.obfuscated_res_0x7f080596, context.getString(R.string.obfuscated_res_0x7f0f0685), "sweet");
            a(arrayList, R.drawable.obfuscated_res_0x7f080588, context.getString(R.string.obfuscated_res_0x7f0f0677), "boardwalk");
            a(arrayList, R.drawable.obfuscated_res_0x7f080592, context.getString(R.string.obfuscated_res_0x7f0f0680), "keylime");
            a(arrayList, R.drawable.obfuscated_res_0x7f08058e, context.getString(R.string.obfuscated_res_0x7f0f067b), "electric");
            a(arrayList, R.drawable.obfuscated_res_0x7f080594, context.getString(R.string.obfuscated_res_0x7f0f0683), "silver");
            a(arrayList, R.drawable.obfuscated_res_0x7f080587, context.getString(R.string.obfuscated_res_0x7f0f0676), "blackwhite");
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return ra9.f + VideoMuxer.FILTER_TEMP_DIR_PREFIX + System.currentTimeMillis() + DefaultHlsExtractorFactory.MP4_FILE_EXTENSION;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            kb9 kb9Var = this.b;
            if (kb9Var != null && !"normal".equalsIgnoreCase(kb9Var.c)) {
                return this.b.c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void e() {
        db9 db9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (db9Var = this.c) != null) {
            db9Var.e();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            db9 db9Var = this.c;
            if (db9Var != null) {
                return db9Var.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            db9 db9Var = this.c;
            if ((db9Var == null || !db9Var.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
                db9 db9Var2 = new db9(this.a, str, d(), str2);
                this.c = db9Var2;
                db9.c cVar = this.d;
                if (cVar != null) {
                    db9Var2.h(cVar);
                }
                this.c.i();
            }
        }
    }
}
