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
/* loaded from: classes5.dex */
public class czb {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public dzb a;
    public long b;
    public int c;
    public long d;
    public LinkedList<bzb> e;
    public ArrayList<String> f;

    /* loaded from: classes5.dex */
    public class a implements Comparator<bzb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(czb czbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {czbVar};
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
        public int compare(bzb bzbVar, bzb bzbVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bzbVar, bzbVar2)) == null) {
                int h = bzbVar2.h() - bzbVar.h();
                if (h == 0) {
                    return (int) (bzbVar2.i() - bzbVar.i());
                }
                return h;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947693470, "Lcom/baidu/tieba/czb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947693470, "Lcom/baidu/tieba/czb;");
                return;
            }
        }
        g = AppConfig.isDebug();
    }

    public final void d() {
        dzb dzbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (dzbVar = this.a) != null) {
            dzbVar.a();
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

    public czb(Context context, boolean z) {
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
        this.a = dzb.f(context);
        j(z);
    }

    public void a(bzb bzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bzbVar) == null) {
            if (bzbVar != null) {
                if (this.e.size() == 0) {
                    this.e.addFirst(bzbVar);
                } else {
                    int i = 0;
                    Iterator<bzb> it = this.e.iterator();
                    while (it.hasNext() && bzbVar.h() < it.next().h()) {
                        i++;
                    }
                    this.e.add(i, bzbVar);
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
            if (this.c < syb.f().m()) {
                if (g) {
                    Log.d("VoyagerTaskModel", "current count: " + this.c + ", max: " + syb.f().m());
                }
                return true;
            }
            this.c = 0;
            if (System.currentTimeMillis() - this.b > syb.f().l()) {
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
            kzb.b(uyb.g().h());
            LinkedList<bzb> linkedList = this.e;
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
                    kzb.d(uyb.g().h(), it.next());
                    it.remove();
                }
            }
        }
    }

    public bzb i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            LinkedList<bzb> linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                return this.e.getFirst();
            }
            if (g) {
                Log.d("VoyagerTaskModel", "have no task in list");
            }
            this.c = 0;
            return null;
        }
        return (bzb) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinkedList<bzb> linkedList = this.e;
            if (linkedList != null && linkedList.size() != 0) {
                long h = syb.f().h();
                File h2 = uyb.g().h();
                Iterator<bzb> it = this.e.iterator();
                while (it.hasNext()) {
                    bzb next = it.next();
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
                int g2 = syb.f().g();
                int size = this.e.size();
                if (size <= g2) {
                    return;
                }
                int i = size - g2;
                for (int i2 = i; i2 > 0; i2--) {
                    bzb removeLast = this.e.removeLast();
                    removeLast.r(false);
                    removeLast.q(System.currentTimeMillis());
                    n(removeLast);
                    kzb.d(uyb.g().h(), removeLast.j());
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
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (f = uyb.g().f()) != null && f.size() != 0) {
            Iterator<File> it = f.iterator();
            while (it.hasNext()) {
                String name = it.next().getName();
                Iterator<bzb> it2 = this.e.iterator();
                while (it2.hasNext() && !TextUtils.equals(name, it2.next().j())) {
                }
                it.remove();
            }
            if (g) {
                Log.d("VoyagerTaskModel", "unreference file count: " + f.size());
            }
            if (f.size() > 0) {
                kzb.c(f);
            }
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        LinkedList<bzb> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.a == null || (linkedList = this.e) == null || linkedList.size() == 0) {
                return false;
            }
            String c = this.a.c();
            bzb bzbVar = null;
            Iterator<bzb> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                bzb next = it.next();
                if (TextUtils.equals(c, next.j())) {
                    bzbVar = next;
                    break;
                }
            }
            if (bzbVar != null) {
                this.e.remove(bzbVar);
            }
            File file = new File(uyb.g().h(), c);
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

    public void k(bzb bzbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, bzbVar) == null) && bzbVar != null) {
            this.a.h(bzbVar);
        }
    }

    public void n(bzb bzbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, bzbVar) == null) && bzbVar != null) {
            this.a.i(bzbVar);
        }
    }

    public void o(bzb bzbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, bzbVar) == null) && bzbVar != null) {
            this.a.j(bzbVar);
        }
    }

    public void q(bzb bzbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, bzbVar) == null) && bzbVar != null) {
            this.e.remove(bzbVar);
            this.e.addLast(bzbVar);
        }
    }

    public void m(boolean z, bzb bzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048588, this, z, bzbVar) == null) {
            bzbVar.r(false);
            bzbVar.q(System.currentTimeMillis());
            n(bzbVar);
            if (z) {
                this.e.remove(bzbVar);
            }
        }
    }

    public void u(boolean z, bzb bzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048596, this, z, bzbVar) == null) {
            bzbVar.r(false);
            bzbVar.q(System.currentTimeMillis());
            o(bzbVar);
            if (z) {
                q(bzbVar);
            } else {
                a(bzbVar);
            }
        }
    }

    public void s(boolean z, bzb bzbVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), bzbVar, Long.valueOf(j)}) == null) {
            bzbVar.r(false);
            bzbVar.s(bzbVar.k() + 1);
            bzbVar.q(System.currentTimeMillis());
            if (z) {
                if (g) {
                    Log.d("VoyagerTaskModel", "max upload count: " + bzbVar.d() + ", has uploaded " + bzbVar.k());
                }
                if (bzbVar.k() < bzbVar.d()) {
                    o(bzbVar);
                    q(bzbVar);
                    return;
                }
                n(bzbVar);
                this.e.remove(bzbVar);
                return;
            }
            o(bzbVar);
            a(bzbVar);
            if (g) {
                Log.d("VoyagerTaskModel", "add task " + bzbVar.j() + " to list");
            }
            this.d += j;
            while (this.d > syb.f().h()) {
                if (!h()) {
                    this.d = 0L;
                    return;
                }
            }
        }
    }

    public void t(boolean z, bzb bzbVar, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), bzbVar, Long.valueOf(j), str}) == null) {
            bzbVar.r(true);
            bzbVar.q(System.currentTimeMillis());
            bzbVar.p(str);
            n(bzbVar);
            if (z) {
                this.e.remove(bzbVar);
                this.d -= j;
            }
        }
    }
}
