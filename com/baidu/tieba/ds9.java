package com.baidu.tieba;

import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.account.helper.UserPrivateHelper;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tieba.bt9;
import com.baidu.tieba.p5a;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ds9 implements bt9.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonCenterModel a;
    public bt9 b;
    public PersonCenterModel.d c;
    public CustomMessageListener d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;

    /* loaded from: classes5.dex */
    public class a implements PersonCenterModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ds9 a;

        /* renamed from: com.baidu.tieba.ds9$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0271a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ hs9 a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            public RunnableC0271a(a aVar, hs9 hs9Var, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, hs9Var, str};
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
                this.a = hs9Var;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String b = this.a.b();
                    if (!StringUtils.isNull(b) && this.c.a.b != null && !this.c.a.b.J()) {
                        SharedPrefHelper.getInstance().putInt(this.b, this.a.a());
                        this.c.a.b.F(b);
                    } else if (this.c.a.b != null) {
                        this.c.a.b.G(this.a.a());
                    }
                }
            }
        }

        public a(ds9 ds9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ds9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ds9Var;
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.d
        public void a(ls9 ls9Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ls9Var) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.a.b != null) {
                    this.a.b.r();
                    this.a.b.B(ls9Var);
                }
                if (ls9Var != null && ls9Var.A() != null) {
                    UserPrivateHelper.init(ls9Var.A().getPersonPrivate());
                }
                qr9.d().i(System.currentTimeMillis() - currentTimeMillis);
                long e = qr9.d().e();
                if (e > 0) {
                    qr9.d().k(System.currentTimeMillis() - e);
                    qr9.d().j(0L);
                }
                hs9 v = this.a.a.R().v();
                UserData A = this.a.a.R().A();
                if (v != null && A != null) {
                    String str = "key_record_bubble_info_id_" + A.getUserId();
                    int i = SharedPrefHelper.getInstance().getInt(str, -1);
                    if (v.a() > 0 && v.a() != i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        SafeHandler.getInst().postDelayed(new RunnableC0271a(this, v, str), 501L);
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

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ds9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ds9 ds9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ds9Var, Integer.valueOf(i)};
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
            this.a = ds9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            p5a p5aVar;
            SparseArray<p5a.a> sparseArray;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof p5a) && (sparseArray = (p5aVar = (p5a) customResponsedMessage.getData()).a) != null && sparseArray.size() > 0) {
                p5a.a aVar = p5aVar.a.get(2);
                p5a.a aVar2 = p5aVar.a.get(3);
                p5a.a aVar3 = p5aVar.a.get(9);
                p5a.a aVar4 = p5aVar.a.get(10);
                if (this.a.a.R() != null) {
                    if (aVar2 != null) {
                        this.a.a.R().g(aVar2.a);
                    }
                    if (aVar != null) {
                        this.a.a.R().e(aVar.a);
                    }
                    if (aVar3 != null) {
                        this.a.a.R().d(aVar3.a);
                    }
                    if (aVar4 != null) {
                        this.a.a.R().f(aVar4.a);
                    }
                }
                p5a.a aVar5 = p5aVar.a.get(5);
                if (aVar5 != null && this.a.b != null) {
                    this.a.b.I(5, aVar5.a);
                }
                if (this.a.b != null) {
                    this.a.b.u();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ds9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ds9 ds9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ds9Var, Integer.valueOf(i)};
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
            this.a = ds9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserPendantData userPendantData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData) && (userPendantData = (UserPendantData) customResponsedMessage.getData()) != null) {
                if (this.a.a.R() != null) {
                    this.a.a.R().G(userPendantData);
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

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ds9 ds9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ds9Var, Integer.valueOf(i)};
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

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ds9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ds9 ds9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ds9Var, Integer.valueOf(i)};
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
            this.a = ds9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int y;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921744 && this.a.a != null && this.a.a.R() != null && (y = this.a.a.R().y()) != -1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921739, Integer.valueOf(y)));
            }
        }
    }

    public ds9(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        bt9 bt9Var = new bt9(view2, tbPageContext, bdUniqueId);
        this.b = bt9Var;
        bt9Var.D(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.a = personCenterModel;
        personCenterModel.X(this.c);
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

    @Override // com.baidu.tieba.bt9.g
    public void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            this.a.loadData();
        }
    }

    public void e(int i) {
        bt9 bt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (bt9Var = this.b) != null) {
            bt9Var.v(i);
        }
    }

    public void i(String str) {
        ls9 R;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (R = this.a.R()) != null && R.A() != null) {
            R.A().setName_show(str);
            bt9 bt9Var = this.b;
            if (bt9Var != null) {
                bt9Var.u();
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.a.Y(z);
            bt9 bt9Var = this.b;
            if (bt9Var != null) {
                bt9Var.y(z);
            }
        }
    }

    public void d() {
        bt9 bt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bt9Var = this.b) != null) {
            bt9Var.s();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            bt9 bt9Var = this.b;
            if (bt9Var != null) {
                bt9Var.w();
                this.b = null;
            }
            PersonCenterModel personCenterModel = this.a;
            if (personCenterModel != null) {
                personCenterModel.X(null);
                this.c = null;
            }
        }
    }

    public void g() {
        bt9 bt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bt9Var = this.b) != null) {
            bt9Var.x();
        }
    }

    public void h() {
        bt9 bt9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (bt9Var = this.b) != null) {
            bt9Var.z();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            qr9.d().j(System.currentTimeMillis());
            this.a.loadData();
        }
    }
}
