package com.baidu.tieba;

import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.sh8;
import com.baidu.tieba.z78;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d78 implements z78.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonCenterModel a;
    public z78 b;
    public PersonCenterModel.d c;
    public CustomMessageListener d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;

    /* loaded from: classes3.dex */
    public class a implements PersonCenterModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d78 a;

        /* renamed from: com.baidu.tieba.d78$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0236a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g78 a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            public RunnableC0236a(a aVar, g78 g78Var, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, g78Var, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = g78Var;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String b = this.a.b();
                    if (!StringUtils.isNull(b) && this.c.a.b != null && !this.c.a.b.J()) {
                        ky4.k().w(this.b, this.a.a());
                        this.c.a.b.F(b);
                    } else if (this.c.a.b != null) {
                        this.c.a.b.G(this.a.a());
                    }
                }
            }
        }

        public a(d78 d78Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d78Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d78Var;
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.d
        public void a(k78 k78Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k78Var) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.a.b != null) {
                    this.a.b.r();
                    this.a.b.B(k78Var);
                }
                if (k78Var != null && k78Var.y() != null) {
                    hr4.b(k78Var.y().getPersonPrivate());
                }
                q68.d().i(System.currentTimeMillis() - currentTimeMillis);
                long e = q68.d().e();
                if (e > 0) {
                    q68.d().k(System.currentTimeMillis() - e);
                    q68.d().j(0L);
                }
                g78 t = this.a.a.D().t();
                UserData y = this.a.a.D().y();
                if (t != null && y != null) {
                    String str = "key_record_bubble_info_id_" + y.getUserId();
                    int l = ky4.k().l(str, -1);
                    if (t.a() > 0 && t.a() != l) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        zg.a().postDelayed(new RunnableC0236a(this, t, str), 501L);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.d
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && i == -1 && !this.a.a.mIsDataLoaded && this.a.b != null) {
                this.a.b.H();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d78 d78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d78Var, Integer.valueOf(i)};
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
            this.a = d78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            sh8 sh8Var;
            SparseArray<sh8.a> sparseArray;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof sh8) && (sparseArray = (sh8Var = (sh8) customResponsedMessage.getData()).a) != null && sparseArray.size() > 0) {
                sh8.a aVar = sh8Var.a.get(2);
                sh8.a aVar2 = sh8Var.a.get(3);
                sh8.a aVar3 = sh8Var.a.get(9);
                sh8.a aVar4 = sh8Var.a.get(10);
                if (this.a.a.D() != null) {
                    if (aVar2 != null) {
                        this.a.a.D().g(aVar2.a);
                    }
                    if (aVar != null) {
                        this.a.a.D().e(aVar.a);
                    }
                    if (aVar3 != null) {
                        this.a.a.D().d(aVar3.a);
                    }
                    if (aVar4 != null) {
                        this.a.a.D().f(aVar4.a);
                    }
                }
                sh8.a aVar5 = sh8Var.a.get(5);
                if (aVar5 != null && this.a.b != null) {
                    this.a.b.I(5, aVar5.a);
                }
                if (this.a.b != null) {
                    this.a.b.u();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d78 d78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d78Var, Integer.valueOf(i)};
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
            this.a = d78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserPendantData userPendantData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData) && (userPendantData = (UserPendantData) customResponsedMessage.getData()) != null) {
                if (this.a.a.D() != null) {
                    this.a.a.D().E(userPendantData);
                    if (this.a.b != null) {
                        this.a.b.u();
                        return;
                    }
                    return;
                }
                this.a.j();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(d78 d78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d78Var, Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            PersonRedTipManager.getInstance().setIsPrimary(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d78 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d78 d78Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d78Var, Integer.valueOf(i)};
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
            this.a = d78Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int w;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921744 && this.a.a != null && this.a.a.D() != null && (w = this.a.a.D().w()) != -1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921739, Integer.valueOf(w)));
            }
        }
    }

    public d78(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new a(this);
        this.d = new b(this, 2001435);
        this.e = new c(this, 2016485);
        this.f = new d(this, 2005016);
        this.g = new e(this, 2921744);
        z78 z78Var = new z78(view2, tbPageContext, bdUniqueId);
        this.b = z78Var;
        z78Var.D(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.a = personCenterModel;
        personCenterModel.J(this.c);
        PersonRedTipManager.getInstance();
        this.d.setTag(bdUniqueId);
        this.f.setTag(bdUniqueId);
        this.g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.d);
        MessageManager.getInstance().registerListener(this.f);
        MessageManager.getInstance().registerListener(this.g);
        this.e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.e);
    }

    @Override // com.baidu.tieba.z78.g
    public void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            this.a.loadData();
        }
    }

    public void e(int i) {
        z78 z78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (z78Var = this.b) != null) {
            z78Var.v(i);
        }
    }

    public void i(String str) {
        k78 D;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (D = this.a.D()) != null && D.y() != null) {
            D.y().setName_show(str);
            z78 z78Var = this.b;
            if (z78Var != null) {
                z78Var.u();
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.a.K(z);
            z78 z78Var = this.b;
            if (z78Var != null) {
                z78Var.y(z);
            }
        }
    }

    public void d() {
        z78 z78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (z78Var = this.b) != null) {
            z78Var.s();
        }
    }

    public void f() {
        z78 z78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (z78Var = this.b) != null) {
            z78Var.w();
            this.b = null;
        }
    }

    public void g() {
        z78 z78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (z78Var = this.b) != null) {
            z78Var.x();
        }
    }

    public void h() {
        z78 z78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (z78Var = this.b) != null) {
            z78Var.z();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            q68.d().j(System.currentTimeMillis());
            this.a.loadData();
        }
    }
}
