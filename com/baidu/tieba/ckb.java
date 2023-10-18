package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.akb;
import com.baidu.tieba.ckb;
import com.baidu.tieba.yjb;
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
public class ckb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jjb a;
    public final yjb b;
    public final HashMap<String, akb> c;

    /* loaded from: classes5.dex */
    public interface c {
        void a(Set<Ssp> set, Set<Ssp> set2);
    }

    /* loaded from: classes5.dex */
    public interface d<E> {
        void a(E e);

        void b(E e);
    }

    public ckb() {
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
        this.b = new yjb();
        this.c = new HashMap<>();
    }

    public synchronized void a(jjb jjbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jjbVar) == null) {
            synchronized (this) {
                HashSet hashSet = new HashSet();
                jjb jjbVar2 = this.a;
                if (jjbVar2 != null) {
                    for (wjb wjbVar : jjbVar2.b) {
                        hashSet.add(wjbVar.a);
                    }
                    for (ujb ujbVar : this.a.c) {
                        hashSet.add(ujbVar.a);
                    }
                }
                jjb jjbVar3 = this.a;
                Set<ujb> set = null;
                b(jjbVar3 == null ? null : jjbVar3.b, jjbVar.b, new a(this, hashSet));
                jjb jjbVar4 = this.a;
                if (jjbVar4 != null) {
                    set = jjbVar4.c;
                }
                b(set, jjbVar.c, new b(this, hashSet));
                if (!hashSet.isEmpty()) {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        LogPrinter.d("reduce sid(%s).", str);
                        this.c.remove(str);
                    }
                }
                this.a = jjbVar;
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
    public class a implements d<wjb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ ckb b;

        public a(ckb ckbVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ckbVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ckbVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(wjb wjbVar, upb upbVar) {
            return new qpb(wjbVar, upbVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.ckb.d
        public void a(wjb wjbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wjbVar) == null) {
                wjb wjbVar2 = wjbVar;
                LogPrinter.v("SlotId:%s is totally same with oldOne", wjbVar2.a);
                this.a.remove(wjbVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ckb.d
        /* renamed from: c */
        public void b(final wjb wjbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wjbVar) == null) {
                LogPrinter.v("Update SlotId:%s", wjbVar.a);
                HashMap<String, akb> hashMap = this.b.c;
                String str = wjbVar.a;
                hashMap.put(str, new akb(str, new akb.a() { // from class: com.baidu.tieba.bjb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.akb.a
                    public final FunAdLoader a(upb upbVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, upbVar)) == null) ? ckb.a.a(wjb.this, upbVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                yjb yjbVar = this.b.b;
                synchronized (yjbVar.a) {
                    yjbVar.a(wjbVar.a).add(new yjb.a(wjbVar));
                }
                this.a.remove(wjbVar.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d<ujb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ ckb b;

        public b(ckb ckbVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ckbVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ckbVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(ujb ujbVar, upb upbVar) {
            return new com.fun.t(ujbVar, upbVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.ckb.d
        public void a(ujb ujbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ujbVar) == null) {
                ujb ujbVar2 = ujbVar;
                LogPrinter.v("SerialSlotId:%s is totally same with oldOne", ujbVar2.a);
                this.a.remove(ujbVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ckb.d
        /* renamed from: c */
        public void b(final ujb ujbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ujbVar) == null) {
                LogPrinter.v("Update SerialSlotId:%s", ujbVar.a);
                HashMap<String, akb> hashMap = this.b.c;
                String str = ujbVar.a;
                hashMap.put(str, new akb(str, new akb.a() { // from class: com.baidu.tieba.zib
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.akb.a
                    public final FunAdLoader a(upb upbVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, upbVar)) == null) ? ckb.b.a(ujb.this, upbVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                yjb yjbVar = this.b.b;
                synchronized (yjbVar.a) {
                    yjbVar.a(ujbVar.a).add(new yjb.b(ujbVar));
                }
                this.a.remove(ujbVar.a);
            }
        }
    }
}
