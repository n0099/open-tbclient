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
import com.baidu.tieba.kv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class at6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public FrsProfessionPermissionModel b;
    public ys6 c;
    public d d;
    public int e;

    /* loaded from: classes3.dex */
    public interface d {
        void a(boolean z, int i);

        void b(boolean z);

        void c(boolean z);
    }

    /* loaded from: classes3.dex */
    public class a implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kv4 b;
        public final /* synthetic */ at6 c;

        public a(at6 at6Var, String str, kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var, str, kv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = at6Var;
            this.a = str;
            this.b = kv4Var;
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(this.c.a.getPageActivity());
                membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.a);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
                this.b.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv4 a;

        public b(at6 at6Var, kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var, kv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kv4Var;
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv4 a;

        public c(at6 at6Var, kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at6Var, kv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kv4Var;
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    public at6(TbPageContext<?> tbPageContext) {
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
        ys6 ys6Var = new ys6();
        this.c = ys6Var;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, ys6Var);
        this.b = frsProfessionPermissionModel;
        frsProfessionPermissionModel.b0(this);
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            kv4 kv4Var = new kv4(this.a.getPageActivity());
            kv4Var.setCanceledOnTouchOutside(false);
            kv4Var.setCancelable(false);
            kv4Var.setMessage(str);
            kv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09d4, new c(this, kv4Var));
            kv4Var.create(this.a);
            kv4Var.show();
        }
    }

    public final void b(zs6 zs6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, zs6Var) == null) && zs6Var != null && zs6Var.b == 0) {
            if (!zs6Var.a && zs6Var.d == 2) {
                l(zs6Var.e);
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.c(zs6Var.a);
            }
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            ys6 ys6Var = this.c;
            ys6Var.d = 1;
            ys6Var.c = str;
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

    public final void c(zs6 zs6Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zs6Var, str) != null) || zs6Var == null) {
            return;
        }
        if (zs6Var.b != 0) {
            if (StringUtils.isNull(zs6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c81);
                return;
            } else {
                this.a.showToast(zs6Var.c);
                return;
            }
        }
        if (!zs6Var.a) {
            int i = zs6Var.d;
            if (i == 1) {
                k(zs6Var.e, str);
            } else if (i == 3) {
                l(zs6Var.e);
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.b(zs6Var.a);
        }
    }

    public final void d(zs6 zs6Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, zs6Var, i) != null) || zs6Var == null) {
            return;
        }
        if (zs6Var.b != 0) {
            if (StringUtils.isNull(zs6Var.c)) {
                this.a.showToast((int) R.string.obfuscated_res_0x7f0f0c81);
                return;
            } else {
                this.a.showToast(zs6Var.c);
                return;
            }
        }
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(zs6Var.a, i);
        }
    }

    public final void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            kv4 kv4Var = new kv4(this.a.getPageActivity());
            kv4Var.setCanceledOnTouchOutside(false);
            kv4Var.setCancelable(false);
            kv4Var.setMessage(str);
            kv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0414, new a(this, str2, kv4Var));
            kv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0413, new b(this, kv4Var));
            kv4Var.create(this.a);
            kv4Var.show();
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
            ys6 ys6Var = this.c;
            ys6Var.c = str;
            ys6Var.b = j;
            ys6Var.d = 3;
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
            ys6 ys6Var = this.c;
            ys6Var.a = i;
            ys6Var.c = str;
            ys6Var.d = 2;
            e();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048587, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof ys6) && mvcSocketResponsedMessage != null && (mvcSocketResponsedMessage.getData() instanceof zs6)) {
            ys6 ys6Var = (ys6) mvcNetMessage.getRequestData();
            zs6 zs6Var = (zs6) mvcSocketResponsedMessage.getData();
            if (ys6Var.e != this.e) {
                return;
            }
            int i = ys6Var.d;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        c(zs6Var, ys6Var.c);
                        return;
                    }
                    return;
                }
                d(zs6Var, ys6Var.a);
                return;
            }
            b(zs6Var);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048588, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcNetMessage != null && (mvcNetMessage.getRequestData() instanceof ys6) && mvcHttpResponsedMessage != null && (mvcHttpResponsedMessage.getData() instanceof zs6)) {
            ys6 ys6Var = (ys6) mvcNetMessage.getRequestData();
            zs6 zs6Var = (zs6) mvcHttpResponsedMessage.getData();
            if (ys6Var.e != this.e) {
                return;
            }
            int i = ys6Var.d;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        c(zs6Var, ys6Var.c);
                        return;
                    }
                    return;
                }
                d(zs6Var, ys6Var.a);
                return;
            }
            b(zs6Var);
        }
    }
}
