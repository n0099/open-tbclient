package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cob;
import com.baidu.tieba.eob;
import com.baidu.tieba.gob;
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
public class gob {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nnb a;
    public final cob b;
    public final HashMap<String, eob> c;

    /* loaded from: classes6.dex */
    public interface c {
        void a(Set<Ssp> set, Set<Ssp> set2);
    }

    /* loaded from: classes6.dex */
    public interface d<E> {
        void a(E e);

        void b(E e);
    }

    public gob() {
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
        this.b = new cob();
        this.c = new HashMap<>();
    }

    public synchronized void a(nnb nnbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nnbVar) == null) {
            synchronized (this) {
                HashSet hashSet = new HashSet();
                nnb nnbVar2 = this.a;
                if (nnbVar2 != null) {
                    for (aob aobVar : nnbVar2.b) {
                        hashSet.add(aobVar.a);
                    }
                    for (ynb ynbVar : this.a.c) {
                        hashSet.add(ynbVar.a);
                    }
                }
                nnb nnbVar3 = this.a;
                Set<ynb> set = null;
                b(nnbVar3 == null ? null : nnbVar3.b, nnbVar.b, new a(this, hashSet));
                nnb nnbVar4 = this.a;
                if (nnbVar4 != null) {
                    set = nnbVar4.c;
                }
                b(set, nnbVar.c, new b(this, hashSet));
                if (!hashSet.isEmpty()) {
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        LogPrinter.d("reduce sid(%s).", str);
                        this.c.remove(str);
                    }
                }
                this.a = nnbVar;
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
    public class a implements d<aob> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ gob b;

        public a(gob gobVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gobVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gobVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(aob aobVar, fub fubVar) {
            return new bub(aobVar, fubVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.gob.d
        public void a(aob aobVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aobVar) == null) {
                aob aobVar2 = aobVar;
                LogPrinter.v("SlotId:%s is totally same with oldOne", aobVar2.a);
                this.a.remove(aobVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gob.d
        /* renamed from: c */
        public void b(final aob aobVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aobVar) == null) {
                LogPrinter.v("Update SlotId:%s", aobVar.a);
                HashMap<String, eob> hashMap = this.b.c;
                String str = aobVar.a;
                hashMap.put(str, new eob(str, new eob.a() { // from class: com.baidu.tieba.fnb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.eob.a
                    public final FunAdLoader a(fub fubVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, fubVar)) == null) ? gob.a.a(aob.this, fubVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                cob cobVar = this.b.b;
                synchronized (cobVar.a) {
                    cobVar.a(aobVar.a).add(new cob.a(aobVar));
                }
                this.a.remove(aobVar.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements d<ynb> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ gob b;

        public b(gob gobVar, Set set) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gobVar, set};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gobVar;
            this.a = set;
        }

        public static /* synthetic */ FunAdLoader a(ynb ynbVar, fub fubVar) {
            return new com.fun.t(ynbVar, fubVar);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.gob.d
        public void a(ynb ynbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ynbVar) == null) {
                ynb ynbVar2 = ynbVar;
                LogPrinter.v("SerialSlotId:%s is totally same with oldOne", ynbVar2.a);
                this.a.remove(ynbVar2.a);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gob.d
        /* renamed from: c */
        public void b(final ynb ynbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ynbVar) == null) {
                LogPrinter.v("Update SerialSlotId:%s", ynbVar.a);
                HashMap<String, eob> hashMap = this.b.c;
                String str = ynbVar.a;
                hashMap.put(str, new eob(str, new eob.a() { // from class: com.baidu.tieba.dnb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.eob.a
                    public final FunAdLoader a(fub fubVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, fubVar)) == null) ? gob.b.a(ynb.this, fubVar) : (FunAdLoader) invokeL.objValue;
                    }
                }));
                cob cobVar = this.b.b;
                synchronized (cobVar.a) {
                    cobVar.a(ynbVar.a).add(new cob.b(ynbVar));
                }
                this.a.remove(ynbVar.a);
            }
        }
    }
}
