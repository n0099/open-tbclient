package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tieba.d35;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes3.dex */
public class e35 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static WeakReference<d35> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d35 a;

        public a(d35 d35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d35Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A();
                boolean unused = e35.a = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d35 a;

        public b(d35 d35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d35Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t();
            }
        }
    }

    public static d35 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            WeakReference<d35> weakReference = b;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (d35) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return invokeV.booleanValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            ky4.k().x("key_live_remind_float_view", System.currentTimeMillis());
        }
    }

    public static d35 d(View view2, TbPageContext<?> tbPageContext, Map<String, Object> map, long j, long j2, d35.h hVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{view2, tbPageContext, map, Long.valueOf(j), Long.valueOf(j2), hVar})) == null) {
            d35 d35Var = new d35(tbPageContext, map);
            if (hVar != null) {
                d35Var.x(hVar);
            }
            if (view2 != null) {
                d35Var.y(view2);
            }
            if (j <= 0) {
                d35Var.A();
                a = true;
            } else {
                zg.a().postDelayed(new a(d35Var), j);
            }
            if (j2 > 0) {
                zg.a().postDelayed(new b(d35Var), j2);
            }
            b = new WeakReference<>(d35Var);
            return d35Var;
        }
        return (d35) invokeCommon.objValue;
    }

    public static d35 f(View view2, TbPageContext<?> tbPageContext, Map<String, Object> map, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{view2, tbPageContext, map, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (tbPageContext != null && !MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !e45.d()) {
                return d(view2, tbPageContext, map, j, j2, null);
            }
            return null;
        }
        return (d35) invokeCommon.objValue;
    }
}
