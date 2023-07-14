package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.w13;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public final class eb2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public static final Set<String> f;
    public static final int g;
    public static final int h;
    public static final int i;
    public transient /* synthetic */ FieldHolder $fh;
    public rp4 a;
    public ArrayList<bb2> b;
    public Queue<Runnable> c;
    public final List<a> d;

    /* loaded from: classes5.dex */
    public interface a {
        void a(@NonNull Fragment fragment);

        void b(@NonNull Fragment fragment);
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public tp4 a;
        public String b;
        public final /* synthetic */ eb2 c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ bb2 a;
            public final /* synthetic */ bb2 b;

            public a(b bVar, bb2 bb2Var, bb2 bb2Var2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, bb2Var, bb2Var2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bb2Var;
                this.b = bb2Var2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    bb2 bb2Var = this.a;
                    if (bb2Var != null && bb2Var.Z()) {
                        this.a.n1(false);
                    }
                    bb2 bb2Var2 = this.a;
                    if (bb2Var2 instanceof db2) {
                        ((db2) bb2Var2).b4();
                    }
                    this.b.n1(true);
                }
            }
        }

        /* renamed from: com.baidu.tieba.eb2$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0278b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ bb2 a;

            public RunnableC0278b(b bVar, bb2 bb2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, bb2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bb2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                bb2 bb2Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bb2Var = this.a) != null) {
                    bb2Var.n1(true);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ bb2 a;

            public c(b bVar, bb2 bb2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, bb2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bb2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                bb2 bb2Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bb2Var = this.a) != null) {
                    bb2Var.n1(false);
                }
            }
        }

        public b(eb2 eb2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eb2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = eb2Var;
            this.a = eb2Var.a.a();
            this.b = str;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.b)) {
                    db2.W3(this.b);
                }
                while (!this.c.c.isEmpty()) {
                    if (this.c.c.peek() != null) {
                        ((Runnable) this.c.c.poll()).run();
                    }
                }
                d();
                this.a.f();
            }
        }

        public b i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.c.b.isEmpty()) {
                    return this;
                }
                ArrayList arrayList = (ArrayList) this.c.b.clone();
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (!((bb2) arrayList.get(size)).g2()) {
                        this.a.h((Fragment) arrayList.get(size));
                        this.c.b.remove(size);
                    }
                }
                r();
                return this;
            }
            return (b) invokeV.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                a();
                return this.c.a.c();
            }
            return invokeV.booleanValue;
        }

        public b g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                h(1);
                return this;
            }
            return (b) invokeV.objValue;
        }

        public final void r() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
                this.c.c.offer(new RunnableC0278b(this, this.c.m()));
            }
        }

        public void c(bb2 bb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bb2Var) == null) {
                tp4 tp4Var = this.a;
                tp4Var.g(bb2Var);
                tp4Var.f();
                this.c.a.c();
            }
        }

        public final boolean e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                return eb2.f.contains(str);
            }
            return invokeL.booleanValue;
        }

        public void o(bb2 bb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, bb2Var) == null) {
                tp4 tp4Var = this.a;
                tp4Var.j(bb2Var);
                tp4Var.f();
                this.c.a.c();
            }
        }

        public b q(v13 v13Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, v13Var)) == null) {
                db2 l = this.c.l();
                if (l != null) {
                    l.X3(v13Var);
                    return this;
                }
                return k("normal", v13Var);
            }
            return (b) invokeL.objValue;
        }

        public final void s(bb2 bb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, bb2Var) == null) {
                this.c.c.offer(new a(this, this.c.m(), bb2Var));
            }
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.c.b.isEmpty()) {
                return;
            }
            int size = this.c.b.size();
            boolean z = false;
            int i = size - 1;
            for (int i2 = i; i2 >= 0; i2--) {
                if (i2 >= i) {
                    if (eb2.e) {
                        Log.d("SwanAppFragmentManager", "show fragment i " + i2 + " ,size: " + size);
                    }
                    this.a.j((Fragment) this.c.b.get(i2));
                    z = ((bb2) this.c.b.get(i2)).E0;
                } else if (z) {
                    this.a.j((Fragment) this.c.b.get(i2));
                    z = ((bb2) this.c.b.get(i2)).E0;
                } else {
                    this.a.g((Fragment) this.c.b.get(i2));
                }
            }
        }

        public b f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                List<Fragment> d = this.c.a.d();
                if (d != null && d.size() != this.c.b.size()) {
                    for (Fragment fragment : d) {
                        if (fragment != null && !this.c.b.contains(fragment)) {
                            if (eb2.e) {
                                Log.d("SwanAppFragmentManager", "popAllFragments remove: " + fragment);
                            }
                            for (a aVar : this.c.d) {
                                if (aVar != null) {
                                    aVar.b(fragment);
                                }
                            }
                            this.a.h(fragment);
                        }
                    }
                }
                h(this.c.b.size());
                return this;
            }
            return (b) invokeV.objValue;
        }

        public b h(int i) {
            InterceptResult invokeI;
            bb2 bb2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                if (this.c.b.isEmpty()) {
                    return this;
                }
                ArrayList arrayList = (ArrayList) this.c.b.clone();
                int size = arrayList.size();
                int i2 = size - i;
                if (i2 >= 0 && i > 0) {
                    bb2Var = (bb2) arrayList.get(i2);
                } else {
                    bb2Var = null;
                }
                while (true) {
                    size--;
                    if (size <= i2 - 1 || size < 0) {
                        break;
                    }
                    for (a aVar : this.c.d) {
                        if (aVar != null) {
                            aVar.b((Fragment) arrayList.get(size));
                        }
                    }
                    this.a.h((Fragment) arrayList.get(size));
                    this.c.b.remove(size);
                }
                this.c.c.offer(new c(this, bb2Var));
                r();
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b j(bb2 bb2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bb2Var)) == null) {
                s(bb2Var);
                this.a.b(R.id.obfuscated_res_0x7f090182, bb2Var, "SwanAppFragment");
                this.c.b.add(bb2Var);
                for (a aVar : this.c.d) {
                    if (aVar != null) {
                        aVar.a(bb2Var);
                    }
                }
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b m(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
                int size = this.c.b.size();
                if (!this.c.b.isEmpty() && i >= 0 && i < size) {
                    this.a.h((bb2) this.c.b.remove(i));
                }
                return this;
            }
            return (b) invokeI.objValue;
        }

        public void p(List<bb2> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
                for (int i = 0; i < list.size(); i++) {
                    this.a.j(list.get(i));
                }
                this.a.f();
                this.c.a.c();
            }
        }

        public b k(String str, v13 v13Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, v13Var)) == null) {
                return l(str, v13Var, false);
            }
            return (b) invokeLL.objValue;
        }

        public b n(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i, i2)) == null) {
                fo3.d(this.a, this.b, i, i2);
                return this;
            }
            return (b) invokeII.objValue;
        }

        @Nullable
        public b l(String str, v13 v13Var, boolean z) {
            InterceptResult invokeLLZ;
            bb2 bb2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048587, this, str, v13Var, z)) == null) {
                if ("about".equals(str)) {
                    bb2Var = ya2.s3();
                } else if ("authority".equals(str)) {
                    bb2Var = ab2.h3();
                } else if ("pluginFunPage".equals(str)) {
                    bb2Var = fb2.a3(v13Var.c, v13Var.b);
                } else if (e(str)) {
                    bb2Var = jb2.e3(v13Var, str);
                } else if (TextUtils.equals(AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS, str)) {
                    bb2Var = hb2.X2();
                } else if ("normal".equals(str)) {
                    w13.a aVar = new w13.a();
                    aVar.d(v13Var.a);
                    aVar.e(v13Var.b);
                    aVar.b(v13Var.c);
                    aVar.c(z);
                    aVar.g(v13Var.e);
                    aVar.f(v13Var.f);
                    bb2Var = db2.O3(aVar.a());
                } else if ("running_info".equals(str)) {
                    bb2Var = gb2.b3();
                } else {
                    bb2Var = null;
                }
                if (bb2Var == null) {
                    return null;
                }
                j(bb2Var);
                return this;
            }
            return (b) invokeLLZ.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947728500, "Lcom/baidu/tieba/eb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947728500, "Lcom/baidu/tieba/eb2;");
                return;
            }
        }
        e = fs1.a;
        HashSet hashSet = new HashSet();
        f = hashSet;
        g = R.anim.obfuscated_res_0x7f010023;
        h = R.anim.obfuscated_res_0x7f010026;
        i = R.anim.obfuscated_res_0x7f01001d;
        hashSet.add("adLanding");
        f.add("wxPay");
        f.add("default_webview");
        f.add("allianceLogin");
        f.add("web_mode");
        f.add("allianceChooseAddress");
        f.add("qrCodePay");
    }

    public eb2(FragmentActivity fragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new LinkedList();
        this.a = fragmentActivity.k();
        this.b = new ArrayList<>();
        this.d = new CopyOnWriteArrayList();
    }

    public void g(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) && aVar != null) {
            this.d.add(aVar);
        }
    }

    public b i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return new b(this, str);
        }
        return (b) invokeL.objValue;
    }

    public bb2 j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (this.b.isEmpty() || i2 < 0 || i2 >= this.b.size()) {
                return null;
            }
            return this.b.get(i2);
        }
        return (bb2) invokeI.objValue;
    }

    public void p(@Nullable a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, aVar) != null) || aVar == null) {
            return;
        }
        this.d.remove(aVar);
    }

    public b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new b(this, "");
        }
        return (b) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    @Nullable
    public bb2 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return j(this.b.size() - 1);
        }
        return (bb2) invokeV.objValue;
    }

    public db2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            for (int size = this.b.size() - 1; size >= 0; size--) {
                bb2 bb2Var = this.b.get(size);
                if (bb2Var instanceof db2) {
                    return (db2) bb2Var;
                }
            }
            return null;
        }
        return (db2) invokeV.objValue;
    }

    public db2 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.b.isEmpty()) {
                return null;
            }
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.b.get(i2).g2()) {
                    return (db2) this.b.get(i2);
                }
            }
            return null;
        }
        return (db2) invokeV.objValue;
    }

    @Nullable
    public <T extends bb2> T n(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cls)) == null) {
            if (cls != null) {
                for (int size = this.b.size() - 1; size >= 0; size--) {
                    T t = (T) this.b.get(size);
                    if (t.getClass() == cls) {
                        return t;
                    }
                }
                return null;
            }
            return null;
        }
        return (T) invokeL.objValue;
    }
}
