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
    protected TextView dEG;
    private TranView eWS;
    private SusPendedView eWY;
    private NoNetworkView eWZ;
    private LinearLayout eXa;
    private a eXb;
    private NoNetworkView.a eXc = new NoNetworkView.a() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SuspendedActivity.this.bvV();
            }
        }
    };
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;

    protected abstract a a(LinearLayout linearLayout, NavigationBar navigationBar);

    protected abstract void bvV();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_suspended);
        init();
    }

    private void init() {
        this.eWY = (SusPendedView) findViewById(R.id.root_view);
        bvS();
        bvT();
        bvU();
        Wq();
        this.eWY.setNavigationBar(this.eXa);
        this.eWY.setTranView(this.eWS);
        this.eWY.setContentView(this.mContentView);
        this.eWY.show();
    }

    private void bvS() {
        this.eWS = new TranView(getPageContext().getPageActivity());
        this.eWS.setVisibility(0);
    }

    private void bvT() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.mCenterText.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.dEG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getResources().getString(R.string.dialog_cancel), new View.OnClickListener() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SuspendedActivity.this.close();
            }
        });
        this.dEG.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.mNavigationBar.setIsCorner(true);
        this.mNavigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.hideBottomLine();
        this.eXa = (LinearLayout) findViewById(R.id.navigation_bar_group);
        this.eXa.addView(this.eWS, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153)));
    }

    private void bvU() {
        this.eWZ = (NoNetworkView) findViewById(R.id.view_no_network);
        this.eWZ.a(this.eXc);
    }

    private void Wq() {
        this.mContentView = (LinearLayout) findViewById(R.id.content_view);
        this.eXb = a(this.mContentView, this.mNavigationBar);
        if (this.eXb != null) {
            this.eWY.setContentViewTop(this.eXb);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eWZ.onChangeSkinType(getPageContext(), i);
        this.eWY.onChangeSkinType(i);
        ap.setBackgroundColor(this.eWY, R.color.cp_mask_b_alpha66);
        ap.setBackgroundColor(this.mContentView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.dEG, R.color.cp_cont_b);
        if (this.eXb != null) {
            this.eXb.qV(i);
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
        if (this.eXb == null || this.eXb.bvQ()) {
            if (this.eWS != null) {
                this.eWY.onFinish();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.eXb != null) {
            Intent bvR = this.eXb.bvR();
            if (bvR != null) {
                setResult(-1, bvR);
            }
            if (this.eWS != null && !this.eWY.getIsFinish()) {
                this.eWY.onFinish();
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
        if (this.eWY != null) {
            this.eWY.onDestroy();
        }
    }
}
