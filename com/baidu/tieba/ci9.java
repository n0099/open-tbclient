package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.uh9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
/* loaded from: classes4.dex */
public final class ci9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedHashMap<String, Long> a;

    /* loaded from: classes4.dex */
    public class a extends gi9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ com.baidu.ubs.analytics.a.l a;

        public a(ci9 ci9Var, com.baidu.ubs.analytics.a.l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // com.baidu.tieba.gi9
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                new mh9().c(this.a);
            }
        }
    }

    public ci9() {
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
        this.a = new LinkedHashMap<>();
    }

    public final void a(String str) {
        uh9 uh9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !TextUtils.isEmpty(str)) {
            com.baidu.ubs.analytics.a.l lVar = new com.baidu.ubs.analytics.a.l();
            synchronized (this.a) {
                Long remove = this.a.remove(str);
                if (remove == null) {
                    return;
                }
                try {
                    lVar.setStartTime(String.valueOf(remove));
                    lVar.t(str);
                    lVar.z(String.valueOf(System.currentTimeMillis()));
                    uh9Var = uh9.a.a;
                    lVar.setPath(uh9Var.b());
                    lVar.x(di9.e().I());
                } catch (Exception e) {
                    mi9.a(e.toString());
                    ei9.b(e.toString());
                }
                fi9.c(new a(this, lVar));
            }
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !TextUtils.isEmpty(str)) {
            synchronized (this.a) {
                this.a.put(str, Long.valueOf(System.currentTimeMillis()));
                String.valueOf(System.currentTimeMillis());
            }
        }
    }
}
