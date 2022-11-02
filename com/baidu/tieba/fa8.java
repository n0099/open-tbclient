package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class fa8 extends z98 implements rq7, w98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public long c;
    public boolean d;
    public BdUniqueId e;
    public ba8 f;
    public zb8 g;
    public PersonPolymericModel h;
    public aa8 i;
    public BaseFragmentActivity j;
    public View k;
    public PersonPostModel l;
    public int m;
    public List<m68> n;

    @Override // com.baidu.tieba.w98
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fa8(BaseFragment baseFragment, ba8 ba8Var, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, ba8Var, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = true;
        this.m = 3;
        BaseFragmentActivity baseFragmentActivity = baseFragment.getBaseFragmentActivity();
        this.j = baseFragmentActivity;
        this.b = baseFragmentActivity.getPageContext();
        this.c = j;
        this.f = ba8Var;
        this.e = bdUniqueId;
        this.k = ba8Var.e;
        this.l = new PersonPostModel(this.b, bdUniqueId, null, this.a, PersonPostModel.FROM_PERSON_POLYMERIC);
        zb8 zb8Var = new zb8(baseFragment, ba8Var, bdUniqueId, z, this.c);
        this.g = zb8Var;
        zb8Var.W(this);
        resetData();
        this.h = this.f.p();
        this.i = this.f.k();
        ArrayList arrayList = new ArrayList(2);
        this.n = arrayList;
        arrayList.add(new m68());
        this.n.add(new m68());
    }

    @Override // com.baidu.tieba.rq7
    public void a() {
        ba8 ba8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ba8Var = this.f) != null) {
            ba8Var.a();
        }
    }

    @Override // com.baidu.tieba.rq7
    public void b() {
        ba8 ba8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (ba8Var = this.f) != null) {
            ba8Var.b();
        }
    }

    @Override // com.baidu.tieba.w98
    public zb8 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (zb8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.w98
    public void e() {
        zb8 zb8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (zb8Var = this.g) != null) {
            zb8Var.M();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            zb8 zb8Var = this.g;
            if (zb8Var != null) {
                zb8Var.U();
            }
        }
    }

    @Override // com.baidu.tieba.rq7
    public void resetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.resetThreadPn();
            PersonPolymericModel personPolymericModel = this.h;
            if (personPolymericModel != null) {
                personPolymericModel.N();
            }
        }
    }

    public void i(v09 v09Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, v09Var) == null) {
            this.g.X(v09Var);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || this.m == i) {
            return;
        }
        zb8 zb8Var = this.g;
        if (zb8Var != null) {
            zb8Var.T(i);
        }
        this.m = i;
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && z && this.d) {
            a();
        }
    }

    public void m() {
        boolean isBigV;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && TbadkCoreApplication.isLogin() && !this.a && this.c == TbadkCoreApplication.getCurrentAccountId()) {
            this.a = true;
            if (TbadkCoreApplication.getCurrentAccountInfo() == null) {
                isBigV = false;
            } else {
                isBigV = TbadkCoreApplication.getCurrentAccountInfo().isBigV();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.b.getPageActivity()).createNormalConfig(wg.g(TbadkCoreApplication.getCurrentAccount(), 0L), true, isBigV)));
            this.j.finish();
        }
    }

    public void n(ga8 ga8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ga8Var) == null) {
            this.g.N();
            this.j.hideLoadingView(this.k);
            boolean z = true;
            if (ga8Var == null) {
                this.i.w(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c7f), true);
                this.i.l();
                this.i.r(8);
                return;
            }
            this.i.n();
            if (ga8Var.e() != null && ((ga8Var.e().getHide_stat() == 1 && ga8Var.e().getBlock_stat() == 1) || (ga8Var.e().getHide_stat() == 1 && ga8Var.e().getBlock_stat() == 2))) {
                this.i.t(this.a);
                this.i.r(8);
                return;
            }
            this.i.r(0);
            ga8Var.b();
            z = (ga8Var.f() == null || ga8Var.f().size() < 20) ? false : false;
            if (ga8Var.j() != null) {
                ga8Var.j().getSex();
            }
            this.d = false;
            if (this.a && ga8Var.j() != null) {
                ga8Var.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                ga8Var.j().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                y85.d().i(ga8Var.j());
            }
            m68 m68Var = this.n.get(0);
            m68Var.a(ga8Var.f());
            m68Var.b(z);
            this.g.Z(ga8Var, z, h(ga8Var));
        }
    }
}
