package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.yy.gameassist.GameAssistNPSPluginManager;
import com.baidu.searchbox.yy.gameassist.LiveYYNpsLoadingCallback;
import com.baidu.searchbox.yy.gameassist.NPSPluginStateHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.view.NpsPluginLoadingDialogActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class az7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<NpsPluginLoadingDialogActivity> a;
    public int b;
    public boolean c;

    /* loaded from: classes5.dex */
    public class a implements LiveYYNpsLoadingCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az7 a;

        public a(az7 az7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = az7Var;
        }

        @Override // com.baidu.searchbox.yy.gameassist.LiveYYNpsLoadingCallback
        public void onLoadingEnd(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.c = false;
            this.a.f();
        }

        @Override // com.baidu.searchbox.yy.gameassist.LiveYYNpsLoadingCallback
        public void onLoadingProgress(long j, long j2) {
            float f;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                BdLog.d("[onDownloadUpdate] package:, current:" + j + ",total:" + j2);
                if (j2 <= 0) {
                    f = 0.0f;
                } else {
                    f = (((float) j) * 100.0f) / ((float) j2);
                }
                this.a.b = (int) f;
                az7 az7Var = this.a;
                az7Var.q(az7Var.h());
            }
        }

        @Override // com.baidu.searchbox.yy.gameassist.LiveYYNpsLoadingCallback
        public void onLoadingStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.c = true;
                this.a.n(TbadkCoreApplication.getInst());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final az7 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-930874707, "Lcom/baidu/tieba/az7$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-930874707, "Lcom/baidu/tieba/az7$b;");
                    return;
                }
            }
            a = new az7(null);
        }
    }

    public az7() {
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
        this.b = 0;
        this.c = false;
        NPSPluginStateHelper.INSTANCE.setLoadingCallback(new a(this));
        b69.a(TbadkCoreApplication.getInst());
    }

    public /* synthetic */ az7(a aVar) {
        this();
    }

    public void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            GameAssistNPSPluginManager.INSTANCE.clearLiveResourceSize(context);
        }
    }

    public long j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            return GameAssistNPSPluginManager.INSTANCE.getLiveResourceSize(context);
        }
        return invokeL.longValue;
    }

    public void m(NpsPluginLoadingDialogActivity npsPluginLoadingDialogActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, npsPluginLoadingDialogActivity) == null) {
            this.a = new WeakReference<>(npsPluginLoadingDialogActivity);
            q(npsPluginLoadingDialogActivity);
        }
    }

    public void q(NpsPluginLoadingDialogActivity npsPluginLoadingDialogActivity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, npsPluginLoadingDialogActivity) == null) && npsPluginLoadingDialogActivity != null) {
            npsPluginLoadingDialogActivity.N0(this.b);
        }
    }

    public void o(Activity activity, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, activity, map) == null) {
            if (p()) {
                BdUtilHelper.showToast(activity, "安卓系统版本不支持");
            } else {
                GameAssistNPSPluginManager.INSTANCE.startGameAssistActivity(activity, map);
            }
        }
    }

    public static az7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return b.a;
        }
        return (az7) invokeV.objValue;
    }

    public final void f() {
        NpsPluginLoadingDialogActivity h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (h = h()) != null) {
            h.finish();
            this.a = null;
        }
    }

    public final NpsPluginLoadingDialogActivity h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WeakReference<NpsPluginLoadingDialogActivity> weakReference = this.a;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (NpsPluginLoadingDialogActivity) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a = null;
            NPSPluginStateHelper.INSTANCE.cancelLoading();
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (Build.VERSION.SDK_INT < 24) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void g(Context context, String str, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, hashMap) == null) {
            GameAssistNPSPluginManager.INSTANCE.dispatchHostEvent(context, str, hashMap);
        }
    }

    public void n(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) != null) || h() != null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent(context, NpsPluginLoadingDialogActivity.class);
        intent.putExtra("dialogId", currentTimeMillis);
        intent.putExtra("tag", "gameAssistTag");
        if (!(context instanceof Activity)) {
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
        }
        context.startActivity(intent);
    }
}
