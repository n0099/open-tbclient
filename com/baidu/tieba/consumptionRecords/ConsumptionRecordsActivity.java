package com.baidu.tieba.consumptionRecords;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ConsumptionRecordsActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.e0.c;
/* loaded from: classes5.dex */
public class ConsumptionRecordsActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SigleRecordsFragment expenditureFragment;
    public SigleRecordsFragment incomeFragment;
    public NavigationBar mNavigationbar;
    public FragmentTabHost mTabHost;
    public SigleRecordsFragment rechargeFragment;

    public ConsumptionRecordsActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void createAndAddTabSpec(c cVar, FragmentTabIndicator fragmentTabIndicator, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, this, cVar, fragmentTabIndicator, str) == null) || cVar == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        bVar.f12348c = cVar.f55251a;
        fragmentTabIndicator.setText(cVar.f55252b);
        if (!TextUtils.isEmpty(str)) {
            fragmentTabIndicator.setText(str);
        }
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.ds32));
        fragmentTabIndicator.l = R.color.s_actionbar_text_color;
        bVar.f12347b = fragmentTabIndicator;
        this.mTabHost.a(bVar);
    }

    private int getIndexByType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2) {
                return 1;
            }
            return i2 == 3 ? 2 : 0;
        }
        return invokeI.intValue;
    }

    private FragmentTabIndicator getTabIndicator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) ? (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null) : (FragmentTabIndicator) invokeL.objValue;
    }

    private void initTabs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.records_tab_host);
            this.mTabHost = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.ds80));
            SigleRecordsFragment sigleRecordsFragment = new SigleRecordsFragment();
            this.expenditureFragment = sigleRecordsFragment;
            sigleRecordsFragment.X0(1);
            c cVar = new c();
            cVar.f55251a = this.expenditureFragment;
            cVar.f55252b = R.string.expenditure_records;
            createAndAddTabSpec(cVar, getTabIndicator(getPageContext().getPageActivity()), null);
            SigleRecordsFragment sigleRecordsFragment2 = new SigleRecordsFragment();
            this.incomeFragment = sigleRecordsFragment2;
            sigleRecordsFragment2.X0(2);
            c cVar2 = new c();
            cVar2.f55251a = this.incomeFragment;
            cVar2.f55252b = R.string.income_records;
            createAndAddTabSpec(cVar2, getTabIndicator(getPageContext().getPageActivity()), null);
            SigleRecordsFragment sigleRecordsFragment3 = new SigleRecordsFragment();
            this.rechargeFragment = sigleRecordsFragment3;
            sigleRecordsFragment3.X0(3);
            c cVar3 = new c();
            cVar3.f55251a = this.rechargeFragment;
            cVar3.f55252b = R.string.recharge_records;
            createAndAddTabSpec(cVar3, getTabIndicator(getPageContext().getPageActivity()), null);
            this.mTabHost.k(3);
            this.mTabHost.setCurrentTab(getIndexByType(getIntent().getIntExtra(ConsumptionRecordsActivityConfig.JUMP_FRAGMENT_TYPE, 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.mNavigationbar.onChangeSkinType(getPageContext(), i2);
            this.mTabHost.setNeedShowThemeStyle(false);
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0201);
            this.mTabHost.p(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.consumption_records_activity_layout);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.mNavigationbar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationbar.setCenterTextTitle(getResources().getString(R.string.consumption_records));
            initTabs();
        }
    }
}
