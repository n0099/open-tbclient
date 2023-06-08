package com.baidu.tieba;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tv.athena.revenue.payui.activity.immersion.BarHide;
@TargetApi(19)
/* loaded from: classes5.dex */
public class gsb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, esb> a;
    public Map<String, esb> b;
    public Map<String, ArrayList<String>> c;
    public Activity d;
    public Window e;
    public ViewGroup f;
    public ViewGroup g;
    public Dialog h;
    public esb i;
    public dsb j;
    public String k;
    public String l;
    public String m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947805907, "Lcom/baidu/tieba/gsb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947805907, "Lcom/baidu/tieba/gsb;");
        }
    }

    /* loaded from: classes5.dex */
    public class a extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gsb a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(gsb gsbVar, Handler handler) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gsbVar, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gsbVar;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (Settings.System.getInt(this.a.d.getContentResolver(), "navigationbar_is_min", 0) == 1) {
                    this.a.i.p.setVisibility(8);
                    this.a.g.setPadding(0, this.a.g.getPaddingTop(), 0, 0);
                    return;
                }
                this.a.i.p.setVisibility(0);
                if (!this.a.i.x) {
                    if (this.a.j.l()) {
                        this.a.g.setPadding(0, this.a.g.getPaddingTop(), 0, this.a.j.d());
                        return;
                    } else {
                        this.a.g.setPadding(0, this.a.g.getPaddingTop(), this.a.j.f(), 0);
                        return;
                    }
                }
                this.a.g.setPadding(0, this.a.g.getPaddingTop(), 0, 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-764283435, "Lcom/baidu/tieba/gsb$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-764283435, "Lcom/baidu/tieba/gsb$b;");
                    return;
                }
            }
            int[] iArr = new int[BarHide.values().length];
            a = iArr;
            try {
                iArr[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public gsb(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        Activity activity2 = (Activity) new WeakReference(activity).get();
        this.d = activity2;
        this.e = activity2.getWindow();
        String name = activity.getClass().getName();
        this.k = name;
        this.m = name;
        m();
    }

    @RequiresApi(api = 21)
    public final int k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            int i2 = i | 1024;
            esb esbVar = this.i;
            if (esbVar.e && esbVar.v) {
                i2 |= 512;
            }
            this.e.clearFlags(67108864);
            if (this.j.k()) {
                this.e.clearFlags(SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
            }
            this.e.addFlags(Integer.MIN_VALUE);
            esb esbVar2 = this.i;
            if (esbVar2.i) {
                this.e.setStatusBarColor(ColorUtils.blendARGB(esbVar2.a, esbVar2.j, esbVar2.c));
            } else {
                this.e.setStatusBarColor(ColorUtils.blendARGB(esbVar2.a, 0, esbVar2.c));
            }
            esb esbVar3 = this.i;
            if (esbVar3.v) {
                this.e.setNavigationBarColor(ColorUtils.blendARGB(esbVar3.b, esbVar3.k, esbVar3.d));
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public static gsb H(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            return new gsb(activity);
        }
        return (gsb) invokeL.objValue;
    }

    public static boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str != null && str.trim().length() != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public gsb A(@ColorInt int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            this.i.a = i;
            return this;
        }
        return (gsb) invokeI.objValue;
    }

    public gsb B(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            C(z, 0.0f);
            return this;
        }
        return (gsb) invokeZ.objValue;
    }

    public gsb g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.i.n = z;
            return this;
        }
        return (gsb) invokeZ.objValue;
    }

    public gsb q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            this.i.v = z;
            return this;
        }
        return (gsb) invokeZ.objValue;
    }

    public final int u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            if (Build.VERSION.SDK_INT >= 23 && this.i.h) {
                return i | 8192;
            }
            return i;
        }
        return invokeI.intValue;
    }

    public gsb z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
            A(ContextCompat.getColor(this.d, i));
            return this;
        }
        return (gsb) invokeI.objValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (!isb.m() && !isb.k() && Build.VERSION.SDK_INT < 23) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public gsb F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.i.a = 0;
            return this;
        }
        return (gsb) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public esb clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.i;
        }
        return (esb) invokeV.objValue;
    }

    public gsb i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            this.a.put(this.m, this.i);
            j();
            v();
            E();
            p();
            r();
            return this;
        }
        return (gsb) invokeV.objValue;
    }

    public final void v() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && Build.VERSION.SDK_INT >= 19 && (view2 = this.i.q) != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.height = this.j.i();
            this.i.q.setLayoutParams(layoutParams);
        }
    }

    public gsb C(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f)})) == null) {
            esb esbVar = this.i;
            esbVar.h = z;
            if (!z) {
                esbVar.r = 0;
            }
            if (o()) {
                this.i.c = 0.0f;
            } else {
                this.i.c = f;
            }
            return this;
        }
        return (gsb) invokeCommon.objValue;
    }

    public final void D() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || Build.VERSION.SDK_INT < 21 || isb.i() || (viewGroup = this.g) == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.g.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                this.i.x = childAt.getFitsSystemWindows();
                if (this.i.x) {
                    this.g.setPadding(0, 0, 0, 0);
                    return;
                }
            }
        }
        esb esbVar = this.i;
        if (esbVar.s) {
            this.g.setPadding(0, this.j.i() + this.j.a(), 0, 0);
        } else if (esbVar.n) {
            this.g.setPadding(0, this.j.i(), 0, 0);
        } else {
            this.g.setPadding(0, 0, 0, 0);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            G();
            esb esbVar = this.i;
            hsb hsbVar = esbVar.y;
            if (hsbVar != null) {
                hsbVar.o(esbVar.u);
                this.i.y = null;
            }
            if (this.f != null) {
                this.f = null;
            }
            if (this.g != null) {
                this.g = null;
            }
            if (this.j != null) {
                this.j = null;
            }
            if (this.e != null) {
                this.e = null;
            }
            if (this.h != null) {
                this.h = null;
            }
            if (this.d != null) {
                this.d = null;
            }
            if (!n(this.m)) {
                if (this.i != null) {
                    this.i = null;
                }
                ArrayList<String> arrayList = this.c.get(this.k);
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        this.b.remove(it.next());
                    }
                    this.c.remove(this.k);
                }
                this.a.remove(this.m);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 19) {
                int i2 = 256;
                if (i >= 21 && !isb.i()) {
                    i2 = u(k(256));
                    D();
                } else {
                    l();
                    y();
                }
                this.e.getDecorView().setSystemUiVisibility(h(i2));
            }
            if (isb.m()) {
                s(this.e, this.i.h);
            } else if (isb.k()) {
                esb esbVar = this.i;
                int i3 = esbVar.r;
                if (i3 != 0) {
                    fsb.d(this.d, i3);
                } else if (Build.VERSION.SDK_INT < 23) {
                    fsb.e(this.d, esbVar.h);
                }
            } else if (isb.n()) {
                t(this.i.h);
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            esb esbVar = this.i;
            if (esbVar.o == null) {
                esbVar.o = new View(this.d);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.j.i());
            layoutParams.gravity = 48;
            this.i.o.setLayoutParams(layoutParams);
            esb esbVar2 = this.i;
            if (esbVar2.i) {
                esbVar2.o.setBackgroundColor(ColorUtils.blendARGB(esbVar2.a, esbVar2.j, esbVar2.c));
            } else {
                esbVar2.o.setBackgroundColor(ColorUtils.blendARGB(esbVar2.a, 0, esbVar2.c));
            }
            this.i.o.setVisibility(0);
            ViewGroup viewGroup = (ViewGroup) this.i.o.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.i.o);
            }
            this.f.addView(this.i.o);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.i.l.size() != 0) {
            for (Map.Entry<View, Map<Integer, Integer>> entry : this.i.l.entrySet()) {
                View key = entry.getKey();
                Integer valueOf = Integer.valueOf(this.i.a);
                Integer valueOf2 = Integer.valueOf(this.i.j);
                for (Map.Entry<Integer, Integer> entry2 : entry.getValue().entrySet()) {
                    Integer key2 = entry2.getKey();
                    valueOf2 = entry2.getValue();
                    valueOf = key2;
                }
                if (key != null) {
                    if (Math.abs(this.i.m - 0.0f) == 0.0f) {
                        key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.i.c));
                    } else {
                        key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.i.m));
                    }
                }
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ViewGroup viewGroup = (ViewGroup) this.e.getDecorView();
            this.f = viewGroup;
            this.g = (ViewGroup) viewGroup.findViewById(16908290);
            this.j = new dsb(this.d);
            if (this.a.get(this.m) == null) {
                this.i = new esb();
                if (!n(this.l)) {
                    if (this.a.get(this.k) != null) {
                        if (Build.VERSION.SDK_INT == 19 || isb.i()) {
                            this.i.o = this.a.get(this.k).o;
                            this.i.p = this.a.get(this.k).p;
                        }
                        this.i.y = this.a.get(this.k).y;
                    } else {
                        throw new IllegalArgumentException("在Fragment里使用时，请先在加载Fragment的Activity里初始化！！！");
                    }
                }
                this.a.put(this.m, this.i);
                return;
            }
            this.i = this.a.get(this.m);
        }
    }

    public final void w() {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            esb esbVar = this.i;
            if (esbVar.p == null) {
                esbVar.p = new View(this.d);
            }
            if (this.j.l()) {
                layoutParams = new FrameLayout.LayoutParams(-1, this.j.d());
                layoutParams.gravity = 80;
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.j.f(), -1);
                layoutParams.gravity = 8388613;
            }
            this.i.p.setLayoutParams(layoutParams);
            esb esbVar2 = this.i;
            if (esbVar2.v && esbVar2.w) {
                if (!esbVar2.e && esbVar2.k == 0) {
                    esbVar2.p.setBackgroundColor(ColorUtils.blendARGB(esbVar2.b, -16777216, esbVar2.d));
                } else {
                    esb esbVar3 = this.i;
                    esbVar3.p.setBackgroundColor(ColorUtils.blendARGB(esbVar3.b, esbVar3.k, esbVar3.d));
                }
            } else {
                this.i.p.setBackgroundColor(0);
            }
            this.i.p.setVisibility(0);
            ViewGroup viewGroup = (ViewGroup) this.i.p.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.i.p);
            }
            this.f.addView(this.i.p);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if ((isb.i() || isb.h()) && this.j.k()) {
                esb esbVar = this.i;
                if (esbVar.v && esbVar.w && esbVar.A != null && esbVar.p != null) {
                    this.d.getContentResolver().unregisterContentObserver(this.i.A);
                }
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.e.addFlags(67108864);
            x();
            if (this.j.k()) {
                esb esbVar = this.i;
                if (esbVar.v && esbVar.w) {
                    this.e.addFlags(SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
                } else {
                    this.e.clearFlags(SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
                }
                w();
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && Build.VERSION.SDK_INT >= 19) {
            esb esbVar = this.i;
            if (esbVar.y == null) {
                esbVar.y = hsb.q(this.d, this.e);
            }
            esb esbVar2 = this.i;
            esbVar2.y.r(esbVar2);
            esb esbVar3 = this.i;
            if (esbVar3.t) {
                esbVar3.y.p(esbVar3.u);
            } else {
                esbVar3.y.o(esbVar3.u);
            }
        }
    }

    public final int h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                int i2 = b.a[this.i.g.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 == 4) {
                                i |= 0;
                            }
                        } else {
                            i |= 514;
                        }
                    } else {
                        i |= 1028;
                    }
                } else {
                    i |= 518;
                }
            }
            return i | 4096;
        }
        return invokeI.intValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if ((isb.i() || isb.h()) && this.j.k()) {
                esb esbVar = this.i;
                if (esbVar.v && esbVar.w) {
                    if (esbVar.A == null && esbVar.p != null) {
                        esbVar.A = new a(this, new Handler());
                    }
                    this.d.getContentResolver().registerContentObserver(Settings.System.getUriFor("navigationbar_is_min"), true, this.i.A);
                }
            }
        }
    }

    public final void s(Window window, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048596, this, window, z) == null) && window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                if (z) {
                    method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.e.addFlags(Integer.MIN_VALUE);
            }
            int systemUiVisibility = this.e.getDecorView().getSystemUiVisibility();
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                if (z) {
                    systemUiVisibility |= 8192;
                } else {
                    systemUiVisibility &= -8193;
                }
            } else if (i >= 19) {
                if (z) {
                    systemUiVisibility |= 16;
                } else {
                    systemUiVisibility &= -17;
                }
            }
            this.e.getDecorView().setSystemUiVisibility(systemUiVisibility);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            int childCount = this.g.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.g.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    if (childAt instanceof DrawerLayout) {
                        View childAt2 = ((DrawerLayout) childAt).getChildAt(0);
                        if (childAt2 != null) {
                            this.i.x = childAt2.getFitsSystemWindows();
                            if (this.i.x) {
                                this.g.setPadding(0, 0, 0, 0);
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        this.i.x = childAt.getFitsSystemWindows();
                        if (this.i.x) {
                            this.g.setPadding(0, 0, 0, 0);
                            return;
                        }
                    }
                }
            }
            if (this.j.k()) {
                esb esbVar = this.i;
                if (!esbVar.f && !esbVar.e) {
                    if (this.j.l()) {
                        esb esbVar2 = this.i;
                        if (!esbVar2.s) {
                            if (esbVar2.v && esbVar2.w) {
                                if (esbVar2.n) {
                                    this.g.setPadding(0, this.j.i(), 0, this.j.d());
                                    return;
                                } else {
                                    this.g.setPadding(0, 0, 0, this.j.d());
                                    return;
                                }
                            } else if (this.i.n) {
                                this.g.setPadding(0, this.j.i(), 0, 0);
                                return;
                            } else {
                                this.g.setPadding(0, 0, 0, 0);
                                return;
                            }
                        } else if (esbVar2.v && esbVar2.w) {
                            this.g.setPadding(0, this.j.i() + this.j.a() + 10, 0, this.j.d());
                            return;
                        } else {
                            this.g.setPadding(0, this.j.i() + this.j.a() + 10, 0, 0);
                            return;
                        }
                    }
                    esb esbVar3 = this.i;
                    if (!esbVar3.s) {
                        if (esbVar3.v && esbVar3.w) {
                            if (esbVar3.n) {
                                this.g.setPadding(0, this.j.i(), this.j.f(), 0);
                                return;
                            } else {
                                this.g.setPadding(0, 0, this.j.f(), 0);
                                return;
                            }
                        } else if (this.i.n) {
                            this.g.setPadding(0, this.j.i(), 0, 0);
                            return;
                        } else {
                            this.g.setPadding(0, 0, 0, 0);
                            return;
                        }
                    } else if (esbVar3.v && esbVar3.w) {
                        this.g.setPadding(0, this.j.i() + this.j.a() + 10, this.j.f(), 0);
                        return;
                    } else {
                        this.g.setPadding(0, this.j.i() + this.j.a() + 10, 0, 0);
                        return;
                    }
                }
            }
            esb esbVar4 = this.i;
            if (!esbVar4.s) {
                if (esbVar4.n) {
                    this.g.setPadding(0, this.j.i(), 0, 0);
                    return;
                } else {
                    this.g.setPadding(0, 0, 0, 0);
                    return;
                }
            }
            this.g.setPadding(0, this.j.i() + this.j.a() + 10, 0, 0);
        }
    }
}
