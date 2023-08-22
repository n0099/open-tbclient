package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.blb;
import com.baidu.tieba.dlb;
import com.baidu.tieba.flb;
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
public class flb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mkb a;
    public final blb b;
    public final HashMap<String, dlb> c;

    /* loaded from: classes5.dex */
    public interface c {
        void a(Set<Ssp> set, Set<Ssp> set2);
    }

    /* loaded from: classes5.dex */
    public interface d<E> {
        void a(E e);

        void b(E e);
    }

    public flb() {
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
        this.b = new blb();
        this.c = new HashMap<>();
    }

    public synchronized void a(mkb mkbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mkbVar) == null) {
            synchronized (this) {
                HashSet hashSet = new HashSet();
                mkb mkbVar2 = this.a;
                if (mkbVar2 != null) {
                    for (zkb zkbVar : mkbVar2.b) {
                        hashSet.add(zkbVar.a);
                    }
                    for (xkb xkbVar : this.a.c) {
                        hashSet.add(xkbVar.a);
                    }
                }
                mkb mkbVar3 = this.a;
                Set<xkb> set = null;
                b(mkbVar3 == null ? null : mkbVar3.b, mkbVar.b, new a(this, hashSet));
                mkb mkbVar4 = this.a;
                if (mkbVar4 != null) {
                    set = mkbVar4.c;
                }
                b(set, mkbVar.c, new b(this, hashSet));
                if (!hashSet.isEmpty()) {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        LogPrinter.d("reduce sid(%s).", str);
                        this.c.remove(str);
                    }
                }
                this.a = mkbVar;
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
    public class a implements d<zkb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ flb b;

        public a(flb flbVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flbVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = flbVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(zkb zkbVar, erb erbVar) {
            return new arb(zkbVar, erbVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.flb.d
        public void a(zkb zkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zkbVar) == null) {
                zkb zkbVar2 = zkbVar;
                LogPrinter.v("SlotId:%s is totally same with oldOne", zkbVar2.a);
                this.a.remove(zkbVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.flb.d
        /* renamed from: c */
        public void b(final zkb zkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zkbVar) == null) {
                LogPrinter.v("Update SlotId:%s", zkbVar.a);
                HashMap<String, dlb> hashMap = this.b.c;
                String str = zkbVar.a;
                hashMap.put(str, new dlb(str, new dlb.a() { // from class: com.baidu.tieba.ekb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.dlb.a
                    public final FunAdLoader a(erb erbVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, erbVar)) == null) ? flb.a.a(zkb.this, erbVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                blb blbVar = this.b.b;
                synchronized (blbVar.a) {
                    blbVar.a(zkbVar.a).add(new blb.a(zkbVar));
                }
                this.a.remove(zkbVar.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d<xkb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ flb b;

        public b(flb flbVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flbVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = flbVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(xkb xkbVar, erb erbVar) {
            return new com.fun.t(xkbVar, erbVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.flb.d
        public void a(xkb xkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xkbVar) == null) {
                xkb xkbVar2 = xkbVar;
                LogPrinter.v("SerialSlotId:%s is totally same with oldOne", xkbVar2.a);
                this.a.remove(xkbVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.flb.d
        /* renamed from: c */
        public void b(final xkb xkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xkbVar) == null) {
                LogPrinter.v("Update SerialSlotId:%s", xkbVar.a);
                HashMap<String, dlb> hashMap = this.b.c;
                String str = xkbVar.a;
                hashMap.put(str, new dlb(str, new dlb.a() { // from class: com.baidu.tieba.ckb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.dlb.a
                    public final FunAdLoader a(erb erbVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, erbVar)) == null) ? flb.b.a(xkb.this, erbVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                blb blbVar = this.b.b;
                synchronized (blbVar.a) {
                    blbVar.a(xkbVar.a).add(new blb.b(xkbVar));
                }
                this.a.remove(xkbVar.a);
            }
        }
    }
}
