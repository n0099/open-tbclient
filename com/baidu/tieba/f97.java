package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.vc.FrsTabViewController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class f97 extends k57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w67 h;
    public boolean i;
    public HashMap<Integer, vw6> j;
    public boolean k;
    public CustomMessageListener l;
    public final CustomMessageListener m;
    public final CustomMessageListener n;
    public final CustomMessageListener o;
    public final CustomMessageListener p;
    public ox6 q;

    /* loaded from: classes4.dex */
    public class f implements ox6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f97 a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.a.m0() != null && this.a.a.f != null && this.a.a.a.m0().getVisibility() != 0) {
                    this.a.a.f.o();
                }
            }
        }

        public f(f97 f97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f97Var;
        }

        @Override // com.baidu.tieba.ox6
        public void f1() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.i = true;
            if (this.a.a != null && this.a.f != null && this.a.d != null && this.a.b != null && this.a.b.isAdded()) {
                if (this.a.a != null && this.a.a.o0() != null) {
                    this.a.a.o0().y();
                }
                this.a.b.P4(false);
                jg.a().postDelayed(new a(this), 110L);
                this.a.a.z1(1, true);
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.b.refresh();
                    this.a.b.P4(true);
                } else {
                    this.a.b.d5();
                }
                TiebaStatic.log(new StatisticItem("c11749").param("fid", this.a.b.O()).param("obj_locate", "1"));
            }
        }

        @Override // com.baidu.tieba.ox6
        public void g0() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.b != null && this.a.b.isAdded()) {
                if (this.a.i && this.a.b.P3() != null) {
                    if (!this.a.k) {
                        this.a.b.P3().i0();
                    }
                    this.a.i = false;
                }
                if (this.a.h != null && this.a.b.v1() != null && this.a.b.v1().c0() != null && !this.a.b.v1().c0().l() && this.a.b.P3() != null && !this.a.b.P3().Y()) {
                    this.a.h.b();
                }
                if (this.a.a != null && this.a.f != null && this.a.d != null && this.a.h != null) {
                    this.a.a.o0().n(0, 0, true, true);
                    this.a.b.x4();
                    this.a.b.P4(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                    if (!TbadkCoreApplication.isLogin() || this.a.b.I3().getVisibility() != 0 || ListUtils.isEmpty(this.a.b.W0().getThreadList())) {
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f97 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f97 f97Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f97Var, Integer.valueOf(i)};
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
            this.a = f97Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.k = false;
                return;
            }
            this.a.k = true;
            this.a.b.P3().O();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f97 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f97 f97Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f97Var, Integer.valueOf(i)};
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
            this.a = f97Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.a != null) {
                this.a.a.b2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f97 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(f97 f97Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f97Var, Integer.valueOf(i)};
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
            this.a = f97Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof vw6)) {
                this.a.a.d2();
                vw6 vw6Var = (vw6) customResponsedMessage.getData();
                ox6 ox6Var = vw6Var.b;
                if (ox6Var == null) {
                    int i = vw6Var.a;
                    if (i == 1) {
                        f97 f97Var = this.a;
                        f97Var.Z(i, f97Var.q);
                    } else {
                        this.a.Z(i, null);
                    }
                } else {
                    this.a.Z(vw6Var.a, ox6Var);
                }
                this.a.c0(vw6Var.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f97 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(f97 f97Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f97Var, Integer.valueOf(i)};
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
            this.a = f97Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof vw6)) {
                vw6 vw6Var = (vw6) customResponsedMessage.getData();
                this.a.a0(vw6Var.a, vw6Var.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f97 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(f97 f97Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f97Var, Integer.valueOf(i)};
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
            this.a = f97Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ow6)) {
                ow6 ow6Var = (ow6) customResponsedMessage.getData();
                this.a.b0(ow6Var.a, ow6Var.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f97(FrsFragment frsFragment) {
        super(frsFragment);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((FrsFragment) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.k = false;
        this.l = new a(this, 2921468);
        this.m = new b(this, 2003003);
        this.n = new c(this, 2921448);
        this.o = new d(this, 9205410);
        this.p = new e(this, 2921449);
        this.q = new f(this);
        this.h = frsFragment.D3();
        this.j = new HashMap<>();
        this.a.n1(1);
        frsFragment.registerListener(this.m);
        frsFragment.registerListener(this.n);
        frsFragment.registerListener(this.o);
        frsFragment.registerListener(this.p);
        frsFragment.registerListener(this.l);
    }

    public final void b0(int i, boolean z) {
        kw6 kw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (kw6Var = this.a) != null) {
            kw6Var.z1(i, z);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.a == null) {
            return;
        }
        j97 j97Var = this.c;
        if ((j97Var instanceof FrsTabViewController) && ((FrsTabViewController) j97Var).B() != null && (((FrsTabViewController) this.c).B().b instanceof ox6)) {
            FrsTabViewController.i B = ((FrsTabViewController) this.c).B();
            Z(B.a, (ox6) B.b);
            c0(B.a);
            return;
        }
        this.a.v1(this.q);
    }

    public final void Z(int i, ox6 ox6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, ox6Var) == null) {
            vw6 vw6Var = this.j.get(Integer.valueOf(i));
            if (vw6Var == null) {
                vw6 vw6Var2 = new vw6();
                vw6Var2.a = i;
                vw6Var2.b = ox6Var;
                this.j.put(Integer.valueOf(i), vw6Var2);
            } else {
                vw6Var.b = ox6Var;
            }
            kw6 kw6Var = this.a;
            if (kw6Var != null) {
                kw6Var.v1(ox6Var);
            }
        }
    }

    public final void a0(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            vw6 vw6Var = this.j.get(Integer.valueOf(i));
            if (vw6Var == null) {
                vw6 vw6Var2 = new vw6();
                vw6Var2.a = i;
                vw6Var2.c = z;
                this.j.put(Integer.valueOf(i), vw6Var2);
            } else {
                vw6Var.c = z;
            }
            kw6 kw6Var = this.a;
            if (kw6Var != null) {
                kw6Var.K1(z);
            }
        }
    }

    public final void c0(int i) {
        vw6 vw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && this.a != null && (vw6Var = this.j.get(Integer.valueOf(i))) != null) {
            this.a.n1(i);
            this.a.v1(vw6Var.b);
            this.a.K1(vw6Var.c);
            if (vw6Var.b == null) {
                this.a.K1(false);
            }
        }
    }
}
