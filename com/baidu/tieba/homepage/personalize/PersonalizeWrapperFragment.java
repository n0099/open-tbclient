package com.baidu.tieba.homepage.personalize;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.gw4;
import com.baidu.tieba.hl6;
import com.baidu.tieba.homepage.framework.RecommendFrsControlFragment;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import com.baidu.tieba.iw4;
import com.baidu.tieba.j17;
import com.baidu.tieba.k17;
import com.baidu.tieba.m17;
import com.baidu.tieba.n67;
import com.baidu.tieba.uf5;
import com.baidu.tieba.uu8;
import com.baidu.tieba.wi5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class PersonalizeWrapperFragment extends BaseFragment implements hl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonalizeWrapperTabHost a;
    public m17 b;
    public k17 c;

    @Override // com.baidu.tieba.hl6
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.hl6
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
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
                this.b.A1(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements m17.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizeWrapperFragment a;

        @Override // com.baidu.tieba.m17.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            }
        }

        @Override // com.baidu.tieba.m17.d
        public void d(DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048579, this, dataRes, z) == null) {
            }
        }

        @Override // com.baidu.tieba.m17.d
        public void e(boolean z, n67 n67Var, boolean z2, String str, String str2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), n67Var, Boolean.valueOf(z2), str, str2, Boolean.valueOf(z3)}) == null) {
            }
        }

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

        @Override // com.baidu.tieba.m17.d
        public void b(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.a.a.G(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.m17.d
        public void c(String str, String str2, int i, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) != null) || !this.a.a.v()) {
                return;
            }
            this.a.a.F(str2, i, i2);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements k17 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizeWrapperFragment a;

        @Override // com.baidu.tieba.k17
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

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

        @Override // com.baidu.tieba.k17
        public void c(int i, wi5 wi5Var, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), wi5Var, Integer.valueOf(i2)}) == null) {
                this.a.b.i(1, i, wi5Var, 1, i2);
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 1));
                }
            }
        }

        @Override // com.baidu.tieba.k17
        public void d(int i, int i2, wi5 wi5Var, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), wi5Var, Integer.valueOf(i3)}) == null) {
                this.a.b.i(2, i2, wi5Var, i, i3);
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 2));
                }
            }
        }
    }

    public PersonalizeWrapperFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
    }

    @Override // com.baidu.tieba.hl6
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.ve5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            PersonalizeWrapperTabHost personalizeWrapperTabHost = this.a;
            if (personalizeWrapperTabHost != null) {
                return personalizeWrapperTabHost.getCurrentPageKey();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            PersonalizeWrapperTabHost personalizeWrapperTabHost = this.a;
            if (personalizeWrapperTabHost != null) {
                personalizeWrapperTabHost.B();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            PersonalizeWrapperTabHost personalizeWrapperTabHost = this.a;
            if (personalizeWrapperTabHost != null) {
                personalizeWrapperTabHost.setPrimary(isPrimary());
            }
            iw4.o(gw4.g);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onResume();
            PersonalizeWrapperTabHost personalizeWrapperTabHost = this.a;
            if (personalizeWrapperTabHost != null) {
                personalizeWrapperTabHost.setPrimary(isPrimary());
            }
        }
    }

    @Override // com.baidu.tieba.hl6
    public void u() {
        PersonalizeWrapperTabHost personalizeWrapperTabHost;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (personalizeWrapperTabHost = this.a) != null) {
            personalizeWrapperTabHost.C();
        }
    }

    public PersonalizeWrapperFragment(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new c(this);
        this.a = new PersonalizeWrapperTabHost(context);
    }

    public void B1(String str) {
        PersonalizeWrapperTabHost personalizeWrapperTabHost;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (personalizeWrapperTabHost = this.a) != null) {
            personalizeWrapperTabHost.setCurrentTabByCode(str);
        }
    }

    public void C1(String str) {
        PersonalizeWrapperTabHost personalizeWrapperTabHost;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (personalizeWrapperTabHost = this.a) != null) {
            personalizeWrapperTabHost.setCurrentTab(str);
        }
    }

    public void D1(int i) {
        PersonalizeWrapperTabHost personalizeWrapperTabHost;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (personalizeWrapperTabHost = this.a) != null) {
            personalizeWrapperTabHost.setCurrentTab(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onActivityCreated(bundle);
            uu8.b(new a(this, bundle), 3);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onChangeSkinType(i);
            PersonalizeWrapperTabHost personalizeWrapperTabHost = this.a;
            if (personalizeWrapperTabHost != null) {
                personalizeWrapperTabHost.A(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    public void A1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, bundle) != null) || getHost() == null) {
            return;
        }
        SpeedStatsManager.getInstance().addStatsTimeStamp(4014);
        SpeedStatsManager.getInstance().addStatsTimeStamp(4015);
        z1();
        SpeedStatsManager.getInstance().addStatsTimeStamp(4016);
        SpeedStatsManager.getInstance().addStatsTimeStamp(4017);
        this.a.x(getPageContext());
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_INIT_TABLE_END_STAMP_KEY);
        SpeedStatsManager.getInstance().addStatsTimeStamp(4019);
        this.a.y(getChildFragmentManager(), this.c, null);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_INIT_VIEW_PAPER_END_STAMP_KEY);
        boolean z = false;
        this.a.setScrollShadow(false);
        this.a.setPageUniqueId(getUniqueId());
        if (this.b != null) {
            RecPersonalizePageModel.e().p(this.b.e());
        }
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_FIRST_LOAD_START_STAMP_KEY);
        if (getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra(MainTabActivityConfig.PUSH_TID);
            if (!TextUtils.isEmpty(stringExtra)) {
                TbSingleton.getInstance().setPushTid(stringExtra);
                getActivity().getIntent().putExtra(MainTabActivityConfig.PUSH_TID, "");
                z = true;
            }
        }
        this.a.E(z);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_FIRST_LOAD_END_STAMP_KEY);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS_START_STAMP_KEY);
        j17.d().h(System.currentTimeMillis() - j17.d().a(1));
        uf5.b().C(System.currentTimeMillis() - j17.d().a(1));
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS_END_STAMP_KEY);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_ON_ACTIVITY_CREATED_END_STAMP_KEY);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @SuppressLint({"InflateParams"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.a == null) {
                this.a = new PersonalizeWrapperTabHost(layoutInflater.getContext());
            }
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onPrimary();
            PersonalizeWrapperTabHost personalizeWrapperTabHost = this.a;
            if (personalizeWrapperTabHost != null) {
                personalizeWrapperTabHost.setPrimary(isPrimary());
            }
            if (getContext() != null && isPrimary()) {
                iw4.p(getContext(), gw4.g);
            } else {
                iw4.o(gw4.g);
            }
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            m17 m17Var = new m17(getPageContext(), getUniqueId());
            this.b = m17Var;
            m17Var.k(new b(this));
            MessageManager.getInstance().sendMessage(new RecommendFrsControlFragment.ControlModelMessage(this.b));
        }
    }
}
