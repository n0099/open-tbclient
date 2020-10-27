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
    protected TextView bKf;
    private TranView frD;
    private SusPendedView frJ;
    private NoNetworkView frK;
    private LinearLayout frL;
    private a frM;
    private NoNetworkView.a frN = new NoNetworkView.a() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.1
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                SuspendedActivity.this.bAy();
            }
        }
    };
    private LinearLayout mContentView;
    private NavigationBar mNavigationBar;

    protected abstract a a(LinearLayout linearLayout, NavigationBar navigationBar);

    protected abstract void bAy();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_suspended);
        init();
    }

    private void init() {
        this.frJ = (SusPendedView) findViewById(R.id.root_view);
        bAv();
        bAw();
        bAx();
        Vr();
        this.frJ.setNavigationBar(this.frL);
        this.frJ.setTranView(this.frD);
        this.frJ.setContentView(this.mContentView);
        this.frJ.show();
    }

    private void bAv() {
        this.frD = new TranView(getPageContext().getPageActivity());
        this.frD.setVisibility(0);
    }

    private void bAw() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.mCenterText.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.bKf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getResources().getString(R.string.dialog_cancel), new View.OnClickListener() { // from class: com.baidu.tbadk.suspended.SuspendedActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SuspendedActivity.this.close();
            }
        });
        this.bKf.setTextSize(0, l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds44));
        this.mNavigationBar.setIsCorner(true);
        this.mNavigationBar.setStatusBarVisibility(8);
        this.mNavigationBar.hideBottomLine();
        this.frL = (LinearLayout) findViewById(R.id.navigation_bar_group);
        this.frL.addView(this.frD, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds153)));
    }

    private void bAx() {
        this.frK = (NoNetworkView) findViewById(R.id.view_no_network);
        this.frK.a(this.frN);
    }

    private void Vr() {
        this.mContentView = (LinearLayout) findViewById(R.id.content_view);
        this.frM = a(this.mContentView, this.mNavigationBar);
        if (this.frM != null) {
            this.frJ.setContentViewTop(this.frM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.frK.onChangeSkinType(getPageContext(), i);
        this.frJ.onChangeSkinType(i);
        ap.setBackgroundColor(this.frJ, R.color.cp_mask_b_alpha66);
        ap.setBackgroundColor(this.mContentView, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.bKf, R.color.cp_cont_b);
        if (this.frM != null) {
            this.frM.rE(i);
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
        if (this.frM == null || this.frM.bAt()) {
            if (this.frD != null) {
                this.frJ.onFinish();
            } else {
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.frM != null) {
            Intent bAu = this.frM.bAu();
            if (bAu != null) {
                setResult(-1, bAu);
            }
            if (this.frD != null && !this.frJ.getIsFinish()) {
                this.frJ.onFinish();
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
        if (this.frJ != null) {
            this.frJ.onDestroy();
        }
    }
}
