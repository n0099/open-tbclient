package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jl2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class dk2 extends tg2<jl2> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public final jl2.a h;

    /* loaded from: classes3.dex */
    public class a implements jl2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dk2 a;

        public a(dk2 dk2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dk2Var;
        }

        @Override // com.baidu.tieba.jl2.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onStateChange", Integer.valueOf(i));
        }

        @Override // com.baidu.tieba.jl2.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onInfo", Integer.valueOf(i));
        }

        @Override // com.baidu.tieba.jl2.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.a.b != null) {
                    this.a.b.onCallback(this.a, "onPaused", null);
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                pt1.e().l(str, false);
            }
        }

        @Override // com.baidu.tieba.jl2.a
        public void d(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onNetStatus", str);
        }

        @Override // com.baidu.tieba.jl2.a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (this.a.b != null) {
                    this.a.b.onCallback(this.a, "onPlayed", null);
                }
                pt1.e().l(str, true);
                pt1.e().k(str);
            }
        }

        @Override // com.baidu.tieba.jl2.a
        public void f() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onVideoSizeChanged", null);
        }

        @Override // com.baidu.tieba.jl2.a
        public void onEnded() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onEnded", null);
        }

        @Override // com.baidu.tieba.jl2.a
        public void onError(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onError", Integer.valueOf(i));
        }

        @Override // com.baidu.tieba.jl2.a
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onPrepared", null);
        }

        @Override // com.baidu.tieba.jl2.a
        public void onRelease(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                if (dk2.i) {
                    Log.i("InlineVideoController", "onRelease: " + str);
                }
                pt1.e().q(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947707358, "Lcom/baidu/tieba/dk2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947707358, "Lcom/baidu/tieba/dk2;");
                return;
            }
        }
        i = ij1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dk2(@NonNull jl2 jl2Var) {
        super(jl2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jl2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((vg2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        jl2Var.h0(aVar);
        this.a.a(new gk2());
        this.a.a(new hk2());
        this.a.a(new ik2());
        this.a.a(new lk2());
        this.a.a(new kk2());
        this.a.a(new jk2());
        this.a.a(new mk2());
        this.a.a(new nk2());
        this.a.a(new ok2());
        this.a.a(new pk2());
        this.a.a(new rk2());
        this.a.a(new sk2());
        this.a.a(new tk2());
        this.a.a(new uk2());
        this.a.a(new wk2());
        this.a.a(new xk2());
        this.a.a(new yk2());
        this.a.a(new al2());
        this.a.a(new bl2());
        this.a.a(new vk2());
        this.a.a(new qk2());
        this.a.a(new zk2());
    }
}
