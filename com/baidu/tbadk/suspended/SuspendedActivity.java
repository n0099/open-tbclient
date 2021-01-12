package com.baidu.tbadk.suspended;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class SuspendedActivity extends BaseFragmentActivity {
    protected TextView bUf;
    private SusPendedView fJD;
    private NoNetworkView fJE;
    private LinearLayout fJF;
    private a fJG;
    private NoNetworkView.a fJH = new NoNetworkView.a() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SuspendedActivity.this.bEv();
            }
        }
    };
    private TranView fJx;
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;

    protected abstract a a(LinearLayout linearLayout, NavigationBar navigationBar);

    protected abstract void bEv();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_suspended);
        init();
    }

    private void init() {
        this.fJD = (SusPendedView) findViewById(R.id.root_view);
        bEs();
        bEt();
        bEu();
        Xv();
        this.fJD.setNavigationBar(this.fJF);
        this.fJD.setTranView(this.fJx);
        this.fJD.setContentView(this.mContentView);
        this.fJD.show();
    }

    private void bEs() {
        this.fJx = new TranView(getPageContext().getPageActivity());
        this.fJx.setVisibility(0);
    }

    private void bEt() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.mCenterText.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.bUf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getResources().getString(R.string.dialog_cancel), new View.OnClickListener() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SuspendedActivity.this.close();
            }
        });
        this.bUf.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.mNavigationBar.setIsCorner(true);
        this.mNavigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.hideBottomLine();
        this.fJF = (LinearLayout) findViewById(R.id.navigation_bar_group);
        this.fJF.addView(this.fJx, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153)));
    }

    private void bEu() {
        this.fJE = (NoNetworkView) findViewById(R.id.view_no_network);
        this.fJE.a(this.fJH);
    }

    private void Xv() {
        this.mContentView = (LinearLayout) findViewById(R.id.content_view);
        this.fJG = a(this.mContentView, this.mNavigationBar);
        if (this.fJG != null) {
            this.fJD.setContentViewTop(this.fJG);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fJE.onChangeSkinType(getPageContext(), i);
        this.fJD.onChangeSkinType(i);
        ao.setBackgroundColor(this.fJD, R.color.CAM_X0608);
        ao.setBackgroundColor(this.mContentView, R.color.CAM_X0201);
        ao.setViewTextColor(this.bUf, R.color.CAM_X0105);
        if (this.fJG != null) {
            this.fJG.rs(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    protected void close() {
        if (this.fJG == null || this.fJG.bEq()) {
            if (this.fJx != null) {
                this.fJD.onFinish();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.fJG != null) {
            Intent bEr = this.fJG.bEr();
            if (bEr != null) {
                setResult(-1, bEr);
            }
            if (this.fJx != null && !this.fJD.getIsFinish()) {
                this.fJD.onFinish();
                return;
            } else {
                super.finish();
                return;
            }
        }
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fJD != null) {
            this.fJD.onDestroy();
        }
    }
}
