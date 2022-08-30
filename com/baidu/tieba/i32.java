package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class i32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<m32> a;
    public final Object b;
    public final int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947802497, "Lcom/baidu/tieba/i32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947802497, "Lcom/baidu/tieba/i32;");
                return;
            }
        }
        d = kh1.a;
    }

    @SuppressLint({"BDThrowableCheck"})
    public i32(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (i < 1) {
            if (d) {
                throw new RuntimeException("MasterPool size can not less than 1");
            }
            i = 1;
        }
        this.c = i;
        this.b = new Object();
        this.a = new LinkedList();
    }

    public void a(Collection<m32> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, collection) == null) {
            boolean z = collection == null || collection.size() <= 0;
            if (d) {
                StringBuilder sb = new StringBuilder();
                sb.append("master pool clear, excludes size - ");
                sb.append(collection != null ? collection.size() : 0);
                Log.i("MasterPool", sb.toString());
                if (collection != null) {
                    for (m32 m32Var : collection) {
                        if (m32Var.i() != null) {
                            Log.i("MasterPool", "excludes  - " + m32Var.i().a());
                        }
                    }
                }
            }
            synchronized (this.b) {
                ArrayList arrayList = new ArrayList();
                for (m32 m32Var2 : this.a) {
                    if (z || (collection != null && !collection.contains(m32Var2))) {
                        arrayList.add(m32Var2);
                    }
                }
                b(arrayList);
            }
        }
    }

    public final void b(Collection<m32> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection) == null) || collection.size() <= 0) {
            return;
        }
        long currentTimeMillis = d ? System.currentTimeMillis() : 0L;
        this.a.removeAll(collection);
        if (d) {
            Log.i("MasterPool", "remove no use master in pool, size - " + collection.size());
        }
        for (m32 m32Var : collection) {
            if (m32Var.i() != null) {
                m32Var.i().destroy();
                if (d) {
                    Log.i("MasterPool", "master destroy, id - " + m32Var.i().a() + ", isReady - " + m32Var.n() + ", is Default - " + m32Var.l() + ", is Prefetch - " + m32Var.j());
                }
            }
        }
        if (d) {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("MasterPool", "destroy masters cost - " + (currentTimeMillis2 - currentTimeMillis) + "ms");
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str) || TextUtils.equals(str, "_default_id_")) {
            return;
        }
        synchronized (this.b) {
            ArrayList arrayList = new ArrayList();
            for (m32 m32Var : this.a) {
                if (TextUtils.equals(m32Var.h(), str)) {
                    arrayList.add(m32Var);
                }
            }
            b(arrayList);
        }
    }

    public m32 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            m32 m32Var = null;
            if (TextUtils.isEmpty(str)) {
                if (d) {
                    Log.w("MasterPool", "appId can not be empty");
                }
                return null;
            }
            synchronized (this.b) {
                if (TextUtils.equals(str, "_default_id_")) {
                    if (d) {
                        Log.i("MasterPool", "get default master manger for id - " + str);
                    }
                    return e();
                }
                int size = this.a.size() - 1;
                int i = size;
                while (true) {
                    if (i < 0) {
                        break;
                    }
                    m32 m32Var2 = this.a.get(i);
                    if (TextUtils.equals(m32Var2.h(), str)) {
                        if (d) {
                            Log.i("MasterPool", "get master in pool for id - " + str);
                        }
                        m32Var = m32Var2;
                    } else {
                        i--;
                    }
                }
                if (m32Var != null && i != size) {
                    this.a.remove(i);
                    this.a.add(m32Var);
                }
                if (d) {
                    if (m32Var == null) {
                        Log.i("MasterPool", "find no master for id - " + str);
                    } else {
                        Log.i("MasterPool", "hit a master cache for id - " + str);
                    }
                }
                return m32Var;
            }
        }
        return (m32) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public final m32 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            for (m32 m32Var : this.a) {
                if (m32Var.l()) {
                    return m32Var;
                }
            }
            if (d) {
                throw new RuntimeException("there must be one default master in pool, you should add default one first");
            }
            return null;
        }
        return (m32) invokeV.objValue;
    }

    public void f(m32 m32Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, m32Var) == null) || m32Var == null) {
            return;
        }
        synchronized (this.b) {
            if (!this.a.contains(m32Var)) {
                this.a.add(m32Var);
            }
            h();
        }
    }

    public void g(Collection<m32> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, collection) == null) {
            if (this.c >= 3) {
                boolean z = true;
                if (this.a.size() > 1) {
                    if (collection != null && collection.size() > 0) {
                        z = false;
                    }
                    synchronized (this.b) {
                        ArrayList arrayList = new ArrayList();
                        for (m32 m32Var : this.a) {
                            if (!m32Var.l() && m32Var.j() && (z || !collection.contains(m32Var))) {
                                arrayList.add(m32Var);
                            }
                        }
                        if (d) {
                            Log.d("MasterPool", "remove all prefetch event master, size - " + arrayList.size());
                        }
                        b(arrayList);
                    }
                    return;
                }
            }
            if (d) {
                Log.d("MasterPool", "no need to remove prefetch master");
                Log.d("MasterPool", "max size - " + this.c);
                Log.d("MasterPool", "current cache size - " + this.a.size());
            }
        }
    }

    public final void h() {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (size = this.a.size()) <= this.c) {
            return;
        }
        if (d) {
            Log.i("MasterPool", "resize, current - " + size + ", target - " + this.c);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            m32 m32Var = this.a.get(i);
            if (!m32Var.l() || z) {
                arrayList.add(m32Var);
                if (arrayList.size() >= size - this.c) {
                    break;
                }
            } else {
                z = true;
            }
        }
        b(arrayList);
    }
}
