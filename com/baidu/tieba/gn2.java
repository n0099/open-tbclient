package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.textarea.ShowConfirmBarLayout;
import com.baidu.tieba.hk2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
/* loaded from: classes6.dex */
public final class gn2 implements hk2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public static final int h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @Nullable
    public String b;
    @Nullable
    public s52 c;
    public int d;
    public ShowConfirmBarLayout e;
    public f f;

    /* loaded from: classes6.dex */
    public interface f {
        void a();
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ gn2 e;

        public a(gn2 gn2Var, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn2Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = gn2Var;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.e.C0(this.a, this.b, this.c, this.d);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gn2 a;

        public b(gn2 gn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gn2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.B0();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ gn2 b;

        public c(gn2 gn2Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn2Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gn2Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.E0(this.a);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ShowConfirmBarLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gn2 a;

        public d(gn2 gn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gn2Var;
        }

        @Override // com.baidu.swan.apps.textarea.ShowConfirmBarLayout.b
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.A0("onConfirmBtnClick", null);
            if (this.a.f != null) {
                this.a.f.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gn2 a;

        public e(gn2 gn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gn2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.v0();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947799614, "Lcom/baidu/tieba/gn2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947799614, "Lcom/baidu/tieba/gn2;");
                return;
            }
        }
        g = vm1.a;
        h = bk3.g(38.0f);
    }

    public final void B0() {
        s52 s52Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (s52Var = this.c) != null && this.d != 0) {
            this.d = 0;
            if (s52Var.E3().getScrollY() > 0) {
                this.c.E3().setScrollY(0);
            }
        }
    }

    @Override // com.baidu.tieba.hk2
    @Nullable
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hk2
    @Nullable
    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public final Activity u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            k63 M = k63.M();
            if (M == null) {
                return null;
            }
            return M.O();
        }
        return (Activity) invokeV.objValue;
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            ek3.a0(new e(this));
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ek3.a0(new b(this));
        }
    }

    public gn2(ZeusPluginFactory.Invoker invoker, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invoker, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (invoker != null) {
            this.b = (String) invoker.get("id");
        }
        this.a = str;
        this.c = t0();
    }

    @Override // com.baidu.tieba.hk2
    public void A(@NonNull hk2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (k63.M() == null) {
                aVar.a(false);
            } else {
                aVar.a(true);
            }
        }
    }

    public void D0(@NonNull f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.f = fVar;
        }
    }

    public void z0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            ek3.a0(new c(this, i));
        }
    }

    public final void A0(String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && g) {
            String str3 = (" <<" + j0() + "-" + hashCode() + ">> \t") + " <<" + str + ">> ";
            if (!TextUtils.isEmpty(str2)) {
                str3 = str3 + str2;
            }
            Log.i(" [[ConfirmBarCallback]] ", str3);
        }
    }

    public final void C0(int i, int i2, int i3, int i4) {
        int i5;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIII(1048579, this, i, i2, i3, i4) != null) || this.c == null) {
            return;
        }
        ss1 i6 = xr2.V().i();
        if (this.d != i3 && i6 != null) {
            this.d = i3;
            if (this.e == null) {
                i5 = 0;
            } else {
                i5 = h;
            }
            int height = ((this.c.E3().getHeight() - i) - i2) + i6.getWebViewScrollY();
            if (height - i4 < i3) {
                if (i4 > height) {
                    this.c.E3().setScrollY(i3 + i5);
                } else {
                    this.c.E3().setScrollY((i3 - height) + i4 + i5);
                }
            }
        }
    }

    public final void E0(int i) {
        Activity u0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || (u0 = u0()) == null) {
            return;
        }
        View decorView = u0.getWindow().getDecorView();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (this.e == null) {
            ShowConfirmBarLayout showConfirmBarLayout = new ShowConfirmBarLayout(u0);
            this.e = showConfirmBarLayout;
            showConfirmBarLayout.setOnConfirmButtonClickListener(new d(this));
            FrameLayout frameLayout = (FrameLayout) decorView.findViewById(16908290);
            layoutParams.topMargin = (frameLayout.getHeight() - i) - h;
            frameLayout.addView(this.e, layoutParams);
        }
    }

    @Nullable
    public final s52 t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            t52 W = xr2.V().W();
            if (W == null) {
                return null;
            }
            int k = W.k();
            for (int i = 0; i < k; i++) {
                q52 j = W.j(i);
                if (j instanceof s52) {
                    s52 s52Var = (s52) j;
                    if (TextUtils.equals(s52Var.A3(), this.a)) {
                        return s52Var;
                    }
                }
            }
            return null;
        }
        return (s52) invokeV.objValue;
    }

    public final void v0() {
        Activity u0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || (u0 = u0()) == null) {
            return;
        }
        View decorView = u0.getWindow().getDecorView();
        ShowConfirmBarLayout showConfirmBarLayout = this.e;
        if (showConfirmBarLayout != null && showConfirmBarLayout.getVisibility() == 0) {
            ((FrameLayout) decorView.findViewById(16908290)).removeView(this.e);
            this.e = null;
        }
    }

    public void y0(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048590, this, i, i2, i3, i4) == null) {
            ek3.a0(new a(this, i, i2, i3, i4));
        }
    }
}
