package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
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
/* loaded from: classes6.dex */
public class hv9 extends bv9 implements ua9, yu9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public long c;
    public boolean d;
    public BdUniqueId e;
    public dv9 f;
    public bx9 g;
    public PersonPolymericModel h;
    public cv9 i;
    public BaseFragmentActivity j;
    public View k;
    public PersonPostModel l;
    public int m;
    public List<mr9> n;

    @Override // com.baidu.tieba.yu9
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hv9(BaseFragment baseFragment, dv9 dv9Var, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, dv9Var, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
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
        this.f = dv9Var;
        this.e = bdUniqueId;
        this.k = dv9Var.e;
        this.l = new PersonPostModel(this.b, bdUniqueId, null, this.a, 1);
        bx9 bx9Var = new bx9(baseFragment, dv9Var, bdUniqueId, z, this.c);
        this.g = bx9Var;
        bx9Var.W(this);
        resetData();
        this.h = this.f.p();
        this.i = this.f.k();
        ArrayList arrayList = new ArrayList(2);
        this.n = arrayList;
        arrayList.add(new mr9());
        this.n.add(new mr9());
    }

    @Override // com.baidu.tieba.ua9
    public void a() {
        dv9 dv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (dv9Var = this.f) != null) {
            dv9Var.a();
        }
    }

    @Override // com.baidu.tieba.ua9
    public void b() {
        dv9 dv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (dv9Var = this.f) != null) {
            dv9Var.b();
        }
    }

    @Override // com.baidu.tieba.yu9
    public bx9 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (bx9) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yu9
    public void e() {
        bx9 bx9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (bx9Var = this.g) != null) {
            bx9Var.M();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            bx9 bx9Var = this.g;
            if (bx9Var != null) {
                bx9Var.U();
            }
        }
    }

    @Override // com.baidu.tieba.ua9
    public void resetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l.resetThreadPn();
            PersonPolymericModel personPolymericModel = this.h;
            if (personPolymericModel != null) {
                personPolymericModel.b0();
            }
        }
    }

    public void i(uta utaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, utaVar) == null) {
            this.g.X(utaVar);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || this.m == i) {
            return;
        }
        bx9 bx9Var = this.g;
        if (bx9Var != null) {
            bx9Var.T(i);
        }
        this.m = i;
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && z && this.d) {
            b();
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.b.getPageActivity()).createNormalConfig(JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L), true, isBigV)));
            this.j.finish();
        }
    }

    public void n(iv9 iv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, iv9Var) == null) {
            this.g.N();
            this.j.hideLoadingView(this.k);
            boolean z = true;
            if (iv9Var == null) {
                this.i.y(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e29), true);
                this.i.l();
                this.i.r(8);
                return;
            }
            this.i.n();
            if (iv9Var.e() != null && ((iv9Var.e().getHide_stat() == 1 && iv9Var.e().getBlock_stat() == 1) || (iv9Var.e().getHide_stat() == 1 && iv9Var.e().getBlock_stat() == 2))) {
                this.i.t(this.a);
                this.i.r(8);
                return;
            }
            this.i.r(0);
            iv9Var.b();
            z = (iv9Var.f() == null || iv9Var.f().size() < 20) ? false : false;
            if (iv9Var.j() != null) {
                iv9Var.j().getSex();
            }
            this.d = false;
            if (this.a && iv9Var.j() != null) {
                iv9Var.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                iv9Var.j().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                iv9Var.j().setIosBImgFormat(TbadkCoreApplication.getInst().getDefaultIosBImgFormat());
                iv9Var.j().setIosBUrl(TbadkCoreApplication.getInst().getDefaultIosBUrl());
                zk5.d().i(iv9Var.j());
            }
            mr9 mr9Var = this.n.get(0);
            mr9Var.a(iv9Var.f());
            mr9Var.b(z);
            this.g.Z(iv9Var, z, h(iv9Var));
        }
    }
}
