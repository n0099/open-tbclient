package com.baidu.tieba.ala.alasquare.live;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.g90;
import com.repackage.k90;
import com.repackage.sq5;
/* loaded from: classes3.dex */
public class AlaLiveTabFeedActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public k90 b;

    public AlaLiveTabFeedActivity() {
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
            String str = i == 1 ? SkinManager.SKIN_TYPE_STR_NIGHT : i == 4 ? "dark" : Config.TRACE_VISIT_RECENT_DAY;
            LiveFeedPageSdk.f().r(str);
            k90 k90Var = this.b;
            if (k90Var != null) {
                k90Var.b(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d00f9);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091b64);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f09158d);
            this.a = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0221));
            this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            sq5.a().c(TbadkCoreApplication.getInst());
            g90 g90Var = new g90();
            this.b = g90Var;
            View i = g90Var.i(this, null, "live_tab", "", null, null, false);
            if (i.getParent() instanceof ViewGroup) {
                ((ViewGroup) i.getParent()).removeView(i);
            }
            linearLayout.addView(i);
            k90 k90Var = this.b;
            if (k90Var != null) {
                k90Var.f();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            k90 k90Var = this.b;
            if (k90Var != null) {
                k90Var.a();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPause();
            k90 k90Var = this.b;
            if (k90Var != null) {
                k90Var.e();
                this.b.onUserVisibleHint(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            k90 k90Var = this.b;
            if (k90Var != null) {
                k90Var.g();
                this.b.onUserVisibleHint(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onStart();
            k90 k90Var = this.b;
            if (k90Var != null) {
                k90Var.d();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onStop();
            k90 k90Var = this.b;
            if (k90Var != null) {
                k90Var.c();
            }
        }
    }
}
