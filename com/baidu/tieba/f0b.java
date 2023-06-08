package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b0b;
import com.baidu.tieba.d0b;
import com.baidu.tieba.f0b;
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
public class f0b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mza a;
    public final b0b b;
    public final HashMap<String, d0b> c;

    /* loaded from: classes5.dex */
    public interface c {
        void a(Set<Ssp> set, Set<Ssp> set2);
    }

    /* loaded from: classes5.dex */
    public interface d<E> {
        void a(E e);

        void b(E e);
    }

    public f0b() {
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
        this.b = new b0b();
        this.c = new HashMap<>();
    }

    public synchronized void a(mza mzaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mzaVar) == null) {
            synchronized (this) {
                HashSet hashSet = new HashSet();
                mza mzaVar2 = this.a;
                if (mzaVar2 != null) {
                    for (zza zzaVar : mzaVar2.b) {
                        hashSet.add(zzaVar.a);
                    }
                    for (xza xzaVar : this.a.c) {
                        hashSet.add(xzaVar.a);
                    }
                }
                mza mzaVar3 = this.a;
                Set<xza> set = null;
                b(mzaVar3 == null ? null : mzaVar3.b, mzaVar.b, new a(this, hashSet));
                mza mzaVar4 = this.a;
                if (mzaVar4 != null) {
                    set = mzaVar4.c;
                }
                b(set, mzaVar.c, new b(this, hashSet));
                if (!hashSet.isEmpty()) {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        LogPrinter.d("reduce sid(%s).", str);
                        this.c.remove(str);
                    }
                }
                this.a = mzaVar;
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
    public class a implements d<zza> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ f0b b;

        public a(f0b f0bVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f0bVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f0bVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(zza zzaVar, f6b f6bVar) {
            return new a6b(zzaVar, f6bVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.f0b.d
        public void a(zza zzaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zzaVar) == null) {
                zza zzaVar2 = zzaVar;
                LogPrinter.v("SlotId:%s is totally same with oldOne", zzaVar2.a);
                this.a.remove(zzaVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f0b.d
        /* renamed from: c */
        public void b(final zza zzaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zzaVar) == null) {
                LogPrinter.v("Update SlotId:%s", zzaVar.a);
                HashMap<String, d0b> hashMap = this.b.c;
                String str = zzaVar.a;
                hashMap.put(str, new d0b(str, new d0b.a() { // from class: com.baidu.tieba.eza
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.d0b.a
                    public final FunAdLoader a(f6b f6bVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, f6bVar)) == null) ? f0b.a.a(zza.this, f6bVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                b0b b0bVar = this.b.b;
                synchronized (b0bVar.a) {
                    b0bVar.a(zzaVar.a).add(new b0b.a(zzaVar));
                }
                this.a.remove(zzaVar.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d<xza> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ f0b b;

        public b(f0b f0bVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f0bVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f0bVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(xza xzaVar, f6b f6bVar) {
            return new b6b(xzaVar, f6bVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.f0b.d
        public void a(xza xzaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xzaVar) == null) {
                xza xzaVar2 = xzaVar;
                LogPrinter.v("SerialSlotId:%s is totally same with oldOne", xzaVar2.a);
                this.a.remove(xzaVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f0b.d
        /* renamed from: c */
        public void b(final xza xzaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xzaVar) == null) {
                LogPrinter.v("Update SerialSlotId:%s", xzaVar.a);
                HashMap<String, d0b> hashMap = this.b.c;
                String str = xzaVar.a;
                hashMap.put(str, new d0b(str, new d0b.a() { // from class: com.baidu.tieba.cza
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.d0b.a
                    public final FunAdLoader a(f6b f6bVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, f6bVar)) == null) ? f0b.b.a(xza.this, f6bVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                b0b b0bVar = this.b.b;
                synchronized (b0bVar.a) {
                    b0bVar.a(xzaVar.a).add(new b0b.b(xzaVar));
                }
                this.a.remove(xzaVar.a);
            }
        }
    }
}
