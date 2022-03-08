package com.baidu.tbadk.suspended;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
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
/* loaded from: classes5.dex */
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
    public c.a.q0.x0.b mSuspendedContentView;
    public TranView mTranView;

    /* loaded from: classes5.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SuspendedActivity f39759e;

        public a(SuspendedActivity suspendedActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {suspendedActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39759e = suspendedActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z) {
                this.f39759e.requestData();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SuspendedActivity f39760e;

        public b(SuspendedActivity suspendedActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {suspendedActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39760e = suspendedActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f39760e.close();
            }
        }
    }

    public SuspendedActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            this.mRootView = (SusPendedView) findViewById(R.id.root_view);
            initTranView();
            initNavigationBar();
            initNoNetView();
            initContentView();
            this.mRootView.setNavigationBar(this.mNavigationBarGroup);
            this.mRootView.setTranView(this.mTranView);
            this.mRootView.setContentView(this.mContentView);
            this.mRootView.show();
        }
    }

    private void initContentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.content_view);
            this.mContentView = linearLayout;
            c.a.q0.x0.b suspendedContentView = getSuspendedContentView(linearLayout, this.mNavigationBar);
            this.mSuspendedContentView = suspendedContentView;
            if (suspendedContentView != null) {
                this.mRootView.setContentViewTop(suspendedContentView);
            }
        }
    }

    private void initNavigationBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            navigationBar.mCenterText.setTextSize(0, n.f(getPageContext().getPageActivity(), R.dimen.tbds44));
            TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getResources().getString(R.string.dialog_cancel), new b(this));
            this.mCancel = addTextButton;
            addTextButton.setTextSize(0, n.f(getPageContext().getPageActivity(), R.dimen.tbds44));
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.mNavigationBar.hideBottomLine();
            this.mNavigationBarGroup = (LinearLayout) findViewById(R.id.navigation_bar_group);
            this.mNavigationBarGroup.addView(this.mTranView, 0, new LinearLayout.LayoutParams(-1, getTranViewHeight()));
        }
    }

    private void initNoNetView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            NoNetworkView noNetworkView = (NoNetworkView) findViewById(R.id.view_no_network);
            this.mNoNetView = noNetworkView;
            noNetworkView.addNetworkChangeListener(this.mNetListener);
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
            c.a.q0.x0.b bVar = this.mSuspendedContentView;
            if (bVar == null || bVar.isOnViewCancel()) {
                if (this.mTranView != null) {
                    this.mRootView.onFinish();
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
            c.a.q0.x0.b bVar = this.mSuspendedContentView;
            if (bVar != null) {
                Intent resultIntent = bVar.getResultIntent();
                if (resultIntent != null) {
                    setResult(-1, resultIntent);
                }
                if (this.mTranView != null && !this.mRootView.getIsFinish()) {
                    this.mRootView.onFinish();
                    return;
                } else {
                    super.finish();
                    return;
                }
            }
            super.finish();
        }
    }

    public abstract c.a.q0.x0.b getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar);

    public int getTranViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? n.f(TbadkCoreApplication.getInst(), R.dimen.tbds153) : invokeV.intValue;
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
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            this.mNoNetView.onChangeSkinType(getPageContext(), i2);
            this.mRootView.onChangeSkinType(i2);
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0608);
            SkinManager.setBackgroundColor(this.mContentView, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.mCancel, (int) R.color.CAM_X0105);
            c.a.q0.x0.b bVar = this.mSuspendedContentView;
            if (bVar != null) {
                bVar.onViewChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            setContentView(R.layout.activity_suspended);
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
                susPendedView.onDestroy();
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
