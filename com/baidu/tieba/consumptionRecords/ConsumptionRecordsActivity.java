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
import com.repackage.q55;
/* loaded from: classes3.dex */
public class ConsumptionRecordsActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public FragmentTabHost b;
    public SigleRecordsFragment c;
    public SigleRecordsFragment d;
    public SigleRecordsFragment e;

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

    public final void n0(q55 q55Var, FragmentTabIndicator fragmentTabIndicator, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, q55Var, fragmentTabIndicator, str) == null) || q55Var == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        bVar.c = q55Var.a;
        fragmentTabIndicator.setText(q55Var.b);
        if (!TextUtils.isEmpty(str)) {
            fragmentTabIndicator.setText(str);
        }
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f070207));
        fragmentTabIndicator.h = R.color.s_actionbar_text_color;
        bVar.b = fragmentTabIndicator;
        this.b.c(bVar);
    }

    public final int o0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.a.onChangeSkinType(getPageContext(), i);
            this.b.setNeedShowThemeStyle(false);
            this.b.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0201);
            this.b.s(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d01f3);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f09158d);
            this.a = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.a.setCenterTextTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0435));
            s0();
        }
    }

    public final FragmentTabIndicator p0(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02e6, (ViewGroup) null) : (FragmentTabIndicator) invokeL.objValue;
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.obfuscated_res_0x7f091ab6);
            this.b = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.b.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070275));
            SigleRecordsFragment sigleRecordsFragment = new SigleRecordsFragment();
            this.c = sigleRecordsFragment;
            sigleRecordsFragment.K1(1);
            q55 q55Var = new q55();
            q55Var.a = this.c;
            q55Var.b = R.string.obfuscated_res_0x7f0f05cf;
            n0(q55Var, p0(getPageContext().getPageActivity()), null);
            SigleRecordsFragment sigleRecordsFragment2 = new SigleRecordsFragment();
            this.d = sigleRecordsFragment2;
            sigleRecordsFragment2.K1(2);
            q55 q55Var2 = new q55();
            q55Var2.a = this.d;
            q55Var2.b = R.string.obfuscated_res_0x7f0f08e2;
            n0(q55Var2, p0(getPageContext().getPageActivity()), null);
            SigleRecordsFragment sigleRecordsFragment3 = new SigleRecordsFragment();
            this.e = sigleRecordsFragment3;
            sigleRecordsFragment3.K1(3);
            q55 q55Var3 = new q55();
            q55Var3.a = this.e;
            q55Var3.b = R.string.obfuscated_res_0x7f0f0f6d;
            n0(q55Var3, p0(getPageContext().getPageActivity()), null);
            this.b.n(3);
            this.b.setCurrentTab(o0(getIntent().getIntExtra(ConsumptionRecordsActivityConfig.JUMP_FRAGMENT_TYPE, 1)));
        }
    }
}
