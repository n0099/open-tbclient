package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.nadcore.webarch.feature.NadWebFeature;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class i81 extends NadWebFeature {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Activity, h81> b;

    @Override // com.baidu.nadcore.webarch.feature.NadWebFeature
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? BdSailorConfig.SAILOR_BASE_UPLOAD : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i81(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new HashMap();
    }

    public h81 d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity)) == null) {
            Map<Activity, h81> map = this.b;
            if (map != null) {
                return map.get(activity);
            }
            return null;
        }
        return (h81) invokeL.objValue;
    }

    public h81 e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            h81 d = d(activity);
            if (d == null) {
                h81 h81Var = new h81(activity);
                this.b.put(activity, h81Var);
                return h81Var;
            }
            return d;
        }
        return (h81) invokeL.objValue;
    }

    public void f(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            h81 d = d(activity);
            if (activity != null && d != null) {
                this.b.remove(activity);
                if (!d.o()) {
                    d.p(-1, null);
                }
            }
        }
    }

    public void g(Activity activity, int i, Intent intent) {
        h81 d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048580, this, activity, i, intent) == null) && (d = d(activity)) != null) {
            d.p(i, intent);
            this.b.remove(activity);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    @RequiresApi(api = 21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean h(Activity activity, @NonNull ValueCallback<Uri[]> valueCallback, g81 g81Var) {
        InterceptResult invokeLLL;
        boolean z;
        Map<Activity, h81> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, activity, valueCallback, g81Var)) == null) {
            if (activity != null) {
                h81 e = e(activity);
                if (g81Var != null) {
                    z = e.q(valueCallback, g81Var);
                    if (!z) {
                        valueCallback.onReceiveValue(null);
                        if (activity != null && (map = this.b) != null) {
                            map.remove(activity);
                        }
                    }
                    return z;
                }
            }
            z = false;
            if (!z) {
            }
            return z;
        }
        return invokeLLL.booleanValue;
    }
}
