package com.baidu.tieba;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdDimDialog;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.stamp.view.NewStyleStampDialogView;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class fka extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final eja b;

    /* loaded from: classes5.dex */
    public class a implements bda<yca> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fka a;

        /* renamed from: com.baidu.tieba.fka$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0292a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ yca a;
            public final /* synthetic */ a b;

            public RunnableC0292a(a aVar, yca ycaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ycaVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = ycaVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                yca ycaVar;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ycaVar = this.a) != null) {
                    this.b.a.l(ycaVar);
                }
            }
        }

        public a(fka fkaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fkaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bda
        /* renamed from: b */
        public void a(yca ycaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ycaVar) == null) {
                this.a.a.runOnUiThread(new RunnableC0292a(this, ycaVar));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdDimDialog a;

        public b(fka fkaVar, BdDimDialog bdDimDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fkaVar, bdDimDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdDimDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdDimDialog a;
        public final /* synthetic */ fka b;

        public c(fka fkaVar, BdDimDialog bdDimDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fkaVar, bdDimDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fkaVar;
            this.a = bdDimDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
                UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount()});
                this.b.m();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdDimDialog a;
        public final /* synthetic */ yca b;
        public final /* synthetic */ fka c;

        public d(fka fkaVar, BdDimDialog bdDimDialog, yca ycaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fkaVar, bdDimDialog, ycaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fkaVar;
            this.a = bdDimDialog;
            this.b = ycaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
                ada adaVar = new ada();
                yca ycaVar = this.b;
                if (ycaVar != null) {
                    adaVar.g(ycaVar.a());
                    adaVar.h(this.b.b());
                }
                new zca(this.c.a, adaVar).a();
                this.c.o();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fka(MainTabActivity mainTabActivity, qia qiaVar) {
        super(2001384);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, qiaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = mainTabActivity.e;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MainTabActivity mainTabActivity = this.a;
            if (mainTabActivity.D == null) {
                mainTabActivity.D = new eda(mainTabActivity.getPageContext(), new a(this));
            }
            this.a.D.b();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 2).param("obj_source", 3).param("obj_locate", 3));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 1).param("obj_source", 3).param("obj_locate", 3));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK).param("obj_locate", 31));
        }
    }

    public final void l(yca ycaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ycaVar) == null) && !this.a.E && TbadkCoreApplication.isLogin() && this.a.y.intValue() == 8) {
            NewStyleStampDialogView newStyleStampDialogView = new NewStyleStampDialogView(this.a);
            newStyleStampDialogView.setStampData(ycaVar);
            BdDimDialog bdDimDialog = new BdDimDialog(this.a);
            bdDimDialog.setContentView(newStyleStampDialogView);
            bdDimDialog.show();
            n();
            this.a.E = true;
            newStyleStampDialogView.getImgStampDialogCancelView().setOnClickListener(new b(this, bdDimDialog));
            newStyleStampDialogView.getStampDialogLookView().setOnClickListener(new c(this, bdDimDialog));
            newStyleStampDialogView.getStampDialogShareView().setOnClickListener(new d(this, bdDimDialog, ycaVar));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        eja ejaVar;
        eja ejaVar2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = this.a.y.intValue();
            this.a.y = (Integer) customResponsedMessage.getData();
            if (this.a.y.intValue() == 1) {
                eja ejaVar3 = this.b;
                if (ejaVar3 != null && ejaVar3.a() != null) {
                    this.b.a().a();
                }
            } else if (intValue == 1 && (ejaVar = this.b) != null && ejaVar.a() != null) {
                this.b.a().f();
            }
            if (this.a.y.intValue() == 21 && (ejaVar2 = this.b) != null && ejaVar2.a() != null) {
                this.b.a().c();
            }
            if (this.a.y.intValue() == 8) {
                tw5.d().k(true);
                eja ejaVar4 = this.b;
                if (ejaVar4 != null && ejaVar4.a() != null) {
                    this.b.a().b();
                }
                if (!this.a.E) {
                    k();
                }
                if (TbadkCoreApplication.isLogin() && !ow5.b()) {
                    MainTabActivity mainTabActivity = this.a;
                    if (mainTabActivity.J && mainTabActivity.I) {
                        new ow5().c(this.a.getPageContext().getPageActivity());
                        return;
                    }
                    return;
                }
                return;
            }
            tw5.d().k(false);
            eda edaVar = this.a.D;
            if (edaVar != null) {
                edaVar.a();
                this.a.D = null;
            }
        }
    }
}
