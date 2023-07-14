package com.baidu.tieba;

import android.util.Pair;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.hv4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class bu4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ScheduledExecutorService a;
    public final SparseArray<List<au4>> b;
    public final LinkedList<au4> c;
    public f d;
    public AtomicBoolean e;
    public boolean f;
    public boolean g;
    public BdUniqueId h;
    public hv4 i;
    public bv4 j;
    public int k;
    public long l;
    public int m;
    public long n;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public zu4<av4> s;
    public d05 t;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bu4 bu4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bu4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.f = true;
            if (!this.a.c.isEmpty()) {
                Iterator it = this.a.c.iterator();
                while (it.hasNext()) {
                    this.a.m((au4) it.next());
                }
                this.a.c.clear();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(bu4 bu4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bu4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage)) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(bu4 bu4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bu4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371) {
                return;
            }
            this.a.g = true;
            this.a.q();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements zu4<av4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu4 a;

        @Override // com.baidu.tieba.c05
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            }
        }

        public d(bu4 bu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bu4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c05
        /* renamed from: c */
        public void onSuccess(av4 av4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, av4Var) == null) && av4Var != null) {
                this.a.n(av4Var.b());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zu4
        /* renamed from: b */
        public void a(av4 av4Var) {
            ActiveCenterData activeCenterData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, av4Var) == null) && av4Var != null && (activeCenterData = av4Var.g) != null && activeCenterData.mission != null) {
                au4 au4Var = new au4();
                au4Var.P(av4Var.g.mission);
                ArrayList arrayList = new ArrayList();
                arrayList.add(au4Var);
                this.a.n(arrayList);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements d05<au4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu4 a;

        public e(bu4 bu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bu4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.d05
        /* renamed from: b */
        public void a(au4 au4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, au4Var) != null) || au4Var == null) {
                return;
            }
            au4 u = this.a.u(au4Var);
            if (u != null && u.z) {
                u.S();
                this.a.T(u);
                return;
            }
            mu4.b().h(u);
            if (u != null && u.x() == 7) {
                u.I();
                int F = u.F();
                int w = u.w();
                if (F <= 1 || F <= w) {
                    this.a.G(u);
                } else {
                    this.a.T(u);
                }
            } else if (u == null || u.x() != 8) {
                this.a.G(au4Var);
            } else {
                this.a.G(u);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile int a;
        public volatile long b;
        public volatile long c;
        public volatile boolean d;
        public final /* synthetic */ bu4 e;

        public f(bu4 bu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = bu4Var;
            this.d = false;
        }

        public synchronized void f(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                synchronized (this) {
                    this.a = i;
                }
            }
        }

        public synchronized void g(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
                synchronized (this) {
                    this.c = j;
                }
            }
        }

        public synchronized void h(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
                synchronized (this) {
                    this.b = j;
                }
            }
        }

        public /* synthetic */ f(bu4 bu4Var, a aVar) {
            this(bu4Var);
        }

        public final void d(List<au4> list, hv4.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048579, this, list, dVar) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (au4 au4Var : list) {
                b(au4Var, dVar);
            }
        }

        public final void e(List<au4> list, hv4.d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048580, this, list, dVar) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            for (au4 au4Var : list) {
                a(au4Var, dVar);
            }
        }

        public final void a(au4 au4Var, hv4.d dVar) {
            ArrayList<gu4> n;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, au4Var, dVar) != null) || au4Var == null || dVar == null || (n = au4Var.n()) == null) {
                return;
            }
            Iterator<gu4> it = n.iterator();
            int i = 0;
            while (it.hasNext()) {
                gu4 next = it.next();
                if (next instanceof lu4) {
                    lu4 lu4Var = (lu4) next;
                    if (this.b != 0 && lu4Var.i() == this.b && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().J() >= next.c().A()) {
                                dVar.b(next);
                            }
                        }
                        dVar.c(au4Var);
                    }
                } else if (next instanceof ju4) {
                    ju4 ju4Var = (ju4) next;
                    if (!au4Var.M() && ju4Var.d() == au4Var.w()) {
                        if (this.b != 0 && ju4Var.i() == this.b && !next.e()) {
                            this.d = false;
                            next.a(1);
                        }
                        i = (int) (i + next.b());
                        if (this.b != 0 && ju4Var.i() == this.b && !next.e()) {
                            if (next.b() >= au4Var.f()) {
                                next.f(true);
                                au4Var.J();
                            }
                            dVar.c(au4Var);
                        }
                        int l = au4Var.l();
                        int A = au4Var.A();
                        long f = au4Var.f() * au4Var.A();
                        if (this.b != 0 && ju4Var.i() == this.b) {
                            next.e();
                        }
                        if (i >= f && l >= A) {
                            dVar.a(au4Var);
                            au4Var.d0(true);
                        }
                    }
                } else if (next instanceof iu4) {
                    if (this.c != 0 && ((iu4) next).i() == this.c && !next.e()) {
                        this.d = false;
                        next.a(1);
                        if (next.b() >= next.c().f()) {
                            next.f(true);
                            if (next.c().H() >= next.c().p()) {
                                dVar.b(next);
                            }
                        }
                    }
                } else if ((next instanceof hu4) && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.b(next);
                    }
                }
            }
        }

        public final void b(au4 au4Var, hv4.d dVar) {
            ArrayList<gu4> n;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, au4Var, dVar) != null) || au4Var == null || dVar == null || (n = au4Var.n()) == null) {
                return;
            }
            Iterator<gu4> it = n.iterator();
            while (it.hasNext()) {
                gu4 next = it.next();
                if ((next instanceof ku4) && !((ku4) next).j() && !next.e()) {
                    this.d = false;
                    next.a(1);
                    if (next.b() >= next.c().f()) {
                        next.f(true);
                        dVar.a(au4Var);
                    }
                    dVar.c(au4Var);
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d = true;
                List<au4> list = (List) this.e.b.get(au4.Y);
                List<au4> list2 = (List) this.e.b.get(this.a);
                if (ListUtils.isEmpty(list) && ListUtils.isEmpty(list2)) {
                    this.e.e.compareAndSet(true, false);
                    return;
                }
                hv4.d dVar = new hv4.d();
                dVar.a = new LinkedList();
                dVar.b = new LinkedList();
                dVar.c = new LinkedList();
                d(list, dVar);
                e(list2, dVar);
                if (this.d) {
                    this.e.e.compareAndSet(true, false);
                }
                if (!ListUtils.isEmpty(dVar.c)) {
                    yt4.g().k(dVar.c);
                }
                if (!ListUtils.isEmpty(dVar.a) || !ListUtils.isEmpty(dVar.b)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921379, dVar));
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                if (this.a == 0 || !this.e.e.get()) {
                    synchronized (this.e.e) {
                        try {
                            this.e.e.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends BdAsyncTask<au4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(bu4 bu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(au4... au4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, au4VarArr)) == null) {
                if (au4VarArr != null && au4VarArr.length > 0 && au4VarArr[0] != null) {
                    yt4.g().a(au4VarArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ g(bu4 bu4Var, a aVar) {
            this(bu4Var);
        }
    }

    /* loaded from: classes5.dex */
    public class h extends BdAsyncTask<List<au4>, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(bu4 bu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(List<au4>... listArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                if (listArr != null && listArr.length > 0 && listArr[0] != null) {
                    yt4.g().b(listArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ h(bu4 bu4Var, a aVar) {
            this(bu4Var);
        }
    }

    /* loaded from: classes5.dex */
    public class i extends BdAsyncTask<au4, Integer, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i(bu4 bu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(au4... au4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, au4VarArr)) == null) {
                if (au4VarArr != null && au4VarArr.length > 0 && au4VarArr[0] != null) {
                    yt4.g().e(au4VarArr[0]);
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        public /* synthetic */ i(bu4 bu4Var, a aVar) {
            this(bu4Var);
        }
    }

    /* loaded from: classes5.dex */
    public class j extends BdAsyncTask<Pair<au4, au4>, Integer, Pair<au4, au4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu4 a;

        public j(bu4 bu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bu4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Pair<au4, au4> pair) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pair) == null) && pair != null) {
                au4 au4Var = (au4) pair.first;
                au4 au4Var2 = (au4) pair.second;
                if (au4Var2 != null) {
                    this.a.t(au4Var2);
                }
                if (au4Var == null) {
                    return;
                }
                this.a.K(au4Var);
            }
        }

        public /* synthetic */ j(bu4 bu4Var, a aVar) {
            this(bu4Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Pair<au4, au4> doInBackground(Pair<au4, au4>... pairArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pairArr)) == null) {
                if (pairArr != null && pairArr.length > 0 && pairArr[0] != null) {
                    Pair<au4, au4> pair = pairArr[0];
                    au4 au4Var = (au4) pair.first;
                    au4 au4Var2 = (au4) pair.second;
                    if (au4Var2 != null) {
                        yt4.g().e(au4Var2);
                    }
                    if (au4Var != null) {
                        yt4.g().a(au4Var);
                        return pair;
                    }
                    return pair;
                }
                return null;
            }
            return (Pair) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k extends BdAsyncTask<Void, Integer, LinkedList<au4>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu4 a;

        public k(bu4 bu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bu4Var;
        }

        public /* synthetic */ k(bu4 bu4Var, a aVar) {
            this(bu4Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public LinkedList<au4> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                LinkedList<au4> linkedList = new LinkedList<>();
                linkedList.addAll(yt4.g().f());
                Iterator<au4> it = linkedList.iterator();
                while (it.hasNext()) {
                    au4 next = it.next();
                    if (next != null && next.N()) {
                        yt4.g().e(next);
                        it.remove();
                    } else if (next != null && next.x() == 7) {
                        next.o0();
                        yt4.g().i(next);
                    }
                }
                return linkedList;
            }
            return (LinkedList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(LinkedList<au4> linkedList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList) == null) {
                super.onPostExecute(linkedList);
                if (linkedList == null) {
                    return;
                }
                if (!linkedList.isEmpty()) {
                    Iterator<au4> it = linkedList.iterator();
                    while (it.hasNext()) {
                        au4 next = it.next();
                        if (next.h() != null) {
                            this.a.K(next);
                        }
                    }
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921391));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public static final bu4 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-906952224, "Lcom/baidu/tieba/bu4$l;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-906952224, "Lcom/baidu/tieba/bu4$l;");
                    return;
                }
            }
            a = new bu4(null);
        }
    }

    /* loaded from: classes5.dex */
    public class m extends BdAsyncTask<au4, Integer, au4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu4 a;

        public m(bu4 bu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bu4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public au4 doInBackground(au4... au4VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, au4VarArr)) == null) {
                if (au4VarArr != null && au4VarArr.length > 0 && au4VarArr[0] != null) {
                    au4 au4Var = au4VarArr[0];
                    yt4.g().i(au4Var);
                    return au4Var;
                }
                return null;
            }
            return (au4) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(au4 au4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, au4Var) == null) && au4Var != null && au4Var.z) {
                au4Var.z = false;
                bu4 bu4Var = this.a;
                bu4Var.Q(bu4Var.k, this.a.l);
            }
        }

        public /* synthetic */ m(bu4 bu4Var, a aVar) {
            this(bu4Var);
        }
    }

    public bu4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = Executors.newSingleThreadScheduledExecutor();
        this.b = new SparseArray<>();
        this.c = new LinkedList<>();
        this.d = new f(this, null);
        this.e = new AtomicBoolean(false);
        this.f = false;
        this.g = false;
        this.o = false;
        this.p = new a(this, 2921391);
        this.q = new b(this, 2001011);
        this.r = new c(this, 2001371);
        this.s = new d(this);
        this.t = new e(this);
        BdUniqueId gen = BdUniqueId.gen();
        this.h = gen;
        hv4 hv4Var = new hv4(gen);
        this.i = hv4Var;
        hv4Var.w(this.t);
        bv4 bv4Var = new bv4(this.h);
        this.j = bv4Var;
        bv4Var.g(this.s);
        new dv4(this.h);
        this.r.setTag(this.h);
        MessageManager.getInstance().registerListener(this.r);
        this.q.setTag(this.h);
        MessageManager.getInstance().registerListener(this.q);
        this.p.setPriority(Integer.MIN_VALUE);
        this.p.setTag(this.h);
        MessageManager.getInstance().registerListener(this.p);
        ba5.e().f();
        ou4.c().d(this.h);
        R();
        if (A()) {
            new k(this, null).execute(new Void[0]);
        }
    }

    public /* synthetic */ bu4(a aVar) {
        this();
    }

    public final void G(au4 au4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, au4Var) == null) {
            t(au4Var);
            new i(this, null).execute(au4Var);
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.o = z;
        }
    }

    public final void T(au4 au4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, au4Var) == null) {
            U(au4Var);
            new m(this, null).execute(au4Var);
        }
    }

    public boolean y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            List<au4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void H(au4 au4Var, au4 au4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, au4Var, au4Var2) == null) {
            t(au4Var2);
            new j(this, null).execute(new Pair(au4Var, au4Var2));
        }
    }

    public static final bu4 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return l.a;
        }
        return (bu4) invokeV.objValue;
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return TbadkCoreApplication.getInst().isMainProcess(true);
        }
        return invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int q = da5.p().q("app_restart_times", 0);
            if (TbSingleton.getInstance().isNewUserRedPackageShowed() || q <= 1) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e.compareAndSet(true, false);
            this.d.f(0);
            this.d.h(0L);
            this.d.g(0L);
            hv4 hv4Var = this.i;
            if (hv4Var != null) {
                hv4Var.m();
            }
        }
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j == null || !A() || !this.g) {
                return false;
            }
            this.j.f(z(), C(), 1);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j == null || A()) {
                return false;
            }
            this.j.f(z(), C(), 1);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.a.scheduleWithFixedDelay(this.d, 0L, 1L, TimeUnit.SECONDS);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return UtilHelper.isSameDay(da5.p().r("pref_key_last_active_config", 0L), System.currentTimeMillis());
        }
        return invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return UtilHelper.isSameDay(x(), System.currentTimeMillis());
        }
        return invokeV.booleanValue;
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public final long x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            long r = da5.p().r("pref_key_active_config_info", 0L);
            this.n = r;
            return r;
        }
        return invokeV.longValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return !r();
        }
        return invokeV.booleanValue;
    }

    public final boolean B(au4 au4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, au4Var)) == null) {
            if (au4Var == null) {
                return false;
            }
            int[] h2 = au4Var.h();
            if (h2 == null) {
                return true;
            }
            for (int i2 : h2) {
                List<au4> list = this.b.get(i2);
                if (list == null) {
                    return false;
                }
                for (au4 au4Var2 : list) {
                    if (au4Var2 != null && au4Var2.d() == au4Var.d() && au4Var2.q() == au4Var.q()) {
                        if (au4Var2.N()) {
                            H(au4Var, au4Var2);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final au4 u(au4 au4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, au4Var)) == null) {
            if (au4Var == null) {
                return null;
            }
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                List<au4> valueAt = this.b.valueAt(i2);
                if (valueAt != null && !valueAt.isEmpty()) {
                    for (au4 au4Var2 : valueAt) {
                        if (au4Var2 != null && au4Var2.d() == au4Var.d() && au4Var2.q() == au4Var.q()) {
                            return au4Var2;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return (au4) invokeL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            List<au4> list = this.b.get(au4.Y);
            if (ListUtils.isEmpty(list)) {
                return;
            }
            boolean z = false;
            for (au4 au4Var : list) {
                Iterator<gu4> it = au4Var.n().iterator();
                while (it.hasNext()) {
                    gu4 next = it.next();
                    if (next instanceof ku4) {
                        ku4 ku4Var = (ku4) next;
                        if (!next.e()) {
                            ku4Var.i();
                            z = true;
                        }
                    }
                }
            }
            if (z && !this.e.get()) {
                this.d.f(au4.Y);
                this.e.compareAndSet(false, true);
                synchronized (this.e) {
                    this.e.notify();
                }
            }
        }
    }

    public final void K(au4 au4Var) {
        int[] h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, au4Var) == null) {
            for (int i2 : au4Var.h()) {
                List<au4> list = this.b.get(i2);
                if (list == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(au4Var);
                    this.b.put(i2, linkedList);
                } else {
                    list.add(au4Var);
                }
            }
        }
    }

    public void m(au4 au4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, au4Var) != null) || au4Var == null) {
            return;
        }
        if (au4Var.x() == 9) {
            ou4.c().f(au4Var);
        } else if (!this.f) {
            this.c.add(au4Var);
        } else if (B(au4Var)) {
        } else {
            K(au4Var);
            new g(this, null).execute(au4Var);
        }
    }

    public void L(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) != null) || !A()) {
            return;
        }
        this.m = i2;
        long j3 = this.l;
        if (j3 > 0 && this.k > 0 && (j2 == 0 || j2 != j3)) {
            S(this.k, this.l);
            this.l = 0L;
            this.k = 0;
        }
        N();
    }

    public void N() {
        int i2;
        List<au4> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && A() && this.f && (list = this.b.get((i2 = au4.Y))) != null && !list.isEmpty()) {
            boolean z = false;
            for (au4 au4Var : list) {
                if (au4Var.x() == 8) {
                    Iterator<gu4> it = au4Var.n().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        gu4 next = it.next();
                        au4 c2 = next.c();
                        if (c2 != null && (next instanceof ku4) && c2.d() == au4Var.d() && c2.q() == au4Var.q()) {
                            ((ku4) next).i();
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        ku4 ku4Var = new ku4(au4Var);
                        ku4Var.g(0L);
                        ku4Var.f(false);
                        au4Var.a(ku4Var);
                    }
                }
            }
            this.d.f(i2);
            this.e.compareAndSet(false, true);
            synchronized (this.e) {
                this.e.notify();
            }
        }
    }

    public void O(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i2) == null) && A() && i2 != 0 && this.f) {
            this.k = i2;
            List<au4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                boolean z = false;
                for (au4 au4Var : list) {
                    if (au4Var.x() == 4) {
                        Iterator<gu4> it = au4Var.n().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            gu4 next = it.next();
                            if ((next instanceof hu4) && next.c().d() == au4Var.d() && next.c().q() == au4Var.q()) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            hu4 hu4Var = new hu4(au4Var);
                            hu4Var.g(0L);
                            hu4Var.f(false);
                            au4Var.a(hu4Var);
                        }
                    }
                }
                this.d.f(i2);
                this.e.compareAndSet(false, true);
                synchronized (this.e) {
                    this.e.notify();
                }
            }
        }
    }

    public final void t(au4 au4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, au4Var) != null) || au4Var == null) {
            return;
        }
        Iterator<gu4> it = au4Var.n().iterator();
        while (it.hasNext()) {
            gu4 next = it.next();
            if (next != null && next.c() != null) {
                au4 c2 = next.c();
                if (c2.d() == au4Var.d() && c2.q() == au4Var.q()) {
                    it.remove();
                }
            }
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            List<au4> valueAt = this.b.valueAt(i2);
            if (valueAt != null && !valueAt.isEmpty()) {
                Iterator<au4> it2 = valueAt.iterator();
                while (it2.hasNext()) {
                    au4 next2 = it2.next();
                    if (next2 != null && next2.d() == au4Var.d() && next2.q() == au4Var.q()) {
                        it2.remove();
                    }
                }
            }
        }
        zt4.a("deleteActivityMissionInfoDataInMemory-->activityId=" + au4Var.d() + ",missionId=" + au4Var.q());
    }

    public void P(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && A() && i2 != 0 && j2 != 0 && this.f) {
            this.k = i2;
            List<au4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                boolean z = false;
                for (au4 au4Var : list) {
                    if (au4Var.x() == 2) {
                        Iterator<gu4> it = au4Var.n().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            gu4 next = it.next();
                            if ((next instanceof iu4) && next.c().d() == au4Var.d() && next.c().q() == au4Var.q() && ((iu4) next).i() == j2) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            iu4 iu4Var = new iu4(au4Var, j2);
                            iu4Var.g(0L);
                            iu4Var.f(false);
                            iu4Var.h(au4Var.w());
                            au4Var.a(iu4Var);
                        }
                    }
                }
                this.d.f(i2);
                this.d.g(j2);
                this.e.compareAndSet(false, true);
                synchronized (this.e) {
                    this.e.notify();
                }
            }
        }
    }

    public void Q(int i2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && A() && i2 != 0 && j2 != 0 && this.f) {
            this.k = i2;
            List<au4> list = this.b.get(i2);
            if (list != null && !list.isEmpty()) {
                for (au4 au4Var : list) {
                    if (au4Var.x() == 1) {
                        p(au4Var, j2);
                    } else if (au4Var.x() == 7 && !au4Var.K(j2)) {
                        o(au4Var, j2);
                    }
                }
                this.d.f(i2);
                this.d.h(j2);
                this.l = j2;
                this.e.compareAndSet(false, true);
                synchronized (this.e) {
                    this.e.notify();
                }
            }
        }
    }

    public void S(int i2, long j2) {
        List<au4> list;
        ju4 ju4Var;
        au4 c2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (list = this.b.get(i2)) != null && !list.isEmpty()) {
            for (au4 au4Var : list) {
                if (au4Var.x() == 7) {
                    Iterator<gu4> it = au4Var.n().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            gu4 next = it.next();
                            if ((next instanceof ju4) && (c2 = (ju4Var = (ju4) next).c()) != null && ju4Var.i() == j2 && c2.d() == au4Var.d() && c2.q() == au4Var.q()) {
                                next.f(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public final void o(au4 au4Var, long j2) {
        boolean z;
        ju4 ju4Var;
        au4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048599, this, au4Var, j2) == null) {
            Iterator<gu4> it = au4Var.n().iterator();
            while (true) {
                if (it.hasNext()) {
                    gu4 next = it.next();
                    if ((next instanceof ju4) && (c2 = (ju4Var = (ju4) next).c()) != null && ju4Var.i() == j2 && c2.d() == au4Var.d() && c2.q() == au4Var.q()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                ju4 ju4Var2 = new ju4(au4Var, j2);
                ju4Var2.g(0L);
                ju4Var2.f(false);
                ju4Var2.h(au4Var.w());
                au4Var.a(ju4Var2);
            }
        }
    }

    public final void p(au4 au4Var, long j2) {
        boolean z;
        lu4 lu4Var;
        au4 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048600, this, au4Var, j2) == null) {
            Iterator<gu4> it = au4Var.n().iterator();
            while (true) {
                if (it.hasNext()) {
                    gu4 next = it.next();
                    if ((next instanceof lu4) && (c2 = (lu4Var = (lu4) next).c()) != null && lu4Var.i() == j2 && c2.d() == au4Var.d() && c2.q() == au4Var.q()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                lu4 lu4Var2 = new lu4(au4Var, j2);
                lu4Var2.g(0L);
                lu4Var2.f(false);
                lu4Var2.h(au4Var.w());
                au4Var.a(lu4Var2);
            }
        }
    }

    public final void U(au4 au4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, au4Var) != null) || au4Var == null) {
            return;
        }
        int x = au4Var.x();
        Iterator<gu4> it = au4Var.n().iterator();
        while (it.hasNext()) {
            gu4 next = it.next();
            if (next != null && next.c() != null) {
                au4 c2 = next.c();
                if (c2.d() == au4Var.d() && c2.q() == au4Var.q()) {
                    if (x == 7 && (next instanceof ju4)) {
                        ((ju4) next).f(true);
                    } else if (x == 1 && (next instanceof lu4)) {
                        ((lu4) next).f(true);
                    }
                }
            }
        }
        au4Var.d0(false);
    }

    public void n(List<au4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (!this.f) {
            this.c.addAll(list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (au4 au4Var : list) {
            if (au4Var != null) {
                if (au4Var.x() == 9) {
                    ou4.c().f(au4Var);
                } else if (!B(au4Var)) {
                    K(au4Var);
                    arrayList.add(au4Var);
                }
            }
        }
        new h(this, null).execute(arrayList);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.j == null || !A() || !this.g) {
            return;
        }
        if (!s() || D()) {
            this.j.f(z(), C(), 0);
        }
    }
}
