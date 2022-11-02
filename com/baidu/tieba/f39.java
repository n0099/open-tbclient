package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.net.VpnService;
import androidx.fragment.app.Fragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Fragment a;
    public Activity b;
    public e39 c;

    public f39() {
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

    public static f39 c(Fragment fragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fragment)) == null) {
            f39 f39Var = new f39();
            f39Var.a = fragment;
            return f39Var;
        }
        return (f39) invokeL.objValue;
    }

    public void a(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIL(1048576, this, i, i2, intent) != null) || i != 25069) {
            return;
        }
        if (i2 == -1) {
            e39 e39Var = this.c;
            if (e39Var != null) {
                e39Var.a();
                return;
            }
            return;
        }
        e39 e39Var2 = this.c;
        if (e39Var2 != null) {
            e39Var2.b();
        }
    }

    public void b(e39 e39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e39Var) == null) {
            this.c = e39Var;
            Fragment fragment = this.a;
            if (fragment != null) {
                Intent prepare = VpnService.prepare(fragment.getContext());
                if (prepare != null) {
                    this.a.startActivityForResult(prepare, 25069);
                    return;
                }
                e39 e39Var2 = this.c;
                if (e39Var2 != null) {
                    e39Var2.a();
                    return;
                }
                return;
            }
            Activity activity = this.b;
            if (activity != null) {
                Intent prepare2 = VpnService.prepare(activity);
                if (prepare2 != null) {
                    this.b.startActivityForResult(prepare2, 25069);
                    return;
                }
                e39 e39Var3 = this.c;
                if (e39Var3 != null) {
                    e39Var3.a();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Can not request VPN permission because no Fragment or Activity, please use static function with()");
        }
    }
}
