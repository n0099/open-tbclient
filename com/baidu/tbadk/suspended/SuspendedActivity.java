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
/* loaded from: classes.dex */
public abstract class SuspendedActivity extends BaseFragmentActivity {
    protected TextView dCF;
    private TranView eUc;
    private SusPendedView eUi;
    private NoNetworkView eUj;
    private LinearLayout eUk;
    private a eUl;
    private NoNetworkView.a eUm = new NoNetworkView.a() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SuspendedActivity.this.buR();
            }
        }
    };
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;

    protected abstract a a(LinearLayout linearLayout, NavigationBar navigationBar);

    protected abstract void buR();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_suspended);
        init();
    }

    private void init() {
        this.eUi = (SusPendedView) findViewById(R.id.root_view);
        buO();
        buP();
        buQ();
        VH();
        this.eUi.setNavigationBar(this.eUk);
        this.eUi.setTranView(this.eUc);
        this.eUi.setContentView(this.mContentView);
        this.eUi.show();
    }

    private void buO() {
        this.eUc = new TranView(getPageContext().getPageActivity());
        this.eUc.setVisibility(0);
    }

    private void buP() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.mCenterText.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.dCF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getResources().getString(R.string.dialog_cancel), new View.OnClickListener() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SuspendedActivity.this.close();
            }
        });
        this.dCF.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dCF.getLayoutParams();
        layoutParams.topMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds46);
        this.dCF.setLayoutParams(layoutParams);
        this.mNavigationBar.setIsCorner(true);
        this.mNavigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.hideBottomLine();
        this.eUk = (LinearLayout) findViewById(R.id.navigation_bar_group);
        this.eUk.addView(this.eUc, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153)));
    }

    private void buQ() {
        this.eUj = (NoNetworkView) findViewById(R.id.view_no_network);
        this.eUj.a(this.eUm);
    }

    private void VH() {
        this.mContentView = (LinearLayout) findViewById(R.id.content_view);
        this.eUl = a(this.mContentView, this.mNavigationBar);
        if (this.eUl != null) {
            this.eUi.setContentViewTop(this.eUl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eUj.onChangeSkinType(getPageContext(), i);
        this.eUi.onChangeSkinType(i);
        ap.setBackgroundColor(this.eUi, R.color.cp_mask_b_alpha66);
        ap.setBackgroundColor(this.mContentView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.dCF, R.color.cp_cont_b);
        if (this.eUl != null) {
            this.eUl.qE(i);
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
        if (this.eUl == null || this.eUl.buM()) {
            if (this.eUc != null) {
                this.eUi.onFinish();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.eUl != null) {
            Intent buN = this.eUl.buN();
            if (buN != null) {
                setResult(-1, buN);
            }
            if (this.eUc != null && !this.eUi.getIsFinish()) {
                this.eUi.onFinish();
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
        if (this.eUi != null) {
            this.eUi.onDestroy();
        }
    }
}
