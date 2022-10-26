package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.profession.permission.FrsProfessionPermissionModel;
import com.baidu.tieba.pu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class er6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public FrsProfessionPermissionModel b;
    public cr6 c;
    public d d;
    public int e;

    /* loaded from: classes3.dex */
    public interface d {
        void a(boolean z, int i);

        void b(boolean z);

        void c(boolean z);
    }

    /* loaded from: classes3.dex */
    public class a implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ pu4 b;
        public final /* synthetic */ er6 c;

        public a(er6 er6Var, String str, pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {er6Var, str, pu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = er6Var;
            this.a = str;
            this.b = pu4Var;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.c.a.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu4 a;

        public b(er6 er6Var, pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {er6Var, pu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pu4Var;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu4 a;

        public c(er6 er6Var, pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {er6Var, pu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pu4Var;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    public er6(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        cr6 cr6Var = new cr6();
        this.c = cr6Var;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, cr6Var);
        this.b = frsProfessionPermissionModel;
        frsProfessionPermissionModel.b0(this);
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            pu4 pu4Var = new pu4(this.a.getPageActivity());
            pu4Var.setCanceledOnTouchOutside(false);
            pu4Var.setCancelable(false);
            pu4Var.setMessage(str);
            pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09c4, new c(this, pu4Var));
            pu4Var.create(this.a);
            pu4Var.show();
        }
    }

    public final void b(dr6 dr6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, dr6Var) == null) && dr6Var != null && dr6Var.b == 0) {
            if (!dr6Var.a && dr6Var.d == 2) {
                l(dr6Var.e);
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.c(dr6Var.a);
            }
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            cr6 cr6Var = this.c;
            cr6Var.d = 1;
            cr6Var.c = str;
            e();
        }
    }

    public void i(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.d = dVar;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.e = i;
            this.c.e = i;
        }
    }

    public final void c(dr6 dr6Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dr6Var, str) != null) || dr6Var == null) {
            return;
        }
        if (dr6Var.b != 0) {
            if (StringUtils.isNull(dr6Var.c)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c68);
                return;
            } else {
                this.a.showToast(dr6Var.c);
                return;
            }
        }
        if (!dr6Var.a) {
            int i = dr6Var.d;
            if (i == 1) {
                k(dr6Var.e, str);
            } else if (i == 3) {
                l(dr6Var.e);
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(dr6Var.a);
        }
    }

    public final void d(dr6 dr6Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, dr6Var, i) != null) || dr6Var == null) {
            return;
        }
        if (dr6Var.b != 0) {
            if (StringUtils.isNull(dr6Var.c)) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c68);
                return;
            } else {
                this.a.showToast(dr6Var.c);
                return;
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(dr6Var.a, i);
        }
    }

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            pu4 pu4Var = new pu4(this.a.getPageActivity());
            pu4Var.setCanceledOnTouchOutside(false);
            pu4Var.setCancelable(false);
            pu4Var.setMessage(str);
            pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0411, new a(this, str2, pu4Var));
            pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0410, new b(this, pu4Var));
            pu4Var.create(this.a);
            pu4Var.show();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !this.b.T()) {
            this.b.loadData();
        }
    }

    public void g(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j) == null) {
            if (UbsABTestHelper.isNotRequestProPermission()) {
                this.d.b(true);
                return;
            }
            cr6 cr6Var = this.c;
            cr6Var.c = str;
            cr6Var.b = j;
            cr6Var.d = 3;
            e();
        }
    }

    public void h(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) {
            if (UbsABTestHelper.isNotRequestProPermission()) {
                this.d.a(true, i);
                return;
            }
            cr6 cr6Var = this.c;
            cr6Var.a = i;
            cr6Var.c = str;
            cr6Var.d = 2;
            e();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof cr6) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof dr6)) {
            cr6 cr6Var = (cr6) mvcNetMessage.getRequestData();
            dr6 dr6Var = (dr6) mvcSocketResponsedMessage.getData();
            if (cr6Var.e != this.e) {
                return;
            }
            int i = cr6Var.d;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        c(dr6Var, cr6Var.c);
                        return;
                    }
                    return;
                }
                d(dr6Var, cr6Var.a);
                return;
            }
            b(dr6Var);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof cr6) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof dr6)) {
            cr6 cr6Var = (cr6) mvcNetMessage.getRequestData();
            dr6 dr6Var = (dr6) mvcHttpResponsedMessage.getData();
            if (cr6Var.e != this.e) {
                return;
            }
            int i = cr6Var.d;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        c(dr6Var, cr6Var.c);
                        return;
                    }
                    return;
                }
                d(dr6Var, cr6Var.a);
                return;
            }
            b(dr6Var);
        }
    }
}
