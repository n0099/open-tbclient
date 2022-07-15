package com.baidu.tieba.homepage.personalize;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.MainTabDataSwitch;
import com.baidu.tieba.homepage.framework.RecommendFrsControlFragment;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cz6;
import com.repackage.ge6;
import com.repackage.jz6;
import com.repackage.ku6;
import com.repackage.lu6;
import com.repackage.ni;
import com.repackage.nu6;
import com.repackage.rx4;
import com.repackage.rz6;
import com.repackage.s95;
import com.repackage.vk8;
import com.repackage.wc5;
import java.util.List;
import tbclient.Personalized.DataRes;
/* loaded from: classes3.dex */
public class PersonalizeWrapperFragment extends BaseFragment implements ge6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonalizeWrapperTabHost a;
    public nu6 b;
    public lu6 c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ PersonalizeWrapperFragment b;

        public a(PersonalizeWrapperFragment personalizeWrapperFragment, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeWrapperFragment, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalizeWrapperFragment;
            this.a = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.v1(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements nu6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizeWrapperFragment a;

        public b(PersonalizeWrapperFragment personalizeWrapperFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeWrapperFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizeWrapperFragment;
        }

        @Override // com.repackage.nu6.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.a == null) {
                return;
            }
            this.a.a.setShowConcernRedTip(z);
            if (this.a.isPrimary() && z) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016325, Integer.valueOf(z ? 1 : 0)));
        }

        @Override // com.repackage.nu6.d
        public void b(DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.a.K(dataRes, z, z2);
            }
        }

        @Override // com.repackage.nu6.d
        public void c(String str, String str2, int i, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && this.a.a.w()) {
                jz6.a("mTabHostError");
                this.a.a.J(str2, i, i2);
            }
        }

        @Override // com.repackage.nu6.d
        public void d(tbclient.Userlike.DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048579, this, dataRes, z) == null) {
                this.a.a.I(dataRes, z);
            }
        }

        @Override // com.repackage.nu6.d
        public void e(boolean z, rz6 rz6Var, boolean z2, String str, String str2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), rz6Var, Boolean.valueOf(z2), str, str2, Boolean.valueOf(z3)}) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements lu6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizeWrapperFragment a;

        public c(PersonalizeWrapperFragment personalizeWrapperFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalizeWrapperFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalizeWrapperFragment;
        }

        @Override // com.repackage.lu6
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.repackage.lu6
        public void c(int i, wc5 wc5Var, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), wc5Var, Integer.valueOf(i2)}) == null) {
                this.a.b.i(1, i, wc5Var, 1, i2);
                if (ni.A()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 1));
                }
            }
        }

        @Override // com.repackage.lu6
        public void d(int i, int i2, wc5 wc5Var, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), wc5Var, Integer.valueOf(i3)}) == null) {
                this.a.b.i(2, i2, wc5Var, i, i3);
                if (ni.A()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 2));
                }
            }
        }
    }

    public PersonalizeWrapperFragment(Context context, List<rx4> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new c(this);
        this.a = new PersonalizeWrapperTabHost(context);
    }

    @Override // com.repackage.ge6
    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.repackage.ge6
    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onActivityCreated(bundle);
            vk8.b(new a(this, bundle), 3);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            PersonalizeWrapperTabHost personalizeWrapperTabHost = this.a;
            if (personalizeWrapperTabHost != null) {
                personalizeWrapperTabHost.C(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @SuppressLint({"InflateParams"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) ? this.a : (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            PersonalizeWrapperTabHost personalizeWrapperTabHost = this.a;
            if (personalizeWrapperTabHost != null) {
                personalizeWrapperTabHost.D();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            PersonalizeWrapperTabHost personalizeWrapperTabHost = this.a;
            if (personalizeWrapperTabHost != null) {
                personalizeWrapperTabHost.setPrimary(isPrimary());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPrimary();
            PersonalizeWrapperTabHost personalizeWrapperTabHost = this.a;
            if (personalizeWrapperTabHost != null) {
                personalizeWrapperTabHost.setPrimary(isPrimary());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            PersonalizeWrapperTabHost personalizeWrapperTabHost = this.a;
            if (personalizeWrapperTabHost != null) {
                personalizeWrapperTabHost.setPrimary(isPrimary());
                this.a.E();
            }
        }
    }

    @Override // com.repackage.ge6
    public void t() {
        PersonalizeWrapperTabHost personalizeWrapperTabHost;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (personalizeWrapperTabHost = this.a) == null) {
            return;
        }
        personalizeWrapperTabHost.F();
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            nu6 nu6Var = new nu6(getPageContext(), getUniqueId());
            this.b = nu6Var;
            nu6Var.k(new b(this));
            MessageManager.getInstance().sendMessage(new RecommendFrsControlFragment.ControlModelMessage(this.b));
        }
    }

    public void v1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) || getHost() == null) {
            return;
        }
        SpeedStatsManager.getInstance().addStatsTimeStamp(4014);
        SpeedStatsManager.getInstance().addStatsTimeStamp(4015);
        u1();
        SpeedStatsManager.getInstance().addStatsTimeStamp(4016);
        SpeedStatsManager.getInstance().addStatsTimeStamp(4017);
        this.a.y(getPageContext());
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_INIT_TABLE_END_STAMP_KEY);
        SpeedStatsManager.getInstance().addStatsTimeStamp(4019);
        this.a.z(getChildFragmentManager(), this.c, null);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_INIT_VIEW_PAPER_END_STAMP_KEY);
        this.a.setScrollShadow(false);
        this.a.setPageUniqueId(getUniqueId());
        if (this.b != null) {
            if (MainTabDataSwitch.isCacheOpen()) {
                RecPersonalizePageModel.g().r(this.b.e());
            } else {
                cz6.m().q(this.b.e());
            }
        }
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_FIRST_LOAD_START_STAMP_KEY);
        this.a.H();
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_FIRST_LOAD_END_STAMP_KEY);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS_START_STAMP_KEY);
        ku6.d().h(System.currentTimeMillis() - ku6.d().a(1));
        s95.b().C(System.currentTimeMillis() - ku6.d().a(1));
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS_END_STAMP_KEY);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_ON_ACTIVITY_CREATED_END_STAMP_KEY);
    }

    @Override // com.repackage.ge6
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }
}
