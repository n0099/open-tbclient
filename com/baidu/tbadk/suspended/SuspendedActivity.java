package com.baidu.tbadk.suspended;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public abstract class SuspendedActivity extends BaseFragmentActivity {
    public TextView mCancel;
    public LinearLayout mContentView;
    public NavigationBar mNavigationBar;
    public LinearLayout mNavigationBarGroup;
    public NoNetworkView.b mNetListener = new a();
    public NoNetworkView mNoNetView;
    public SusPendedView mRootView;
    public d.b.h0.t0.a mSuspendedContentView;
    public TranView mTranView;

    /* loaded from: classes3.dex */
    public class a implements NoNetworkView.b {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                SuspendedActivity.this.requestData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SuspendedActivity.this.close();
        }
    }

    private void init() {
        this.mRootView = (SusPendedView) findViewById(R.id.root_view);
        initTranView();
        initNavigationBar();
        initNoNetView();
        initContentView();
        this.mRootView.setNavigationBar(this.mNavigationBarGroup);
        this.mRootView.setTranView(this.mTranView);
        this.mRootView.setContentView(this.mContentView);
        this.mRootView.i();
    }

    private void initContentView() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.content_view);
        this.mContentView = linearLayout;
        d.b.h0.t0.a suspendedContentView = getSuspendedContentView(linearLayout, this.mNavigationBar);
        this.mSuspendedContentView = suspendedContentView;
        if (suspendedContentView != null) {
            this.mRootView.setContentViewTop(suspendedContentView);
        }
    }

    private void initNavigationBar() {
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.mCenterText.setTextSize(0, l.g(getPageContext().getPageActivity(), R.dimen.tbds44));
        TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getResources().getString(R.string.dialog_cancel), new b());
        this.mCancel = addTextButton;
        addTextButton.setTextSize(0, l.g(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.mNavigationBar.setIsCorner(true);
        this.mNavigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBarGroup = (LinearLayout) findViewById(R.id.navigation_bar_group);
        this.mNavigationBarGroup.addView(this.mTranView, 0, new LinearLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds153)));
    }

    private void initNoNetView() {
        NoNetworkView noNetworkView = (NoNetworkView) findViewById(R.id.view_no_network);
        this.mNoNetView = noNetworkView;
        noNetworkView.a(this.mNetListener);
    }

    private void initTranView() {
        TranView tranView = new TranView(getPageContext().getPageActivity());
        this.mTranView = tranView;
        tranView.setVisibility(0);
    }

    public void close() {
        d.b.h0.t0.a aVar = this.mSuspendedContentView;
        if (aVar == null || aVar.isOnViewCancel()) {
            if (this.mTranView != null) {
                this.mRootView.h();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        d.b.h0.t0.a aVar = this.mSuspendedContentView;
        if (aVar != null) {
            Intent resultIntent = aVar.getResultIntent();
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

    public abstract d.b.h0.t0.a getSuspendedContentView(LinearLayout linearLayout, NavigationBar navigationBar);

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.mNoNetView.c(getPageContext(), i);
        this.mRootView.f(i);
        SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0608);
        SkinManager.setBackgroundColor(this.mContentView, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.mCancel, R.color.CAM_X0105);
        d.b.h0.t0.a aVar = this.mSuspendedContentView;
        if (aVar != null) {
            aVar.onViewChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_suspended);
        init();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        SusPendedView susPendedView = this.mRootView;
        if (susPendedView != null) {
            susPendedView.g();
        }
    }

    public abstract void requestData();
}
