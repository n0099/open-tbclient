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
import com.baidu.tieba.jo5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ConsumptionRecordsActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public FragmentTabHost b;
    public SigleRecordsFragment c;
    public SigleRecordsFragment d;
    public SigleRecordsFragment e;

    public final int u1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.a.onChangeSkinType(getPageContext(), i);
            this.b.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0201);
            this.b.s(i);
        }
    }

    public final FragmentTabIndicator v1(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            return (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        }
        return (FragmentTabIndicator) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0228);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.a = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.a.setCenterTextTitle(getResources().getString(R.string.consumption_records));
            w1();
        }
    }

    public final void t1(jo5 jo5Var, FragmentTabIndicator fragmentTabIndicator, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jo5Var, fragmentTabIndicator, str) != null) || jo5Var == null) {
            return;
        }
        FragmentTabHost.c cVar = new FragmentTabHost.c();
        cVar.c = jo5Var.a;
        fragmentTabIndicator.setText(jo5Var.b);
        if (!TextUtils.isEmpty(str)) {
            fragmentTabIndicator.setText(str);
        }
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f070207));
        fragmentTabIndicator.h = R.color.s_actionbar_text_color;
        cVar.b = fragmentTabIndicator;
        this.b.b(cVar);
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.obfuscated_res_0x7f091e65);
            this.b = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.b.setTabWidgetViewHeight((int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070275));
            SigleRecordsFragment sigleRecordsFragment = new SigleRecordsFragment();
            this.c = sigleRecordsFragment;
            sigleRecordsFragment.Y1(1);
            jo5 jo5Var = new jo5();
            jo5Var.a = this.c;
            jo5Var.b = R.string.obfuscated_res_0x7f0f06e4;
            t1(jo5Var, v1(getPageContext().getPageActivity()), null);
            SigleRecordsFragment sigleRecordsFragment2 = new SigleRecordsFragment();
            this.d = sigleRecordsFragment2;
            sigleRecordsFragment2.Y1(2);
            jo5 jo5Var2 = new jo5();
            jo5Var2.a = this.d;
            jo5Var2.b = R.string.obfuscated_res_0x7f0f0a78;
            t1(jo5Var2, v1(getPageContext().getPageActivity()), null);
            SigleRecordsFragment sigleRecordsFragment3 = new SigleRecordsFragment();
            this.e = sigleRecordsFragment3;
            sigleRecordsFragment3.Y1(3);
            jo5 jo5Var3 = new jo5();
            jo5Var3.a = this.e;
            jo5Var3.b = R.string.obfuscated_res_0x7f0f11d0;
            t1(jo5Var3, v1(getPageContext().getPageActivity()), null);
            this.b.k(3);
            this.b.setCurrentTab(u1(getIntent().getIntExtra(ConsumptionRecordsActivityConfig.JUMP_FRAGMENT_TYPE, 1)));
        }
    }
}
