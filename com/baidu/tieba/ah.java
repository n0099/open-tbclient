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
import com.baidu.tieba.yg;
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
public class ah {
    public static /* synthetic */ Interceptable $ic;
    public static ah d;
    public static BdAsyncTaskParallel e;
    public static BdAsyncTaskParallel f;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public SparseArray b;
    public boolean c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448299622, "Lcom/baidu/tieba/ah;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448299622, "Lcom/baidu/tieba/ah;");
        }
    }

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask {
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
        public final Map i;
        public final yg j;
        public final /* synthetic */ ah k;

        public a(ah ahVar, String str, int i, int i2, int i3, BdUniqueId bdUniqueId, zg zgVar, boolean z, Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr2 = {ahVar, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bdUniqueId, zgVar, Boolean.valueOf(z), objArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = ahVar;
            this.c = 0;
            this.d = 0;
            this.e = false;
            this.f = null;
            this.g = 2;
            this.i = new HashMap();
            this.j = new yg();
            this.h = System.currentTimeMillis();
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = z;
            this.f = objArr;
            b(zgVar, bdUniqueId);
        }

        public void b(zg zgVar, BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, zgVar, bdUniqueId) == null) {
                fj.c();
                if (this.i.containsKey(zgVar)) {
                    return;
                }
                this.i.put(zgVar, bdUniqueId);
            }
        }

        public void c(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) {
                fj.c();
                if (this.i.size() == 0) {
                    cancel();
                    return;
                }
                Iterator it = this.i.entrySet().iterator();
                while (it.hasNext()) {
                    BdUniqueId bdUniqueId2 = (BdUniqueId) ((Map.Entry) it.next()).getValue();
                    if (bdUniqueId2 != null && bdUniqueId2 == bdUniqueId) {
                        it.remove();
                    }
                }
                if (this.i.size() == 0) {
                    cancel();
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Object obj) {
            bh bhVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
                if (obj != null && (bhVar = (bh) this.k.b.get(this.b)) != null) {
                    bhVar.updateMemory(this.k.g(this.a, this.b), obj, this.c, this.d, this.f);
                }
                for (Map.Entry entry : this.i.entrySet()) {
                    zg zgVar = (zg) entry.getKey();
                    if (zgVar != null) {
                        zgVar.onLoaded(obj, this.a, this.g);
                    }
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            yg.a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel();
                yg ygVar = this.j;
                if (ygVar != null && (aVar = ygVar.a) != null) {
                    aVar.cancel();
                }
                if (this.i.size() == 0) {
                    return;
                }
                for (Map.Entry entry : this.i.entrySet()) {
                    zg zgVar = (zg) entry.getKey();
                    if (zgVar != null) {
                        zgVar.onCancelled(this.a);
                    }
                }
                this.i.clear();
            }
        }

        public void d(BdUniqueId bdUniqueId, zg zgVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, bdUniqueId, zgVar) == null) {
                fj.c();
                if (this.i.size() == 0) {
                    cancel();
                    return;
                }
                Iterator it = this.i.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    zg zgVar2 = (zg) entry.getKey();
                    BdUniqueId bdUniqueId2 = (BdUniqueId) entry.getValue();
                    if (bdUniqueId2 != null && bdUniqueId2 == bdUniqueId && zgVar2 == zgVar) {
                        it.remove();
                    }
                }
                if (this.i.size() == 0) {
                    cancel();
                }
            }
        }

        public void e(zg zgVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, zgVar) == null) {
                fj.c();
                this.i.remove(zgVar);
                if (zgVar != null) {
                    zgVar.onCancelled(this.a);
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
                for (Map.Entry entry : this.i.entrySet()) {
                    zg zgVar = (zg) entry.getKey();
                    if (zgVar != null) {
                        zgVar.onProgressUpdate(objArr);
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Object doInBackground(String... strArr) {
            InterceptResult invokeL;
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, strArr)) == null) {
                xg.m(true, System.currentTimeMillis() - this.h);
                bh bhVar = (bh) this.k.b.get(this.b);
                if (bhVar == null) {
                    return null;
                }
                String key = getKey();
                try {
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    obj = null;
                }
                if (isCancelled()) {
                    return null;
                }
                Object fromLocal = bhVar.getFromLocal(this.a, key, this.c, this.d, this.j, this.f);
                if (fromLocal != null) {
                    return fromLocal;
                }
                obj = fromLocal;
                if (isCancelled() || this.e) {
                    return null;
                }
                this.g = 3;
                try {
                    return bhVar.getFromRemote(this.a, key, this.c, this.d, this.j, this.f);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return obj;
                }
            }
            return invokeL.objValue;
        }
    }

    public ah() {
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
        this.c = false;
        BdUniqueId gen = BdUniqueId.gen();
        e = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, gen);
        f = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL, gen);
        this.b = new SparseArray();
    }

    public bh i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            SparseArray sparseArray = this.b;
            if (sparseArray == null) {
                return null;
            }
            return (bh) sparseArray.get(i);
        }
        return (bh) invokeI.objValue;
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.c = z;
        }
    }

    public static ah h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (ah.class) {
                    if (d == null) {
                        d = new ah();
                    }
                }
            }
            return d;
        }
        return (ah) invokeV.objValue;
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
            bh bhVar = (bh) this.b.get(i);
            if (bhVar == null) {
                BdLog.e("Can't find the ResourceLoaderProc with type " + i);
                return false;
            }
            return bhVar.isNeedLoad();
        }
        return invokeI.booleanValue;
    }

    public final a p(String str) {
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

    public void d(String str, int i, zg zgVar) {
        a p;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i, zgVar) != null) || (p = p(g(str, i))) == null) {
            return;
        }
        p.e(zgVar);
    }

    public void f(BdUniqueId bdUniqueId, zg zgVar) {
        LinkedList<BdAsyncTask<?, ?, ?>> searchWaitingTask;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, bdUniqueId, zgVar) == null) && (searchWaitingTask = BdAsyncTask.searchWaitingTask(this.a)) != null && searchWaitingTask.size() != 0) {
            Iterator<BdAsyncTask<?, ?, ?>> it = searchWaitingTask.iterator();
            while (it.hasNext()) {
                BdAsyncTask<?, ?, ?> next = it.next();
                if (next != null && (next instanceof a)) {
                    ((a) next).d(bdUniqueId, zgVar);
                }
            }
        }
    }

    public String g(String str, int i) {
        InterceptResult invokeLI;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            if (str == null) {
                str = "";
            }
            if (this.c && (indexOf = str.indexOf("?")) > 0) {
                str = str.substring(0, indexOf - 1);
            }
            return str + i;
        }
        return (String) invokeLI.objValue;
    }

    public synchronized void o(int i, bh bhVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, bhVar) == null) {
            synchronized (this) {
                if (bhVar != null) {
                    if (this.b.get(i) == null) {
                        this.b.put(i, bhVar);
                    } else {
                        throw new IllegalArgumentException("registerLoaderProc key has been registered. The key is " + i);
                    }
                }
            }
        }
    }

    public Object k(String str, int i, zg zgVar, int i2, int i3, BdUniqueId bdUniqueId, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Integer.valueOf(i), zgVar, Integer.valueOf(i2), Integer.valueOf(i3), bdUniqueId, objArr})) == null) {
            return l(str, i, zgVar, i2, i3, false, bdUniqueId, objArr);
        }
        return invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object l(String str, int i, zg zgVar, int i2, int i3, boolean z, BdUniqueId bdUniqueId, Object... objArr) {
        InterceptResult invokeCommon;
        bh bhVar;
        int i4;
        int i5;
        a p;
        boolean isWifiNet;
        int asyncTaskPriority;
        Object fromMemory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{str, Integer.valueOf(i), zgVar, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), bdUniqueId, objArr})) == null) {
            if (TextUtils.isEmpty(str) || (bhVar = (bh) this.b.get(i)) == null) {
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
                fromMemory = bhVar.getFromMemory(g, str, i4, i5, true, objArr);
            } catch (Exception e2) {
                e = e2;
            }
            if (fromMemory != null) {
                if (zgVar != null) {
                    try {
                        zgVar.onLoaded(fromMemory, str, 1);
                    } catch (Exception e3) {
                        e = e3;
                        BdLog.e(e.getMessage());
                        p = p(g);
                        if (p == null) {
                        }
                        isWifiNet = BdNetTypeUtil.isWifiNet();
                        boolean is4GNet = BdNetTypeUtil.is4GNet();
                        a aVar = new a(this, str, i, i4, i5, bdUniqueId, zgVar, z, objArr);
                        aVar.setKey(g);
                        aVar.setTag(this.a);
                        asyncTaskPriority = bhVar.getAsyncTaskPriority();
                        if (asyncTaskPriority == 0) {
                        }
                        aVar.setPriority(asyncTaskPriority);
                        if (isWifiNet) {
                        }
                        if (bhVar.getAsyncTaskParallel() != null) {
                        }
                        aVar.execute(new String[0]);
                        return null;
                    }
                }
                return fromMemory;
            }
            p = p(g);
            if (p == null && p.getStatus() != BdAsyncTask.BdAsyncTaskStatus.FINISHED) {
                p.b(zgVar, bdUniqueId);
                return null;
            }
            isWifiNet = BdNetTypeUtil.isWifiNet();
            boolean is4GNet2 = BdNetTypeUtil.is4GNet();
            a aVar2 = new a(this, str, i, i4, i5, bdUniqueId, zgVar, z, objArr);
            aVar2.setKey(g);
            aVar2.setTag(this.a);
            asyncTaskPriority = bhVar.getAsyncTaskPriority();
            if (asyncTaskPriority == 0) {
                asyncTaskPriority = 1;
            }
            aVar2.setPriority(asyncTaskPriority);
            if (isWifiNet && !is4GNet2) {
                aVar2.setParallel(e);
            } else if (bhVar.getAsyncTaskParallel() != null) {
                aVar2.setParallel(f);
            } else {
                aVar2.setParallel(bhVar.getAsyncTaskParallel());
            }
            aVar2.execute(new String[0]);
            return null;
        }
        return invokeCommon.objValue;
    }

    public Object m(String str, int i, zg zgVar, BdUniqueId bdUniqueId) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048586, this, str, i, zgVar, bdUniqueId)) == null) {
            return k(str, i, zgVar, 0, 0, bdUniqueId, new Object[0]);
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
            bh bhVar = (bh) this.b.get(i);
            if (bhVar == null) {
                BdLog.e("Can't find the ResourceLoaderProc with type " + i);
                return null;
            }
            return bhVar.getFromMemory(g(str, i), str, 0, 0, false, objArr);
        }
        return invokeLIL.objValue;
    }
}
