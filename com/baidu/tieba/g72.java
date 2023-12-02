package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.launchtips.monitor.network.NetworkStatus;
import com.baidu.swan.apps.core.launchtips.scene.SceneType;
import com.baidu.tieba.s62;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public final s62 a;
    public final b72 b;
    public final p62 c;

    /* loaded from: classes6.dex */
    public class a implements s62.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d72 a;
        public final /* synthetic */ r62 b;
        public final /* synthetic */ g72 c;

        public a(g72 g72Var, d72 d72Var, r62 r62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g72Var, d72Var, r62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g72Var;
            this.a = d72Var;
            this.b = r62Var;
        }

        @Override // com.baidu.tieba.s62.b
        public void a(NetworkStatus networkStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkStatus) == null) {
                l62.e(SceneType.SCENE_INIT_DATA_ERROR.getType(), networkStatus.getStatus(), this.a.e().getStatus(), this.a.g(), this.a.b(), this.a.f(), this.a.a());
                StringBuilder sb = new StringBuilder();
                sb.append(SceneType.SCENE_INIT_DATA_ERROR.getScene());
                sb.append(this.b.a());
                sb.append(this.a.d());
                sb.append(networkStatus.getDesc());
                sb.append(this.a.c());
                if (g72.d) {
                    Log.d("SceneInitDataTips", ">> " + sb.toString());
                }
                m62.g(sb.toString());
                this.c.d(networkStatus);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-821124663, "Lcom/baidu/tieba/g72$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-821124663, "Lcom/baidu/tieba/g72$b;");
                    return;
                }
            }
            int[] iArr = new int[NetworkStatus.values().length];
            a = iArr;
            try {
                iArr[NetworkStatus.NETWORK_BAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[NetworkStatus.NETWORK_OFFLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947746759, "Lcom/baidu/tieba/g72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947746759, "Lcom/baidu/tieba/g72;");
                return;
            }
        }
        d = vm1.a;
    }

    public g72() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = p62.d();
        this.a = new s62();
        this.b = b72.d();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (d) {
                Log.d("SceneInitDataTips", ">> trigger init data error event.");
            }
            b72.d().j();
            p62.d().j();
            r62 f = this.c.f();
            this.a.a(new a(this, this.b.f(), f));
        }
    }

    public final void d(NetworkStatus networkStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkStatus) == null) {
            int i = b.a[networkStatus.ordinal()];
            if (i != 1 && i != 2) {
                k62.f(R.string.obfuscated_res_0x7f0f15de);
            } else {
                k62.f(R.string.obfuscated_res_0x7f0f15d4);
            }
        }
    }
}
