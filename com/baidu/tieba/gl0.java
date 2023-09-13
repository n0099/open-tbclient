package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.presenter.LPDownloadManager;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tieba.n81;
import com.baidu.tieba.nl0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gl0 extends bl1<n81> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements n81 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.n81
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        /* renamed from: com.baidu.tieba.gl0$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0309a extends jn0<nl0> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n81.c b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0309a(a aVar, Class cls, n81.c cVar) {
                super(cls);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, cls, cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Class) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.jn0
            public void onEvent(@NonNull nl0 nl0Var) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nl0Var) == null) && this.b != null && !h31.g(nl0Var.a)) {
                    for (nl0.a aVar : nl0Var.a) {
                        if (aVar instanceof nl0.a) {
                            nl0.a aVar2 = aVar;
                            if (!TextUtils.isEmpty(aVar2.b) && !TextUtils.isEmpty(aVar2.a) && !TextUtils.isEmpty(aVar2.c)) {
                                String str = "javascript:" + aVar2.a + "('" + i31.a(aVar2.c) + "');";
                                n81.c cVar = this.b;
                                if (cVar instanceof n81.b) {
                                    ((n81.b) cVar).b(str, aVar2.d);
                                } else {
                                    cVar.a(str);
                                }
                            }
                        }
                    }
                }
            }
        }

        public a(gl0 gl0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.n81
        public void a(Object obj, n81.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, obj, cVar) == null) {
                fn0.a().b(obj, new C0309a(this, nl0.class, cVar));
            }
        }

        @Override // com.baidu.tieba.n81
        public void b(Context context, RelativeLayout relativeLayout, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, relativeLayout, str) == null) {
                LPDownloadManager.f(context, relativeLayout, str, true);
            }
        }
    }

    public gl0() {
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
    @Override // com.baidu.tieba.bl1
    /* renamed from: a */
    public n81 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (n81) invokeV.objValue;
    }
}
