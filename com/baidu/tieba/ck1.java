package com.baidu.tieba;

import android.util.LruCache;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
/* loaded from: classes3.dex */
public class ck1 extends LruCache<String, bk1<File>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<e> a;
    public final String b;
    public HashMap<bk1<File>, byte[]> c;
    public long d;
    public volatile boolean e;
    public int f;
    public long g;

    /* loaded from: classes3.dex */
    public interface e {
        void a(String str, bk1<File> bk1Var);

        void b(String str, bk1<File> bk1Var);

        void c(String str, bk1<File> bk1Var);
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public static class a extends cl1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String c;
        public final /* synthetic */ ck1 d;

        public a(String str, ck1 ck1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, ck1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = str;
            this.d = ck1Var;
        }

        @Override // com.baidu.tieba.cl1
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = new File(this.c);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.d.r(file.listFiles(), currentTimeMillis);
                    return null;
                } catch (Exception unused) {
                    this.d.e = true;
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends cl1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ byte[] c;
        public final /* synthetic */ bk1 d;
        public final /* synthetic */ ck1 e;

        public b(ck1 ck1Var, byte[] bArr, bk1 bk1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck1Var, bArr, bk1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ck1Var;
            this.c = bArr;
            this.d = bk1Var;
        }

        @Override // com.baidu.tieba.cl1
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    g41.i(this.c, (File) this.d.a());
                    this.e.put(((File) this.d.a()).getName(), this.d);
                    ck1.b(this.e);
                    if (!this.e.a.isEmpty()) {
                        for (e eVar : this.e.a) {
                            eVar.c(((File) this.d.a()).getName(), this.d);
                        }
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    ck1 ck1Var = this.e;
                    ck1Var.m("File saved using " + currentTimeMillis2 + "ms: " + ((File) this.d.a()).getName() + "\nStatus:" + this.e.t());
                    this.e.g();
                    return null;
                } catch (Throwable unused) {
                    if (!this.e.a.isEmpty()) {
                        for (e eVar2 : this.e.a) {
                            eVar2.b(((File) this.d.a()).getName(), this.d);
                        }
                        return null;
                    }
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends cl1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bk1 c;
        public final /* synthetic */ ck1 d;

        public c(ck1 ck1Var, bk1 bk1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck1Var, bk1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ck1Var;
            this.c = bk1Var;
        }

        @Override // com.baidu.tieba.cl1
        public Object b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    if (this.c != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        String name = ((File) this.c.a()).getName();
                        ck1.c(this.d);
                        this.c.e();
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        ck1 ck1Var = this.d;
                        ck1Var.m("File deleted using " + currentTimeMillis2 + "ms: " + name);
                    }
                    this.d.g();
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Comparator<File> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(ck1 ck1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ck1Var};
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
        public int compare(File file, File file2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) {
                return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947677536, "Lcom/baidu/tieba/ck1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947677536, "Lcom/baidu/tieba/ck1;");
            }
        }
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return super.maxSize();
        }
        return invokeV.longValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ck1(int i, String str) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.e = false;
        this.f = 0;
        this.g = 2592000000L;
        this.b = str;
        this.c = new HashMap<>();
    }

    public static /* synthetic */ int b(ck1 ck1Var) {
        int i = ck1Var.f;
        ck1Var.f = i + 1;
        return i;
    }

    public static /* synthetic */ int c(ck1 ck1Var) {
        int i = ck1Var.f;
        ck1Var.f = i - 1;
        return i;
    }

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && super.get(str) != null) {
            h((bk1) super.remove(str));
        }
    }

    public void f(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.a.add(eVar);
        }
    }

    public final void h(bk1<File> bk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bk1Var) == null) {
            dl1.a().c(new c(this, bk1Var));
        }
    }

    public void q(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) && this.a.contains(eVar)) {
            this.a.remove(eVar);
        }
    }

    public boolean query(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (j(str) != null && j(str).a().exists()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.util.LruCache
    public synchronized void trimToSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            synchronized (this) {
                super.trimToSize(i);
            }
        }
    }

    public static ck1 o(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, str, i)) == null) {
            ck1 ck1Var = new ck1(i, str);
            ck1Var.e = false;
            dl1.a().c(new a(str, ck1Var));
            return ck1Var;
        }
        return (ck1) invokeLI.objValue;
    }

    public final void p(String str, File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, str, file) == null) && file.exists()) {
            super.put(str, new bk1(file));
            this.f++;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: s */
    public int sizeOf(String str, bk1<File> bk1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, bk1Var)) == null) {
            if (bk1Var == null) {
                return super.sizeOf(null, null);
            }
            return bk1Var.f();
        }
        return invokeLL.intValue;
    }

    public void u(byte[] bArr, bk1<File> bk1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, bArr, bk1Var) == null) && bk1Var != null) {
            if (this.e) {
                v(bk1Var, bArr);
            } else {
                this.c.put(bk1Var, bArr);
            }
        }
    }

    public final void v(bk1<File> bk1Var, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, bk1Var, bArr) == null) {
            dl1.a().c(new b(this, bArr, bk1Var));
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.d < this.g) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Map snapshot = super.snapshot();
                this.d = System.currentTimeMillis();
                for (String str : snapshot.keySet()) {
                    bk1 bk1Var = (bk1) snapshot.get(str);
                    if (bk1Var.d(this.g)) {
                        ((File) ((bk1) super.remove(str)).a()).delete();
                        this.f--;
                    } else if (((File) bk1Var.a()).lastModified() < this.d) {
                        this.d = ((File) bk1Var.a()).lastModified();
                    }
                }
                m("Clear cache using " + (System.currentTimeMillis() - currentTimeMillis) + "ms: ");
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: i */
    public void entryRemoved(boolean z, String str, bk1<File> bk1Var, bk1<File> bk1Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, bk1Var, bk1Var2}) == null) {
            super.entryRemoved(z, str, bk1Var, bk1Var2);
            if (z && bk1Var != null) {
                h(bk1Var);
            }
            if (z && !this.a.isEmpty()) {
                for (e eVar : this.a) {
                    eVar.a(str, bk1Var);
                }
            }
        }
    }

    public bk1<File> j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            bk1<File> bk1Var = (bk1) super.get(str);
            if (bk1Var != null) {
                try {
                    bk1Var.a().setLastModified(System.currentTimeMillis());
                    m("Fetch resource for " + str + ",\nStatus:" + t());
                } catch (Throwable unused) {
                }
            }
            return bk1Var;
        }
        return (bk1) invokeL.objValue;
    }

    public final synchronized void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                this.e = true;
                if (this.c != null) {
                    for (bk1<File> bk1Var : this.c.keySet()) {
                        v(bk1Var, this.c.get(bk1Var));
                    }
                    this.c.clear();
                    this.c = null;
                }
            }
        }
    }

    public final void r(File[] fileArr, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, fileArr, j) == null) {
            if (fileArr != null && fileArr.length > 0) {
                PriorityQueue priorityQueue = new PriorityQueue(11, new d(this));
                if (priorityQueue.size() > 0) {
                    this.d = ((File) priorityQueue.peek()).lastModified();
                } else {
                    this.d = System.currentTimeMillis();
                }
                priorityQueue.addAll(Arrays.asList(fileArr));
                while (!priorityQueue.isEmpty()) {
                    File file = (File) priorityQueue.poll();
                    p(file.getName(), file);
                }
            }
            m("Complete restore cache using " + (System.currentTimeMillis() - j) + "ms: ");
            n();
        }
    }

    public String t() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            int hitCount = hitCount() + missCount();
            if (hitCount != 0) {
                i = (hitCount() * 100) / hitCount;
            } else {
                i = 0;
            }
            return String.format(Locale.CHINA, "LruDiskCache[count=%d,size=%d/%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f), Integer.valueOf(size()), Integer.valueOf(maxSize()), Integer.valueOf(hitCount()), Integer.valueOf(missCount()), Integer.valueOf(i));
        }
        return (String) invokeV.objValue;
    }
}
