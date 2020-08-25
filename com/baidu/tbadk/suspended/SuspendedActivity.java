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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public abstract class SuspendedActivity extends BaseFragmentActivity {
    protected TextView dCB;
    private TranView eTY;
    private SusPendedView eUe;
    private NoNetworkView eUf;
    private LinearLayout eUg;
    private a eUh;
    private NoNetworkView.a eUi = new NoNetworkView.a() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SuspendedActivity.this.buQ();
            }
        }
    };
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;

    protected abstract a a(LinearLayout linearLayout, NavigationBar navigationBar);

    protected abstract void buQ();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_suspended);
        init();
    }

    private void init() {
        this.eUe = (SusPendedView) findViewById(R.id.root_view);
        buN();
        buO();
        buP();
        VH();
        this.eUe.setNavigationBar(this.eUg);
        this.eUe.setTranView(this.eTY);
        this.eUe.setContentView(this.mContentView);
        this.eUe.show();
    }

    private void buN() {
        this.eTY = new TranView(getPageContext().getPageActivity());
        this.eTY.setVisibility(0);
    }

    private void buO() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.mCenterText.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.dCB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getResources().getString(R.string.dialog_cancel), new View.OnClickListener() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SuspendedActivity.this.close();
            }
        });
        this.dCB.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dCB.getLayoutParams();
        layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds46);
        this.dCB.setLayoutParams(layoutParams);
        this.mNavigationBar.setIsCorner(true);
        this.mNavigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.hideBottomLine();
        this.eUg = (LinearLayout) findViewById(R.id.navigation_bar_group);
        this.eUg.addView(this.eTY, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153)));
    }

    private void buP() {
        this.eUf = (NoNetworkView) findViewById(R.id.view_no_network);
        this.eUf.a(this.eUi);
    }

    private void VH() {
        this.mContentView = (LinearLayout) findViewById(R.id.content_view);
        this.eUh = a(this.mContentView, this.mNavigationBar);
        if (this.eUh != null) {
            this.eUe.setContentViewTop(this.eUh);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eUf.onChangeSkinType(getPageContext(), i);
        this.eUe.onChangeSkinType(i);
        ap.setBackgroundColor(this.eUe, R.color.cp_mask_b_alpha66);
        ap.setBackgroundColor(this.mContentView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.dCB, R.color.cp_cont_b);
        if (this.eUh != null) {
            this.eUh.qE(i);
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
        if (this.eUh == null || this.eUh.buL()) {
            if (this.eTY != null) {
                this.eUe.onFinish();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.eUh != null) {
            Intent buM = this.eUh.buM();
            if (buM != null) {
                setResult(-1, buM);
            }
            if (this.eTY != null && !this.eUe.getIsFinish()) {
                this.eUe.onFinish();
                return;
            } else {
                super.finish();
                return;
            }
        }
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eUe != null) {
            this.eUe.onDestroy();
        }
    }
}
