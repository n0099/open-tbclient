package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a0b;
import com.baidu.tieba.wza;
import com.baidu.tieba.yza;
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
/* loaded from: classes4.dex */
public class a0b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hza a;
    public final wza b;
    public final HashMap<String, yza> c;

    /* loaded from: classes4.dex */
    public interface c {
        void a(Set<Ssp> set, Set<Ssp> set2);
    }

    /* loaded from: classes4.dex */
    public interface d<E> {
        void a(E e);

        void b(E e);
    }

    public a0b() {
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
        this.b = new wza();
        this.c = new HashMap<>();
    }

    public synchronized void a(hza hzaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hzaVar) == null) {
            synchronized (this) {
                HashSet hashSet = new HashSet();
                hza hzaVar2 = this.a;
                if (hzaVar2 != null) {
                    for (uza uzaVar : hzaVar2.b) {
                        hashSet.add(uzaVar.a);
                    }
                    for (sza szaVar : this.a.c) {
                        hashSet.add(szaVar.a);
                    }
                }
                hza hzaVar3 = this.a;
                Set<sza> set = null;
                b(hzaVar3 == null ? null : hzaVar3.b, hzaVar.b, new a(this, hashSet));
                hza hzaVar4 = this.a;
                if (hzaVar4 != null) {
                    set = hzaVar4.c;
                }
                b(set, hzaVar.c, new b(this, hashSet));
                if (!hashSet.isEmpty()) {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        LogPrinter.d("reduce sid(%s).", str);
                        this.c.remove(str);
                    }
                }
                this.a = hzaVar;
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

    /* loaded from: classes4.dex */
    public class a implements d<uza> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ a0b b;

        public a(a0b a0bVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a0bVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a0bVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(uza uzaVar, a6b a6bVar) {
            return new v5b(uzaVar, a6bVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.a0b.d
        public void a(uza uzaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, uzaVar) == null) {
                uza uzaVar2 = uzaVar;
                LogPrinter.v("SlotId:%s is totally same with oldOne", uzaVar2.a);
                this.a.remove(uzaVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a0b.d
        /* renamed from: c */
        public void b(final uza uzaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uzaVar) == null) {
                LogPrinter.v("Update SlotId:%s", uzaVar.a);
                HashMap<String, yza> hashMap = this.b.c;
                String str = uzaVar.a;
                hashMap.put(str, new yza(str, new yza.a() { // from class: com.baidu.tieba.zya
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.yza.a
                    public final FunAdLoader a(a6b a6bVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, a6bVar)) == null) ? a0b.a.a(uza.this, a6bVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                wza wzaVar = this.b.b;
                synchronized (wzaVar.a) {
                    wzaVar.a(uzaVar.a).add(new wza.a(uzaVar));
                }
                this.a.remove(uzaVar.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d<sza> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ a0b b;

        public b(a0b a0bVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a0bVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a0bVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(sza szaVar, a6b a6bVar) {
            return new w5b(szaVar, a6bVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.a0b.d
        public void a(sza szaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, szaVar) == null) {
                sza szaVar2 = szaVar;
                LogPrinter.v("SerialSlotId:%s is totally same with oldOne", szaVar2.a);
                this.a.remove(szaVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a0b.d
        /* renamed from: c */
        public void b(final sza szaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, szaVar) == null) {
                LogPrinter.v("Update SerialSlotId:%s", szaVar.a);
                HashMap<String, yza> hashMap = this.b.c;
                String str = szaVar.a;
                hashMap.put(str, new yza(str, new yza.a() { // from class: com.baidu.tieba.xya
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.yza.a
                    public final FunAdLoader a(a6b a6bVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, a6bVar)) == null) ? a0b.b.a(sza.this, a6bVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                wza wzaVar = this.b.b;
                synchronized (wzaVar.a) {
                    wzaVar.a(szaVar.a).add(new wza.b(szaVar));
                }
                this.a.remove(szaVar.a);
            }
        }
    }
}
