package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ag;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes3.dex */
public class cg {
    public static /* synthetic */ Interceptable $ic;
    public static cg c;
    public static BdAsyncTaskParallel d;
    public static BdAsyncTaskParallel e;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public SparseArray<dg<?>> b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448301513, "Lcom/baidu/tieba/cg;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448301513, "Lcom/baidu/tieba/cg;");
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a<T> extends BdAsyncTask<String, Object, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final int b;
        public int c;
        public int d;
        public boolean e;
        public Object[] f;
        public int g;
        public long h;
        public final Map<bg<T>, BdUniqueId> i;
        public final ag j;
        public final /* synthetic */ cg k;

        public a(cg cgVar, String str, int i, int i2, int i3, BdUniqueId bdUniqueId, bg<T> bgVar, boolean z, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {cgVar, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bdUniqueId, bgVar, Boolean.valueOf(z), objArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = cgVar;
            this.c = 0;
            this.d = 0;
            this.e = false;
            this.f = null;
            this.g = 2;
            this.i = new HashMap();
            this.j = new ag();
            this.h = System.currentTimeMillis();
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = z;
            this.f = objArr;
            b(bgVar, bdUniqueId);
        }

        public void b(bg<T> bgVar, BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bgVar, bdUniqueId) == null) {
                hi.c();
                if (this.i.containsKey(bgVar)) {
                    return;
                }
                this.i.put(bgVar, bdUniqueId);
            }
        }

        public void c(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
                hi.c();
                if (this.i.size() == 0) {
                    cancel();
                    return;
                }
                Iterator<Map.Entry<bg<T>, BdUniqueId>> it = this.i.entrySet().iterator();
                while (it.hasNext()) {
                    BdUniqueId value = it.next().getValue();
                    if (value != null && value == bdUniqueId) {
                        it.remove();
                    }
                }
                if (this.i.size() == 0) {
                    cancel();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(T t) {
            dg dgVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
                if (t != null && (dgVar = (dg) this.k.b.get(this.b)) != null) {
                    dgVar.updateMemory(this.k.g(this.a, this.b), t, this.c, this.d, this.f);
                }
                for (Map.Entry<bg<T>, BdUniqueId> entry : this.i.entrySet()) {
                    bg<T> key = entry.getKey();
                    if (key != null) {
                        key.onLoaded(t, this.a, this.g);
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            ag.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel();
                ag agVar = this.j;
                if (agVar != null && (aVar = agVar.a) != null) {
                    aVar.cancel();
                }
                if (this.i.size() == 0) {
                    return;
                }
                for (Map.Entry<bg<T>, BdUniqueId> entry : this.i.entrySet()) {
                    bg<T> key = entry.getKey();
                    if (key != null) {
                        key.onCancelled(this.a);
                    }
                }
                this.i.clear();
            }
        }

        public void d(BdUniqueId bdUniqueId, bg<T> bgVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, bdUniqueId, bgVar) == null) {
                hi.c();
                if (this.i.size() == 0) {
                    cancel();
                    return;
                }
                Iterator<Map.Entry<bg<T>, BdUniqueId>> it = this.i.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<bg<T>, BdUniqueId> next = it.next();
                    bg<T> key = next.getKey();
                    BdUniqueId value = next.getValue();
                    if (value != null && value == bdUniqueId && key == bgVar) {
                        it.remove();
                    }
                }
                if (this.i.size() == 0) {
                    cancel();
                }
            }
        }

        public void e(bg<T> bgVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, bgVar) == null) {
                hi.c();
                this.i.remove(bgVar);
                if (bgVar != null) {
                    bgVar.onCancelled(this.a);
                }
                if (this.i.size() == 0) {
                    cancel();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, objArr) == null) {
                for (Map.Entry<bg<T>, BdUniqueId> entry : this.i.entrySet()) {
                    bg<T> key = entry.getKey();
                    if (key != null) {
                        key.onProgressUpdate(objArr);
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public T doInBackground(String... strArr) {
            InterceptResult invokeL;
            T t;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, strArr)) == null) {
                zf.m(true, System.currentTimeMillis() - this.h);
                dg dgVar = (dg) this.k.b.get(this.b);
                if (dgVar == null) {
                    return null;
                }
                String key = getKey();
                try {
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    t = null;
                }
                if (isCancelled()) {
                    return null;
                }
                T t2 = (T) dgVar.getFromLocal(this.a, key, this.c, this.d, this.j, this.f);
                if (t2 != null) {
                    return t2;
                }
                t = t2;
                if (isCancelled() || this.e) {
                    return null;
                }
                this.g = 3;
                try {
                    return (T) dgVar.getFromRemote(this.a, key, this.c, this.d, this.j, this.f);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return t;
                }
            }
            return (T) invokeL.objValue;
        }
    }

    public cg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = BdUniqueId.gen();
        this.b = null;
        BdUniqueId gen = BdUniqueId.gen();
        d = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        e = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.b = new SparseArray<>();
    }

    public dg i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            SparseArray<dg<?>> sparseArray = this.b;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i);
        }
        return (dg) invokeI.objValue;
    }

    public static cg h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (cg.class) {
                    if (c == null) {
                        c = new cg();
                    }
                }
            }
            return c;
        }
        return (cg) invokeV.objValue;
    }

    public void b(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchAllTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdUniqueId) == null) && (searchAllTask = BdAsyncTask.searchAllTask(this.a)) != null && searchAllTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchAllTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof a)) {
                    ((a) next).c(bdUniqueId);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) && (searchWaitingTask = BdAsyncTask.searchWaitingTask(this.a)) != null && searchWaitingTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof a)) {
                    ((a) next).c(bdUniqueId);
                }
            }
        }
    }

    public boolean j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            dg<?> dgVar = this.b.get(i);
            if (dgVar == null) {
                BdLog.e("Can't find the ResourceLoaderProc with type " + i);
                return false;
            }
            return dgVar.isNeedLoad();
        }
        return invokeI.booleanValue;
    }

    public final <T> a<T> p(String str) {
        InterceptResult invokeL;
        BdAsyncTask<?, ?, ?> searchTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (searchTask = BdAsyncTask.searchTask(str)) == null) {
                return null;
            }
            if (!(searchTask instanceof a)) {
                BdLog.e("BdAsyncTask has encountered repeat key");
                return null;
            }
            try {
                return (a) searchTask;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (a) invokeL.objValue;
    }

    public void c(String str, int i) {
        a p;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) != null) || (p = p(g(str, i))) == null) {
            return;
        }
        p.cancel();
    }

    public String g(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            if (str == null) {
                str = "";
            }
            return str + i;
        }
        return (String) invokeLI.objValue;
    }

    public <T> void d(String str, int i, bg<T> bgVar) {
        a<T> p;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i, bgVar) != null) || (p = p(g(str, i))) == null) {
            return;
        }
        p.e(bgVar);
    }

    public <T> void f(BdUniqueId bdUniqueId, bg<T> bgVar) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, bdUniqueId, bgVar) == null) && (searchWaitingTask = BdAsyncTask.searchWaitingTask(this.a)) != null && searchWaitingTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof a)) {
                    ((a) next).d(bdUniqueId, bgVar);
                }
            }
        }
    }

    public synchronized <T> void o(int i, dg<T> dgVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, dgVar) == null) {
            synchronized (this) {
                if (dgVar != null) {
                    if (this.b.get(i) == null) {
                        this.b.put(i, dgVar);
                    } else {
                        throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
                    }
                }
            }
        }
    }

    public <T> Object k(String str, int i, bg<T> bgVar, int i2, int i3, BdUniqueId bdUniqueId, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Integer.valueOf(i), bgVar, Integer.valueOf(i2), Integer.valueOf(i3), bdUniqueId, objArr})) == null) {
            return l(str, i, bgVar, i2, i3, false, bdUniqueId, objArr);
        }
        return invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> Object l(String str, int i, bg<T> bgVar, int i2, int i3, boolean z, BdUniqueId bdUniqueId, Object... objArr) {
        InterceptResult invokeCommon;
        dg<?> dgVar;
        int i4;
        int i5;
        a<T> p;
        boolean isWifiNet;
        int asyncTaskPriority;
        Object fromMemory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, Integer.valueOf(i), bgVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), bdUniqueId, objArr})) == null) {
            if (TextUtils.isEmpty(str) || (dgVar = this.b.get(i)) == null) {
                return null;
            }
            if (i2 >= 0 && i3 >= 0) {
                i4 = i2;
                i5 = i3;
            } else {
                i4 = 0;
                i5 = 0;
            }
            String g = g(str, i);
            try {
                fromMemory = dgVar.getFromMemory(g, str, i4, i5, true, objArr);
            } catch (Exception e2) {
                e = e2;
            }
            if (fromMemory != null) {
                if (bgVar != 0) {
                    try {
                        bgVar.onLoaded(fromMemory, str, 1);
                    } catch (Exception e3) {
                        e = e3;
                        BdLog.e(e.getMessage());
                        p = p(g);
                        if (p == null) {
                        }
                        isWifiNet = BdNetTypeUtil.isWifiNet();
                        boolean is4GNet = BdNetTypeUtil.is4GNet();
                        a aVar = new a(this, str, i, i4, i5, bdUniqueId, bgVar, z, objArr);
                        aVar.setKey(g);
                        aVar.setTag(this.a);
                        asyncTaskPriority = dgVar.getAsyncTaskPriority();
                        if (asyncTaskPriority == 0) {
                        }
                        aVar.setPriority(asyncTaskPriority);
                        if (isWifiNet) {
                        }
                        if (dgVar.getAsyncTaskParallel() != null) {
                        }
                        aVar.execute(new String[0]);
                        return null;
                    }
                }
                return fromMemory;
            }
            p = p(g);
            if (p == null && p.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
                p.b(bgVar, bdUniqueId);
                return null;
            }
            isWifiNet = BdNetTypeUtil.isWifiNet();
            boolean is4GNet2 = BdNetTypeUtil.is4GNet();
            a aVar2 = new a(this, str, i, i4, i5, bdUniqueId, bgVar, z, objArr);
            aVar2.setKey(g);
            aVar2.setTag(this.a);
            asyncTaskPriority = dgVar.getAsyncTaskPriority();
            if (asyncTaskPriority == 0) {
                asyncTaskPriority = 1;
            }
            aVar2.setPriority(asyncTaskPriority);
            if (isWifiNet && !is4GNet2) {
                aVar2.setParallel(d);
            } else if (dgVar.getAsyncTaskParallel() != null) {
                aVar2.setParallel(e);
            } else {
                aVar2.setParallel(dgVar.getAsyncTaskParallel());
            }
            aVar2.execute(new String[0]);
            return null;
        }
        return invokeCommon.objValue;
    }

    public <T> Object m(String str, int i, bg<T> bgVar, BdUniqueId bdUniqueId) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048586, this, str, i, bgVar, bdUniqueId)) == null) {
            return k(str, i, bgVar, 0, 0, bdUniqueId, new Object[0]);
        }
        return invokeLILL.objValue;
    }

    public Object n(String str, int i, Object... objArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048587, this, str, i, objArr)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            dg<?> dgVar = this.b.get(i);
            if (dgVar == null) {
                BdLog.e("Can't find the ResourceLoaderProc with type " + i);
                return null;
            }
            return dgVar.getFromMemory(g(str, i), str, 0, 0, false, objArr);
        }
        return invokeLIL.objValue;
    }
}
