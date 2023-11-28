package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a2c;
import com.baidu.tieba.w1c;
import com.baidu.tieba.y1c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes5.dex */
public class a2c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h1c a;
    public final w1c b;
    public final HashMap<String, y1c> c;

    /* loaded from: classes5.dex */
    public interface c {
        void a(Set<Ssp> set, Set<Ssp> set2);
    }

    /* loaded from: classes5.dex */
    public interface d<E> {
        void a(E e);

        void b(E e);
    }

    public a2c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new w1c();
        this.c = new HashMap<>();
    }

    public synchronized void a(h1c h1cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h1cVar) == null) {
            synchronized (this) {
                HashSet hashSet = new HashSet();
                h1c h1cVar2 = this.a;
                if (h1cVar2 != null) {
                    for (u1c u1cVar : h1cVar2.b) {
                        hashSet.add(u1cVar.a);
                    }
                    for (s1c s1cVar : this.a.c) {
                        hashSet.add(s1cVar.a);
                    }
                }
                h1c h1cVar3 = this.a;
                Set<s1c> set = null;
                b(h1cVar3 == null ? null : h1cVar3.b, h1cVar.b, new a(this, hashSet));
                h1c h1cVar4 = this.a;
                if (h1cVar4 != null) {
                    set = h1cVar4.c;
                }
                b(set, h1cVar.c, new b(this, hashSet));
                if (!hashSet.isEmpty()) {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        LogPrinter.d("reduce sid(%s).", str);
                        this.c.remove(str);
                    }
                }
                this.a = h1cVar;
            }
        }
    }

    public final <E> void b(Set<E> set, Set<E> set2, d<E> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set, set2, dVar) == null) {
            for (E e : set2) {
                if (set == null || !set.contains(e)) {
                    dVar.b(e);
                } else {
                    dVar.a(e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements d<u1c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ a2c b;

        public a(a2c a2cVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a2cVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a2cVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(u1c u1cVar, r7c r7cVar) {
            return new n7c(u1cVar, r7cVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.a2c.d
        public void a(u1c u1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u1cVar) == null) {
                u1c u1cVar2 = u1cVar;
                LogPrinter.v("SlotId:%s is totally same with oldOne", u1cVar2.a);
                this.a.remove(u1cVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a2c.d
        public void b(final u1c u1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u1cVar) == null) {
                LogPrinter.v("Update SlotId:%s", u1cVar.a);
                HashMap<String, y1c> hashMap = this.b.c;
                String str = u1cVar.a;
                hashMap.put(str, new y1c(str, new y1c.a() { // from class: com.baidu.tieba.z0c
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.y1c.a
                    public final FunAdLoader a(r7c r7cVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, r7cVar)) == null) ? a2c.a.a(u1c.this, r7cVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                w1c w1cVar = this.b.b;
                synchronized (w1cVar.a) {
                    w1cVar.a(u1cVar.a).add(new w1c.a(u1cVar));
                }
                this.a.remove(u1cVar.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d<s1c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ a2c b;

        public b(a2c a2cVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a2cVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a2cVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(s1c s1cVar, r7c r7cVar) {
            return new com.fun.t(s1cVar, r7cVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.a2c.d
        public void a(s1c s1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s1cVar) == null) {
                s1c s1cVar2 = s1cVar;
                LogPrinter.v("SerialSlotId:%s is totally same with oldOne", s1cVar2.a);
                this.a.remove(s1cVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a2c.d
        public void b(final s1c s1cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s1cVar) == null) {
                LogPrinter.v("Update SerialSlotId:%s", s1cVar.a);
                HashMap<String, y1c> hashMap = this.b.c;
                String str = s1cVar.a;
                hashMap.put(str, new y1c(str, new y1c.a() { // from class: com.baidu.tieba.x0c
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.y1c.a
                    public final FunAdLoader a(r7c r7cVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, r7cVar)) == null) ? a2c.b.a(s1c.this, r7cVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                w1c w1cVar = this.b.b;
                synchronized (w1cVar.a) {
                    w1cVar.a(s1cVar.a).add(new w1c.b(s1cVar));
                }
                this.a.remove(s1cVar.a);
            }
        }
    }
}
