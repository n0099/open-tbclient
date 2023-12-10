package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public class f56 extends fg1<ye0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements ye0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.ye0
        public String[] c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String[]) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ye0
        public boolean d(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        /* renamed from: com.baidu.tieba.f56$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0264a implements bf0 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean[] a;
            public final /* synthetic */ ze0 b;

            public C0264a(a aVar, boolean[] zArr, ze0 ze0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, zArr, ze0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = zArr;
                this.b = ze0Var;
            }

            @Override // com.baidu.tieba.bf0
            public void onResult(boolean z) {
                ze0 ze0Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    this.a[0] = z;
                    if (z && (ze0Var = this.b) != null) {
                        ze0Var.a(true, null);
                    }
                }
            }
        }

        public a(f56 f56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ye0
        public boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable ze0 ze0Var) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, str, map, ze0Var)) == null) {
                Log.e("CMDConfig", "host invoke command = " + str);
                if (UrlSchemaJumpHelper.isHitBlackList(str)) {
                    return true;
                }
                if (!str.startsWith("http://") && !str.startsWith("https://")) {
                    df0.a(context, str, null, new C0264a(this, new boolean[1], ze0Var), false);
                    return true;
                }
                UrlManager.getInstance().dealOneLink(new String[]{str});
                return true;
            }
            return invokeLLLL.booleanValue;
        }

        @Override // com.baidu.tieba.ye0
        public void b(String str, String str2, bf0 bf0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, bf0Var) == null) && bf0Var != null) {
                bf0Var.onResult(true);
            }
        }
    }

    public f56() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fg1
    /* renamed from: a */
    public ye0 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (ye0) invokeV.objValue;
    }
}
