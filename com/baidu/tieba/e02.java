package com.baidu.tieba;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.tieba.kz1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e02 extends a02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "PageScrollToApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements kz1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e02 a;

        /* renamed from: com.baidu.tieba.e02$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0264a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ a c;

            /* renamed from: com.baidu.tieba.e02$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0265a implements ValueAnimator.AnimatorUpdateListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ox1 a;

                public C0265a(RunnableC0264a runnableC0264a, ox1 ox1Var) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0264a, ox1Var};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = ox1Var;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                        this.a.webViewScrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                }
            }

            public RunnableC0264a(a aVar, int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = i;
                this.b = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                ox1 i;
                int f;
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (i = uw2.T().i()) == null) {
                    return;
                }
                if (i instanceof NgWebView) {
                    f = e02.z(i, yo3.f(this.c.a.getContext(), this.a));
                } else {
                    f = yo3.f(this.c.a.getContext(), this.a);
                }
                ValueAnimator ofInt = ValueAnimator.ofInt(i.getWebViewScrollY(), f);
                ofInt.setDuration(this.b);
                ofInt.addUpdateListener(new C0265a(this, i));
                ofInt.start();
            }
        }

        public a(e02 e02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e02Var;
        }

        @Override // com.baidu.tieba.kz1.a
        public h32 a(hb3 hb3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, hb3Var, jSONObject, str)) == null) {
                int optInt = jSONObject.optInt("scrollTop", -1);
                int optInt2 = jSONObject.optInt("duration", -1);
                if (optInt > -1 && optInt2 > -1) {
                    bp3.e0(new RunnableC0264a(this, optInt, optInt2));
                    return new h32(0);
                }
                h82.c("PageScrollToApi", "illegal scrollTop or duration");
                return new h32(1001, "illegal params");
            }
            return (h32) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e02(@NonNull iz1 iz1Var) {
        super(iz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public h32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#pageScrollTo", false);
            return l(str, false, new a(this));
        }
        return (h32) invokeL.objValue;
    }

    public static int z(@NonNull ox1 ox1Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, ox1Var, i)) == null) {
            int contentHeight = ((int) (ox1Var.getContentHeight() * ox1Var.getScale())) - ((Integer) uw2.T().r().second).intValue();
            if (contentHeight <= 0) {
                return 0;
            }
            if (i > contentHeight) {
                return contentHeight;
            }
            return i;
        }
        return invokeLI.intValue;
    }
}
