package com.baidu.tbadk.suspended;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.li;
import com.repackage.s85;
/* loaded from: classes3.dex */
public abstract class SuspendedActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean forceFinishWithoutAnim;
    public TextView mCancel;
    public LinearLayout mContentView;
    public NavigationBar mNavigationBar;
    public LinearLayout mNavigationBarGroup;
    public NoNetworkView.b mNetListener;
    public NoNetworkView mNoNetView;
    public SusPendedView mRootView;
    public s85 mSuspendedContentView;
    public TranView mTranView;

    /* loaded from: classes3.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SuspendedActivity a;

        public a(SuspendedActivity suspendedActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {suspendedActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = suspendedActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.a.requestData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SuspendedActivity a;

        public b(SuspendedActivity suspendedActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {suspendedActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = suspendedActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.close();
            }
        }
    }

    public SuspendedActivity() {
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
        this.mNetListener = new a(this);
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.mRootView = (SusPendedView) findViewById(R.id.obfuscated_res_0x7f091adb);
            initTranView();
            initNavigationBar();
            initNoNetView();
            initContentView();
            this.mRootView.setNavigationBar(this.mNavigationBarGroup);
            this.mRootView.setTranView(this.mTranView);
            this.mRootView.setContentView(this.mContentView);
            this.mRootView.i();
        }
    }

    private void initContentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0906d1);
            this.mContentView = linearLayout;
            s85 suspendedContentView = getSuspendedContentView(linearLayout, this.mNavigationBar);
            this.mSuspendedContentView = suspendedContentView;
            if (suspendedContentView != null) {
                this.mRootView.setContentViewTop(suspendedContentView);
            }
        }
    }

    private void initNavigationBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923a2);
            this.mNavigationBar = navigationBar;
            navigationBar.mCenterText.setTextSize(0, li.f(getPageContext().getPageActivity(), R.dimen.tbds44));
            TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getResources().getString(R.string.obfuscated_res_0x7f0f04e5), new b(this));
            this.mCancel = addTextButton;
            addTextButton.setTextSize(0, li.f(getPageContext().getPageActivity(), R.dimen.tbds44));
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.mNavigationBar.hideBottomLine();
            this.mNavigationBarGroup = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0914f5);
            this.mNavigationBarGroup.addView(this.mTranView, 0, new LinearLayout.LayoutParams(-1, getTranViewHeight()));
        }
    }

    private void initNoNetView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            NoNetworkView noNetworkView = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f0923a4);
            this.mNoNetView = noNetworkView;
            noNetworkView.a(this.mNetListener);
        }
    }

    private void initTranView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            TranView tranView = new TranView(getPageContext().getPageActivity());
            this.mTranView = tranView;
            tranView.setVisibility(0);
            this.mTranView.setOnClickListener(getTranViewOnClickListener());
        }
    }

    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            s85 s85Var = this.mSuspendedContentView;
            if (s85Var == null || s85Var.isOnViewCancel()) {
                if (this.mTranView != null) {
                    this.mRootView.h();
                } else {
                    finish();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.forceFinishWithoutAnim) {
                super.finish();
                return;
            }
            s85 s85Var = this.mSuspendedContentView;
            if (s85Var != null) {
                Intent resultIntent = s85Var.getResultIntent();
                if (resultIntent != null) {
                    setResult(-1, resultIntent);
                }
                if (this.mTranView != null && !this.mRootView.getIsFinish()) {
                    this.mRootView.h();
                    return;
                } else {
                    super.finish();
                    return;
                }
            }
            super.finish();
        }
    }

    public abstract s85 getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar);

    public int getTranViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? li.f(TbadkCoreApplication.getInst(), R.dimen.tbds153) : invokeV.intValue;
    }

    public View.OnClickListener getTranViewOnClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            this.mNoNetView.c(getPageContext(), i);
            this.mRootView.f(i);
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0608);
            SkinManager.setBackgroundColor(this.mContentView, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.mCancel, (int) R.color.CAM_X0105);
            s85 s85Var = this.mSuspendedContentView;
            if (s85Var != null) {
                s85Var.onViewChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0052);
            init();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            SusPendedView susPendedView = this.mRootView;
            if (susPendedView != null) {
                susPendedView.g();
            }
        }
    }

    public abstract void requestData();

    public void setCanDragClose(boolean z) {
        SusPendedView susPendedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (susPendedView = this.mRootView) == null) {
            return;
        }
        susPendedView.setCanDragClose(z);
    }

    public void setForceFinishWithoutAnim(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.forceFinishWithoutAnim = z;
        }
    }
}
