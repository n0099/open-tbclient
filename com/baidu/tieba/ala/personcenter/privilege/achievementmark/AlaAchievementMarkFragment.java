package com.baidu.tieba.ala.personcenter.privilege.achievementmark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.message.AlaAchievementMarkResponsedMessage;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaPersonCenterPrivilegeMarkModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.k55;
import com.repackage.ni;
import com.repackage.nv5;
import com.repackage.qv5;
import com.repackage.tv5;
/* loaded from: classes3.dex */
public class AlaAchievementMarkFragment extends AbsFragment {
    public static /* synthetic */ Interceptable $ic;
    public static final String h;
    public transient /* synthetic */ FieldHolder $fh;
    public tv5 a;
    public AlaPersonCenterPrivilegeMarkModel b;
    public k55 c;
    public nv5 d;
    public AlaPersonCenterPrivilegeMarkModel.b e;
    public View.OnClickListener f;
    public tv5.c g;

    /* loaded from: classes3.dex */
    public class a implements nv5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaAchievementMarkFragment a;

        public a(AlaAchievementMarkFragment alaAchievementMarkFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaAchievementMarkFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaAchievementMarkFragment;
        }

        @Override // com.repackage.nv5.h
        public void a(boolean z, qv5 qv5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZL(1048576, this, z, qv5Var) == null) && z) {
                this.a.w1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AlaPersonCenterPrivilegeMarkModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaAchievementMarkFragment a;

        public b(AlaAchievementMarkFragment alaAchievementMarkFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaAchievementMarkFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaAchievementMarkFragment;
        }

        @Override // com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaPersonCenterPrivilegeMarkModel.b
        public void a(int i, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, obj) == null) {
                this.a.m();
                if (i != 0 && !StringUtils.isNull(str)) {
                    if (this.a.a != null) {
                        if (ni.z()) {
                            this.a.a.h(R.drawable.pic_live_empty04, R.string.obfuscated_res_0x7f0f0231, false, null);
                        } else {
                            this.a.a.h(R.drawable.pic_live_empty03, R.string.obfuscated_res_0x7f0f0232, true, this.a.f);
                        }
                        this.a.a.g(null, null);
                    }
                } else if (obj == null) {
                    this.a.a.g(null, null);
                } else if (obj instanceof AlaAchievementMarkResponsedMessage) {
                    AlaAchievementMarkResponsedMessage alaAchievementMarkResponsedMessage = (AlaAchievementMarkResponsedMessage) obj;
                    if (this.a.a != null) {
                        this.a.a.d();
                        this.a.a.g(alaAchievementMarkResponsedMessage.getAlaUserInfoData(), alaAchievementMarkResponsedMessage.getList());
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaAchievementMarkFragment a;

        public c(AlaAchievementMarkFragment alaAchievementMarkFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaAchievementMarkFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaAchievementMarkFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (ni.z()) {
                    this.a.w1();
                    return;
                }
                AlaAchievementMarkFragment alaAchievementMarkFragment = this.a;
                alaAchievementMarkFragment.showToast(alaAchievementMarkFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0c50));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements tv5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaAchievementMarkFragment a;

        public d(AlaAchievementMarkFragment alaAchievementMarkFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaAchievementMarkFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaAchievementMarkFragment;
        }

        @Override // com.repackage.tv5.c
        public void a(qv5 qv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qv5Var) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-782850346, "Lcom/baidu/tieba/ala/personcenter/privilege/achievementmark/AlaAchievementMarkFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-782850346, "Lcom/baidu/tieba/ala/personcenter/privilege/achievementmark/AlaAchievementMarkFragment;");
                return;
            }
        }
        h = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f01ea);
    }

    public AlaAchievementMarkFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new b(this);
        this.f = new c(this);
        this.g = new d(this);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public int getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public String getTabTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? h : (String) invokeV.objValue;
    }

    public final void m() {
        tv5 tv5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.c == null || (tv5Var = this.a) == null || tv5Var.c() == null) {
            return;
        }
        this.c.dettachView(this.a.c());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            k55 k55Var = this.c;
            if (k55Var != null) {
                k55Var.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            this.a = new tv5(getPageContext(), this.g);
            x1();
            w1();
            this.d = new nv5(getPageContext(), new a(this));
            return this.a.c();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            AlaPersonCenterPrivilegeMarkModel alaPersonCenterPrivilegeMarkModel = this.b;
            if (alaPersonCenterPrivilegeMarkModel != null) {
                alaPersonCenterPrivilegeMarkModel.destory();
            }
            nv5 nv5Var = this.d;
            if (nv5Var != null) {
                nv5Var.p();
            }
            m();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                TiebaStatic.log("c13334");
            }
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.b == null) {
                this.b = new AlaPersonCenterPrivilegeMarkModel(BdUniqueId.gen(), this.e);
            }
            this.b.C();
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.c == null) {
                this.c = new k55(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b2));
            }
            tv5 tv5Var = this.a;
            if (tv5Var == null || tv5Var.c() == null) {
                return;
            }
            this.c.attachView(this.a.c(), false);
        }
    }
}
