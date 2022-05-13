package com.baidu.tieba.consumptionRecords;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.e55;
/* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void createAndAddTabSpec(e55 e55Var, FragmentTabIndicator fragmentTabIndicator, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, this, e55Var, fragmentTabIndicator, str) == null) || e55Var == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        bVar.c = e55Var.a;
        fragmentTabIndicator.setText(e55Var.b);
        if (!TextUtils.isEmpty(str)) {
            fragmentTabIndicator.setText(str);
        }
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f070207));
        fragmentTabIndicator.h = R.color.s_actionbar_text_color;
        bVar.b = fragmentTabIndicator;
        this.mTabHost.c(bVar);
    }

    private int getIndexByType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            return i == 3 ? 2 : 0;
        }
        return invokeI.intValue;
    }

    private FragmentTabIndicator getTabIndicator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) ? (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02ef, (ViewGroup) null) : (FragmentTabIndicator) invokeL.objValue;
    }

    private void initTabs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.obfuscated_res_0x7f091a66);
            this.mTabHost = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.mTabHost.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070275));
            SigleRecordsFragment sigleRecordsFragment = new SigleRecordsFragment();
            this.expenditureFragment = sigleRecordsFragment;
            sigleRecordsFragment.T0(1);
            e55 e55Var = new e55();
            e55Var.a = this.expenditureFragment;
            e55Var.b = R.string.obfuscated_res_0x7f0f05ca;
            createAndAddTabSpec(e55Var, getTabIndicator(getPageContext().getPageActivity()), null);
            SigleRecordsFragment sigleRecordsFragment2 = new SigleRecordsFragment();
            this.incomeFragment = sigleRecordsFragment2;
            sigleRecordsFragment2.T0(2);
            e55 e55Var2 = new e55();
            e55Var2.a = this.incomeFragment;
            e55Var2.b = R.string.obfuscated_res_0x7f0f08d0;
            createAndAddTabSpec(e55Var2, getTabIndicator(getPageContext().getPageActivity()), null);
            SigleRecordsFragment sigleRecordsFragment3 = new SigleRecordsFragment();
            this.rechargeFragment = sigleRecordsFragment3;
            sigleRecordsFragment3.T0(3);
            e55 e55Var3 = new e55();
            e55Var3.a = this.rechargeFragment;
            e55Var3.b = R.string.obfuscated_res_0x7f0f0f58;
            createAndAddTabSpec(e55Var3, getTabIndicator(getPageContext().getPageActivity()), null);
            this.mTabHost.n(3);
            this.mTabHost.setCurrentTab(getIndexByType(getIntent().getIntExtra(ConsumptionRecordsActivityConfig.JUMP_FRAGMENT_TYPE, 1)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.mNavigationbar.onChangeSkinType(getPageContext(), i);
            this.mTabHost.setNeedShowThemeStyle(false);
            this.mTabHost.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0201);
            this.mTabHost.s(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d01fc);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091534);
            this.mNavigationbar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationbar.setCenterTextTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0436));
            initTabs();
        }
    }
}
