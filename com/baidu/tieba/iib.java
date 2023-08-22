package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class iib {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public jib a;
    public long b;
    public int c;
    public long d;
    public LinkedList<hib> e;
    public ArrayList<String> f;

    /* loaded from: classes6.dex */
    public class a implements Comparator<hib> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(iib iibVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iibVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(hib hibVar, hib hibVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, hibVar, hibVar2)) == null) {
                int h = hibVar2.h() - hibVar.h();
                if (h == 0) {
                    return (int) (hibVar2.i() - hibVar.i());
                }
                return h;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947855879, "Lcom/baidu/tieba/iib;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947855879, "Lcom/baidu/tieba/iib;");
                return;
            }
        }
        g = AppConfig.isDebug();
    }

    public final void d() {
        jib jibVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (jibVar = this.a) != null) {
            jibVar.a();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.e.size() > 0) {
            Collections.sort(this.e, new a(this));
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.b = System.currentTimeMillis();
            if (g) {
                Log.d("VoyagerTaskModel", "update check task time: " + this.b);
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.c++;
        }
    }

    public iib(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = jib.f(context);
        j(z);
    }

    public void a(hib hibVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hibVar) == null) {
            if (hibVar != null) {
                if (this.e.size() == 0) {
                    this.e.addFirst(hibVar);
                } else {
                    int i = 0;
                    Iterator<hib> it = this.e.iterator();
                    while (it.hasNext() && hibVar.h() < it.next().h()) {
                        i++;
                    }
                    this.e.add(i, hibVar);
                }
            }
            if (g) {
                Log.d("VoyagerTaskModel", "count: " + this.e.size());
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.c < yhb.f().m()) {
                if (g) {
                    Log.d("VoyagerTaskModel", "current count: " + this.c + ", max: " + yhb.f().m());
                }
                return true;
            }
            this.c = 0;
            if (System.currentTimeMillis() - this.b > yhb.f().l()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d();
            qib.b(aib.g().h());
            LinkedList<hib> linkedList = this.e;
            if (linkedList != null && linkedList.size() > 0) {
                this.e.clear();
            }
            ArrayList<String> arrayList = this.f;
            if (arrayList != null && arrayList.size() > 0) {
                this.f.clear();
            }
            this.b = 0L;
            this.c = 0;
            this.d = 0L;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.g(this.f, this.e);
            if (this.f.size() > 0) {
                Iterator<String> it = this.f.iterator();
                while (it.hasNext()) {
                    qib.d(aib.g().h(), it.next());
                    it.remove();
                }
            }
        }
    }

    public hib i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            LinkedList<hib> linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                return this.e.getFirst();
            }
            if (g) {
                Log.d("VoyagerTaskModel", "have no task in list");
            }
            this.c = 0;
            return null;
        }
        return (hib) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinkedList<hib> linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                long h = yhb.f().h();
                File h2 = aib.g().h();
                Iterator<hib> it = this.e.iterator();
                while (it.hasNext()) {
                    hib next = it.next();
                    File file = new File(h2, next.j());
                    if (this.d < h) {
                        if (file.exists()) {
                            this.d += file.length();
                        }
                    } else {
                        next.r(false);
                        next.q(System.currentTimeMillis());
                        n(next);
                        file.delete();
                    }
                }
                if (g) {
                    Log.d("VoyagerTaskModel", "task count after delete exceed task: " + this.e.size());
                }
                int g2 = yhb.f().g();
                int size = this.e.size();
                if (size <= g2) {
                    return;
                }
                int i = size - g2;
                for (int i2 = i; i2 > 0; i2--) {
                    hib removeLast = this.e.removeLast();
                    removeLast.r(false);
                    removeLast.q(System.currentTimeMillis());
                    n(removeLast);
                    qib.d(aib.g().h(), removeLast.j());
                }
                if (g) {
                    Log.d("VoyagerTaskModel", "delete count: " + i);
                }
            } else if (g) {
                Log.d("VoyagerTaskModel", "task list length 0");
            }
        }
    }

    public final void g() {
        ArrayList<File> f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (f = aib.g().f()) != null && f.size() != 0) {
            Iterator<File> it = f.iterator();
            while (it.hasNext()) {
                String name = it.next().getName();
                Iterator<hib> it2 = this.e.iterator();
                while (it2.hasNext() && !TextUtils.equals(name, it2.next().j())) {
                }
                it.remove();
            }
            if (g) {
                Log.d("VoyagerTaskModel", "unreference file count: " + f.size());
            }
            if (f.size() > 0) {
                qib.c(f);
            }
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        LinkedList<hib> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null || (linkedList = this.e) == null || linkedList.size() == 0) {
                return false;
            }
            String c = this.a.c();
            hib hibVar = null;
            Iterator<hib> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                hib next = it.next();
                if (TextUtils.equals(c, next.j())) {
                    hibVar = next;
                    break;
                }
            }
            if (hibVar != null) {
                this.e.remove(hibVar);
            }
            File file = new File(aib.g().h(), c);
            if (file.exists()) {
                file.delete();
                this.d -= file.length();
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                c();
                return;
            }
            this.e = new LinkedList<>();
            this.f = new ArrayList<>();
            this.b = 0L;
            this.c = 0;
            this.d = 0L;
            f();
            g();
            e();
            l();
        }
    }

    public void k(hib hibVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, hibVar) == null) && hibVar != null) {
            this.a.h(hibVar);
        }
    }

    public void n(hib hibVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, hibVar) == null) && hibVar != null) {
            this.a.i(hibVar);
        }
    }

    public void o(hib hibVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, hibVar) == null) && hibVar != null) {
            this.a.j(hibVar);
        }
    }

    public void q(hib hibVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, hibVar) == null) && hibVar != null) {
            this.e.remove(hibVar);
            this.e.addLast(hibVar);
        }
    }

    public void m(boolean z, hib hibVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, hibVar) == null) {
            hibVar.r(false);
            hibVar.q(System.currentTimeMillis());
            n(hibVar);
            if (z) {
                this.e.remove(hibVar);
            }
        }
    }

    public void u(boolean z, hib hibVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048596, this, z, hibVar) == null) {
            hibVar.r(false);
            hibVar.q(System.currentTimeMillis());
            o(hibVar);
            if (z) {
                q(hibVar);
            } else {
                a(hibVar);
            }
        }
    }

    public void s(boolean z, hib hibVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), hibVar, Long.valueOf(j)}) == null) {
            hibVar.r(false);
            hibVar.s(hibVar.k() + 1);
            hibVar.q(System.currentTimeMillis());
            if (z) {
                if (g) {
                    Log.d("VoyagerTaskModel", "max upload count: " + hibVar.d() + ", has uploaded " + hibVar.k());
                }
                if (hibVar.k() < hibVar.d()) {
                    o(hibVar);
                    q(hibVar);
                    return;
                }
                n(hibVar);
                this.e.remove(hibVar);
                return;
            }
            o(hibVar);
            a(hibVar);
            if (g) {
                Log.d("VoyagerTaskModel", "add task " + hibVar.j() + " to list");
            }
            this.d += j;
            while (this.d > yhb.f().h()) {
                if (!h()) {
                    this.d = 0L;
                    return;
                }
            }
        }
    }

    public void t(boolean z, hib hibVar, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), hibVar, Long.valueOf(j), str}) == null) {
            hibVar.r(true);
            hibVar.q(System.currentTimeMillis());
            hibVar.p(str);
            n(hibVar);
            if (z) {
                this.e.remove(hibVar);
                this.d -= j;
            }
        }
    }
}
