package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.presenter.LPDownloadManager;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.tieba.a91;
import com.baidu.tieba.lm0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class em0 extends pl1<a91> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements a91 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.a91
        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        /* renamed from: com.baidu.tieba.em0$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0283a extends ho0<lm0> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a91.c b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0283a(a aVar, Class cls, a91.c cVar) {
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
            @Override // com.baidu.tieba.ho0
            public void onEvent(@NonNull lm0 lm0Var) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lm0Var) == null) && this.b != null && !x31.g(lm0Var.a)) {
                    for (lm0.a aVar : lm0Var.a) {
                        if (aVar instanceof lm0.a) {
                            lm0.a aVar2 = aVar;
                            if (!TextUtils.isEmpty(aVar2.b) && !TextUtils.isEmpty(aVar2.a) && !TextUtils.isEmpty(aVar2.c)) {
                                String str = "javascript:" + aVar2.a + "('" + y31.a(aVar2.c) + "');";
                                a91.c cVar = this.b;
                                if (cVar instanceof a91.b) {
                                    ((a91.b) cVar).b(str, aVar2.d);
                                } else {
                                    cVar.a(str);
                                }
                            }
                        }
                    }
                }
            }
        }

        public a(em0 em0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {em0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.a91
        public void a(Object obj, a91.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, obj, cVar) == null) {
                do0.a().b(obj, new C0283a(this, lm0.class, cVar));
            }
        }

        @Override // com.baidu.tieba.a91
        public void b(Context context, RelativeLayout relativeLayout, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, relativeLayout, str) == null) {
                LPDownloadManager.f(context, relativeLayout, str, true);
            }
        }
    }

    public em0() {
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
    @Override // com.baidu.tieba.pl1
    /* renamed from: a */
    public a91 createService() throws ServiceNotFoundException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this);
        }
        return (a91) invokeV.objValue;
    }
}
