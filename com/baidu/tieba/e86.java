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
public class e86 extends wl1<fk0> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements fk0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.fk0
        public String[] c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String[]) invokeV.objValue;
        }

        @Override // com.baidu.tieba.fk0
        public boolean d(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        /* renamed from: com.baidu.tieba.e86$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0282a implements ik0 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean[] a;
            public final /* synthetic */ gk0 b;

            public C0282a(a aVar, boolean[] zArr, gk0 gk0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, zArr, gk0Var};
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
                this.b = gk0Var;
            }

            @Override // com.baidu.tieba.ik0
            public void onResult(boolean z) {
                gk0 gk0Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    this.a[0] = z;
                    if (z && (gk0Var = this.b) != null) {
                        gk0Var.a(true, null);
                    }
                }
            }
        }

        public a(e86 e86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.fk0
        public boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable gk0 gk0Var) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, str, map, gk0Var)) == null) {
                Log.e("CMDConfig", "host invoke command = " + str);
                if (UrlSchemaJumpHelper.isHitBlackList(str)) {
                    return true;
                }
                if (!str.startsWith("http://") && !str.startsWith("https://")) {
                    kk0.a(context, str, null, new C0282a(this, new boolean[1], gk0Var), false);
                    return true;
                }
                UrlManager.getInstance().dealOneLink(new String[]{str});
                return true;
            }
            return invokeLLLL.booleanValue;
        }

        @Override // com.baidu.tieba.fk0
        public void b(String str, String str2, ik0 ik0Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, ik0Var) == null) && ik0Var != null) {
                ik0Var.onResult(true);
            }
        }
    }

    public e86() {
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
    @Override // com.baidu.tieba.wl1
    /* renamed from: a */
    public fk0 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (fk0) invokeV.objValue;
    }
}
