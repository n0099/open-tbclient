package com.baidu.tieba.ala.alasquare.live;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.feedpage.interfaces.ILiveFeedPageView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ks5;
import com.repackage.l90;
/* loaded from: classes3.dex */
public class AlaLiveTabFeedActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public ILiveFeedPageView b;

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
            String str = i == 1 ? "night" : i == 4 ? "dark" : "day";
            LiveFeedPageSdk.getInstance().updateUiMode(str);
            ILiveFeedPageView iLiveFeedPageView = this.b;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onDarkModeChange(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d00f9);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091c22);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091624);
            this.a = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0224));
            this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            ks5.a().c(TbadkCoreApplication.getInst());
            l90 l90Var = new l90();
            this.b = l90Var;
            View onCreateView = l90Var.onCreateView(this, null, LiveFeedPageSdk.HOST_LIVE_TAB, "index", null, null, false);
            if (onCreateView.getParent() instanceof ViewGroup) {
                ((ViewGroup) onCreateView.getParent()).removeView(onCreateView);
            }
            linearLayout.addView(onCreateView);
            ILiveFeedPageView iLiveFeedPageView = this.b;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.lazyLoad();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            ILiveFeedPageView iLiveFeedPageView = this.b;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onViewDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onPause();
            ILiveFeedPageView iLiveFeedPageView = this.b;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onViewPause();
                this.b.onUserVisibleHint(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
            ILiveFeedPageView iLiveFeedPageView = this.b;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onViewResume();
                this.b.onUserVisibleHint(true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onStart();
            ILiveFeedPageView iLiveFeedPageView = this.b;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onViewStart();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onStop();
            ILiveFeedPageView iLiveFeedPageView = this.b;
            if (iLiveFeedPageView != null) {
                iLiveFeedPageView.onViewStop();
            }
        }
    }
}
