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
import com.baidu.tieba.e67;
import com.baidu.tieba.homepage.framework.RecommendFrsControlFragment;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import com.baidu.tieba.lm5;
import com.baidu.tieba.np5;
import com.baidu.tieba.sn7;
import com.baidu.tieba.tn7;
import com.baidu.tieba.vn7;
import com.baidu.tieba.vs7;
import com.baidu.tieba.y05;
import com.baidu.tieba.z05;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import tbclient.Userlike.DataRes;
/* loaded from: classes4.dex */
public class PersonalizeWrapperFragment extends BaseFragment implements e67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonalizeWrapperTabHost a;
    public vn7 b;
    public tn7 c;

    @Override // com.baidu.tieba.e67
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.e67
    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements tn7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalizeWrapperFragment a;

        @Override // com.baidu.tieba.tn7
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public a(PersonalizeWrapperFragment personalizeWrapperFragment) {
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

        @Override // com.baidu.tieba.tn7
        public void c(int i, np5 np5Var, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), np5Var, Integer.valueOf(i2)}) == null) {
                this.a.b.h(1, i, np5Var, 1, i2);
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 1));
                }
            }
        }

        @Override // com.baidu.tieba.tn7
        public void d(int i, int i2, np5 np5Var, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), np5Var, Integer.valueOf(i3)}) == null) {
                this.a.b.h(2, i2, np5Var, i, i3);
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    TiebaStatic.log(new StatisticItem("c11032").param("obj_source", 2));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements vn7.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<PersonalizeWrapperFragment> a;

        @Override // com.baidu.tieba.vn7.c
        public void c(DataRes dataRes, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, dataRes, z) == null) {
            }
        }

        @Override // com.baidu.tieba.vn7.c
        public void d(boolean z, vs7 vs7Var, boolean z2, String str, String str2, boolean z3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), vs7Var, Boolean.valueOf(z2), str, str2, Boolean.valueOf(z3)}) == null) {
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
            this.a = new WeakReference<>(personalizeWrapperFragment);
        }

        @Override // com.baidu.tieba.vn7.c
        public void a(tbclient.Personalized.DataRes dataRes, boolean z, boolean z2) {
            PersonalizeWrapperFragment personalizeWrapperFragment;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{dataRes, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || (personalizeWrapperFragment = this.a.get()) == null) {
                return;
            }
            personalizeWrapperFragment.a.I(dataRes, z, z2);
        }

        @Override // com.baidu.tieba.vn7.c
        public void b(String str, String str2, int i, boolean z, int i2) {
            PersonalizeWrapperFragment personalizeWrapperFragment;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) != null) || (personalizeWrapperFragment = this.a.get()) == null || !personalizeWrapperFragment.a.w()) {
                return;
            }
            personalizeWrapperFragment.a.H(str2, i, i2);
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
        this.c = new a(this);
    }

    public String G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PersonalizeWrapperTabHost personalizeWrapperTabHost = this.a;
            if (personalizeWrapperTabHost != null) {
                return personalizeWrapperTabHost.getCurrentSecondTabName();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e67
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tieba.ll5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            PersonalizeWrapperTabHost personalizeWrapperTabHost = this.a;
            if (personalizeWrapperTabHost != null) {
                personalizeWrapperTabHost.C();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            PersonalizeWrapperTabHost personalizeWrapperTabHost = this.a;
            if (personalizeWrapperTabHost != null) {
                personalizeWrapperTabHost.setPrimary(isPrimary());
            }
            z05.m(y05.g);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onResume();
            PersonalizeWrapperTabHost personalizeWrapperTabHost = this.a;
            if (personalizeWrapperTabHost != null) {
                personalizeWrapperTabHost.setPrimary(isPrimary());
            }
        }
    }

    @Override // com.baidu.tieba.e67
    public void u() {
        PersonalizeWrapperTabHost personalizeWrapperTabHost;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (personalizeWrapperTabHost = this.a) != null) {
            personalizeWrapperTabHost.D();
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
        this.c = new a(this);
        this.a = new PersonalizeWrapperTabHost(context);
    }

    public void J1(String str) {
        PersonalizeWrapperTabHost personalizeWrapperTabHost;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (personalizeWrapperTabHost = this.a) != null) {
            personalizeWrapperTabHost.setCurrentTabByCode(str);
        }
    }

    public void K1(String str) {
        PersonalizeWrapperTabHost personalizeWrapperTabHost;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && (personalizeWrapperTabHost = this.a) != null) {
            personalizeWrapperTabHost.setCurrentTab(str);
        }
    }

    public void L1(int i) {
        PersonalizeWrapperTabHost personalizeWrapperTabHost;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (personalizeWrapperTabHost = this.a) != null) {
            personalizeWrapperTabHost.setCurrentTab(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onActivityCreated(bundle);
            I1(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            super.onChangeSkinType(i);
            PersonalizeWrapperTabHost personalizeWrapperTabHost = this.a;
            if (personalizeWrapperTabHost != null) {
                personalizeWrapperTabHost.B(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            vn7 vn7Var = new vn7(getPageContext(), getUniqueId());
            this.b = vn7Var;
            vn7Var.j(new b(this));
            MessageManager.getInstance().sendMessage(new RecommendFrsControlFragment.ControlModelMessage(this.b));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPrimary();
            PersonalizeWrapperTabHost personalizeWrapperTabHost = this.a;
            if (personalizeWrapperTabHost != null) {
                personalizeWrapperTabHost.setPrimary(isPrimary());
            }
            if (getContext() != null && isPrimary()) {
                z05.n(getContext(), y05.g);
            } else {
                z05.m(y05.g);
            }
        }
    }

    public void I1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, bundle) != null) || getHost() == null) {
            return;
        }
        SpeedStatsManager.getInstance().addStatsTimeStamp(4014);
        SpeedStatsManager.getInstance().addStatsTimeStamp(4015);
        H1();
        SpeedStatsManager.getInstance().addStatsTimeStamp(4016);
        SpeedStatsManager.getInstance().addStatsTimeStamp(4017);
        this.a.y(getPageContext());
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_INIT_TABLE_END_STAMP_KEY);
        SpeedStatsManager.getInstance().addStatsTimeStamp(4019);
        this.a.z(getChildFragmentManager(), this.c, null);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_INIT_VIEW_PAPER_END_STAMP_KEY);
        boolean z = false;
        this.a.setScrollShadow(false);
        this.a.setPageUniqueId(getUniqueId());
        if (this.b != null) {
            RecPersonalizePageModel.e().p(this.b.d());
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
        this.a.G(z);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_FIRST_LOAD_END_STAMP_KEY);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS_START_STAMP_KEY);
        sn7.d().h(System.currentTimeMillis() - sn7.d().a(1));
        lm5.b().C(System.currentTimeMillis() - sn7.d().a(1));
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_SHOW_CONCERN_TAB_TIPS_END_STAMP_KEY);
        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.HOME_FRAGMENT_ON_ACTIVITY_CREATED_END_STAMP_KEY);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @SuppressLint({"InflateParams"})
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.a == null) {
                this.a = new PersonalizeWrapperTabHost(layoutInflater.getContext());
            }
            return this.a;
        }
        return (View) invokeLLL.objValue;
    }
}
