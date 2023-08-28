package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dlb;
import com.baidu.tieba.flb;
import com.baidu.tieba.hlb;
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
/* loaded from: classes6.dex */
public class hlb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public okb a;
    public final dlb b;
    public final HashMap<String, flb> c;

    /* loaded from: classes6.dex */
    public interface c {
        void a(Set<Ssp> set, Set<Ssp> set2);
    }

    /* loaded from: classes6.dex */
    public interface d<E> {
        void a(E e);

        void b(E e);
    }

    public hlb() {
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
        this.b = new dlb();
        this.c = new HashMap<>();
    }

    public synchronized void a(okb okbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, okbVar) == null) {
            synchronized (this) {
                HashSet hashSet = new HashSet();
                okb okbVar2 = this.a;
                if (okbVar2 != null) {
                    for (blb blbVar : okbVar2.b) {
                        hashSet.add(blbVar.a);
                    }
                    for (zkb zkbVar : this.a.c) {
                        hashSet.add(zkbVar.a);
                    }
                }
                okb okbVar3 = this.a;
                Set<zkb> set = null;
                b(okbVar3 == null ? null : okbVar3.b, okbVar.b, new a(this, hashSet));
                okb okbVar4 = this.a;
                if (okbVar4 != null) {
                    set = okbVar4.c;
                }
                b(set, okbVar.c, new b(this, hashSet));
                if (!hashSet.isEmpty()) {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        LogPrinter.d("reduce sid(%s).", str);
                        this.c.remove(str);
                    }
                }
                this.a = okbVar;
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

    /* loaded from: classes6.dex */
    public class a implements d<blb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ hlb b;

        public a(hlb hlbVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hlbVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hlbVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(blb blbVar, grb grbVar) {
            return new crb(blbVar, grbVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.hlb.d
        public void a(blb blbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, blbVar) == null) {
                blb blbVar2 = blbVar;
                LogPrinter.v("SlotId:%s is totally same with oldOne", blbVar2.a);
                this.a.remove(blbVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hlb.d
        /* renamed from: c */
        public void b(final blb blbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, blbVar) == null) {
                LogPrinter.v("Update SlotId:%s", blbVar.a);
                HashMap<String, flb> hashMap = this.b.c;
                String str = blbVar.a;
                hashMap.put(str, new flb(str, new flb.a() { // from class: com.baidu.tieba.gkb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.flb.a
                    public final FunAdLoader a(grb grbVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, grbVar)) == null) ? hlb.a.a(blb.this, grbVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                dlb dlbVar = this.b.b;
                synchronized (dlbVar.a) {
                    dlbVar.a(blbVar.a).add(new dlb.a(blbVar));
                }
                this.a.remove(blbVar.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements d<zkb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ hlb b;

        public b(hlb hlbVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hlbVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hlbVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(zkb zkbVar, grb grbVar) {
            return new com.fun.t(zkbVar, grbVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.hlb.d
        public void a(zkb zkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zkbVar) == null) {
                zkb zkbVar2 = zkbVar;
                LogPrinter.v("SerialSlotId:%s is totally same with oldOne", zkbVar2.a);
                this.a.remove(zkbVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hlb.d
        /* renamed from: c */
        public void b(final zkb zkbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zkbVar) == null) {
                LogPrinter.v("Update SerialSlotId:%s", zkbVar.a);
                HashMap<String, flb> hashMap = this.b.c;
                String str = zkbVar.a;
                hashMap.put(str, new flb(str, new flb.a() { // from class: com.baidu.tieba.ekb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.flb.a
                    public final FunAdLoader a(grb grbVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, grbVar)) == null) ? hlb.b.a(zkb.this, grbVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                dlb dlbVar = this.b.b;
                synchronized (dlbVar.a) {
                    dlbVar.a(zkbVar.a).add(new dlb.b(zkbVar));
                }
                this.a.remove(zkbVar.a);
            }
        }
    }
}
