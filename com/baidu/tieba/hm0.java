package com.baidu.tieba;

import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.retain.RetainDialogActivity;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class hm0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, Boolean> a;
    public il0 b;
    public WeakReference<sl0> c;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final hm0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-742684960, "Lcom/baidu/tieba/hm0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-742684960, "Lcom/baidu/tieba/hm0$b;");
                    return;
                }
            }
            a = new hm0(null);
        }
    }

    public hm0() {
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
        this.a = new HashMap<>();
    }

    public static hm0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (hm0) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            il0 il0Var = this.b;
            if (il0Var != null && il0Var.c != AdDownloadStatus.COMPLETED) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void f() {
        WeakReference<sl0> weakReference;
        sl0 sl0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (weakReference = this.c) != null && (sl0Var = weakReference.get()) != null) {
            sl0Var.h();
        }
    }

    public /* synthetic */ hm0(a aVar) {
        this();
    }

    public final boolean b(sl0 sl0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sl0Var)) == null) {
            WeakReference<sl0> weakReference = new WeakReference<>(sl0Var);
            this.c = weakReference;
            sl0 sl0Var2 = weakReference.get();
            if (sl0Var2 != null && sl0Var2.getData() != null) {
                this.b = sl0Var2.getData();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.put(this.b.e(), Boolean.TRUE);
            Intent intent = new Intent();
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.putExtra("ext", this.b.p.a);
            intent.putExtra("alsPage", ClogBuilder.Page.AD_DIALOG);
            intent.putExtra("percent", (int) (this.b.i * 100.0f));
            intent.setClassName(tj0.b().getPackageName(), RetainDialogActivity.class.getName());
            i61.d(tj0.b(), intent);
        }
    }

    public boolean e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (!(obj instanceof sl0) || un0.b().a().a("key_ad_interrupt_dialog_switch", 1) == 0) {
                return false;
            }
            boolean b2 = b((sl0) obj);
            int a2 = un0.b().a().a("key_ad_interrupt_dialog_target_percnet", 50);
            if (!b2) {
                return false;
            }
            il0 il0Var = this.b;
            if (il0Var.i * 100.0f < a2 || this.a.get(il0Var.e()) != null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
