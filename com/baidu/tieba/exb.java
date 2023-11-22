package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.axb;
import com.baidu.tieba.cxb;
import com.baidu.tieba.exb;
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
public class exb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lwb a;
    public final axb b;
    public final HashMap<String, cxb> c;

    /* loaded from: classes5.dex */
    public interface c {
        void a(Set<Ssp> set, Set<Ssp> set2);
    }

    /* loaded from: classes5.dex */
    public interface d<E> {
        void a(E e);

        void b(E e);
    }

    public exb() {
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
        this.b = new axb();
        this.c = new HashMap<>();
    }

    public synchronized void a(lwb lwbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, lwbVar) == null) {
            synchronized (this) {
                HashSet hashSet = new HashSet();
                lwb lwbVar2 = this.a;
                if (lwbVar2 != null) {
                    for (ywb ywbVar : lwbVar2.b) {
                        hashSet.add(ywbVar.a);
                    }
                    for (wwb wwbVar : this.a.c) {
                        hashSet.add(wwbVar.a);
                    }
                }
                lwb lwbVar3 = this.a;
                Set<wwb> set = null;
                b(lwbVar3 == null ? null : lwbVar3.b, lwbVar.b, new a(this, hashSet));
                lwb lwbVar4 = this.a;
                if (lwbVar4 != null) {
                    set = lwbVar4.c;
                }
                b(set, lwbVar.c, new b(this, hashSet));
                if (!hashSet.isEmpty()) {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        LogPrinter.d("reduce sid(%s).", str);
                        this.c.remove(str);
                    }
                }
                this.a = lwbVar;
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
    public class a implements d<ywb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ exb b;

        public a(exb exbVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {exbVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = exbVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(ywb ywbVar, w2c w2cVar) {
            return new s2c(ywbVar, w2cVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.exb.d
        public void a(ywb ywbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ywbVar) == null) {
                ywb ywbVar2 = ywbVar;
                LogPrinter.v("SlotId:%s is totally same with oldOne", ywbVar2.a);
                this.a.remove(ywbVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.exb.d
        /* renamed from: c */
        public void b(final ywb ywbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ywbVar) == null) {
                LogPrinter.v("Update SlotId:%s", ywbVar.a);
                HashMap<String, cxb> hashMap = this.b.c;
                String str = ywbVar.a;
                hashMap.put(str, new cxb(str, new cxb.a() { // from class: com.baidu.tieba.dwb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.cxb.a
                    public final FunAdLoader a(w2c w2cVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, w2cVar)) == null) ? exb.a.a(ywb.this, w2cVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                axb axbVar = this.b.b;
                synchronized (axbVar.a) {
                    axbVar.a(ywbVar.a).add(new axb.a(ywbVar));
                }
                this.a.remove(ywbVar.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d<wwb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ exb b;

        public b(exb exbVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {exbVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = exbVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(wwb wwbVar, w2c w2cVar) {
            return new com.fun.t(wwbVar, w2cVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.exb.d
        public void a(wwb wwbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wwbVar) == null) {
                wwb wwbVar2 = wwbVar;
                LogPrinter.v("SerialSlotId:%s is totally same with oldOne", wwbVar2.a);
                this.a.remove(wwbVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.exb.d
        /* renamed from: c */
        public void b(final wwb wwbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wwbVar) == null) {
                LogPrinter.v("Update SerialSlotId:%s", wwbVar.a);
                HashMap<String, cxb> hashMap = this.b.c;
                String str = wwbVar.a;
                hashMap.put(str, new cxb(str, new cxb.a() { // from class: com.baidu.tieba.bwb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.cxb.a
                    public final FunAdLoader a(w2c w2cVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, w2cVar)) == null) ? exb.b.a(wwb.this, w2cVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                axb axbVar = this.b.b;
                synchronized (axbVar.a) {
                    axbVar.a(wwbVar.a).add(new axb.b(wwbVar));
                }
                this.a.remove(wwbVar.a);
            }
        }
    }
}
