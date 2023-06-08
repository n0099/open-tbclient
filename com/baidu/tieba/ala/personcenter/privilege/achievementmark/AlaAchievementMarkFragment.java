package com.baidu.tieba.ala.personcenter.privilege.achievementmark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.message.AlaAchievementMarkResponsedMessage;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.model.AlaPersonCenterPrivilegeMarkModel;
import com.baidu.tieba.ng6;
import com.baidu.tieba.qg6;
import com.baidu.tieba.tg6;
import com.baidu.tieba.vm5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AlaAchievementMarkFragment extends AbsFragment {
    public static /* synthetic */ Interceptable $ic;
    public static final String h;
    public transient /* synthetic */ FieldHolder $fh;
    public tg6 a;
    public AlaPersonCenterPrivilegeMarkModel b;
    public vm5 c;
    public ng6 d;
    public AlaPersonCenterPrivilegeMarkModel.b e;
    public View.OnClickListener f;
    public tg6.c g;

    /* loaded from: classes5.dex */
    public class a implements ng6.h {
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

        @Override // com.baidu.tieba.ng6.h
        public void a(boolean z, qg6 qg6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZL(1048576, this, z, qg6Var) != null) || !z) {
                return;
            }
            this.a.L1();
        }
    }

    /* loaded from: classes5.dex */
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
            if (interceptable != null && interceptable.invokeILL(1048576, this, i, str, obj) != null) {
                return;
            }
            this.a.hideLoadingView();
            if (i != 0 && !StringUtils.isNull(str)) {
                if (this.a.a != null) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.a.h(R.drawable.pic_live_empty04, R.string.obfuscated_res_0x7f0f0261, false, null);
                    } else {
                        this.a.a.h(R.drawable.pic_live_empty03, R.string.obfuscated_res_0x7f0f0262, true, this.a.f);
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

    /* loaded from: classes5.dex */
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
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    AlaAchievementMarkFragment alaAchievementMarkFragment = this.a;
                    alaAchievementMarkFragment.showToast(alaAchievementMarkFragment.getResources().getString(R.string.no_network_guide));
                    return;
                }
                this.a.L1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements tg6.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaAchievementMarkFragment a;

        @Override // com.baidu.tieba.tg6.c
        public void a(qg6 qg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qg6Var) == null) {
            }
        }

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
        h = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0219);
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.b == null) {
                this.b = new AlaPersonCenterPrivilegeMarkModel(BdUniqueId.gen(), this.e);
            }
            this.b.W();
        }
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsFragment
    public String getTabTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return h;
        }
        return (String) invokeV.objValue;
    }

    public final void hideLoadingView() {
        tg6 tg6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.c != null && (tg6Var = this.a) != null && tg6Var.c() != null) {
            this.c.dettachView(this.a.c());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            AlaPersonCenterPrivilegeMarkModel alaPersonCenterPrivilegeMarkModel = this.b;
            if (alaPersonCenterPrivilegeMarkModel != null) {
                alaPersonCenterPrivilegeMarkModel.destory();
            }
            ng6 ng6Var = this.d;
            if (ng6Var != null) {
                ng6Var.p();
            }
            hideLoadingView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPrimary();
            if (isAdded() && isPrimary()) {
                TiebaStatic.log("c13334");
            }
        }
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            vm5 vm5Var = this.c;
            if (vm5Var != null) {
                vm5Var.onChangeSkinType();
            }
        }
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.c == null) {
                this.c = new vm5(getPageContext().getPageActivity(), getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703ca));
            }
            tg6 tg6Var = this.a;
            if (tg6Var != null && tg6Var.c() != null) {
                this.c.attachView(this.a.c(), false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            this.a = new tg6(getPageContext(), this.g);
            M1();
            L1();
            this.d = new ng6(getPageContext(), new a(this));
            return this.a.c();
        }
        return (View) invokeLLL.objValue;
    }
}
