package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bxb;
import com.baidu.tieba.dxb;
import com.baidu.tieba.zwb;
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
public class dxb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kwb a;
    public final zwb b;
    public final HashMap<String, bxb> c;

    /* loaded from: classes5.dex */
    public interface c {
        void a(Set<Ssp> set, Set<Ssp> set2);
    }

    /* loaded from: classes5.dex */
    public interface d<E> {
        void a(E e);

        void b(E e);
    }

    public dxb() {
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
        this.b = new zwb();
        this.c = new HashMap<>();
    }

    public synchronized void a(kwb kwbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kwbVar) == null) {
            synchronized (this) {
                HashSet hashSet = new HashSet();
                kwb kwbVar2 = this.a;
                if (kwbVar2 != null) {
                    for (xwb xwbVar : kwbVar2.b) {
                        hashSet.add(xwbVar.a);
                    }
                    for (vwb vwbVar : this.a.c) {
                        hashSet.add(vwbVar.a);
                    }
                }
                kwb kwbVar3 = this.a;
                Set<vwb> set = null;
                b(kwbVar3 == null ? null : kwbVar3.b, kwbVar.b, new a(this, hashSet));
                kwb kwbVar4 = this.a;
                if (kwbVar4 != null) {
                    set = kwbVar4.c;
                }
                b(set, kwbVar.c, new b(this, hashSet));
                if (!hashSet.isEmpty()) {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        LogPrinter.d("reduce sid(%s).", str);
                        this.c.remove(str);
                    }
                }
                this.a = kwbVar;
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
    public class a implements d<xwb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ dxb b;

        public a(dxb dxbVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dxbVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dxbVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(xwb xwbVar, v2c v2cVar) {
            return new r2c(xwbVar, v2cVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.dxb.d
        public void a(xwb xwbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xwbVar) == null) {
                xwb xwbVar2 = xwbVar;
                LogPrinter.v("SlotId:%s is totally same with oldOne", xwbVar2.a);
                this.a.remove(xwbVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dxb.d
        /* renamed from: c */
        public void b(final xwb xwbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xwbVar) == null) {
                LogPrinter.v("Update SlotId:%s", xwbVar.a);
                HashMap<String, bxb> hashMap = this.b.c;
                String str = xwbVar.a;
                hashMap.put(str, new bxb(str, new bxb.a() { // from class: com.baidu.tieba.cwb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.bxb.a
                    public final FunAdLoader a(v2c v2cVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, v2cVar)) == null) ? dxb.a.a(xwb.this, v2cVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                zwb zwbVar = this.b.b;
                synchronized (zwbVar.a) {
                    zwbVar.a(xwbVar.a).add(new zwb.a(xwbVar));
                }
                this.a.remove(xwbVar.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d<vwb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ dxb b;

        public b(dxb dxbVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dxbVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dxbVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(vwb vwbVar, v2c v2cVar) {
            return new com.fun.t(vwbVar, v2cVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.dxb.d
        public void a(vwb vwbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vwbVar) == null) {
                vwb vwbVar2 = vwbVar;
                LogPrinter.v("SerialSlotId:%s is totally same with oldOne", vwbVar2.a);
                this.a.remove(vwbVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dxb.d
        /* renamed from: c */
        public void b(final vwb vwbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vwbVar) == null) {
                LogPrinter.v("Update SerialSlotId:%s", vwbVar.a);
                HashMap<String, bxb> hashMap = this.b.c;
                String str = vwbVar.a;
                hashMap.put(str, new bxb(str, new bxb.a() { // from class: com.baidu.tieba.awb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.bxb.a
                    public final FunAdLoader a(v2c v2cVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, v2cVar)) == null) ? dxb.b.a(vwb.this, v2cVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                zwb zwbVar = this.b.b;
                synchronized (zwbVar.a) {
                    zwbVar.a(vwbVar.a).add(new zwb.b(vwbVar));
                }
                this.a.remove(vwbVar.a);
            }
        }
    }
}
