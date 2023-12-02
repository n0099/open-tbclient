package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class h52 extends SwanAppWebViewManager implements qs1<NgWebView> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean y;
    public transient /* synthetic */ FieldHolder $fh;
    public Context w;
    public boolean x;

    public void E(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.ts1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "console" : (String) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947774628, "Lcom/baidu/tieba/h52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947774628, "Lcom/baidu/tieba/h52;");
                return;
            }
        }
        y = vm1.a;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k32.n(false);
            ViewParent parent = getWebView().getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(getWebView());
            }
            destroy();
        }
    }

    public final void Q() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (context = this.w) != null && (context instanceof Activity)) {
            lj3.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.baidu.tieba.qs1
    public void S() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (getWebView().getVisibility() != 0) {
                z = true;
            } else {
                z = false;
            }
            N(z);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.ts1
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.b0();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.ts1
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Q();
            super.destroy();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h52(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.x = false;
        this.w = context;
        d1();
    }

    @Override // com.baidu.tieba.qs1
    public void D(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) != null) || viewGroup == null) {
            return;
        }
        i(viewGroup, getWebView());
    }

    public void N(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            NgWebView webView = getWebView();
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            webView.setVisibility(i);
        }
    }

    public final void b1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (y) {
                Log.d("SwanAppConsoleManager", "call downloadConsoleCore: " + z);
            }
            if (this.x && !z) {
                return;
            }
            nh4 nh4Var = new nh4("sconsole-core", l32.c(), l32.b(), 2);
            fe4 fe4Var = null;
            un1 h = sp2.h();
            if (h != null) {
                fe4Var = h.d();
            }
            ud4.g(nh4Var, fe4Var);
            this.x = true;
        }
    }

    public final boolean c1(ViewGroup viewGroup, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, viewGroup, view2)) == null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (viewGroup.getChildAt(i) == view2) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void i(ViewGroup viewGroup, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, viewGroup, view2) != null) || viewGroup == null || view2 == null || c1(viewGroup, view2)) {
            return;
        }
        viewGroup.addView(view2, new FrameLayout.LayoutParams(-1, -1));
    }

    public void d0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            JSONArray jSONArray = new JSONArray();
            if (!TextUtils.isEmpty(str2)) {
                jSONArray.put(str2);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("logType", str);
            hashMap.put("logs", jSONArray.toString());
            xr2.V().n("console", new lg2("searchboxSConsole", hashMap));
        }
    }

    public void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            getWebView().setVisibility(8);
            getWebView().setBackgroundColor(0);
            File file = new File(l32.a(), "index.html");
            if (file.exists() && file.isFile()) {
                loadUrl(Uri.fromFile(file).toString());
                b1(false);
                return;
            }
            loadUrl("file:///android_asset/aiapps/sConsole.html");
            l32.d();
            b1(true);
        }
    }
}
